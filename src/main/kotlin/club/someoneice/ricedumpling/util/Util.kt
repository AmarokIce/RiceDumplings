package club.someoneice.ricedumpling.util

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import java.util.*
import kotlin.random.asKotlinRandom

fun Item.asItemStack(size: Int = 1): ItemStack {
    return ItemStack(this, size);
}

fun Block.asItemStack(size: Int = 1): ItemStack {
    return ItemStack(this, size);
}

fun MobEffectInstance.copy(): MobEffectInstance = MobEffectInstance(this.effect, this.duration, this.amplifier)
fun MobEffect.Instance(duration: Int, amplifier: Int = 0) = MobEffectInstance(this, duration, amplifier)

val random = Random().asKotlinRandom()

