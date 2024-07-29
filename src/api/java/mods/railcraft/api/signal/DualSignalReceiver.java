package mods.railcraft.api.signal;

import java.util.function.Consumer;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import mods.railcraft.api.core.CompoundTagKeys;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;

public class DualSignalReceiver extends SingleSignalReceiver {

  private static final Logger logger = LogUtils.getLogger();

  private final SignalClient secondarySignalClient;

  public DualSignalReceiver(BlockEntity blockEntity,
      Runnable syncListener, Consumer<SignalAspect> primarySignalAspectListener,
      Consumer<SignalAspect> secondarySignalAspectListener) {
    super(blockEntity, syncListener, primarySignalAspectListener);
    this.secondarySignalClient = new SignalClient(secondarySignalAspectListener);
  }

  public SignalAspect getSecondarySignalAspect() {
    return this.secondarySignalClient.getSignalAspect();
  }

  @Override
  public void linked(SignalController signalController) {
    if (this.primarySignalClient.getSignalController() == null) {
      super.linked(signalController);
      return;
    } else if (this.secondarySignalClient.getSignalController() == null) {
      this.secondarySignalClient.linked(signalController);
      return;
    }
    this.primarySignalClient.unlinked();
    this.secondarySignalClient.unlinked();
    super.linked(signalController);
  }

  @Override
  public void unlinked(SignalController signalController) {
    if (signalController.blockPos()
        .equals(this.primarySignalClient.getSignalControllerBlockPos())) {
      this.primarySignalClient.unlinked();
    } else if (signalController.blockPos()
        .equals(this.secondarySignalClient.getSignalControllerBlockPos())) {
      this.secondarySignalClient.unlinked();
    } else {
      logger.warn(
          "Signal controller @ [{}] tried to unlink with signal receiver @ [{}] without initially being linked",
          signalController.blockPos(), this.blockEntity.getBlockPos());
    }
  }

  @Override
  public void receiveSignalAspect(SignalController signalController,
      SignalAspect signalAspect) {
    if (signalController == this.primarySignalClient.getSignalController()) {
      super.receiveSignalAspect(signalController, signalAspect);
    } else if (signalController == this.secondarySignalClient.getSignalController()) {
      this.secondarySignalClient.setSignalAspect(signalAspect);
    }
  }

  @Override
  public void refresh() {
    super.refresh();
    this.secondarySignalClient.refresh();
  }

  @Override
  public void destroy() {
    super.destroy();
    this.secondarySignalClient.unlink();
  }

  @Override
  public CompoundTag serializeNBT(HolderLookup.Provider provider) {
    var tag = super.serializeNBT(provider);
    tag.put(CompoundTagKeys.SECONDARY_SIGNAL_CLIENT, this.secondarySignalClient.serializeNBT(provider));
    return tag;
  }

  @Override
  public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
    super.deserializeNBT(provider, tag);
    this.secondarySignalClient.deserializeNBT(provider, tag.getCompound(CompoundTagKeys.SECONDARY_SIGNAL_CLIENT));
  }

  @Override
  public void writeToBuf(RegistryFriendlyByteBuf data) {
    super.writeToBuf(data);
    data.writeEnum(this.secondarySignalClient.getSignalAspect());
  }

  @Override
  public void readFromBuf(RegistryFriendlyByteBuf data) {
    super.readFromBuf(data);
    this.secondarySignalClient.setSignalAspect(data.readEnum(SignalAspect.class));
  }
}
