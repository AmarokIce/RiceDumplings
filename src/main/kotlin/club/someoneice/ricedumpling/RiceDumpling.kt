package club.someoneice.ricedumpling

import club.someoneice.ricedumpling.client.gui.GUITable
import club.someoneice.ricedumpling.init.*
import net.minecraft.client.gui.screens.MenuScreens
import net.minecraft.client.gui.screens.Screen
import net.minecraft.client.gui.screens.inventory.MenuAccess
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import java.lang.reflect.TypeVariable


@Mod(RiceDumpling.MODID)
object RiceDumpling {
    const val MODID = "rice_dumpling";

    init {
        ItemList.REGISTRY.register(MOD_BUS)
        BlockList.REGISTRY.register(MOD_BUS)
        TileInit.REGISTRY.register(MOD_BUS)
        MenuInit.REGISTRY.register(MOD_BUS)
        TabInit.REGISTRY.register(MOD_BUS)

        MOD_BUS.addListener(this::clientSetup)
    }

    @SubscribeEvent
    fun clientSetup(event: FMLClientSetupEvent) {
        event.enqueueWork {
            MenuScreens.register(MenuInit.TABLE) { type, inv, _ -> GUITable(type, inv) }
        }
    }
}