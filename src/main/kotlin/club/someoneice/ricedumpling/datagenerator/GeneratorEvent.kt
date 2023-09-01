package club.someoneice.ricedumpling.datagenerator

import club.someoneice.ricedumpling.RiceDumpling
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = RiceDumpling.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
object GeneratorEvent {
    @SubscribeEvent
    fun generator(event: GatherDataEvent) {
        val data = event.generator
        data.addProvider(true, GeneratorLanguage(data.packOutput, RiceDumpling.MODID, "en_us"))
        data.addProvider(true, GeneratorRecipes(data.packOutput))
    }
}

