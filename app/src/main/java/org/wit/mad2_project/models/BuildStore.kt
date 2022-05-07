package org.wit.mad2_project.models

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser

interface BuildStore {

    fun findAll(buildList: MutableLiveData<List<BuildModel>>)
    fun findAll(userid:String, buildList: MutableLiveData<List<BuildModel>>)

    fun findById(userid:String, buildid: String, build: MutableLiveData<BuildModel>)
    fun create(firebaseUser: MutableLiveData<FirebaseUser>, build: BuildModel)

    fun delete(userid:String, buildid: String)
    fun update(userid:String, buildid: String, build: BuildModel)
}