package org.wit.mad2_project.ui.buildlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.wit.mad2_project.models.BuildModel

class BuildListFragmentViewModel : ViewModel() {

    private val build = MutableLiveData<List<BuildModel>>()

    val observableBuild: LiveData<List<BuildModel>>
        get() = build




}