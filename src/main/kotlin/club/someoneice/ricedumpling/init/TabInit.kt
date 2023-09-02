package club.someoneice.ricedumpling.init

import club.someoneice.ricedumpling.RiceDumpling
import club.someoneice.ricedumpling.util.asItemStack
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject

object TabInit {
    val REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RiceDumpling.MODID)

    val TAB = REGISTRY.registerObject("rice_dumpling_tab") {
        CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.rice_dumpling_tab"))
            .icon { ItemList.RICE_DIMPLING.asItemStack() }
            .displayItems {
                    _, output ->
                for (item in ItemList.REGISTRY.entries) output.accept(item.get())
            }.build()
    }
}