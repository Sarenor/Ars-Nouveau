package com.hollingsworth.arsnouveau.client.jei;

import com.hollingsworth.arsnouveau.api.enchanting_apparatus.EnchantmentRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.EnchantmentInstance;

import java.util.List;

public class ApparatusEnchantingRecipeCategory extends EnchantingApparatusRecipeCategory<EnchantmentRecipe> {

    public ApparatusEnchantingRecipeCategory(IGuiHelper helper) {
        super(helper);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, EnchantmentRecipe recipe, IFocusGroup focuses) {
        List<Ingredient> inputs = multiProvider.apply(recipe).input();
        double angleBetweenEach = 360.0 / inputs.size();

        for (Ingredient input : inputs) {
            builder.addSlot(RecipeIngredientRole.INPUT, (int) point.x, (int) point.y)
                    .addIngredients(input);
            point = rotatePointAbout(point, center, angleBetweenEach);
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 10).addItemStack(EnchantedBookItem.createForEnchantment(new EnchantmentInstance(recipe.enchantment, recipe.enchantLevel)));

    }

    @Override
    public Component getTitle() {
        return Component.translatable("ars_nouveau.enchanting");
    }

    @Override
    public RecipeType<EnchantmentRecipe> getRecipeType() {
        return JEIArsNouveauPlugin.ENCHANTING_RECIPE_TYPE;
    }

}
