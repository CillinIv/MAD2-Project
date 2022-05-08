package org.wit.mad2_project.ui.builddetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.wit.mad2_project.firebase.FirebaseDBManager
import org.wit.mad2_project.models.BuildModel
import timber.log.Timber

class BuildDetailViewModel : ViewModel() {
    private val build = MutableLiveData<BuildModel>()

    var observableBuild: LiveData<BuildModel>
        get() = build
        set(value) {build.value = value.value}

    fun getBuild(userid:String, id: String) {
        try {
            FirebaseDBManager.findById(userid, id, build)
            Timber.i("Detail getBuild() Success : ${
                build.value?.toString()}")
        }
        catch (e: Exception) {
            Timber.i("Detail getBuild() Error : $e.message")
        }
    }


}