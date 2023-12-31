package club.someoneice.ricedumpling.common.tile

import club.someoneice.ricedumpling.api.AbstractLeaves
import club.someoneice.ricedumpling.api.AbstractSeasoning
import club.someoneice.ricedumpling.api.AbstractStuffing
import club.someoneice.ricedumpling.client.gui.ContainerTable
import club.someoneice.ricedumpling.common.item.ItemRiceDumpling
import club.someoneice.ricedumpling.init.ItemList
import club.someoneice.ricedumpling.init.TileInit
import club.someoneice.ricedumpling.util.asItemStack
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ListTag
import net.minecraft.network.chat.Component
import net.minecraft.world.MenuProvider
import net.minecraft.world.SimpleContainer
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ForgeCapabilities
import net.minecraftforge.common.util.LazyOptional
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.wrapper.InvWrapper


class TileRiceDumplingTable(pos: BlockPos, state: BlockState): BlockEntity(TileInit.TABLE, pos, state), MenuProvider {
    private val itemList = SimpleContainer(4)
    private val handler = LazyOptional.of<IItemHandler> { InvWrapper(itemList) }

    override fun load(compoundTag: CompoundTag) {
        super.load(compoundTag)
        itemList.fromTag(compoundTag["contents"] as ListTag)
    }

    override fun saveAdditional(compoundTag: CompoundTag) {
        compoundTag.put("contents", itemList.createTag())
        super.saveAdditional(compoundTag)
    }

    override fun invalidateCaps() {
        super.invalidateCaps()
        handler.invalidate()
    }

    override fun setRemoved() {
        super.setRemoved()
        this.handler.invalidate()
    }

    fun getItem(slot: Int): ItemStack {
        return this.itemList.getItem(slot)
    }

    fun removeItem(slot: Int, remove: Int): ItemStack {
        if (slot < this.itemList.containerSize) {
            if (!this.itemList.getItem(slot).isEmpty) {
                return this.itemList.getItem(slot).split(remove)
            }
        }
        return ItemStack.EMPTY
    }

    override fun <T> getCapability(cap: Capability<T>, side: Direction?): LazyOptional<T> =
        if (cap === ForgeCapabilities.ITEM_HANDLER) handler.cast() else super.getCapability(cap, side)

    override fun createMenu(id: Int, inv: Inventory, player: Player): AbstractContainerMenu {
        return ContainerTable(id, inv, this)
    }

    override fun getDisplayName(): Component = Component.literal("")

    fun chickRecipe(): Boolean {
        var canRecipe = false
        this.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent {
            val itemLeaves   = it.getStackInSlot(0)
            val itemRice     = it.getStackInSlot(1)
            val itemStuffing = it.getStackInSlot(2)

            canRecipe = itemLeaves != ItemStack.EMPTY && itemRice != ItemStack.EMPTY && itemStuffing != ItemStack.EMPTY
                    && itemLeaves.item is AbstractLeaves
                    && itemRice.`is`(ItemList.RICE_BALL)
                    && itemStuffing.item is AbstractStuffing
        }

        return canRecipe
    }

    fun assembleRecipe(): ItemStack {
        val item: ItemStack = ItemList.RICE_DIMPLING.asItemStack()
        val itemLeaves    = this.getItem(0)
        val itemStuffing  = this.getItem(2)
        val itemSeasoning = this.getItem(3)

        val nbt = item.orCreateTag
        nbt.putString(ItemRiceDumpling.LEAVES   , AbstractLeaves.mappingToName[itemLeaves.item as AbstractLeaves]!!)
        nbt.putString(ItemRiceDumpling.STUFFING , AbstractStuffing.mappingToName[itemStuffing.item as AbstractStuffing]!!)
        if (!itemSeasoning.isEmpty) {
            nbt.putString(ItemRiceDumpling.SEASONING, AbstractSeasoning.mappingToName[itemSeasoning.item as AbstractSeasoning]!!)
            itemSeasoning.shrink(1)
            this.getLevel()?.let { world ->
                world.addFreshEntity(ItemEntity(world, this.blockPos.x + 0.5, this.blockPos.y + 1.5, this.blockPos.z + 0.5, ItemList.SEASONING_GLASS.asItemStack()))
            }
        }

        this.getItem(0).shrink(1)
        this.getItem(1).shrink(1)
        this.getItem(2).shrink(1)

        return item
    }

    fun drops() {
        fun getEntity(item: ItemStack): ItemEntity = ItemEntity(this.level!!, this.blockPos.x + 0.5, this.blockPos.y + 1.5, this.blockPos.z + 0.5, item)

        this.getLevel()!!.addFreshEntity(getEntity(this.getItem(0)))
        this.getLevel()!!.addFreshEntity(getEntity(this.getItem(1)))
        this.getLevel()!!.addFreshEntity(getEntity(this.getItem(2)))
        this.getLevel()!!.addFreshEntity(getEntity(this.getItem(3)))

        this.itemList.clearContent()
    }
}

