package org.wit.mad2_project.ui.build

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.wit.mad2_project.models.BuildModel

class BuildViewModel : ViewModel() {

    private val build = MutableLiveData<BuildModel>()

    val observableBuild: LiveData<BuildModel>
        get() = build



    fun set(currentBuild : BuildModel) {
        build.value = currentBuild
    }
}