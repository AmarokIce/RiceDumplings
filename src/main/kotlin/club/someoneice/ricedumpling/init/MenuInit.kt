package club.someoneice.ricedumpling.init

import club.someoneice.ricedumpling.RiceDumpling
import club.someoneice.ricedumpling.common.gui.ContainerTable
import net.minecraft.world.inventory.MenuType
import net.minecraftforge.common.extensions.IForgeMenuType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object MenuInit {
    val REGISTRY: DeferredRegister<MenuType<*>> = DeferredRegister.create(ForgeRegistries.MENU_TYPES, RiceDumpling.MODID)

    val TABLE by REGISTRY.registerObject("rice_dumpling_table") { IForgeMenuType.create {id, inv, data -> ContainerTable(id, inv ,data) }}
}