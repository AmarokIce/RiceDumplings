package club.someoneice.ricedumpling.client

import club.someoneice.ricedumpling.RiceDumpling
import club.someoneice.ricedumpling.api.AbstractLeaves
import club.someoneice.ricedumpling.common.item.ItemRiceDumpling
import club.someoneice.ricedumpling.init.ItemList
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

@Mod.EventBusSubscriber(modid = RiceDumpling.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
class ItemEvent {
    @SubscribeEvent
    fun propertyOverrideRegistry(event: FMLClientSetupEvent) {
        event.enqueueWork {
            ItemProperties.register(
                ItemList.RICE_DIMPLING,
                ResourceLocation(RiceDumpling.MODID, "leaf_color")
            ) { itemStack, _, _, _ ->
                when (AbstractLeaves.mappingToItem[itemStack.orCreateTag.getString(ItemRiceDumpling.LEAVES)]) {
                    ItemList.PURPLE_LEAVES -> 2.0F
                    ItemList.NETHER_LEAVES -> 1.0F
                    else -> 0.0F
                }
            }
        }
    }
}