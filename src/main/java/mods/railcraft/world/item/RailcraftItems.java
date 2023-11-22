package mods.railcraft.world.item;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;
import mods.railcraft.api.core.RailcraftConstants;
import mods.railcraft.util.VariantSet;
import mods.railcraft.world.entity.vehicle.TankMinecart;
import mods.railcraft.world.entity.vehicle.locomotive.CreativeLocomotive;
import mods.railcraft.world.entity.vehicle.locomotive.ElectricLocomotive;
import mods.railcraft.world.entity.vehicle.locomotive.SteamLocomotive;
import mods.railcraft.world.item.tunnelbore.BronzeTunnelBoreHeadItem;
import mods.railcraft.world.item.tunnelbore.DiamondTunnelBoreHeadItem;
import mods.railcraft.world.item.tunnelbore.IronTunnelBoreHeadItem;
import mods.railcraft.world.item.tunnelbore.SteelTunnelBoreHeadItem;
import mods.railcraft.world.item.tunnelbore.TunnelBoreItem;
import mods.railcraft.world.level.block.RailcraftBlocks;
import mods.railcraft.world.level.block.track.TrackTypes;
import mods.railcraft.world.level.material.RailcraftFluids;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class RailcraftItems {

  private static final DeferredRegister.Items deferredRegister =
      DeferredRegister.createItems(RailcraftConstants.ID);

  private static final Function<Block, BlockItem> BLOCK_TO_BLOCK_ITEM =
      block -> new BlockItem(block, new Item.Properties());

  public static void register(IEventBus modEventBus) {
    deferredRegister.register(modEventBus);
  }

  public static Collection<DeferredHolder<Item, ? extends Item>> entries() {
    return deferredRegister.getEntries();
  }

  public static final VariantSet<DyeColor, Item, BlockItem> STRENGTHENED_GLASS =
      VariantSet.ofMapped(
          DyeColor.class,
          deferredRegister,
          RailcraftBlocks.STRENGTHENED_GLASS,
          BLOCK_TO_BLOCK_ITEM);
  public static final VariantSet<DyeColor, Item, BlockItem> POST =
      VariantSet.ofMapped(
          DyeColor.class,
          deferredRegister,
          RailcraftBlocks.POST,
          BLOCK_TO_BLOCK_ITEM);
  public static final VariantSet<DyeColor, Item, BlockItem> IRON_TANK_GAUGE =
      VariantSet.ofMapped(
          DyeColor.class,
          deferredRegister,
          RailcraftBlocks.IRON_TANK_GAUGE,
          BLOCK_TO_BLOCK_ITEM);
  public static final VariantSet<DyeColor, Item, BlockItem> IRON_TANK_VALVE =
      VariantSet.ofMapped(
          DyeColor.class,
          deferredRegister,
          RailcraftBlocks.IRON_TANK_VALVE,
          BLOCK_TO_BLOCK_ITEM);
  public static final VariantSet<DyeColor, Item, BlockItem> IRON_TANK_WALL =
      VariantSet.ofMapped(
          DyeColor.class,
          deferredRegister,
          RailcraftBlocks.IRON_TANK_WALL,
          BLOCK_TO_BLOCK_ITEM);
  public static final VariantSet<DyeColor, Item, BlockItem> STEEL_TANK_GAUGE =
      VariantSet.ofMapped(
          DyeColor.class,
          deferredRegister,
          RailcraftBlocks.STEEL_TANK_GAUGE,
          BLOCK_TO_BLOCK_ITEM);
  public static final VariantSet<DyeColor, Item, BlockItem> STEEL_TANK_VALVE =
      VariantSet.ofMapped(
          DyeColor.class,
          deferredRegister,
          RailcraftBlocks.STEEL_TANK_VALVE,
          BLOCK_TO_BLOCK_ITEM);
  public static final VariantSet<DyeColor, Item, BlockItem> STEEL_TANK_WALL =
      VariantSet.ofMapped(
          DyeColor.class,
          deferredRegister,
          RailcraftBlocks.STEEL_TANK_WALL,
          BLOCK_TO_BLOCK_ITEM);

  public static final DeferredItem<PressureBoilerTankBlockItem> LOW_PRESSURE_STEAM_BOILER_TANK =
      deferredRegister.register("low_pressure_steam_boiler_tank",
          () -> new PressureBoilerTankBlockItem(
              RailcraftBlocks.LOW_PRESSURE_STEAM_BOILER_TANK.get(),
              new Item.Properties()));

  public static final DeferredItem<PressureBoilerTankBlockItem> HIGH_PRESSURE_STEAM_BOILER_TANK =
      deferredRegister.register("high_pressure_steam_boiler_tank",
          () -> new PressureBoilerTankBlockItem(
              RailcraftBlocks.HIGH_PRESSURE_STEAM_BOILER_TANK.get(),
              new Item.Properties()));

  public static final DeferredItem<FueledFireboxBlockItem> SOLID_FUELED_FIREBOX =
      deferredRegister.register("solid_fueled_firebox",
          () -> new FueledFireboxBlockItem(RailcraftBlocks.SOLID_FUELED_FIREBOX.get(),
              new Item.Properties()));

  public static final DeferredItem<FueledFireboxBlockItem> FLUID_FUELED_FIREBOX =
      deferredRegister.register("fluid_fueled_firebox",
          () -> new FueledFireboxBlockItem(RailcraftBlocks.FLUID_FUELED_FIREBOX.get(),
              new Item.Properties()));

  public static final DeferredItem<Item> SIGNAL_LABEL =
      deferredRegister.register("signal_label",
          () -> new SignalLabelItem(new Item.Properties()));

  public static final DeferredItem<Item> TURBINE_BLADE = registerBasic("turbine_blade");

  public static final DeferredItem<Item> TURBINE_DISK = registerBasic("turbine_disk");

  public static final DeferredItem<Item> TURBINE_ROTOR =
      deferredRegister.register("turbine_rotor",
          () -> new TurbineRotorItem(new Item.Properties().stacksTo(1)));

  public static final DeferredItem<BlockItem> STEAM_TURBINE =
      blockItem("steam_turbine", RailcraftBlocks.STEAM_TURBINE);


  public static final DeferredItem<BlockItem> BLAST_FURNACE_BRICKS =
      blockItem("blast_furnace_bricks", RailcraftBlocks.BLAST_FURNACE_BRICKS);

  public static final DeferredItem<BlockItem> FEED_STATION =
      blockItem("feed_station", RailcraftBlocks.FEED_STATION);

  public static final DeferredItem<BlockItem> LOGBOOK =
      blockItem("logbook", RailcraftBlocks.LOGBOOK);

  public static final DeferredItem<BlockItem> FRAME_BLOCK =
      blockItem("frame", RailcraftBlocks.FRAME);

  public static final DeferredItem<Item> CHARGE_METER =
      deferredRegister.register("charge_meter",
          () -> new ChargeMeterItem(new Item.Properties()
              .durability(0)
              .stacksTo(1)));

  public static final DeferredItem<BlockItem> NICKEL_ZINC_BATTERY =
      blockItem("nickel_zinc_battery", RailcraftBlocks.NICKEL_ZINC_BATTERY);

  public static final DeferredItem<BlockItem> NICKEL_IRON_BATTERY =
      blockItem("nickel_iron_battery", RailcraftBlocks.NICKEL_IRON_BATTERY);

  public static final DeferredItem<BlockItem> ZINC_CARBON_BATTERY =
      blockItem("zinc_carbon_battery", RailcraftBlocks.ZINC_CARBON_BATTERY);

  public static final DeferredItem<BlockItem> ZINC_CARBON_BATTERY_EMPTY =
      blockItem("zinc_carbon_battery_empty", RailcraftBlocks.ZINC_CARBON_BATTERY_EMPTY);

  public static final DeferredItem<BlockItem> ZINC_SILVER_BATTERY =
      blockItem("zinc_silver_battery", RailcraftBlocks.ZINC_SILVER_BATTERY);

  public static final DeferredItem<BlockItem> ZINC_SILVER_BATTERY_EMPTY =
      blockItem("zinc_silver_battery_empty", RailcraftBlocks.ZINC_SILVER_BATTERY_EMPTY);

  public static final DeferredItem<BlockItem> STEEL_ANVIL =
      blockItem("steel_anvil", RailcraftBlocks.STEEL_ANVIL);

  public static final DeferredItem<BlockItem> CHIPPED_STEEL_ANVIL =
      blockItem("chipped_steel_anvil", RailcraftBlocks.CHIPPED_STEEL_ANVIL);

  public static final DeferredItem<BlockItem> DAMAGED_STEEL_ANVIL =
      blockItem("damaged_steel_anvil", RailcraftBlocks.DAMAGED_STEEL_ANVIL);

  public static final DeferredItem<BlockItem> STEEL_BLOCK =
      blockItem("steel_block", RailcraftBlocks.STEEL_BLOCK);

  public static final DeferredItem<BlockItem> BRASS_BLOCK =
      blockItem("brass_block", RailcraftBlocks.BRASS_BLOCK);

  public static final DeferredItem<BlockItem> BRONZE_BLOCK =
      blockItem("bronze_block", RailcraftBlocks.BRONZE_BLOCK);

  public static final DeferredItem<BlockItem> INVAR_BLOCK =
      blockItem("invar_block", RailcraftBlocks.INVAR_BLOCK);

  public static final DeferredItem<BlockItem> LEAD_BLOCK =
      blockItem("lead_block", RailcraftBlocks.LEAD_BLOCK);

  public static final DeferredItem<BlockItem> NICKEL_BLOCK =
      blockItem("nickel_block", RailcraftBlocks.NICKEL_BLOCK);

  public static final DeferredItem<BlockItem> SILVER_BLOCK =
      blockItem("silver_block", RailcraftBlocks.SILVER_BLOCK);

  public static final DeferredItem<BlockItem> TIN_BLOCK =
      blockItem("tin_block", RailcraftBlocks.TIN_BLOCK);

  public static final DeferredItem<BlockItem> ZINC_BLOCK =
      blockItem("zinc_block", RailcraftBlocks.ZINC_BLOCK);

  public static final DeferredItem<BlockItem> LEAD_ORE =
      blockItem("lead_ore", RailcraftBlocks.LEAD_ORE);

  public static final DeferredItem<BlockItem> NICKEL_ORE =
      blockItem("nickel_ore", RailcraftBlocks.NICKEL_ORE);

  public static final DeferredItem<BlockItem> SILVER_ORE =
      blockItem("silver_ore", RailcraftBlocks.SILVER_ORE);

  public static final DeferredItem<BlockItem> TIN_ORE =
      blockItem("tin_ore", RailcraftBlocks.TIN_ORE);

  public static final DeferredItem<BlockItem> ZINC_ORE =
      blockItem("zinc_ore", RailcraftBlocks.ZINC_ORE);

  public static final DeferredItem<BlockItem> DEEPSLATE_LEAD_ORE =
      blockItem("deepslate_lead_ore", RailcraftBlocks.DEEPSLATE_LEAD_ORE);

  public static final DeferredItem<BlockItem> DEEPSLATE_NICKEL_ORE =
      blockItem("deepslate_nickel_ore", RailcraftBlocks.DEEPSLATE_NICKEL_ORE);

  public static final DeferredItem<BlockItem> DEEPSLATE_SILVER_ORE =
      blockItem("deepslate_silver_ore", RailcraftBlocks.DEEPSLATE_SILVER_ORE);

  public static final DeferredItem<BlockItem> DEEPSLATE_TIN_ORE =
      blockItem("deepslate_tin_ore", RailcraftBlocks.DEEPSLATE_TIN_ORE);

  public static final DeferredItem<BlockItem> DEEPSLATE_ZINC_ORE =
      blockItem("deepslate_zinc_ore", RailcraftBlocks.DEEPSLATE_ZINC_ORE);

  public static final DeferredItem<BlockItem> SULFUR_ORE =
      blockItem("sulfur_ore", RailcraftBlocks.SULFUR_ORE);

  public static final DeferredItem<BlockItem> DEEPSLATE_SULFUR_ORE =
      blockItem("deepslate_sulfur_ore", RailcraftBlocks.DEEPSLATE_SULFUR_ORE);

  public static final DeferredItem<BlockItem> SALTPETER_ORE =
      blockItem("saltpeter_ore", RailcraftBlocks.SALTPETER_ORE);

  public static final DeferredItem<BlockItem> COKE_BLOCK =
      deferredRegister.register("coal_coke_block",
          () -> new CoalCokeBlockItem(new Properties()));

  public static final DeferredItem<Item> STEEL_SHEARS =
      deferredRegister.register("steel_shears",
          () -> new ShearsItem(new Item.Properties()
              .durability(500)));

  public static final DeferredItem<Item> STEEL_SWORD =
      deferredRegister.register("steel_sword",
          () -> new SwordItem(RailcraftItemTier.STEEL, 3, -2.4F,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_SHOVEL =
      deferredRegister.register("steel_shovel",
          () -> new ShovelItem(RailcraftItemTier.STEEL, 1.5F, -3.0F,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_PICKAXE =
      deferredRegister.register("steel_pickaxe",
          () -> new PickaxeItem(RailcraftItemTier.STEEL, 1, -2.8F,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_AXE =
      deferredRegister.register("steel_axe",
          () -> new AxeItem(RailcraftItemTier.STEEL, 8.0F, -3F,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_HOE =
      deferredRegister.register("steel_hoe",
          () -> new HoeItem(RailcraftItemTier.STEEL, -2, -0.5F,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_BOOTS =
      deferredRegister.register("steel_boots",
          () -> new ArmorItem(RailcraftArmorMaterial.STEEL, ArmorItem.Type.BOOTS,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_CHESTPLATE =
      deferredRegister.register("steel_chestplate",
          () -> new ArmorItem(RailcraftArmorMaterial.STEEL, ArmorItem.Type.CHESTPLATE,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_HELMET =
      deferredRegister.register("steel_helmet",
          () -> new ArmorItem(RailcraftArmorMaterial.STEEL, ArmorItem.Type.HELMET,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_LEGGINGS =
      deferredRegister.register("steel_leggings",
          () -> new ArmorItem(RailcraftArmorMaterial.STEEL, ArmorItem.Type.LEGGINGS,
              new Item.Properties()));

  public static final DeferredItem<Item> IRON_TUNNEL_BORE_HEAD =
      deferredRegister.register("iron_tunnel_bore_head",
          () -> new IronTunnelBoreHeadItem(new Item.Properties()
              .durability(1500)));

  public static final DeferredItem<Item> BRONZE_TUNNEL_BORE_HEAD =
      deferredRegister.register("bronze_tunnel_bore_head",
          () -> new BronzeTunnelBoreHeadItem(new Item.Properties()
              .durability(1200)));

  public static final DeferredItem<Item> STEEL_TUNNEL_BORE_HEAD =
      deferredRegister.register("steel_tunnel_bore_head",
          () -> new SteelTunnelBoreHeadItem(
              new Item.Properties()
                  .durability(3000)));

  public static final DeferredItem<Item> DIAMOND_TUNNEL_BORE_HEAD =
      deferredRegister.register("diamond_tunnel_bore_head",
          () -> new DiamondTunnelBoreHeadItem(new Item.Properties()
              .durability(6000)));

  public static final DeferredItem<Item> TANK_MINECART =
      deferredRegister.register("tank_minecart",
          () -> new CartItem(TankMinecart::new,
              new Item.Properties()
                  .stacksTo(1)));

  public static final DeferredItem<BlockItem> FLUID_LOADER =
      blockItem("fluid_loader", RailcraftBlocks.FLUID_LOADER);

  public static final DeferredItem<BlockItem> FLUID_UNLOADER =
      blockItem("fluid_unloader", RailcraftBlocks.FLUID_UNLOADER);

  public static final DeferredItem<BlockItem> ADVANCED_ITEM_LOADER =
      blockItem("advanced_item_loader", RailcraftBlocks.ADVANCED_ITEM_LOADER);

  public static final DeferredItem<BlockItem> ADVANCED_ITEM_UNLOADER =
      blockItem("advanced_item_unloader", RailcraftBlocks.ADVANCED_ITEM_UNLOADER);

  public static final DeferredItem<BlockItem> ITEM_LOADER =
      blockItem("item_loader", RailcraftBlocks.ITEM_LOADER);

  public static final DeferredItem<BlockItem> ITEM_UNLOADER =
      blockItem("item_unloader", RailcraftBlocks.ITEM_UNLOADER);

  public static final DeferredItem<BlockItem> CART_DISPENSER =
      blockItem("cart_dispenser", RailcraftBlocks.CART_DISPENSER);

  public static final DeferredItem<BlockItem> TRAIN_DISPENSER =
      blockItem("train_dispenser", RailcraftBlocks.TRAIN_DISPENSER);

  public static final DeferredItem<Item> IRON_SPIKE_MAUL =
      deferredRegister.register("iron_spike_maul",
          () -> new SpikeMaulItem(11.0F, -3.5F, Tiers.IRON,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_SPIKE_MAUL =
      deferredRegister.register("steel_spike_maul",
          () -> new SpikeMaulItem(11.0F, -3.4F, RailcraftItemTier.STEEL,
              new Item.Properties()));

  public static final DeferredItem<Item> DIAMOND_SPIKE_MAUL =
      deferredRegister.register("diamond_spike_maul",
          () -> new SpikeMaulItem(11.0F, -3.3F, Tiers.DIAMOND,
              new Item.Properties()));

  public static final DeferredItem<BlockItem> SWITCH_TRACK_LEVER =
      blockItem("switch_track_lever", RailcraftBlocks.SWITCH_TRACK_LEVER);

  public static final DeferredItem<BlockItem> SWITCH_TRACK_MOTOR =
      blockItem("switch_track_motor", RailcraftBlocks.SWITCH_TRACK_MOTOR);

  public static final DeferredItem<BlockItem> SWITCH_TRACK_ROUTER =
      blockItem("switch_track_router", RailcraftBlocks.SWITCH_TRACK_ROUTER);

  public static final DeferredItem<Item> SIGNAL_TUNER =
      deferredRegister.register("signal_tuner",
          () -> new SignalTunerItem(new Item.Properties().stacksTo(1)));

  public static final DeferredItem<Item> SIGNAL_BLOCK_SURVEYOR =
      deferredRegister.register("signal_block_surveyor",
          () -> new SignalBlockSurveyorItem(new Item.Properties().stacksTo(1)));

  public static final DeferredItem<BlockItem> ANALOG_SIGNAL_CONTROLLER_BOX =
      blockItem("analog_signal_controller_box", RailcraftBlocks.ANALOG_SIGNAL_CONTROLLER_BOX);

  public static final DeferredItem<BlockItem> SIGNAL_SEQUENCER_BOX =
      blockItem("signal_sequencer_box", RailcraftBlocks.SIGNAL_SEQUENCER_BOX);

  public static final DeferredItem<BlockItem> SIGNAL_CAPACITOR_BOX =
      blockItem("signal_capacitor_box", RailcraftBlocks.SIGNAL_CAPACITOR_BOX);

  public static final DeferredItem<BlockItem> SIGNAL_INTERLOCK_BOX =
      blockItem("signal_interlock_box", RailcraftBlocks.SIGNAL_INTERLOCK_BOX);

  public static final DeferredItem<BlockItem> SIGNAL_BLOCK_RELAY_BOX =
      blockItem("signal_block_relay_box", RailcraftBlocks.SIGNAL_BLOCK_RELAY_BOX);

  public static final DeferredItem<BlockItem> SIGNAL_RECEIVER_BOX =
      blockItem("signal_receiver_box", RailcraftBlocks.SIGNAL_RECEIVER_BOX);

  public static final DeferredItem<BlockItem> SIGNAL_CONTROLLER_BOX =
      blockItem("signal_controller_box", RailcraftBlocks.SIGNAL_CONTROLLER_BOX);

  public static final DeferredItem<BlockItem> DUAL_BLOCK_SIGNAL =
      blockItem("dual_block_signal", RailcraftBlocks.DUAL_BLOCK_SIGNAL);

  public static final DeferredItem<BlockItem> DUAL_DISTANT_SIGNAL =
      blockItem("dual_distant_signal", RailcraftBlocks.DUAL_DISTANT_SIGNAL);

  public static final DeferredItem<BlockItem> DUAL_TOKEN_SIGNAL =
      blockItem("dual_token_signal", RailcraftBlocks.DUAL_TOKEN_SIGNAL);

  public static final DeferredItem<BlockItem> BLOCK_SIGNAL =
      blockItem("block_signal", RailcraftBlocks.BLOCK_SIGNAL);

  public static final DeferredItem<BlockItem> DISTANT_SIGNAL =
      blockItem("distant_signal", RailcraftBlocks.DISTANT_SIGNAL);

  public static final DeferredItem<BlockItem> TOKEN_SIGNAL =
      blockItem("token_signal", RailcraftBlocks.TOKEN_SIGNAL);

  public static final DeferredItem<TrackRemoverCartItem> TRACK_REMOVER =
      deferredRegister.register("track_remover",
          () -> new TrackRemoverCartItem(new Item.Properties()
              .rarity(Rarity.UNCOMMON)
              .stacksTo(1)));

  public static final DeferredItem<TrackLayerCartItem> TRACK_LAYER =
      deferredRegister.register("track_layer",
          () -> new TrackLayerCartItem(new Item.Properties()
              .rarity(Rarity.UNCOMMON)
              .stacksTo(1)));

  public static final DeferredItem<TrackRelayerCartItem> TRACK_RELAYER =
      deferredRegister.register("track_relayer",
          () -> new TrackRelayerCartItem(new Item.Properties()
              .rarity(Rarity.UNCOMMON)
              .stacksTo(1)));

  public static final DeferredItem<TrackUndercutterCartItem> TRACK_UNDERCUTTER =
      deferredRegister.register("track_undercutter",
          () -> new TrackUndercutterCartItem(new Item.Properties()
              .rarity(Rarity.UNCOMMON)
              .stacksTo(1)));

  public static final DeferredItem<Item> TUNNEL_BORE =
      deferredRegister.register("tunnel_bore",
          () -> new TunnelBoreItem(new Item.Properties()
              .rarity(Rarity.UNCOMMON)
              .stacksTo(1)));

  public static final DeferredItem<Item> CREATIVE_LOCOMOTIVE =
      deferredRegister.register("creative_locomotive",
          () -> new LocomotiveItem(CreativeLocomotive::new,
              DyeColor.BLACK, DyeColor.MAGENTA,
              new Item.Properties()
                  .stacksTo(1)));

  public static final DeferredItem<Item> ELECTRIC_LOCOMOTIVE =
      deferredRegister.register("electric_locomotive",
          () -> new LocomotiveItem(ElectricLocomotive::new,
              DyeColor.YELLOW, DyeColor.BLACK,
              new Item.Properties()
                  .stacksTo(1)));

  public static final DeferredItem<Item> STEAM_LOCOMOTIVE =
      deferredRegister.register("steam_locomotive",
          () -> new LocomotiveItem(SteamLocomotive::new,
              DyeColor.LIGHT_GRAY, DyeColor.GRAY,
              new Item.Properties()
                  .stacksTo(1)));

  public static final DeferredItem<Item> WHISTLE_TUNER =
      deferredRegister.register("whistle_tuner",
          () -> new Item(new Item.Properties().durability(250)));

  public static final DeferredItem<Item> GOLDEN_TICKET =
      deferredRegister.register("golden_ticket",
          () -> new GoldenTicketItem(new Item.Properties()
              .rarity(Rarity.UNCOMMON)));

  public static final DeferredItem<Item> TICKET =
      deferredRegister.register("ticket",
          () -> new TicketItem(new Item.Properties()));

  public static final DeferredItem<Item> ROUTING_TABLE_BOOK =
      deferredRegister.register("routing_table_book",
          () -> new RoutingTableBookItem(new Item.Properties()));

  public static final DeferredItem<Item> OVERALLS =
      deferredRegister.register("overalls",
          () -> new OverallsItem(new Item.Properties()));

  public static final DeferredItem<FirestoneOreBlockItem> FIRESTONE_ORE =
      deferredRegister.register("firestone_ore", () -> new FirestoneOreBlockItem(
          new Item.Properties()));

  public static final DeferredItem<FirestoneItem> RAW_FIRESTONE =
      deferredRegister.register("raw_firestone",
          () -> new FirestoneItem(true,
              new Item.Properties().rarity(Rarity.RARE)));

  public static final DeferredItem<RefinedFirestoneItem> REFINED_FIRESTONE =
      deferredRegister.register("refined_firestone",
          () -> new RefinedFirestoneItem(false, new Item.Properties()
              .stacksTo(1)
              .durability(RefinedFirestoneItem.CHARGES)
              .rarity(Rarity.RARE)));

  public static final DeferredItem<CrackedFirestoneItem> CRACKED_FIRESTONE =
      deferredRegister.register("cracked_firestone",
          () -> new CrackedFirestoneItem(new Item.Properties()
              .stacksTo(1)
              .durability(RefinedFirestoneItem.CHARGES)
              .rarity(Rarity.RARE)));

  public static final DeferredItem<FirestoneItem> CUT_FIRESTONE =
      deferredRegister.register("cut_firestone",
          () -> new FirestoneItem(true,
              new Item.Properties()
                  .stacksTo(1)
                  .durability(RefinedFirestoneItem.CHARGES)
                  .rarity(Rarity.RARE)));

  public static final DeferredItem<BlockItem> FORCE_TRACK_EMITTER =
      blockItem("force_track_emitter", RailcraftBlocks.FORCE_TRACK_EMITTER);

  public static final DeferredItem<BlockItem> ABANDONED_TRACK =
      blockItem("abandoned_track", RailcraftBlocks.ABANDONED_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_LOCKING_TRACK =
      blockItem("abandoned_locking_track", RailcraftBlocks.ABANDONED_LOCKING_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_BUFFER_STOP_TRACK =
      blockItem("abandoned_buffer_stop_track", RailcraftBlocks.ABANDONED_BUFFER_STOP_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_ACTIVATOR_TRACK =
      blockItem("abandoned_activator_track", RailcraftBlocks.ABANDONED_ACTIVATOR_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_BOOSTER_TRACK =
      blockItem("abandoned_booster_track", RailcraftBlocks.ABANDONED_BOOSTER_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_CONTROL_TRACK =
      blockItem("abandoned_control_track", RailcraftBlocks.ABANDONED_CONTROL_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_GATED_TRACK =
      blockItem("abandoned_gated_track", RailcraftBlocks.ABANDONED_GATED_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_DETECTOR_TRACK =
      blockItem("abandoned_detector_track", RailcraftBlocks.ABANDONED_DETECTOR_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_COUPLER_TRACK =
      blockItem("abandoned_coupler_track", RailcraftBlocks.ABANDONED_COUPLER_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_EMBARKING_TRACK =
      blockItem("abandoned_embarking_track", RailcraftBlocks.ABANDONED_EMBARKING_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_DISEMBARKING_TRACK =
      blockItem("abandoned_disembarking_track", RailcraftBlocks.ABANDONED_DISEMBARKING_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_DUMPING_TRACK =
      blockItem("abandoned_dumping_track", RailcraftBlocks.ABANDONED_DUMPING_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_WYE_TRACK =
      blockItem("abandoned_wye_track", RailcraftBlocks.ABANDONED_WYE_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_TURNOUT_TRACK =
      blockItem("abandoned_turnout_track", RailcraftBlocks.ABANDONED_TURNOUT_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_JUNCTION_TRACK =
      blockItem("abandoned_junction_track", RailcraftBlocks.ABANDONED_JUNCTION_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_LAUNCHER_TRACK =
      blockItem("abandoned_launcher_track", RailcraftBlocks.ABANDONED_LAUNCHER_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_ONE_WAY_TRACK =
      blockItem("abandoned_one_way_track", RailcraftBlocks.ABANDONED_ONE_WAY_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_WHISTLE_TRACK =
      blockItem("abandoned_whistle_track", RailcraftBlocks.ABANDONED_WHISTLE_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_LOCOMOTIVE_TRACK =
      blockItem("abandoned_locomotive_track", RailcraftBlocks.ABANDONED_LOCOMOTIVE_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_THROTTLE_TRACK =
      blockItem("abandoned_throttle_track", RailcraftBlocks.ABANDONED_THROTTLE_TRACK);

  public static final DeferredItem<BlockItem> ABANDONED_ROUTING_TRACK =
      blockItem("abandoned_routing_track", RailcraftBlocks.ABANDONED_ROUTING_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_TRACK =
      blockItem("electric_track", RailcraftBlocks.ELECTRIC_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_LOCKING_TRACK =
      blockItem("electric_locking_track", RailcraftBlocks.ELECTRIC_LOCKING_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_BUFFER_STOP_TRACK =
      blockItem("electric_buffer_stop_track", RailcraftBlocks.ELECTRIC_BUFFER_STOP_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_ACTIVATOR_TRACK =
      blockItem("electric_activator_track", RailcraftBlocks.ELECTRIC_ACTIVATOR_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_BOOSTER_TRACK =
      blockItem("electric_booster_track", RailcraftBlocks.ELECTRIC_BOOSTER_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_CONTROL_TRACK =
      blockItem("electric_control_track", RailcraftBlocks.ELECTRIC_CONTROL_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_GATED_TRACK =
      blockItem("electric_gated_track", RailcraftBlocks.ELECTRIC_GATED_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_DETECTOR_TRACK =
      blockItem("electric_detector_track", RailcraftBlocks.ELECTRIC_DETECTOR_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_COUPLER_TRACK =
      blockItem("electric_coupler_track", RailcraftBlocks.ELECTRIC_COUPLER_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_EMBARKING_TRACK =
      blockItem("electric_embarking_track", RailcraftBlocks.ELECTRIC_EMBARKING_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_DISEMBARKING_TRACK =
      blockItem("electric_disembarking_track", RailcraftBlocks.ELECTRIC_DISEMBARKING_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_DUMPING_TRACK =
      blockItem("electric_dumping_track", RailcraftBlocks.ELECTRIC_DUMPING_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_WYE_TRACK =
      blockItem("electric_wye_track", RailcraftBlocks.ELECTRIC_WYE_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_TURNOUT_TRACK =
      blockItem("electric_turnout_track", RailcraftBlocks.ELECTRIC_TURNOUT_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_JUNCTION_TRACK =
      blockItem("electric_junction_track", RailcraftBlocks.ELECTRIC_JUNCTION_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_LAUNCHER_TRACK =
      blockItem("electric_launcher_track", RailcraftBlocks.ELECTRIC_LAUNCHER_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_ONE_WAY_TRACK =
      blockItem("electric_one_way_track", RailcraftBlocks.ELECTRIC_ONE_WAY_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_WHISTLE_TRACK =
      blockItem("electric_whistle_track", RailcraftBlocks.ELECTRIC_WHISTLE_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_LOCOMOTIVE_TRACK =
      blockItem("electric_locomotive_track", RailcraftBlocks.ELECTRIC_LOCOMOTIVE_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_THROTTLE_TRACK =
      blockItem("electric_throttle_track", RailcraftBlocks.ELECTRIC_THROTTLE_TRACK);

  public static final DeferredItem<BlockItem> ELECTRIC_ROUTING_TRACK =
      blockItem("electric_routing_track", RailcraftBlocks.ELECTRIC_ROUTING_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_TRACK =
      blockItem("high_speed_track", RailcraftBlocks.HIGH_SPEED_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_TRANSITION_TRACK =
      blockItem("high_speed_transition_track", RailcraftBlocks.HIGH_SPEED_TRANSITION_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_LOCKING_TRACK =
      blockItem("high_speed_locking_track", RailcraftBlocks.HIGH_SPEED_LOCKING_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ACTIVATOR_TRACK =
      blockItem("high_speed_activator_track", RailcraftBlocks.HIGH_SPEED_ACTIVATOR_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_BOOSTER_TRACK =
      blockItem("high_speed_booster_track", RailcraftBlocks.HIGH_SPEED_BOOSTER_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_DETECTOR_TRACK =
      blockItem("high_speed_detector_track", RailcraftBlocks.HIGH_SPEED_DETECTOR_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_WYE_TRACK =
      blockItem("high_speed_wye_track", RailcraftBlocks.HIGH_SPEED_WYE_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_TURNOUT_TRACK =
      blockItem("high_speed_turnout_track", RailcraftBlocks.HIGH_SPEED_TURNOUT_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_JUNCTION_TRACK =
      blockItem("high_speed_junction_track", RailcraftBlocks.HIGH_SPEED_JUNCTION_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_WHISTLE_TRACK =
      blockItem("high_speed_whistle_track", RailcraftBlocks.HIGH_SPEED_WHISTLE_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_LOCOMOTIVE_TRACK =
      blockItem("high_speed_locomotive_track", RailcraftBlocks.HIGH_SPEED_LOCOMOTIVE_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_THROTTLE_TRACK =
      blockItem("high_speed_throttle_track", RailcraftBlocks.HIGH_SPEED_THROTTLE_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_TRACK =
      blockItem("high_speed_electric_track", RailcraftBlocks.HIGH_SPEED_ELECTRIC_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_TRANSITION_TRACK =
      blockItem("high_speed_electric_transition_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_TRANSITION_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_LOCKING_TRACK =
      blockItem("high_speed_electric_locking_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_LOCKING_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_ACTIVATOR_TRACK =
      blockItem("high_speed_electric_activator_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_ACTIVATOR_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_BOOSTER_TRACK =
      blockItem("high_speed_electric_booster_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_BOOSTER_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_DETECTOR_TRACK =
      blockItem("high_speed_electric_detector_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_DETECTOR_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_WYE_TRACK =
      blockItem("high_speed_electric_wye_track", RailcraftBlocks.HIGH_SPEED_ELECTRIC_WYE_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_TURNOUT_TRACK =
      blockItem("high_speed_electric_turnout_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_TURNOUT_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_JUNCTION_TRACK =
      blockItem("high_speed_electric_junction_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_JUNCTION_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_WHISTLE_TRACK =
      blockItem("high_speed_electric_whistle_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_WHISTLE_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_LOCOMOTIVE_TRACK =
      blockItem("high_speed_electric_locomotive_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_LOCOMOTIVE_TRACK);

  public static final DeferredItem<BlockItem> HIGH_SPEED_ELECTRIC_THROTTLE_TRACK =
      blockItem("high_speed_electric_throttle_track",
          RailcraftBlocks.HIGH_SPEED_ELECTRIC_THROTTLE_TRACK);

  public static final DeferredItem<BlockItem> IRON_LOCKING_TRACK =
      blockItem("iron_locking_track", RailcraftBlocks.IRON_LOCKING_TRACK);

  public static final DeferredItem<BlockItem> IRON_BUFFER_STOP_TRACK =
      blockItem("iron_buffer_stop_track", RailcraftBlocks.IRON_BUFFER_STOP_TRACK);

  public static final DeferredItem<BlockItem> IRON_ACTIVATOR_TRACK =
      blockItem("iron_activator_track", RailcraftBlocks.IRON_ACTIVATOR_TRACK);

  public static final DeferredItem<BlockItem> IRON_BOOSTER_TRACK =
      blockItem("iron_booster_track", RailcraftBlocks.IRON_BOOSTER_TRACK);

  public static final DeferredItem<BlockItem> IRON_CONTROL_TRACK =
      blockItem("iron_control_track", RailcraftBlocks.IRON_CONTROL_TRACK);

  public static final DeferredItem<BlockItem> IRON_GATED_TRACK =
      blockItem("iron_gated_track", RailcraftBlocks.IRON_GATED_TRACK);

  public static final DeferredItem<BlockItem> IRON_DETECTOR_TRACK =
      blockItem("iron_detector_track", RailcraftBlocks.IRON_DETECTOR_TRACK);

  public static final DeferredItem<BlockItem> IRON_COUPLER_TRACK =
      blockItem("iron_coupler_track", RailcraftBlocks.IRON_COUPLER_TRACK);

  public static final DeferredItem<BlockItem> IRON_EMBARKING_TRACK =
      blockItem("iron_embarking_track", RailcraftBlocks.IRON_EMBARKING_TRACK);

  public static final DeferredItem<BlockItem> IRON_DISEMBARKING_TRACK =
      blockItem("iron_disembarking_track", RailcraftBlocks.IRON_DISEMBARKING_TRACK);

  public static final DeferredItem<BlockItem> IRON_DUMPING_TRACK =
      blockItem("iron_dumping_track", RailcraftBlocks.IRON_DUMPING_TRACK);

  public static final DeferredItem<BlockItem> IRON_WYE_TRACK =
      blockItem("iron_wye_track", RailcraftBlocks.IRON_WYE_TRACK);

  public static final DeferredItem<BlockItem> IRON_TURNOUT_TRACK =
      blockItem("iron_turnout_track", RailcraftBlocks.IRON_TURNOUT_TRACK);

  public static final DeferredItem<BlockItem> IRON_JUNCTION_TRACK =
      blockItem("iron_junction_track", RailcraftBlocks.IRON_JUNCTION_TRACK);

  public static final DeferredItem<BlockItem> IRON_LAUNCHER_TRACK =
      blockItem("iron_launcher_track", RailcraftBlocks.IRON_LAUNCHER_TRACK);

  public static final DeferredItem<BlockItem> IRON_ONE_WAY_TRACK =
      blockItem("iron_one_way_track", RailcraftBlocks.IRON_ONE_WAY_TRACK);

  public static final DeferredItem<BlockItem> IRON_WHISTLE_TRACK =
      blockItem("iron_whistle_track", RailcraftBlocks.IRON_WHISTLE_TRACK);

  public static final DeferredItem<BlockItem> IRON_LOCOMOTIVE_TRACK =
      blockItem("iron_locomotive_track", RailcraftBlocks.IRON_LOCOMOTIVE_TRACK);

  public static final DeferredItem<BlockItem> IRON_THROTTLE_TRACK =
      blockItem("iron_throttle_track", RailcraftBlocks.IRON_THROTTLE_TRACK);

  public static final DeferredItem<BlockItem> IRON_ROUTING_TRACK =
      blockItem("iron_routing_track", RailcraftBlocks.IRON_ROUTING_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_TRACK =
      blockItem("reinforced_track", RailcraftBlocks.REINFORCED_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_LOCKING_TRACK =
      blockItem("reinforced_locking_track", RailcraftBlocks.REINFORCED_LOCKING_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_BUFFER_STOP_TRACK =
      blockItem("reinforced_buffer_stop_track", RailcraftBlocks.REINFORCED_BUFFER_STOP_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_ACTIVATOR_TRACK =
      blockItem("reinforced_activator_track", RailcraftBlocks.REINFORCED_ACTIVATOR_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_BOOSTER_TRACK =
      blockItem("reinforced_booster_track", RailcraftBlocks.REINFORCED_BOOSTER_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_CONTROL_TRACK =
      blockItem("reinforced_control_track", RailcraftBlocks.REINFORCED_CONTROL_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_GATED_TRACK =
      blockItem("reinforced_gated_track", RailcraftBlocks.REINFORCED_GATED_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_DETECTOR_TRACK =
      blockItem("reinforced_detector_track", RailcraftBlocks.REINFORCED_DETECTOR_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_COUPLER_TRACK =
      blockItem("reinforced_coupler_track", RailcraftBlocks.REINFORCED_COUPLER_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_EMBARKING_TRACK =
      blockItem("reinforced_embarking_track", RailcraftBlocks.REINFORCED_EMBARKING_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_DISEMBARKING_TRACK =
      blockItem("reinforced_disembarking_track", RailcraftBlocks.REINFORCED_DISEMBARKING_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_DUMPING_TRACK =
      blockItem("reinforced_dumping_track", RailcraftBlocks.REINFORCED_DUMPING_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_WYE_TRACK =
      blockItem("reinforced_wye_track", RailcraftBlocks.REINFORCED_WYE_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_TURNOUT_TRACK =
      blockItem("reinforced_turnout_track", RailcraftBlocks.REINFORCED_TURNOUT_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_JUNCTION_TRACK =
      blockItem("reinforced_junction_track", RailcraftBlocks.REINFORCED_JUNCTION_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_LAUNCHER_TRACK =
      blockItem("reinforced_launcher_track", RailcraftBlocks.REINFORCED_LAUNCHER_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_ONE_WAY_TRACK =
      blockItem("reinforced_one_way_track", RailcraftBlocks.REINFORCED_ONE_WAY_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_WHISTLE_TRACK =
      blockItem("reinforced_whistle_track", RailcraftBlocks.REINFORCED_WHISTLE_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_LOCOMOTIVE_TRACK =
      blockItem("reinforced_locomotive_track", RailcraftBlocks.REINFORCED_LOCOMOTIVE_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_THROTTLE_TRACK =
      blockItem("reinforced_throttle_track", RailcraftBlocks.REINFORCED_THROTTLE_TRACK);

  public static final DeferredItem<BlockItem> REINFORCED_ROUTING_TRACK =
      blockItem("reinforced_routing_track", RailcraftBlocks.REINFORCED_ROUTING_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_TRACK =
      blockItem("strap_iron_track", RailcraftBlocks.STRAP_IRON_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_LOCKING_TRACK =
      blockItem("strap_iron_locking_track", RailcraftBlocks.STRAP_IRON_LOCKING_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_BUFFER_STOP_TRACK =
      blockItem("strap_iron_buffer_stop_track", RailcraftBlocks.STRAP_IRON_BUFFER_STOP_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_ACTIVATOR_TRACK =
      blockItem("strap_iron_activator_track", RailcraftBlocks.STRAP_IRON_ACTIVATOR_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_BOOSTER_TRACK =
      blockItem("strap_iron_booster_track", RailcraftBlocks.STRAP_IRON_BOOSTER_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_CONTROL_TRACK =
      blockItem("strap_iron_control_track", RailcraftBlocks.STRAP_IRON_CONTROL_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_GATED_TRACK =
      blockItem("strap_iron_gated_track", RailcraftBlocks.STRAP_IRON_GATED_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_DETECTOR_TRACK =
      blockItem("strap_iron_detector_track", RailcraftBlocks.STRAP_IRON_DETECTOR_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_COUPLER_TRACK =
      blockItem("strap_iron_coupler_track", RailcraftBlocks.STRAP_IRON_COUPLER_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_EMBARKING_TRACK =
      blockItem("strap_iron_embarking_track", RailcraftBlocks.STRAP_IRON_EMBARKING_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_DISEMBARKING_TRACK =
      blockItem("strap_iron_disembarking_track", RailcraftBlocks.STRAP_IRON_DISEMBARKING_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_DUMPING_TRACK =
      blockItem("strap_iron_dumping_track", RailcraftBlocks.STRAP_IRON_DUMPING_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_WYE_TRACK =
      blockItem("strap_iron_wye_track", RailcraftBlocks.STRAP_IRON_WYE_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_TURNOUT_TRACK =
      blockItem("strap_iron_turnout_track", RailcraftBlocks.STRAP_IRON_TURNOUT_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_JUNCTION_TRACK =
      blockItem("strap_iron_junction_track", RailcraftBlocks.STRAP_IRON_JUNCTION_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_LAUNCHER_TRACK =
      blockItem("strap_iron_launcher_track", RailcraftBlocks.STRAP_IRON_LAUNCHER_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_ONE_WAY_TRACK =
      blockItem("strap_iron_one_way_track", RailcraftBlocks.STRAP_IRON_ONE_WAY_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_WHISTLE_TRACK =
      blockItem("strap_iron_whistle_track", RailcraftBlocks.STRAP_IRON_WHISTLE_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_LOCOMOTIVE_TRACK =
      blockItem("strap_iron_locomotive_track", RailcraftBlocks.STRAP_IRON_LOCOMOTIVE_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_THROTTLE_TRACK =
      blockItem("strap_iron_throttle_track", RailcraftBlocks.STRAP_IRON_THROTTLE_TRACK);

  public static final DeferredItem<BlockItem> STRAP_IRON_ROUTING_TRACK =
      blockItem("strap_iron_routing_track", RailcraftBlocks.STRAP_IRON_ROUTING_TRACK);

  public static final DeferredItem<BlockItem> ELEVATOR_TRACK =
      blockItem("elevator_track", RailcraftBlocks.ELEVATOR_TRACK);

  public static final DeferredItem<Item> IRON_CROWBAR =
      deferredRegister.register("iron_crowbar",
          () -> new CrowbarItem(2.5F, -2.8F, Tiers.IRON,
              new Item.Properties()));

  public static final DeferredItem<Item> STEEL_CROWBAR =
      deferredRegister.register("steel_crowbar",
          () -> new CrowbarItem(2.5F, -2.7F, RailcraftItemTier.STEEL,
              new Item.Properties()));

  public static final DeferredItem<Item> DIAMOND_CROWBAR =
      deferredRegister.register("diamond_crowbar",
          () -> new CrowbarItem(2.5F, -2.4F, Tiers.DIAMOND,
              new Item.Properties()));

  public static final DeferredItem<Item> SEASONS_CROWBAR =
      deferredRegister.register("seasons_crowbar",
          () -> new SeasonsCrowbarItem(new Item.Properties()));

  public static final DeferredItem<Item> TRACK_PARTS = registerBasic("track_parts");

  public static final DeferredItem<Item> TRANSITION_TRACK_KIT =
      deferredRegister.register("transition_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_TRANSITION_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_TRANSITION_TRACK)));

  public static final DeferredItem<Item> LOCKING_TRACK_KIT =
      deferredRegister.register("locking_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_LOCKING_TRACK)));

  public static final DeferredItem<Item> BUFFER_STOP_TRACK_KIT =
      deferredRegister.register("buffer_stop_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_BUFFER_STOP_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_BUFFER_STOP_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_BUFFER_STOP_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED,
                  RailcraftBlocks.REINFORCED_BUFFER_STOP_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_BUFFER_STOP_TRACK)));

  public static final DeferredItem<Item> ACTIVATOR_TRACK_KIT =
      deferredRegister.register("activator_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_ACTIVATOR_TRACK)));

  public static final DeferredItem<Item> BOOSTER_TRACK_KIT =
      deferredRegister.register("booster_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_BOOSTER_TRACK)));

  public static final DeferredItem<Item> CONTROL_TRACK_KIT =
      deferredRegister.register("control_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_CONTROL_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_CONTROL_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_CONTROL_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_CONTROL_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_CONTROL_TRACK)));

  public static final DeferredItem<Item> GATED_TRACK_KIT =
      deferredRegister.register("gated_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_GATED_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_GATED_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_GATED_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_GATED_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_GATED_TRACK)));

  public static final DeferredItem<Item> DETECTOR_TRACK_KIT =
      deferredRegister.register("detector_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_DETECTOR_TRACK)));

  public static final DeferredItem<Item> COUPLER_TRACK_KIT =
      deferredRegister.register("coupler_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_COUPLER_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_COUPLER_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_COUPLER_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_COUPLER_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_COUPLER_TRACK)));

  public static final DeferredItem<Item> EMBARKING_TRACK_KIT =
      deferredRegister.register("embarking_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_EMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_EMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_EMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_EMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_EMBARKING_TRACK)));

  public static final DeferredItem<Item> DISEMBARKING_TRACK_KIT =
      deferredRegister.register("disembarking_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_DISEMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_DISEMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_DISEMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED,
                  RailcraftBlocks.REINFORCED_DISEMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_DISEMBARKING_TRACK)));

  public static final DeferredItem<Item> DUMPING_TRACK_KIT =
      deferredRegister.register("dumping_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_DUMPING_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_DUMPING_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_DUMPING_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED,
                  RailcraftBlocks.REINFORCED_DUMPING_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_DUMPING_TRACK)));

  public static final DeferredItem<Item> LAUNCHER_TRACK_KIT =
      deferredRegister.register("launcher_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_LAUNCHER_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_LAUNCHER_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_LAUNCHER_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED,
                  RailcraftBlocks.REINFORCED_LAUNCHER_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_LAUNCHER_TRACK)));

  public static final DeferredItem<Item> ONE_WAY_TRACK_KIT =
      deferredRegister.register("one_way_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_ONE_WAY_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_ONE_WAY_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_ONE_WAY_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED,
                  RailcraftBlocks.REINFORCED_ONE_WAY_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_ONE_WAY_TRACK)));

  public static final DeferredItem<Item> WHISTLE_TRACK_KIT =
      deferredRegister.register("whistle_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_WHISTLE_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_WHISTLE_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_WHISTLE_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_WHISTLE_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_WHISTLE_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_WHISTLE_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_WHISTLE_TRACK)));

  public static final DeferredItem<Item> LOCOMOTIVE_TRACK_KIT =
      deferredRegister.register("locomotive_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_LOCOMOTIVE_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_LOCOMOTIVE_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_LOCOMOTIVE_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_LOCOMOTIVE_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_LOCOMOTIVE_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_LOCOMOTIVE_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_LOCOMOTIVE_TRACK)));

  public static final DeferredItem<Item> THROTTLE_TRACK_KIT =
      deferredRegister.register("throttle_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_THROTTLE_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_THROTTLE_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_THROTTLE_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_THROTTLE_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_THROTTLE_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_THROTTLE_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_THROTTLE_TRACK)));

  public static final DeferredItem<Item> ROUTING_TRACK_KIT =
      deferredRegister.register("routing_track_kit",
          () -> new TrackKitItem(new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_ROUTING_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_ROUTING_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_ROUTING_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_ROUTING_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_ROUTING_TRACK)));

  public static final DeferredItem<Item> GOGGLES =
      deferredRegister.register("goggles",
          () -> new GogglesItem(new Item.Properties()));

  public static final DeferredItem<BlockItem> MANUAL_ROLLING_MACHINE =
      blockItem("manual_rolling_machine", RailcraftBlocks.MANUAL_ROLLING_MACHINE);

  public static final DeferredItem<BlockItem> POWERED_ROLLING_MACHINE =
      blockItem("powered_rolling_machine", RailcraftBlocks.POWERED_ROLLING_MACHINE);

  public static final DeferredItem<BlockItem> CRUSHER =
      blockItem("crusher", RailcraftBlocks.CRUSHER);

  public static final DeferredItem<BlockItem> COKE_OVEN_BRICKS =
      blockItem("coke_oven_bricks", RailcraftBlocks.COKE_OVEN_BRICKS);

  public static final DeferredItem<BlockItem> STEAM_OVEN =
      blockItem("steam_oven", RailcraftBlocks.STEAM_OVEN);

  public static final DeferredItem<BlockItem> CRUSHED_OBSIDIAN =
      blockItem("crushed_obsidian", RailcraftBlocks.CRUSHED_OBSIDIAN);

  // ================================================================================
  // Crafting Materials
  // ================================================================================

  public static final DeferredItem<Item> COAL_COKE = deferredRegister.register("coal_coke",
      () -> new CoalCokeItem(new Item.Properties()));

  public static final DeferredItem<Item> STEEL_PLATE = registerBasic("steel_plate");
  public static final DeferredItem<Item> IRON_PLATE = registerBasic("iron_plate");
  public static final DeferredItem<Item> TIN_PLATE = registerBasic("tin_plate");
  public static final DeferredItem<Item> GOLD_PLATE = registerBasic("gold_plate");
  public static final DeferredItem<Item> LEAD_PLATE = registerBasic("lead_plate");
  public static final DeferredItem<Item> ZINC_PLATE = registerBasic("zinc_plate");
  public static final DeferredItem<Item> BRASS_PLATE = registerBasic("brass_plate");
  public static final DeferredItem<Item> INVAR_PLATE = registerBasic("invar_plate");
  public static final DeferredItem<Item> BRONZE_PLATE = registerBasic("bronze_plate");
  public static final DeferredItem<Item> COPPER_PLATE = registerBasic("copper_plate");
  public static final DeferredItem<Item> NICKEL_PLATE = registerBasic("nickel_plate");
  public static final DeferredItem<Item> SILVER_PLATE = registerBasic("silver_plate");

  public static final DeferredItem<Item> STEEL_INGOT = registerBasic("steel_ingot");
  public static final DeferredItem<Item> TIN_INGOT = registerBasic("tin_ingot");
  public static final DeferredItem<Item> ZINC_INGOT = registerBasic("zinc_ingot");
  public static final DeferredItem<Item> BRASS_INGOT = registerBasic("brass_ingot");
  public static final DeferredItem<Item> BRONZE_INGOT = registerBasic("bronze_ingot");
  public static final DeferredItem<Item> NICKEL_INGOT = registerBasic("nickel_ingot");
  public static final DeferredItem<Item> INVAR_INGOT = registerBasic("invar_ingot");
  public static final DeferredItem<Item> LEAD_INGOT = registerBasic("lead_ingot");
  public static final DeferredItem<Item> SILVER_INGOT = registerBasic("silver_ingot");

  public static final DeferredItem<Item> SALTPETER_DUST = registerBasic("saltpeter_dust");
  public static final DeferredItem<Item> COAL_DUST = registerBasic("coal_dust");
  public static final DeferredItem<Item> CHARCOAL_DUST = registerBasic("charcoal_dust");
  public static final DeferredItem<Item> SLAG = registerBasic("slag");
  public static final DeferredItem<Item> ENDER_DUST = registerBasic("ender_dust");
  public static final DeferredItem<Item> SULFUR_DUST = registerBasic("sulfur_dust");
  public static final DeferredItem<Item> OBSIDIAN_DUST = registerBasic("obsidian_dust");

  public static final DeferredItem<Item> STEEL_NUGGET = registerBasic("steel_nugget");
  public static final DeferredItem<Item> TIN_NUGGET = registerBasic("tin_nugget");
  public static final DeferredItem<Item> ZINC_NUGGET = registerBasic("zinc_nugget");
  public static final DeferredItem<Item> BRASS_NUGGET = registerBasic("brass_nugget");
  public static final DeferredItem<Item> BRONZE_NUGGET = registerBasic("bronze_nugget");
  public static final DeferredItem<Item> NICKEL_NUGGET = registerBasic("nickel_nugget");
  public static final DeferredItem<Item> INVAR_NUGGET = registerBasic("invar_nugget");
  public static final DeferredItem<Item> SILVER_NUGGET = registerBasic("silver_nugget");
  public static final DeferredItem<Item> LEAD_NUGGET = registerBasic("lead_nugget");

  public static final DeferredItem<Item> TIN_RAW = registerBasic("tin_raw");
  public static final DeferredItem<Item> ZINC_RAW = registerBasic("zinc_raw");
  public static final DeferredItem<Item> NICKEL_RAW = registerBasic("nickel_raw");
  public static final DeferredItem<Item> SILVER_RAW = registerBasic("silver_raw");
  public static final DeferredItem<Item> LEAD_RAW = registerBasic("lead_raw");

  public static final DeferredItem<Item> BUSHING_GEAR = registerBasic("bushing_gear");
  public static final DeferredItem<Item> TIN_GEAR = registerBasic("tin_gear");
  public static final DeferredItem<Item> GOLD_GEAR = registerBasic("gold_gear");
  public static final DeferredItem<Item> IRON_GEAR = registerBasic("iron_gear");
  public static final DeferredItem<Item> LEAD_GEAR = registerBasic("lead_gear");
  public static final DeferredItem<Item> ZINC_GEAR = registerBasic("zinc_gear");
  public static final DeferredItem<Item> BRASS_GEAR = registerBasic("brass_gear");
  public static final DeferredItem<Item> INVAR_GEAR = registerBasic("invar_gear");
  public static final DeferredItem<Item> STEEL_GEAR = registerBasic("steel_gear");
  public static final DeferredItem<Item> BRONZE_GEAR = registerBasic("bronze_gear");
  public static final DeferredItem<Item> COPPER_GEAR = registerBasic("copper_gear");
  public static final DeferredItem<Item> NICKEL_GEAR = registerBasic("nickel_gear");
  public static final DeferredItem<Item> SILVER_GEAR = registerBasic("silver_gear");

  public static final DeferredItem<Item> TIN_ELECTRODE = registerBasic("tin_electrode");
  public static final DeferredItem<Item> GOLD_ELECTRODE = registerBasic("gold_electrode");
  public static final DeferredItem<Item> IRON_ELECTRODE = registerBasic("iron_electrode");
  public static final DeferredItem<Item> LEAD_ELECTRODE = registerBasic("lead_electrode");
  public static final DeferredItem<Item> ZINC_ELECTRODE = registerBasic("zinc_electrode");
  public static final DeferredItem<Item> BRASS_ELECTRODE = registerBasic("brass_electrode");
  public static final DeferredItem<Item> INVAR_ELECTRODE = registerBasic("invar_electrode");
  public static final DeferredItem<Item> STEEL_ELECTRODE = registerBasic("steel_electrode");
  public static final DeferredItem<Item> BRONZE_ELECTRODE = registerBasic("bronze_electrode");
  public static final DeferredItem<Item> CARBON_ELECTRODE = registerBasic("carbon_electrode");
  public static final DeferredItem<Item> COPPER_ELECTRODE = registerBasic("copper_electrode");
  public static final DeferredItem<Item> NICKEL_ELECTRODE = registerBasic("nickel_electrode");
  public static final DeferredItem<Item> SILVER_ELECTRODE = registerBasic("silver_electrode");

  public static final DeferredItem<Item> CONTROLLER_CIRCUIT = registerBasic("controller_circuit");
  public static final DeferredItem<Item> RECEIVER_CIRCUIT = registerBasic("receiver_circuit");
  public static final DeferredItem<Item> SIGNAL_CIRCUIT = registerBasic("signal_circuit");
  public static final DeferredItem<Item> RADIO_CIRCUIT = registerBasic("radio_circuit");

  public static final DeferredItem<Item> WOODEN_RAIL = registerBasic("wooden_rail");
  public static final DeferredItem<Item> STANDARD_RAIL = registerBasic("standard_rail");
  public static final DeferredItem<Item> ADVANCED_RAIL = registerBasic("advanced_rail");
  public static final DeferredItem<Item> REINFORCED_RAIL = registerBasic("reinforced_rail");
  public static final DeferredItem<Item> HIGH_SPEED_RAIL = registerBasic("high_speed_rail");
  public static final DeferredItem<Item> ELECTRIC_RAIL = registerBasic("electric_rail");

  public static final DeferredItem<Item> BAG_OF_CEMENT = registerBasic("bag_of_cement");

  public static final DeferredItem<Item> WOODEN_TIE = registerBasic("wooden_tie");
  public static final DeferredItem<Item> STONE_TIE = registerBasic("stone_tie");

  public static final DeferredItem<Item> REBAR = registerBasic("rebar");
  public static final DeferredItem<Item> WOODEN_RAILBED = registerBasic("wooden_railbed");
  public static final DeferredItem<Item> STONE_RAILBED = registerBasic("stone_railbed");

  public static final DeferredItem<Item> SIGNAL_LAMP = registerBasic("signal_lamp");

  public static final DeferredItem<Item> CHARGE_SPOOL_LARGE = registerBasic("charge_spool_large");
  public static final DeferredItem<Item> CHARGE_SPOOL_MEDIUM =
      registerBasic("charge_spool_medium");
  public static final DeferredItem<Item> CHARGE_SPOOL_SMALL = registerBasic("charge_spool_small");

  public static final DeferredItem<Item> CHARGE_MOTOR = registerBasic("charge_motor");

  public static final DeferredItem<Item> CHARGE_COIL = registerBasic("charge_coil");

  public static final DeferredItem<Item> CHARGE_TERMINAL = registerBasic("charge_terminal");

  public static final DeferredItem<BlockItem> WATER_TANK_SIDING =
      blockItem("water_tank_siding", RailcraftBlocks.WATER_TANK_SIDING);

  public static final DeferredItem<BlockItem> QUARRIED_STONE =
      blockItem("quarried_stone", RailcraftBlocks.QUARRIED_STONE);

  public static final DeferredItem<BlockItem> QUARRIED_COBBLESTONE =
      blockItem("quarried_cobblestone", RailcraftBlocks.QUARRIED_COBBLESTONE);

  public static final DeferredItem<BlockItem> POLISHED_QUARRIED_STONE =
      blockItem("polished_quarried_stone", RailcraftBlocks.POLISHED_QUARRIED_STONE);

  public static final DeferredItem<BlockItem> CHISELED_QUARRIED_STONE =
      blockItem("chiseled_quarried_stone", RailcraftBlocks.CHISELED_QUARRIED_STONE);

  public static final DeferredItem<BlockItem> ETCHED_QUARRIED_STONE =
      blockItem("etched_quarried_stone", RailcraftBlocks.ETCHED_QUARRIED_STONE);

  public static final DeferredItem<BlockItem> QUARRIED_BRICKS =
      blockItem("quarried_bricks", RailcraftBlocks.QUARRIED_BRICKS);

  public static final DeferredItem<BlockItem> QUARRIED_BRICK_STAIRS =
      blockItem("quarried_brick_stairs", RailcraftBlocks.QUARRIED_BRICK_STAIRS);

  public static final DeferredItem<BlockItem> QUARRIED_BRICK_SLAB =
      blockItem("quarried_brick_slab", RailcraftBlocks.QUARRIED_BRICK_SLAB);

  public static final DeferredItem<BlockItem> QUARRIED_PAVER =
      blockItem("quarried_paver", RailcraftBlocks.QUARRIED_PAVER);

  public static final DeferredItem<BlockItem> QUARRIED_PAVER_STAIRS =
      blockItem("quarried_paver_stairs", RailcraftBlocks.QUARRIED_PAVER_STAIRS);

  public static final DeferredItem<BlockItem> QUARRIED_PAVER_SLAB =
      blockItem("quarried_paver_slab", RailcraftBlocks.QUARRIED_PAVER_SLAB);

  public static final DeferredItem<BlockItem> ABYSSAL_STONE =
      blockItem("abyssal_stone", RailcraftBlocks.ABYSSAL_STONE);

  public static final DeferredItem<BlockItem> ABYSSAL_COBBLESTONE =
      blockItem("abyssal_cobblestone", RailcraftBlocks.ABYSSAL_COBBLESTONE);

  public static final DeferredItem<BlockItem> POLISHED_ABYSSAL_STONE =
      blockItem("polished_abyssal_stone", RailcraftBlocks.POLISHED_ABYSSAL_STONE);

  public static final DeferredItem<BlockItem> CHISELED_ABYSSAL_STONE =
      blockItem("chiseled_abyssal_stone", RailcraftBlocks.CHISELED_ABYSSAL_STONE);

  public static final DeferredItem<BlockItem> ETCHED_ABYSSAL_STONE =
      blockItem("etched_abyssal_stone", RailcraftBlocks.ETCHED_ABYSSAL_STONE);

  public static final DeferredItem<BlockItem> ABYSSAL_BRICKS =
      blockItem("abyssal_bricks", RailcraftBlocks.ABYSSAL_BRICKS);

  public static final DeferredItem<BlockItem> ABYSSAL_BRICK_STAIRS =
      blockItem("abyssal_brick_stairs", RailcraftBlocks.ABYSSAL_BRICK_STAIRS);

  public static final DeferredItem<BlockItem> ABYSSAL_BRICK_SLAB =
      blockItem("abyssal_brick_slab", RailcraftBlocks.ABYSSAL_BRICK_SLAB);

  public static final DeferredItem<BlockItem> ABYSSAL_PAVER =
      blockItem("abyssal_paver", RailcraftBlocks.ABYSSAL_PAVER);

  public static final DeferredItem<BlockItem> ABYSSAL_PAVER_STAIRS =
      blockItem("abyssal_paver_stairs", RailcraftBlocks.ABYSSAL_PAVER_STAIRS);

  public static final DeferredItem<BlockItem> ABYSSAL_PAVER_SLAB =
      blockItem("abyssal_paver_slab", RailcraftBlocks.ABYSSAL_PAVER_SLAB);

  // ================================================================================
  // Buckets
  // ================================================================================

  public static final DeferredItem<Item> CREOSOTE_BUCKET =
      deferredRegister.register("creosote_bucket",
          () -> new BucketItem(RailcraftFluids.CREOSOTE,
              new Item.Properties()
                  .stacksTo(1)
                  .craftRemainder(Items.BUCKET)) {
            @Override
            public ICapabilityProvider initCapabilities(ItemStack stack,
                @Nullable CompoundTag nbt) {
              return new FluidBucketWrapper(stack);
            }

            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
              return 800;
            }
          });

  public static final DeferredItem<Item> CREOSOTE_BOTTLE =
      deferredRegister.register("creosote_bottle",
          () -> new FluidBottleItem(RailcraftFluids.CREOSOTE,
              new Item.Properties()
                  .stacksTo(16)
                  .craftRemainder(Items.GLASS_BOTTLE)));

  // ================================================================================
  // Utils
  // ================================================================================

  private static DeferredItem<Item> registerBasic(String name) {
    return deferredRegister.registerItem(name, new Item.Properties());
  }

  private static DeferredItem<BlockItem> blockItem(String name, Supplier<? extends Block> block) {
    return deferredRegister.registerBlockItem(name, block, new Properties());
  }
}
