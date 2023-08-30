package club.someoneice.ricedumpling.util

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

object StuffingApplyList {
    val RICE_STUFFING_EFFECT    = MobEffects.HEAL.Instance(20)
    val FISH_STUFFING_EFFECT    = MobEffects.WATER_BREATHING.Instance(20 * 30)
    val CARROT_STUFFING_EFFECT  = MobEffects.NIGHT_VISION.Instance(20 * 60)
    val APPLE_STUFFING_EFFECT   = MobEffects.DIG_SPEED.Instance(20 * 60)
    val GOLDEN_STUFFING_EFFECT  = MobEffects.NIGHT_VISION.Instance(20 * 60 * 2)
    val BACON_STUFFING_EFFECT   = MobEffects.DIG_SPEED.Instance(20 * 60 * 2, 1)
    val CHICKEN_STUFFING_EFFECT = MobEffects.DAMAGE_BOOST.Instance(20 * 60)
    val EGG_STUFFING_EFFECT     = MobEffects.DAMAGE_RESISTANCE.Instance(20 * 60)
    val SUGAR_STUFFING_EFFECT   = MobEffects.MOVEMENT_SPEED.Instance(20 * 60)
    val SLAT_STUFFING_EFFECT    = MobEffects.REGENERATION.Instance(20 * 10)

    val RICE_STUFFING_APPLY     : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> }
    val FISH_STUFFING_APPLY     : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> }
    val CARROT_STUFFING_APPLY   : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> }
    val APPLE_STUFFING_APPLY    : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> }
    val GOLDEN_STUFFING_APPLY   : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> run { player.addEffect(MobEffects.REGENERATION.Instance(20 * 10)) }}
    val BACON_STUFFING_APPLY    : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> run { player.addEffect(MobEffects.DAMAGE_BOOST.Instance(20 * 30)) }}
    val CHICKEN_STUFFING_APPLY  : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> }
    val EGG_STUFFING_APPLY      : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> }
    val SUGAR_STUFFING_APPLY    : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> }
    val SLAT_STUFFING_APPLY     : (ItemStack, Level, Player) -> Unit = { item: ItemStack, world: Level, player: Player -> }

    val RICE_STUFFING_APPLY_EFFECT      : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
    val FISH_STUFFING_APPLY_EFFECT      : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
    val CARROT_STUFFING_APPLY_EFFECT    : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
    val APPLE_STUFFING_APPLY_EFFECT     : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
    val GOLDEN_STUFFING_APPLY_EFFECT    : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
    val BACON_STUFFING_APPLY_EFFECT     : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
    val CHICKEN_STUFFING_APPLY_EFFECT   : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
    val EGG_STUFFING_APPLY_EFFECT       : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
    val SUGAR_STUFFING_APPLY_EFFECT     : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
    val SLAT_STUFFING_APPLY_EFFECT      : (MobEffectInstance, Player) -> Unit = { effect: MobEffectInstance, player: Player -> run { player.addEffect(effect) }}
}