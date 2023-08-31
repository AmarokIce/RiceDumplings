package club.someoneice.ricedumpling.init

import club.someoneice.ricedumpling.RiceDumpling
import club.someoneice.ricedumpling.common.tile.TileRiceDumplingTable
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object TileInit {
    val REGISTRY: DeferredRegister<BlockEntityType<*>> = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RiceDumpling.MODID)

    val TABLE by REGISTRY.registerObject("rice_dumpling_table") {
        BlockEntityType.Builder.of({ pos: BlockPos, state: BlockState -> TileRiceDumplingTable(pos, state) }, BlockList.TABLE_BLOCK).build(null)
    }
}