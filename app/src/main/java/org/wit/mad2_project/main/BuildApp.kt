package org.wit.mad2_project.main

import android.app.Application
import org.wit.mad2_project.models.BuildStore
import timber.log.Timber

class BuildApp : Application() {

    //lateinit var buildStore: BuildJSONStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        //buildStore = BuildJSONStore(applicationContext)
        Timber.i("Starting App")
    }
}