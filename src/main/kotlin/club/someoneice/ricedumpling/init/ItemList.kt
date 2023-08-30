package club.someoneice.ricedumpling.init

import club.someoneice.ricedumpling.RiceDumpling
import club.someoneice.ricedumpling.api.AbstractLeaves
import club.someoneice.ricedumpling.api.AbstractStuffing
import club.someoneice.ricedumpling.common.item.ItemRiceDumpling
import club.someoneice.ricedumpling.util.FoodPropertiesList
import club.someoneice.ricedumpling.util.LeavesApplyList
import club.someoneice.ricedumpling.util.StuffingApplyList
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

@Suppress("unused")
object ItemList {
    val REGISTRY: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, RiceDumpling.MODID)

    val DIMPLING_LEAVES         by REGISTRY.registerObject("dumpling_leaves")           { object: AbstractLeaves("dumpling_leaves", LeavesApplyList.DUMPLING_LEAVES) {} }
    val NETHER_LEAVES           by REGISTRY.registerObject("nether_leaves")             { object: AbstractLeaves("nether_leaves", LeavesApplyList.NETHER_LEAVES) {} }
    val PURPLE_LEAVES           by REGISTRY.registerObject("purple_leaves")             { object: AbstractLeaves("purple_leaves", LeavesApplyList.PURPLE_LEAVES) {} }

    val RICE_DIMPLING           by REGISTRY.registerObject("rice_dumpling")             { ItemRiceDumpling(FoodPropertiesList.RICE_DUMPLING) }

    /* Food */
    val GLUTINOUS_RICE          by REGISTRY.registerObject("glutinous_rice")            { BlockItem(BlockList.GLUTINOUS_RICE, Item.Properties().food(FoodPropertiesList.GLUTINOUS_RICE)) }
    val SALTED_EGG              by REGISTRY.registerObject("salted_egg")                { Item(Item.Properties().food(FoodPropertiesList.SALTED_EGG)) }
    val BACON                   by REGISTRY.registerObject("bacon")                     { Item(Item.Properties().food(FoodPropertiesList.BACON)) }
    val RICE_BALL               by REGISTRY.registerObject("rice_ball")                 { Item(Item.Properties().food(FoodPropertiesList.RICE_BALL)) }
    val FISH_RICE_BALL          by REGISTRY.registerObject("fish_rice_ball")            { Item(Item.Properties().food(FoodPropertiesList.FISH_RICE_BALL)) }

    /* StuffingApplyList */
    val RICE_STUFFING           by REGISTRY.registerObject("rice_stuffing")             { object: AbstractStuffing("rice_stuffing", FoodPropertiesList.RICE_STUFFING, StuffingApplyList.RICE_STUFFING_EFFECT, StuffingApplyList.RICE_STUFFING_APPLY, StuffingApplyList.RICE_STUFFING_APPLY_EFFECT)                  {} }
    val FISH_STUFFING           by REGISTRY.registerObject("fish_stuffing")             { object: AbstractStuffing("fish_stuffing", FoodPropertiesList.FISH_STUFFING, StuffingApplyList.FISH_STUFFING_EFFECT, StuffingApplyList.FISH_STUFFING_APPLY, StuffingApplyList.FISH_STUFFING_APPLY_EFFECT)                  {} }
    val CARROT_STUFFING         by REGISTRY.registerObject("carrot_stuffing")           { object: AbstractStuffing("carrot_stuffing", FoodPropertiesList.CARROT_STUFFING, StuffingApplyList.CARROT_STUFFING_EFFECT, StuffingApplyList.CARROT_STUFFING_APPLY, StuffingApplyList.CARROT_STUFFING_APPLY_EFFECT)        {} }
    val APPLE_STUFFING          by REGISTRY.registerObject("apple_stuffing")            { object: AbstractStuffing("apple_stuffing", FoodPropertiesList.APPLE_STUFFING, StuffingApplyList.APPLE_STUFFING_EFFECT, StuffingApplyList.APPLE_STUFFING_APPLY, StuffingApplyList.APPLE_STUFFING_APPLY_EFFECT)             {} }
    val GOLDEN_STUFFING         by REGISTRY.registerObject("golden_stuffing")           { object: AbstractStuffing("golden_stuffing", FoodPropertiesList.GOLDEN_STUFFING, StuffingApplyList.GOLDEN_STUFFING_EFFECT, StuffingApplyList.GOLDEN_STUFFING_APPLY, StuffingApplyList.GOLDEN_STUFFING_APPLY_EFFECT)        {} }
    val BACON_STUFFING          by REGISTRY.registerObject("bacon_stuffing")            { object: AbstractStuffing("bacon_stuffing", FoodPropertiesList.BACON_STUFFING, StuffingApplyList.BACON_STUFFING_EFFECT, StuffingApplyList.BACON_STUFFING_APPLY, StuffingApplyList.BACON_STUFFING_APPLY_EFFECT)             {} }
    val CHICKEN_STUFFING        by REGISTRY.registerObject("chicken_stuffing")          { object: AbstractStuffing("chicken_stuffing", FoodPropertiesList.CHICKEN_STUFFING, StuffingApplyList.CHICKEN_STUFFING_EFFECT, StuffingApplyList.CHICKEN_STUFFING_APPLY, StuffingApplyList.CHICKEN_STUFFING_APPLY_EFFECT)   {} }
    val EGG_STUFFING            by REGISTRY.registerObject("egg_stuffing")              { object: AbstractStuffing("egg_stuffing", FoodPropertiesList.EGG_STUFFING, StuffingApplyList.EGG_STUFFING_EFFECT, StuffingApplyList.EGG_STUFFING_APPLY, StuffingApplyList.EGG_STUFFING_APPLY_EFFECT)                       {} }
    val SUGAR_STUFFING          by REGISTRY.registerObject("sugar_stuffing")            { object: AbstractStuffing("sugar_stuffing", FoodPropertiesList.SUGAR_STUFFING, StuffingApplyList.SUGAR_STUFFING_EFFECT, StuffingApplyList.SUGAR_STUFFING_APPLY, StuffingApplyList.SUGAR_STUFFING_APPLY_EFFECT)             {} }
    val SLAT_STUFFING           by REGISTRY.registerObject("slat_stuffing")             { object: AbstractStuffing("slat_stuffing", FoodPropertiesList.SLAT_STUFFING, StuffingApplyList.SLAT_STUFFING_EFFECT, StuffingApplyList.SLAT_STUFFING_APPLY, StuffingApplyList.SLAT_STUFFING_APPLY_EFFECT)                  {} }

}