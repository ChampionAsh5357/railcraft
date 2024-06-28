package mods.railcraft.world.item.tunnelbore;

import java.util.Set;
import mods.railcraft.api.carts.TunnelBoreHead;
import mods.railcraft.api.core.RailcraftConstants;
import mods.railcraft.tags.RailcraftTags;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class TunnelBoreHeadItem extends TieredItem implements TunnelBoreHead {

  private static final Set<ItemAbility> TOOL_ACTIONS =
      Set.of(ItemAbilities.AXE_DIG, ItemAbilities.PICKAXE_DIG, ItemAbilities.SHOVEL_DIG);
  private final ResourceLocation textureLocation;

  public TunnelBoreHeadItem(Tier tier, String tierName, Properties properties) {
    super(tier, properties.component(DataComponents.TOOL,
        tier.createToolProperties(RailcraftTags.Blocks.TUNNEL_BORE_MINEABLE_BLOCKS)));
    this.textureLocation =
        RailcraftConstants.rl("textures/entity/tunnel_bore/%s_tunnel_bore.png".formatted(tierName));
  }

  @Override
  public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
    return true;
  }

  @Override
  public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
    return TOOL_ACTIONS.contains(itemAbility);
  }

  @Override
  public ResourceLocation getTextureLocation() {
    return this.textureLocation;
  }
}
