package org.wit.mad2_project.models
import timber.log.Timber

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class BuildMemStore : BuildStore {

    val donations = ArrayList<BuildModel>()

    override fun findAll(): List<BuildModel> {
        return donations
    }

    override fun findById(id:Long) : BuildModel? {
        val foundDonation: BuildModel? = donations.find { it.id == id }
        return foundDonation
    }

    override fun create(donation: BuildModel) {
        donation.id = getId()
        donations.add(donation)
        logAll()
    }

    fun logAll() {
        Timber.v("** Donations List **")
        donations.forEach { Timber.v("Donate ${it}") }
    }
}