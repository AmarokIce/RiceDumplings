package club.someoneice.ricedumpling.api

import club.someoneice.ricedumpling.util.copy
import com.google.common.collect.Maps
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

abstract class AbstractStuffing(name: String, food: FoodProperties, private val effect: MobEffectInstance?,
                                private val pApply: (item: ItemStack, world: Level, player: Player) -> Unit,
                                private val pApplyEffect: ((effect: MobEffectInstance, player: Player) -> Unit)?
): Item(Properties().food(food)) {
    init {
        mappingToItem[name] = this
        mappingToName[this] = name
    }

    fun apply(item: ItemStack, world: Level, player: Player) = this.pApply(item, world, player)
    fun applyEffect(player: Player) = pApplyEffect?.let { it(getFillingEffect()!!, player) }

    fun getFillingEffect(): MobEffectInstance? = effect?.copy()

    override fun finishUsingItem(item: ItemStack, world: Level, player: LivingEntity): ItemStack {
        if (player is Player) {
            this.apply(item, world, player)
            this.applyEffect(player)
        }

        return super.finishUsingItem(item, world, player)
    }

    companion object {
        val mappingToItem: HashMap<String, AbstractStuffing> = Maps.newHashMap()
        val mappingToName: HashMap<AbstractStuffing, String> = Maps.newHashMap()
    }
}