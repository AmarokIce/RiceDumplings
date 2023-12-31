package club.someoneice.ricedumpling.common.item

import club.someoneice.ricedumpling.api.AbstractLeaves
import club.someoneice.ricedumpling.api.AbstractSeasoning
import club.someoneice.ricedumpling.api.AbstractStuffing
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

open class ItemRiceDumpling(food: FoodProperties): Item(Item.Properties().food(food).stacksTo(32)) {
    override fun finishUsingItem(item: ItemStack, world: Level, player: LivingEntity): ItemStack {
        if (player is Player && !world.isClientSide) {
            val tag = item.orCreateTag

            val leaves = AbstractLeaves.mappingToItem[tag.getString(LEAVES)]
            val stuffing = AbstractStuffing.mappingToItem[tag.getString(STUFFING)]

            if (leaves == null || stuffing == null) return super.finishUsingItem(item, world, player)
            leaves.apply(player)
            stuffing.apply(item, world, player)

            if (tag.contains(SEASONING)) {
                val seasoning = AbstractSeasoning.mappingToItem[tag.getString(SEASONING)]
                seasoning?.apply(item, world, player)

                if (seasoning?.willApplyEffect!!) seasoning.applyEffect(player, stuffing)
                else stuffing.applyEffect(player)
            } else stuffing.applyEffect(player)
        }

        return super.finishUsingItem(item, world, player)
    }

    companion object {
        const val TAG_NAME  = "rice_dumpling_tag"
        const val SEASONING = "seasoning"
        const val STUFFING  = "stuffing"
        const val LEAVES    = "leaf"
    }
}