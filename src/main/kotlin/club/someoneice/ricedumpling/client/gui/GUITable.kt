package club.someoneice.ricedumpling.client.gui

import club.someoneice.ricedumpling.RiceDumpling
import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.client.renderer.GameRenderer
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.player.Inventory

class GUITable(pMenu: ContainerTable, pPlayerInventory: Inventory): AbstractContainerScreen<ContainerTable>(pMenu, pPlayerInventory, Component.literal("包粽台")) {
    override fun renderBg(pGuiGraphics: GuiGraphics, pPartialTick: Float, pMouseX: Int, pMouseY: Int) {
        RenderSystem.setShader { GameRenderer.getPositionTexShader() }
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f)
        RenderSystem.setShaderTexture(0, TEXTURE);

        val x = (width - imageWidth) / 2
        val y = (height - imageHeight) / 2
        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight)
    }

    override fun render(pGuiGraphics: GuiGraphics, pMouseX: Int, pMouseY: Int, pPartialTick: Float) {
        this.renderBackground(pGuiGraphics)
        this.renderBg(pGuiGraphics, pPartialTick, pMouseX, pMouseY)
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick)
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY)
    }

    companion object {
        val TEXTURE = ResourceLocation(RiceDumpling.MODID, "textures/gui/rice_dumpling_table.png")
    }
}