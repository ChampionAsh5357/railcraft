package mods.railcraft.world.entity.vehicle;

import mods.railcraft.api.core.CompoundTagKeys;
import mods.railcraft.util.container.AdvancedContainer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class FilteredMinecart extends RailcraftMinecart {

  private static final EntityDataAccessor<ItemStack> FILTER =
      SynchedEntityData.defineId(FilteredMinecart.class, EntityDataSerializers.ITEM_STACK);
  private final AdvancedContainer filterContainer =
      new AdvancedContainer(1).listener(this).phantom();

  protected FilteredMinecart(EntityType<?> type, Level level) {
    super(type, level);
  }

  protected FilteredMinecart(ItemStack itemStack, EntityType<?> type, double x, double y, double z,
      Level level) {
    super(itemStack, type, x, y, z, level);
  }

  @Override
  protected void defineSynchedData(SynchedEntityData.Builder builder) {
    super.defineSynchedData(builder);
    builder.define(FILTER, ItemStack.EMPTY);
  }

  @Override
  public boolean canBeRidden() {
    return false;
  }

  @Override
  protected void readAdditionalSaveData(CompoundTag tag) {
    super.readAdditionalSaveData(tag);
    this.filterContainer.fromTag(tag.getList(CompoundTagKeys.FILTER, Tag.TAG_COMPOUND), this.registryAccess());
    this.entityData.set(FILTER, this.getFilterInv().getItem(0));
  }

  @Override
  protected void addAdditionalSaveData(CompoundTag tag) {
    super.addAdditionalSaveData(tag);
    tag.put(CompoundTagKeys.FILTER, this.filterContainer.createTag(this.registryAccess()));
  }

  public boolean hasFilter() {
    return !this.getFilterItem().isEmpty();
  }

  public ItemStack getFilterItem() {
    return this.entityData.get(FILTER);
  }

  public AdvancedContainer getFilterInv() {
    return this.filterContainer;
  }

  public void setFilter(ItemStack filter) {
    this.getFilterInv().setItem(0, filter);
  }

  @Override
  public void setChanged() {
    super.setChanged();
    this.entityData.set(FILTER, this.getFilterInv().getItem(0));
  }
}
