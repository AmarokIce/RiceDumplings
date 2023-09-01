package club.someoneice.ricedumpling.util

import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.player.Player
import java.util.*

object LeavesApplyList {
    val DUMPLING_LEAVES: (player: Player) -> Unit = { player: Player -> run {}}
    val NETHER_LEAVES: (player: Player) -> Unit   = { player: Player -> run { player.addEffect(MobEffects.FIRE_RESISTANCE.Instance(20 * 30)) } }
    val PURPLE_LEAVES: (player: Player) -> Unit   = { player: Player ->
        run {
            val random = Random()
            val x = player.x + random.nextDouble(-10.0, 10.0)
            val y = player.y + random.nextDouble(10.0)
            val z = player.z + random.nextDouble(-10.0, 10.0)

            player.teleportTo(x, y, z)
        }
    }
}