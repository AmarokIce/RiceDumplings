package club.someoneice.ricedumpling.datagenerator

import club.someoneice.ricedumpling.init.ItemList
import net.minecraft.advancements.critereon.InventoryChangeTrigger
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import java.util.function.Consumer

class GeneratorRecipes(data: PackOutput): RecipeProvider(data) {
    override fun buildRecipes(writer: Consumer<FinishedRecipe>) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.DIMPLING_LEAVES, 4).requires(Items.BAMBOO, 2).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.NETHER_LEAVES, 4).requires(Items.WEEPING_VINES, 2).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.PURPLE_LEAVES, 4).requires(Items.CHORUS_FLOWER, 2).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.SEASONING_GLASS, 4).requires(Items.GLASS_PANE, 2).requires(Items.GLASS_BOTTLE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.GLUTINOUS_RICE, 1).requires(Items.WHEAT_SEEDS).requires(Items.WHEAT_SEEDS).requires(Items.WHEAT_SEEDS).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.SALTED_EGG, 1).requires(Items.EGG).requires(ItemList.SALT).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.FISH_RICE_BALL, 1).requires(Items.COOKED_COD).requires(ItemList.RICE_BALL).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.RICE_STUFFING, 1).requires(ItemList.GLUTINOUS_RICE).requires(ItemList.GLUTINOUS_RICE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.FISH_STUFFING, 1).requires(Items.COOKED_COD).requires(ItemList.GLUTINOUS_RICE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.CARROT_STUFFING, 1).requires(Items.CARROT).requires(ItemList.GLUTINOUS_RICE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.BACON_STUFFING, 1).requires(ItemList.BACON).requires(ItemList.GLUTINOUS_RICE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.EGG_STUFFING, 1).requires(ItemList.SALTED_EGG).requires(ItemList.GLUTINOUS_RICE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.APPLE_STUFFING, 1).requires(Items.APPLE).requires(ItemList.GLUTINOUS_RICE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.CHICKEN_STUFFING, 1).requires(Items.CHICKEN).requires(ItemList.GLUTINOUS_RICE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.GOLDEN_STUFFING, 1).requires(Items.GOLD_NUGGET).requires(ItemList.GLUTINOUS_RICE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.GLOW_SEASONING, 1).requires(Items.GLOWSTONE_DUST).requires(ItemList.SEASONING_GLASS).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.REDSRONE_SEASONING, 1).requires(Items.REDSTONE).requires(ItemList.SEASONING_GLASS).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.GUNPOWDER_SEASONING, 1).requires(Items.GUNPOWDER).requires(ItemList.SEASONING_GLASS).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemList.SUGAR_SEASONING, 1).requires(Items.SUGAR).requires(ItemList.SEASONING_GLASS).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemList.RICE_DUMPLING_TABLE, 1)
            .pattern("###")
            .pattern("I I")
            .pattern("I I")
            .define('#', TagKey.create(Registries.ITEM, ResourceLocation("planks"))).define('I', TagKey.create(Registries.ITEM, ResourceLocation("fences"))).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemList.BACON, 1)
            .pattern("SRS")
            .pattern("RBR")
            .pattern("SRS")
            .define('S', ItemList.SALT).define('R', Items.ROTTEN_FLESH).define('B', Items.BONE).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS)).save(writer)

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.WATER_BUCKET), RecipeCategory.FOOD, ItemList.SALT, 0.5f, 200)
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemList.GLUTINOUS_RICE), RecipeCategory.FOOD, ItemList.RICE_BALL, 0.5F, 150)

    }
}