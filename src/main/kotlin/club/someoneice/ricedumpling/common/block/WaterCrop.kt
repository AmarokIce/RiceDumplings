package club.someoneice.ricedumpling.common.block

import club.someoneice.ricedumpling.init.ItemList
import club.someoneice.ricedumpling.util.asItemStack
import club.someoneice.ricedumpling.util.random
import com.google.common.collect.Lists
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.phys.BlockHitResult
import java.util.*

open class WaterCrop(private val crop: ItemStack = ItemStack.EMPTY) : CropBlock(Properties.copy(Blocks.GRASS)) {
    override fun mayPlaceOn(block: BlockState, getter: BlockGetter, pos: BlockPos): Boolean = block.`is`(Blocks.WATER)

    @Deprecated("Deprecated in Java")
    override fun use(block: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        return if ((block.block as CropBlock).getAge(block) >= 7) {
            val entity = ItemEntity(world, pos.x.toDouble(), pos.y + 0.5, pos.z.toDouble(), this.asItemStack(2 + random.nextInt(3)))
            world.addFreshEntity(entity)

            world.setBlockAndUpdate(pos, this.getStateForAge(0))

            InteractionResult.SUCCESS
        } else InteractionResult.FAIL
    }

    override fun getBaseSeedId(): ItemLike {
        return this.asItem()
    }

    @Deprecated("Deprecated in Java")
    override fun getDrops(state: BlockState, loot: LootParams.Builder): MutableList<ItemStack> {
        val list = Lists.newArrayList<ItemStack>(super.getDrops(state, loot))
        if (state.`is`(this) && (state.block as CropBlock).getAge(state) >= 7) {
            list.add(this.asItemStack(2))
            if (this.crop.isEmpty) list.add(this.asItemStack(Random().nextInt(2) + 1))
        } else list.add(this.asItemStack())

        return list
    }
}