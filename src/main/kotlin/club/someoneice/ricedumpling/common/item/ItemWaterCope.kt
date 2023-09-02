package club.someoneice.ricedumpling.common.item

import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.ClipContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks

class ItemWaterCope(block: Block, properties: Properties): BlockItem(block, properties) {
    override fun use(world: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack> {
        val itemStack = player.getItemInHand(hand)
        return if (itemStack.isEdible) {
            if (player.canEat(itemStack.getFoodProperties(player)!!.canAlwaysEat())) {
                player.startUsingItem(hand)
                InteractionResultHolder.consume(itemStack)
            } else {
                val blockHitResult = getPlayerPOVHitResult(world, player, ClipContext.Fluid.SOURCE_ONLY)
                if (world.getBlockState(blockHitResult.blockPos).`is`(Blocks.WATER)) {
                    val blockHitResult1 = blockHitResult.withPosition(blockHitResult.blockPos.above())
                    val callBack = place(BlockPlaceContext(UseOnContext(player, hand, blockHitResult1)))
                    if (callBack == InteractionResult.SUCCESS) itemStack.shrink(1)
                    return InteractionResultHolder<ItemStack>(callBack, player.getItemInHand(hand))
                }

                InteractionResultHolder.pass(player.getItemInHand(hand))
            }
        } else {
            InteractionResultHolder.pass(player.getItemInHand(hand))
        }
    }
}