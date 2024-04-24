package mods.railcraft.world.item.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mods.railcraft.api.core.RecipeJsonKeys;
import mods.railcraft.data.recipes.builders.BlastFurnaceRecipeBuilder;
import mods.railcraft.world.level.block.RailcraftBlocks;
import mods.railcraft.world.level.material.RailcraftFluids;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;

public class CokeOvenRecipe extends AbstractCookingRecipe {

  private final FluidStack creosote;

  public CokeOvenRecipe(Ingredient ingredient, ItemStack result,
      float experience, int cookingTime, int creosoteOutput) {
    super(RailcraftRecipeTypes.COKING.get(), "", CookingBookCategory.MISC,
        ingredient, result, experience, cookingTime);
    this.creosote = new FluidStack(RailcraftFluids.CREOSOTE.get(), creosoteOutput);
  }

  public FluidStack getCreosote() {
    return this.creosote;
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return RailcraftRecipeSerializers.COKING.get();
  }

  @Override
  public boolean isSpecial() {
    return true;
  }

  @Override
  public ItemStack getToastSymbol() {
    return new ItemStack(RailcraftBlocks.COKE_OVEN_BRICKS.get());
  }

  public static class Serializer implements RecipeSerializer<CokeOvenRecipe> {

    private static final MapCodec<CokeOvenRecipe> CODEC =
        RecordCodecBuilder.mapCodec(instance -> instance.group(
            Ingredient.CODEC_NONEMPTY.fieldOf(RecipeJsonKeys.INGREDIENT)
                .forGetter(recipe -> recipe.ingredient),
            ItemStack.CODEC.fieldOf(RecipeJsonKeys.RESULT)
                .forGetter(recipe -> recipe.result),
            Codec.FLOAT.fieldOf(RecipeJsonKeys.EXPERIENCE)
                .orElse(0.0F)
                .forGetter(recipe -> recipe.experience),
            ExtraCodecs.POSITIVE_INT.optionalFieldOf(RecipeJsonKeys.COOKING_TIME,
                    BlastFurnaceRecipeBuilder.DEFAULT_COOKING_TIME)
                .forGetter(recipe -> recipe.cookingTime),
            ExtraCodecs.POSITIVE_INT.fieldOf(RecipeJsonKeys.CREOSOTE_OUTPUT)
                .forGetter(recipe -> recipe.creosote.getAmount())
        ).apply(instance, CokeOvenRecipe::new));

    private static final StreamCodec<RegistryFriendlyByteBuf, CokeOvenRecipe> STREAM_CODEC =
        StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

    @Override
    public MapCodec<CokeOvenRecipe> codec() {
      return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CokeOvenRecipe> streamCodec() {
      return STREAM_CODEC;
    }

    private static CokeOvenRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
      var creosoteOutput = buffer.readVarInt();
      var cookingTime = buffer.readVarInt();
      var ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
      var result = ItemStack.STREAM_CODEC.decode(buffer);
      var experience = buffer.readFloat();
      return new CokeOvenRecipe(ingredient, result, experience, cookingTime, creosoteOutput);
    }

    private static void toNetwork(RegistryFriendlyByteBuf buffer, CokeOvenRecipe recipe) {
      buffer.writeVarInt(recipe.creosote.getAmount());
      buffer.writeVarInt(recipe.cookingTime);
      Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.ingredient);
      ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
      buffer.writeFloat(recipe.experience);
    }
  }
}
