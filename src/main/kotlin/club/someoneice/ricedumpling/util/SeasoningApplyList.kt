package club.someoneice.ricedumpling.util

import club.someoneice.ricedumpling.api.AbstractStuffing
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

object SeasoningApplyList {
    val EMPTY_APPLY: (item: ItemStack, world: Level, player: Player) -> Unit = {item, world, player -> run {}}

    val GUNPOWDER_APPLY: (item: ItemStack, world: Level, player: Player) -> Unit = {item, world, player -> player.remainingFireTicks = 5}
    val SUGAR_APPLY: (item: ItemStack, world: Level, player: Player) -> Unit = {item, world, player -> player.addEffect(MobEffects.MOVEMENT_SPEED.Instance(20 * 30))}

    val GLOW_SEASONING_EFFECT: (player: Player, stuffing: AbstractStuffing) -> Unit = {player, stuffing -> run {
        val effect = stuffing.getFillingEffect() ?: return@run

        player.addEffect(effect.effect.Instance(effect.duration, effect.amplifier + 1))
    }}

    val REDSTONE_SEASONING_EFFECT: (player: Player, stuffing: AbstractStuffing) -> Unit = {player, stuffing -> run {
        player.addEffect(MobEffects.GLOWING.Instance(20 * 30))

        val effect = stuffing.getFillingEffect() ?: return@run
        player.addEffect(effect.effect.Instance(effect.duration * 2, effect.amplifier))

    }}
}