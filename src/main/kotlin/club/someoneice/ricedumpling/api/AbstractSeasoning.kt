package club.someoneice.ricedumpling.api

import com.google.common.collect.Maps
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

abstract class AbstractSeasoning(name: String,
    private val pApply: (item: ItemStack, world: Level, player: Player) -> Unit,
    private val pApplyEffect: ((player: Player, stuffing: AbstractStuffing) -> Unit)?,
    val willApplyEffect: Boolean = pApplyEffect != null
): Item(Properties().stacksTo(16)) {
    init {
        mappingToItem[name] = this
        mappingToName[this] = name
    }

    fun apply(item: ItemStack, world: Level, player: Player) = pApply(item, world, player)
    fun applyEffect(player: Player, stuffing: AbstractStuffing) = pApplyEffect?. let { it(player, stuffing) }

    companion object {
        val mappingToItem: HashMap<String, AbstractSeasoning> = Maps.newHashMap()
        val mappingToName: HashMap<AbstractSeasoning, String> = Maps.newHashMap()
    }
}