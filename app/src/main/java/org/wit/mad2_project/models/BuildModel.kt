package org.wit.mad2_project.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BuildModel(var id: Long = 0,
                      val buildTitle: String = "N/A",

                      val headSlot: String = "N/A",
                      val headWeight: String = "N/A",
                      val headEnch: String = "N/A",
                      val headTrait: String = "N/A",
                      val headQuality: Int = 3,


                      val shoulderSlot: String = "N/A",
                      val shoulderWeight: String = "N/A",
                      val shoulderEnch: String = "N/A",
                      val shoulderTrait: String = "N/A",
                      val shoulderQuality: Int = 3,

                      val chestSlot: String = "N/A",
                      val chestWeight: String = "N/A",
                      val chestEnch: String = "N/A",
                      val chestTrait: String = "N/A",
                      val chestQuality: Int = 3,

                      val handSlot: String = "N/A",
                      val handWeight: String = "N/A",
                      val handEnch: String = "N/A",
                      val handTrait: String = "N/A",
                      val handQuality: Int = 3,

                      val gloveSlot: String = "N/A",
                      val gloveWeight: String = "N/A",
                      val gloveEnch: String = "N/A",
                      val gloveTrait: String = "N/A",
                      val gloveQuality: Int = 3,

                      val waistSlot: String = "N/A",
                      val waistWeight: String = "N/A",
                      val waistEnch: String = "N/A",
                      val waistTrait: String = "N/A",
                      val waistQuality: Int = 3,

                      val bootSlot: String = "N/A",
                      val bootWeight: String = "N/A",
                      val bootEnch: String = "N/A",
                      val bootTrait: String = "N/A",
                      val bootQuality: Int = 3,

                      val neckSlot: String = "N/A",
                      val neckEnch: String = "N/A",
                      val neckTrait: String = "N/A",
                      val neckQuality: Int = 3,

                      val ring1Slot: String = "N/A",
                      val ring1Ench: String = "N/A",
                      val ring1Trait: String = "N/A",
                      val ring1Quality: Int = 3,

                      val ring2Slot: String = "N/A",
                      val ring2Ench: String = "N/A",
                      val ring2Trait: String = "N/A",
                      val ring2Quality: Int = 3,

                      val frontSlot: String = "N/A",
                      val frontType: String = "N/A",
                      val frontEnch: String = "N/A",
                      val frontTrait: String = "N/A",
                      val frontQuality: Int = 3,

                      val backSlot: String = "N/A",
                      val backType: String = "N/A",
                      val backEnch: String = "N/A",
                      val backTrait: String = "N/A",
                      val backQuality: Int = 3,


                      ) : Parcelable