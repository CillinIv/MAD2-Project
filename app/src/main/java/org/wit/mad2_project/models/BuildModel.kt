package org.wit.mad2_project.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import org.wit.mad2_project.firebase.FirebaseDBManager.database

@IgnoreExtraProperties
@Parcelize
data class BuildModel(var uid: String = "",
                      var buildTitle: String = "N/A",

                      var headSlot: String = "N/A",
                      var headWeight: String = "N/A",
                      var headEnch: String = "N/A",
                      var headTrait: String = "N/A",
                      var headQuality: Int = 3,


                      var shoulderSlot: String = "N/A",
                      var shoulderWeight: String = "N/A",
                      var shoulderEnch: String = "N/A",
                      var shoulderTrait: String = "N/A",
                      var shoulderQuality: Int = 3,

                      var chestSlot: String = "N/A",
                      var chestWeight: String = "N/A",
                      var chestEnch: String = "N/A",
                      var chestTrait: String = "N/A",
                      var chestQuality: Int = 3,

                      var handSlot: String = "N/A",
                      var handWeight: String = "N/A",
                      var handEnch: String = "N/A",
                      var handTrait: String = "N/A",
                      var handQuality: Int = 3,

                      var waistSlot: String = "N/A",
                      var waistWeight: String = "N/A",
                      var waistEnch: String = "N/A",
                      var waistTrait: String = "N/A",
                      var waistQuality: Int = 3,

                      var legSlot: String = "N/A",
                      var legWeight: String = "N/A",
                      var legEnch: String = "N/A",
                      var legTrait: String = "N/A",
                      var legQuality: Int = 3,

                      var bootSlot: String = "N/A",
                      var bootWeight: String = "N/A",
                      var bootEnch: String = "N/A",
                      var bootTrait: String = "N/A",
                      var bootQuality: Int = 3,

                      var neckSlot: String = "N/A",
                      var neckEnch: String = "N/A",
                      var neckTrait: String = "N/A",
                      var neckQuality: Int = 3,

                      var ring1Slot: String = "N/A",
                      var ring1Ench: String = "N/A",
                      var ring1Trait: String = "N/A",
                      var ring1Quality: Int = 3,

                      var ring2Slot: String = "N/A",
                      var ring2Ench: String = "N/A",
                      var ring2Trait: String = "N/A",
                      var ring2Quality: Int = 3,

                      var frontSlot: String = "N/A",
                      var frontType: String = "N/A",
                      var frontEnch: String = "N/A",
                      var frontTrait: String = "N/A",
                      var frontQuality: Int = 3,

                      var backSlot: String = "N/A",
                      var backType: String = "N/A",
                      var backEnch: String = "N/A",
                      var backTrait: String = "N/A",
                      var backQuality: Int = 3,

                      var email: String = "joe@bloggs.com",
                      ) : Parcelable
{
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to uid,
            "buildTitle" to buildTitle,

            "headSlot" to headSlot,
            "headWeight" to headWeight,
            "headEnch" to headEnch,
            "headTrait" to headTrait,
            "headQuality" to headQuality,

            "shoulderSlot" to shoulderSlot,
            "shoulderWeight" to shoulderWeight,
            "shoulderEnch" to shoulderEnch,
            "shoulderTrait" to shoulderTrait,
            "shoulderQuality" to shoulderQuality,

            "chestSlot" to chestSlot,
            "chestWeight" to chestWeight,
            "chestEnch" to chestEnch,
            "chestTrait" to chestTrait,
            "chestQuality" to chestQuality,

            "handSlot" to handSlot,
            "handWeight" to handWeight,
            "handEnch" to handEnch,
            "handTrait" to handTrait,
            "handQuality" to handQuality,

            "waistSlot" to waistSlot,
            "waistWeight" to waistWeight,
            "waistEnch" to waistEnch,
            "waistTrait" to waistTrait,
            "waistQuality" to waistQuality,

            "legSlot" to legSlot,
            "legWeight" to legWeight,
            "legEnch" to legEnch,
            "legTrait" to legTrait,
            "legQuality" to legQuality,

            "bootSlot" to bootSlot,
            "bootWeight" to bootWeight,
            "bootEnch" to bootEnch,
            "bootTrait" to bootTrait,
            "bootQuality" to bootQuality,

            "neckSlot" to neckSlot,
            "neckEnch" to neckEnch,
            "neckTrait" to neckTrait,
            "neckQuality" to neckQuality,

            "ring1Slot" to ring1Slot,
            "ring1Ench" to ring1Ench,
            "ring1Trait" to ring1Trait,
            "ring1Quality" to ring1Quality,

            "ring2Slot" to ring2Slot,
            "ring2Ench" to ring2Ench,
            "ring2Trait" to ring2Trait,
            "ring2Quality" to ring2Quality,

            "frontSlot" to frontSlot,
            "frontType" to frontType,
            "frontEnch" to frontEnch,
            "frontTrait" to frontTrait,
            "frontQuality" to frontQuality,

            "backSlot" to backSlot,
            "backType" to backType,
            "backEnch" to backEnch,
            "backTrait" to backTrait,
            "backQuality" to backQuality,

            "email" to email
        )
    }
}

