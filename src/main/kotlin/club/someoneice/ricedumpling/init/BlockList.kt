package club.someoneice.ricedumpling.init

import club.someoneice.ricedumpling.RiceDumpling
import club.someoneice.ricedumpling.common.block.WaterCrop
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object BlockList {
    val REGISTRY: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, RiceDumpling.MODID)

    val GLUTINOUS_RICE  by REGISTRY.registerObject("glutinous_rice") { WaterCrop() }
}