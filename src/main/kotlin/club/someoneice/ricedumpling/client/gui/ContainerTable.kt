package club.someoneice.ricedumpling.client.gui

import club.someoneice.ricedumpling.common.tile.TileRiceDumplingTable
import club.someoneice.ricedumpling.init.MenuInit
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.Slot
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraftforge.common.capabilities.ForgeCapabilities
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.SlotItemHandler

class ContainerTable(id: Int, inv: Inventory, tile: BlockEntity?): AbstractContainerMenu(MenuInit.TABLE, id) {
    constructor(pContainerId: Int, inv: Inventory, data: FriendlyByteBuf): this(pContainerId, inv, inv.player.level().getBlockEntity(data.readBlockPos()))

    init {
        if (tile is TileRiceDumplingTable) {
            addPlayerHotbar(inv)
            addPlayerInventory(inv)

            class SlotInput(itemHandler: IItemHandler, var index: Int, x: Int, y: Int) :
                SlotItemHandler(itemHandler, index, x, y) {
                override fun mayPickup(playerIn: Player): Boolean = !itemHandler.extractItem(index, 1, true).isEmpty
            }

            tile.getCapability(ForgeCapabilities.ITEM_HANDLER)
                .ifPresent {
                    addSlot(SlotInput(it, 0, 81, 56))
                    addSlot(SlotInput(it, 1, 70, 33))
                    addSlot(SlotInput(it, 2, 93, 33))
                    addSlot(SlotInput(it, 3, 81, 10))
                }
        }
    }

    private val TE_INVENTORY_SLOT_COUNT = 4
    private val HOTBAR_SLOT_COUNT = 9
    private val PLAYER_INVENTORY_ROW_COUNT = 3
    private val PLAYER_INVENTORY_COLUMN_COUNT = 9
    private val PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT
    private val VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT
    private val VANILLA_FIRST_SLOT_INDEX = 0
    private val TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT

    override fun quickMoveStack(player: Player, index: Int): ItemStack {
        val sourceSlot = slots[index]
        if (!sourceSlot.hasItem()) {
            return ItemStack.EMPTY
        }
        val sourceStack = sourceSlot.item
        val copyOfSourceStack = sourceStack.copy()
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(
                    sourceStack,
                    TE_INVENTORY_FIRST_SLOT_INDEX,
                    TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT,
                    false
                )
            ) return ItemStack.EMPTY
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(
                    sourceStack,
                    VANILLA_FIRST_SLOT_INDEX,
                    VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT,
                    false
                )
            ) return ItemStack.EMPTY
        } else return ItemStack.EMPTY
        if (sourceStack.count == 0) sourceSlot.set(ItemStack.EMPTY) else sourceSlot.setChanged()
        sourceSlot.onTake(player, sourceStack)
        return copyOfSourceStack
    }

    override fun stillValid(player: Player): Boolean {
        return !player.isDeadOrDying && !player.hurtMarked
    }

    private fun addPlayerInventory(inventory: Inventory) {
        for (i in 0..2) for (l in 0..8) addSlot(Slot(inventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18))
    }

    private fun addPlayerHotbar(inventory: Inventory) {
        for (i in 0..8) {
            addSlot(Slot(inventory, i, 8 + i * 18, 142))
        }
    }

}