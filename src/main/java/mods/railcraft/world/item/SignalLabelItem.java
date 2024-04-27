package mods.railcraft.world.item;

import java.util.List;
import mods.railcraft.Translations.Tips;
import mods.railcraft.api.signal.entity.SignalEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;

public class SignalLabelItem extends Item {

  public SignalLabelItem(Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResult onItemUseFirst(ItemStack itemStack, UseOnContext context) {
    var level = context.getLevel();
    var player = context.getPlayer();
    if (player.isShiftKeyDown() && itemStack.has(DataComponents.CUSTOM_NAME)
        && level.getBlockEntity(context.getClickedPos()) instanceof SignalEntity signal) {
      if (!level.isClientSide()) {
        signal.setCustomName(itemStack.getHoverName());
        if (!player.isCreative()) {
          itemStack.shrink(1);
        }
      }
      return InteractionResult.sidedSuccess(level.isClientSide());
    }
    return InteractionResult.PASS;
  }

  @Override
  public void appendHoverText(ItemStack itemStack, TooltipContext context,
      List<Component> lines, TooltipFlag tooltipFlag) {
    lines.add(Component.translatable(Tips.SIGNAL_LABEL_DESC1).withStyle(ChatFormatting.BLUE));
    lines.add(Component.translatable(Tips.SIGNAL_LABEL_DESC2)
        .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
  }
}
