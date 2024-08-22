package mods.railcraft.world.item;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;
import com.mojang.authlib.GameProfile;
import mods.railcraft.Translations;
import mods.railcraft.api.item.Filter;
import mods.railcraft.api.item.MinecartFactory;
import mods.railcraft.world.item.component.LocomotiveColorComponent;
import mods.railcraft.world.item.component.LocomotiveOwnerComponent;
import mods.railcraft.world.item.component.LocomotiveWhistlePitchComponent;
import mods.railcraft.world.item.component.RailcraftDataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class LocomotiveItem extends CartItem implements Filter {

  public LocomotiveItem(MinecartFactory minecartPlacer, Properties properties) {
    super(minecartPlacer, properties);
  }

  @Override
  public boolean matches(ItemStack matcher, ItemStack target) {
    return target.is(this) && getColor(matcher).equals(getColor(target));
  }

  @Override
  public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip,
      TooltipFlag adv) {
    var owner = getOwner(stack);
    if (owner != null && StringUtils.isNotBlank(owner.getName())) {
      tooltip.add(Component.translatable(Translations.Tips.LOCOMOTIVE_ITEM_OWNER)
          .withStyle(ChatFormatting.AQUA)
          .append(CommonComponents.SPACE)
          .append(Component.literal(owner.getName()).withStyle(ChatFormatting.GRAY)));
    }
    var color = stack.get(RailcraftDataComponents.LOCOMOTIVE_COLOR);
    if (color != null) {
      color.addToTooltip(context, tooltip::add, adv);
    }
    var whistlePitch = stack.get(RailcraftDataComponents.LOCOMOTIVE_WHISTLE_PITCH);
    if (whistlePitch != null) {
      whistlePitch.addToTooltip(context, tooltip::add, adv);
    }
  }

  public static void setItemColorData(ItemStack stack, DyeColor primaryColor,
      DyeColor secondaryColor) {
    stack.set(RailcraftDataComponents.LOCOMOTIVE_COLOR, new LocomotiveColorComponent(primaryColor, secondaryColor));
  }

  public static void setItemWhistleData(ItemStack stack, float whistlePitch) {
    stack.set(RailcraftDataComponents.LOCOMOTIVE_WHISTLE_PITCH,
        new LocomotiveWhistlePitchComponent(whistlePitch));
  }

  public static void setOwnerData(ItemStack stack, GameProfile owner) {
    stack.set(RailcraftDataComponents.LOCOMOTIVE_OWNER, new LocomotiveOwnerComponent(owner));
  }

  @Nullable
  public static GameProfile getOwner(ItemStack stack) {
    if (stack.has(RailcraftDataComponents.LOCOMOTIVE_OWNER)) {
      return stack.get(RailcraftDataComponents.LOCOMOTIVE_OWNER).owner().gameProfile();
    }
    return null;
  }

  public static LocomotiveColorComponent getColor(ItemStack stack) {
    if (stack.has(RailcraftDataComponents.LOCOMOTIVE_COLOR)) {
      return stack.get(RailcraftDataComponents.LOCOMOTIVE_COLOR);
    }
    throw new IllegalArgumentException("locomotive_color component not found");
  }
}
