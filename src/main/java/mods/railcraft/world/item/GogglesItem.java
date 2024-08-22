package mods.railcraft.world.item;

import java.util.List;
import mods.railcraft.Translations;
import mods.railcraft.api.util.EnumUtil;
import mods.railcraft.network.to_server.UpdateAuraByKeyMessage;
import mods.railcraft.world.item.component.AuraComponent;
import mods.railcraft.world.item.component.RailcraftDataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;

public class GogglesItem extends ArmorItem {

  public GogglesItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
    super(material, type, properties);
  }

  public static Aura getAura(ItemStack itemStack) {
    if (itemStack.has(RailcraftDataComponents.AURA)) {
      return itemStack.get(RailcraftDataComponents.AURA).aura();
    }
    return Aura.NONE;
  }

  public static Aura incrementAura(ItemStack itemStack) {
    var aura = getAura(itemStack).getNext();
    if (aura == Aura.TRACKING) {
      aura.getNext();
    }
    itemStack.set(RailcraftDataComponents.AURA, new AuraComponent(aura));
    return aura;
  }

  public static void changeAuraByKey(LocalPlayer player) {
    var itemStack = player.getItemBySlot(EquipmentSlot.HEAD);
    if (itemStack.isEmpty()) {
      return;
    }
    var aura = incrementAura(itemStack);
    player.displayClientMessage(getDescriptionText(aura.getDisplayName(), false), true);
    PacketDistributor.sendToServer(new UpdateAuraByKeyMessage(aura));
  }

  public static boolean isGoggleAuraActive(Aura aura) {
    var player = Minecraft.getInstance().player;
    var itemStack = player.getItemBySlot(EquipmentSlot.HEAD);
    return itemStack.getItem() instanceof GogglesItem && getAura(itemStack) == aura;
  }

  private static Component getDescriptionText(MutableComponent value, boolean tooltip) {
    var title = Component.translatable(Translations.Tips.GOGGLES_AURA);
    if (tooltip) {
      title.withStyle(ChatFormatting.GRAY);
    }
    return title.append(CommonComponents.SPACE).append(value.withStyle(ChatFormatting.DARK_PURPLE));
  }

  @Override
  public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
    var itemStack = player.getItemInHand(hand);
    if (!level.isClientSide()) {
      var aura = incrementAura(itemStack);
      player.displayClientMessage(getDescriptionText(aura.getDisplayName(), false), true);
    }
    return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
  }

  @Override
  public void appendHoverText(ItemStack itemStack, TooltipContext context,
      List<Component> lines, TooltipFlag adv) {
    lines.add(getDescriptionText(getAura(itemStack).getDisplayName(), true));
    lines.add(Component.translatable(Translations.Tips.GOGGLES_DESC)
        .withStyle(ChatFormatting.GRAY));
  }

  public enum Aura implements StringRepresentable {

    NONE(Translations.Tips.GOGGLES_AURA_NONE),
    TRACKING(Translations.Tips.GOGGLES_AURA_TRACKING),
    TUNING(Translations.Tips.GOGGLES_AURA_TUNING),
    SHUNTING(Translations.Tips.GOGGLES_AURA_SHUNTING),
    SIGNALLING(Translations.Tips.GOGGLES_AURA_SIGNALLING),
    SURVEYING(Translations.Tips.GOGGLES_AURA_SURVEYING),
    WORLDSPIKE(Translations.Tips.GOGGLES_AURA_WORLDSPIKE);

    public static final StringRepresentable.EnumCodec<Aura> CODEC =
        StringRepresentable.fromEnum(Aura::values);
    public static final StreamCodec<FriendlyByteBuf, GogglesItem.Aura> STREAM_CODEC =
        NeoForgeStreamCodecs.enumCodec(GogglesItem.Aura.class);
    private final String name;
    private final String translationKey;

    Aura(String translationKey) {
      this.translationKey = translationKey;
      this.name = translationKey.substring(translationKey.lastIndexOf('.') + 1);
    }

    public MutableComponent getDisplayName() {
      return Component.translatable(this.translationKey);
    }

    @Override
    public String getSerializedName() {
      return this.name;
    }

    public Aura getNext() {
      return EnumUtil.next(this, values());
    }
  }
}
