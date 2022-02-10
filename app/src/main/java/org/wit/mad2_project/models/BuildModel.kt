package org.wit.mad2_project.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BuildModel(var id: Long = 0,

                      val headSlot: String = "N/A",
                      val headWeight: Int = 0,
                      val headEnch: Int = 3,
                      val headQuality: Int = 3,

                      val shoulderSlot: String = "N/A",
                      val shoulderWeight: Int = 0,
                      val shoulderEnch: Int = 3,
                      val shoulderQuality: Int = 3,

                      val chestSlot: String = "N/A",
                      val chestWeight: Int = 0,
                      val chestEnch: Int = 3,
                      val chestQuality: Int = 3,

                      val handSlot: String = "N/A",
                      val handWeight: Int = 0,
                      val handEnch: Int = 3,
                      val handQuality: Int = 3,

                      val gloveSlot: String = "N/A",
                      val gloveWeight: Int = 0,
                      val gloveEnch: Int = 3,
                      val gloveQuality: Int = 3,

                      val waistSlot: String = "N/A",
                      val waistWeight: Int = 0,
                      val waistEnch: Int = 3,
                      val waistQuality: Int = 3,

                      val bootSlot: String = "N/A",
                      val bootWeight: Int = 0,
                      val bootEnch: Int = 3,
                      val bootQuality: Int = 3,

                      val neckSlot: String = "N/A",
                      val neckWeight: Int = 0,
                      val neckEnch: Int = 3,
                      val neckQuality: Int = 3,

                      val ring1Slot: String = "N/A",
                      val ring1Weight: Int = 0,
                      val ring1Ench: Int = 3,
                      val ring1Quality: Int = 3,

                      val ring2Slot: String = "N/A",
                      val ring2Weight: Int = 0,
                      val ring2Ench: Int = 3,
                      val ring2Quality: Int = 3,

                      val frontSlot: String = "N/A",
                      val frontWeight: Int = 0,
                      val frontEnch: Int = 3,
                      val frontQuality: Int = 3,

                      val backSlot: String = "N/A",
                      val backWeight: Int = 0,
                      val backEnch: Int = 3,
                      val backQuality: Int = 3,


                      ) : Parcelable