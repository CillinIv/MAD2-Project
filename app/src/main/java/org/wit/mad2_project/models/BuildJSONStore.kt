package org.wit.mad2_project.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.wit.mad2_project.models.BuildModel
import org.wit.mad2_project.models.BuildStore
import org.wit.mad2_project.helpers.exists
import org.wit.mad2_project.helpers.read
import org.wit.mad2_project.helpers.write
import java.nio.file.Files.exists
import java.util.*

class BuildJSONStore (private val context : Context){

    val JSON_FILE_BUILDS = "builds.json"
    val gsonBuilderBuild = GsonBuilder().setPrettyPrinting().create()
    val listTypeBuild = object : TypeToken<ArrayList<BuildModel>>() {}.type

    private fun generateRandomId(): Long {
        return Random().nextLong()
    }

    var builds = mutableListOf<BuildModel>()

    init {
        if (exists(context, JSON_FILE_BUILDS)) {
            deserialize()
        }
    }

    fun findAll(): MutableList<BuildModel> {
        return builds
    }

    fun findOne(id: Long) : BuildModel? {
        var foundBuild: BuildModel? = builds.find { p -> p.id == id }
        return foundBuild
    }

    fun create(build: BuildModel) {
        build.id = generateRandomId()
        builds.add(build)
        serialize()
    }

    fun update(build: BuildModel) {
        var foundBuild = findOne(build.id!!)
        if (foundBuild != null) {
            foundBuild.buildTitle = build.buildTitle

            foundBuild.headSlot = build.headSlot
            foundBuild.headWeight = build.headWeight
            foundBuild.headEnch = build.headEnch
            foundBuild.headTrait = build.headTrait
            foundBuild.headQuality = build.headQuality

            foundBuild.shoulderSlot = build.shoulderSlot
            foundBuild.shoulderWeight = build.shoulderWeight
            foundBuild.shoulderEnch = build.shoulderEnch
            foundBuild.shoulderTrait = build.shoulderTrait
            foundBuild.shoulderQuality = build.shoulderQuality

            foundBuild.chestSlot = build.chestSlot
            foundBuild.chestWeight = build.chestWeight
            foundBuild.chestEnch = build.chestEnch
            foundBuild.chestTrait = build.chestTrait
            foundBuild.chestQuality = build.chestQuality

            foundBuild.handSlot = build.handSlot
            foundBuild.handWeight = build.handWeight
            foundBuild.handEnch = build.handEnch
            foundBuild.handTrait = build.handTrait
            foundBuild.handQuality = build.handQuality

            foundBuild.waistSlot = build.waistSlot
            foundBuild.waistWeight = build.waistWeight
            foundBuild.waistEnch = build.waistEnch
            foundBuild.waistTrait = build.waistTrait
            foundBuild.waistQuality = build.waistQuality

            foundBuild.legSlot = build.legSlot
            foundBuild.legWeight = build.legWeight
            foundBuild.legEnch = build.legEnch
            foundBuild.legTrait = build.legTrait
            foundBuild.legQuality = build.legQuality

            foundBuild.bootSlot = build.bootSlot
            foundBuild.bootWeight = build.bootWeight
            foundBuild.bootEnch = build.bootEnch
            foundBuild.bootTrait = build.bootTrait
            foundBuild.bootQuality = build.bootQuality

            foundBuild.neckSlot = build.neckSlot
            foundBuild.neckEnch = build.neckEnch
            foundBuild.neckTrait = build.neckTrait
            foundBuild.neckQuality = build.neckQuality

            foundBuild.ring1Slot = build.ring1Slot
            foundBuild.ring1Ench = build.ring1Ench
            foundBuild.ring1Trait = build.ring1Trait
            foundBuild.ring1Quality = build.ring1Quality

            foundBuild.ring2Slot = build.ring2Slot
            foundBuild.ring2Ench = build.ring2Ench
            foundBuild.ring2Trait = build.ring2Trait
            foundBuild.ring2Quality = build.ring2Quality

            foundBuild.frontSlot = build.frontSlot
            foundBuild.frontType = build.frontType
            foundBuild.frontEnch = build.frontEnch
            foundBuild.frontTrait = build.frontTrait
            foundBuild.frontQuality = build.frontQuality

            foundBuild.backSlot = build.backSlot
            foundBuild.backType = build.backType
            foundBuild.backEnch = build.backEnch
            foundBuild.backTrait = build.backTrait
            foundBuild.backQuality = build.backQuality

        }
        serialize()
    }

    private fun serialize() {
        val jsonString = gsonBuilderBuild.toJson(builds, listTypeBuild)
        write(context, JSON_FILE_BUILDS, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, JSON_FILE_BUILDS)
        builds = Gson().fromJson(jsonString, listTypeBuild)
    }

    fun delete(build: BuildModel) {
        builds.remove(build)
        serialize()
    }

    fun searchBuildByTitle(title: String) : List<BuildModel>?{
        var resultArray = listOf<BuildModel>().toMutableList()
        builds.forEach {
            if (it.buildTitle.contains(title)) {
                resultArray.add(it)
            }
        }
        return resultArray
    }


}