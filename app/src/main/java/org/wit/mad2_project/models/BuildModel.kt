package org.wit.mad2_project.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BuildModel(var id: Long = 0,
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


                      ) : Parcelable

