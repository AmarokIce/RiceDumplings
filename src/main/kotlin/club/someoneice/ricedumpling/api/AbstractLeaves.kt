package club.someoneice.ricedumpling.api

import com.google.common.collect.Maps
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item

abstract class AbstractLeaves(
    name: String, private val pApply: (player: Player) -> Unit
): Item(Properties()) {
    init {
        mappingToItem[name] = this
        mappingToName[this] = name
    }

    fun apply(player: Player) = pApply(player)

    companion object {
        val mappingToItem: HashMap<String, AbstractLeaves> = Maps.newHashMap()
        val mappingToName: HashMap<AbstractLeaves, String> = Maps.newHashMap()
    }
}