package club.someoneice.ricedumpling.common.block

import club.someoneice.ricedumpling.common.tile.TileRiceDumplingTable
import club.someoneice.ricedumpling.util.asItemStack
import com.google.common.collect.Lists
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.phys.BlockHitResult
import net.minecraftforge.network.NetworkHooks

class BlockRiceDumplingTable: Block(Properties.copy(Blocks.OAK_WOOD).strength(0.3F).noOcclusion()), EntityBlock {
    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity = TileRiceDumplingTable(pos, state)

    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        if (!world.isClientSide) {
            val tile = world.getBlockEntity(pos)
            if (tile is TileRiceDumplingTable) {
                if (!player.isShiftKeyDown) {
                    NetworkHooks.openScreen(player as ServerPlayer, tile, pos)
                } else if (tile.chickRecipe()) {
                        player.addItem(tile.assembleRecipe());
                }
            }
        }


        return InteractionResult.sidedSuccess(world.isClientSide())
    }

    override fun onRemove(pState: BlockState, pLevel: Level, pPos: BlockPos, pNewState: BlockState, pIsMoving: Boolean) {
        (pLevel.getBlockEntity(pPos) as TileRiceDumplingTable).drops()
    }

    override fun getDrops(pState: BlockState, pParams: LootParams.Builder): ArrayList<ItemStack> {
        val list = Lists.newArrayList<ItemStack>(this.asItemStack())
        list.addAll(super.getDrops(pState, pParams))
        return list;
    }
}