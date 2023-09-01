package club.someoneice.ricedumpling.datagenerator

import club.someoneice.ricedumpling.init.ItemList
import net.minecraft.data.PackOutput

import net.minecraftforge.common.data.LanguageProvider


class GeneratorLanguage(gen: PackOutput, modid: String, locale: String) :
    LanguageProvider(gen, modid, locale) {
    override fun addTranslations() {
        for (item in ItemList.REGISTRY.entries) {
            this.add(item.get(), item.id.toString())
        }
    }
}
