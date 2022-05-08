package org.wit.mad2_project.ui.buildlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import org.wit.mad2_project.firebase.FirebaseDBManager
import org.wit.mad2_project.models.BuildModel
import org.wit.mad2_project.models.BuildStore
import timber.log.Timber

class BuildListViewModel : ViewModel() {

    private val buildsList =
        MutableLiveData<List<BuildModel>>()

    val observableBuildList: LiveData<List<BuildModel>>
        get() = buildsList

    var liveFirebaseUser = MutableLiveData<FirebaseUser>()

    init { load() }

    fun load() {
        try {
            FirebaseDBManager.findAll(liveFirebaseUser.value?.uid!!, buildsList)
            println("Build Load Success : ${buildsList.value.toString()}")
        }
        catch (e: Exception) {
            println("Build Load Error : $e.message")
        }
    }

    fun delete(email: String, id: String) {
        try {
            FirebaseDBManager.delete(email,id)
            Timber.i("Report Delete Success")
        }
        catch (e: Exception) {
            Timber.i("Report Delete Error : $e.message")
        }
    }

}