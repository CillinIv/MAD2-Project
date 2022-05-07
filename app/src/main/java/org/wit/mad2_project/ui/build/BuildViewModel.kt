package org.wit.mad2_project.ui.build

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import org.wit.mad2_project.firebase.FirebaseDBManager
import org.wit.mad2_project.models.BuildModel
import timber.log.Timber

class BuildViewModel : ViewModel() {

    private val status = MutableLiveData<Boolean>()

    val observableBuild: LiveData<Boolean>
        get() = status


    fun addBuild(firebaseUser: MutableLiveData<FirebaseUser>, build: BuildModel) {
        status.value = try {
            FirebaseDBManager.create(firebaseUser,build)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun delete(userid: String, id: String) {
        try {
            FirebaseDBManager.delete(userid,id)
            Timber.i("Report Delete Success")
        }
        catch (e: Exception) {
            Timber.i("Report Delete Error : $e.message")
        }
    }
}