package club.someoneice.ricedumpling

import club.someoneice.ricedumpling.init.BlockList
import club.someoneice.ricedumpling.init.ItemList
import club.someoneice.ricedumpling.init.MenuInit
import club.someoneice.ricedumpling.init.TileInit
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(RiceDumpling.MODID)
object RiceDumpling {
    const val MODID = "rice_dumpling";

    init {
        ItemList.REGISTRY.register(MOD_BUS)
        BlockList.REGISTRY.register(MOD_BUS)
        TileInit.REGISTRY.register(MOD_BUS)
        MenuInit.REGISTRY.register(MOD_BUS)
    }
}