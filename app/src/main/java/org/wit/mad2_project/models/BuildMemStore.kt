package org.wit.mad2_project.models
import timber.log.Timber

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class BuildMemStore : BuildStore {

    val builds = ArrayList<BuildModel>()

    override fun findAll(): List<BuildModel> {
        return builds
    }

    override fun findById(id:Long) : BuildModel? {
        val foundBuild: BuildModel? = builds.find { it.id == id }
        return foundBuild
    }

    override fun create(build: BuildModel) {
        build.id = getId()
        builds.add(build)
        logAll()
    }

    fun logAll() {
        Timber.v("** Build List **")
        builds.forEach { Timber.v("Donate ${it}") }
    }
}