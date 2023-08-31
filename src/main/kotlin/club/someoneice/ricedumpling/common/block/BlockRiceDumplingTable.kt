package club.someoneice.ricedumpling.common.block

import club.someoneice.ricedumpling.common.tile.TileRiceDumplingTable
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult
import net.minecraftforge.network.NetworkHooks

class BlockRiceDumplingTable: Block(Properties.copy(Blocks.OAK_WOOD).strength(0.3F).noOcclusion()), EntityBlock {
    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity = TileRiceDumplingTable(pos, state)

    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        if (!world.isClientSide) {
            val tile = world.getBlockEntity(pos)
            if (tile is TileRiceDumplingTable) {
                if (!player.isShiftKeyDown) {
                    NetworkHooks.openScreen(player as ServerPlayer, tile)

                } else {
                    if (tile.chickRecipe()) {
                        val item = ItemEntity(world, pos.x + 0.5, pos.y + 1.5, pos.z + 0.5, tile.assembleRecipe())
                        world.addFreshEntity(item)
                    }
                }
            }
        }


        return InteractionResult.sidedSuccess(world.isClientSide())
    }
}