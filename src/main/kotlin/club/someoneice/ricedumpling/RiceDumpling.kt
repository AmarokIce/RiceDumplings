package club.someoneice.ricedumpling

import club.someoneice.ricedumpling.init.BlockList
import club.someoneice.ricedumpling.init.ItemList
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(RiceDumpling.MODID)
object RiceDumpling {
    const val MODID = "rice_dumpling";

    init {
        ItemList.REGISTRY.register(MOD_BUS)
        BlockList.REGISTRY.register(MOD_BUS)

    }
}