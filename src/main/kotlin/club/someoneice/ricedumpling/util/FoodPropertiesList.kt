package club.someoneice.ricedumpling.util

import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties

object FoodPropertiesList {
    val RICE_DUMPLING: FoodProperties       = FoodProperties.Builder().nutrition(15).saturationMod(1.79F).build()
    val GLUTINOUS_RICE: FoodProperties      = FoodProperties.Builder().nutrition(1).saturationMod(0.2F).fast().build()
    val SALTED_EGG: FoodProperties          = FoodProperties.Builder().nutrition(3).saturationMod(0.4F).alwaysEat().build()
    val BACON: FoodProperties               = FoodProperties.Builder().nutrition(7).saturationMod(1.1F).effect({ MobEffects.DAMAGE_BOOST.Instance(20 * 10) }, 1.0F).build()
    val RICE_BALL: FoodProperties           = FoodProperties.Builder().nutrition(4).saturationMod(0.55F).build()
    val FISH_RICE_BALL: FoodProperties      = FoodProperties.Builder().nutrition(9).saturationMod(1.25F).build()

    val RICE_STUFFING: FoodProperties       = FoodProperties.Builder().nutrition(2).saturationMod(0.15F).build()
    val FISH_STUFFING: FoodProperties       = FoodProperties.Builder().nutrition(5).saturationMod(0.95F).build()
    val CARROT_STUFFING: FoodProperties     = FoodProperties.Builder().nutrition(4).saturationMod(0.54F).build()
    val APPLE_STUFFING: FoodProperties      = FoodProperties.Builder().nutrition(4).saturationMod(0.54F).build()
    val GOLDEN_STUFFING: FoodProperties     = FoodProperties.Builder().nutrition(5).saturationMod(0.64F).build()
    val BACON_STUFFING: FoodProperties      = FoodProperties.Builder().nutrition(6).saturationMod(1.05F).build()
    val CHICKEN_STUFFING: FoodProperties    = FoodProperties.Builder().nutrition(7).saturationMod(1.2F).build()
    val EGG_STUFFING: FoodProperties        = FoodProperties.Builder().nutrition(6).saturationMod(0.57F).build()
    // val SUGAR_STUFFING: FoodProperties      = FoodProperties.Builder().nutrition(5).saturationMod(0.54F).build()
    // val SLAT_STUFFING: FoodProperties       = FoodProperties.Builder().nutrition(5).saturationMod(0.54F).build()
}