package org.wit.mad2_project.firebase

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import org.wit.mad2_project.models.BuildModel
import org.wit.mad2_project.models.BuildStore
import timber.log.Timber

object FirebaseDBManager : BuildStore {

    var database: DatabaseReference = FirebaseDatabase.getInstance().reference

    override fun findAll(buildList: MutableLiveData<List<BuildModel>>) {
        TODO("Not yet implemented")
    }

    override fun findAll(userid: String, buildList: MutableLiveData<List<BuildModel>>) {

        database.child("user-donations").child(userid)
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    Timber.i("Firebase Donation error : ${error.message}")
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    val localList = ArrayList<BuildModel>()
                    val children = snapshot.children
                    children.forEach {
                        val build = it.getValue(BuildModel::class.java)
                        localList.add(build!!)
                    }
                    database.child("user-builds").child(userid)
                        .removeEventListener(this)

                    buildList.value = localList
                }
            })
    }

    override fun findById(userid: String, buildid: String, builds: MutableLiveData<BuildModel>) {

        database.child("user-donations").child(userid)
            .child(buildid).get().addOnSuccessListener {
                builds.value = it.getValue(BuildModel::class.java)
                Timber.i("firebase Got value ${it.value}")
            }.addOnFailureListener{
                Timber.e("firebase Error getting data $it")
            }
    }

    override fun create(firebaseUser: MutableLiveData<FirebaseUser>, build: BuildModel) {
        Timber.i("Firebase DB Reference : $database")

        val uid = firebaseUser.value!!.uid
        val key = database.child("builds").push().key
        if (key == null) {
            Timber.i("Firebase Error : Key Empty")
            return
        }
        build.id = key
        val donationValues = build.toMap()

        val childAdd = HashMap<String, Any>()
        childAdd["/builds/$key"] = donationValues
        childAdd["/user-builds/$uid/$key"] = donationValues

        database.updateChildren(childAdd)
    }

    override fun delete(userid: String, buildid: String) {

        val childDelete : MutableMap<String, Any?> = HashMap()
        childDelete["/builds/$buildid"] = null
        childDelete["/user-builds/$userid/$buildid"] = null

        database.updateChildren(childDelete)
    }

    override fun update(userid: String, buildid: String, build: BuildModel) {

        val buildValues = build.toMap()

        val childUpdate : MutableMap<String, Any?> = HashMap()
        childUpdate["builds/$buildid"] = buildValues
        childUpdate["user-builds/$userid/$buildid"] = buildValues

        database.updateChildren(childUpdate)
    }
}