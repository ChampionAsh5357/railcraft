package mods.railcraft.world.level.block.entity.detector;

import org.jetbrains.annotations.Nullable;
import com.mojang.authlib.GameProfile;
import mods.railcraft.api.core.CompoundTagKeys;
import mods.railcraft.api.core.Lockable;
import mods.railcraft.world.level.block.entity.LockableSwitchTrackActuatorBlockEntity.Lock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SecureDetectorBlockEntity extends DetectorBlockEntity implements Lockable {

  private Lock lock = Lock.UNLOCKED;

  protected SecureDetectorBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
    super(type, blockPos, blockState);
  }

  public Lock getLock() {
    return this.lock;
  }

  public void setLock(@Nullable GameProfile gameProfile) {
    this.lock = gameProfile == null ? Lock.UNLOCKED : Lock.LOCKED;
    this.setOwner(gameProfile);
  }

  @Override
  public boolean isLocked() {
    return this.lock == Lock.LOCKED;
  }

  public boolean canAccess(GameProfile gameProfile) {
    return !this.isLocked() || this.isOwnerOrOperator(gameProfile);
  }

  @Override
  public void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
    super.saveAdditional(tag, provider);
    tag.putString(CompoundTagKeys.LOCK, this.lock.getSerializedName());
  }

  @Override
  public void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
    super.loadAdditional(tag, provider);
    this.lock = Lock.fromName(tag.getString(CompoundTagKeys.LOCK));
  }

  @Override
  public void writeToBuf(FriendlyByteBuf data) {
    super.writeToBuf(data);
    data.writeEnum(this.lock);
  }

  @Override
  public void readFromBuf(FriendlyByteBuf data) {
    super.readFromBuf(data);
    this.lock = data.readEnum(Lock.class);
  }
}
