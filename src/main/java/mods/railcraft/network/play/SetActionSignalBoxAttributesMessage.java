package mods.railcraft.network.play;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.Supplier;
import com.mojang.authlib.GameProfile;
import mods.railcraft.api.signal.SignalAspect;
import mods.railcraft.util.LevelUtil;
import mods.railcraft.world.level.block.entity.signal.ActionSignalBoxBlockEntity;
import mods.railcraft.world.level.block.entity.signal.SecureSignalBoxBlockEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

public class SetActionSignalBoxAttributesMessage {

  private final BlockPos blockPos;
  private final Set<SignalAspect> actionSignalAspects;
  private final SecureSignalBoxBlockEntity.Lock lock;

  public SetActionSignalBoxAttributesMessage(BlockPos blockPos,
      Set<SignalAspect> actionSignalAspects, SecureSignalBoxBlockEntity.Lock lock) {
    this.blockPos = blockPos;
    this.actionSignalAspects = actionSignalAspects;
    this.lock = lock;
  }

  public void encode(PacketBuffer out) {
    out.writeBlockPos(this.blockPos);
    out.writeVarInt(this.actionSignalAspects.size());
    this.actionSignalAspects.forEach(out::writeEnum);
    out.writeEnum(this.lock);
  }

  public static SetActionSignalBoxAttributesMessage decode(PacketBuffer in) {
    BlockPos blockPos = in.readBlockPos();
    int size = in.readVarInt();
    Set<SignalAspect> actionSignalAspects = EnumSet.noneOf(SignalAspect.class);
    for (int i = 0; i < size; i++) {
      actionSignalAspects.add(in.readEnum(SignalAspect.class));
    }
    SecureSignalBoxBlockEntity.Lock lock = in.readEnum(SecureSignalBoxBlockEntity.Lock.class);
    return new SetActionSignalBoxAttributesMessage(blockPos, actionSignalAspects, lock);
  }

  public void handle(Supplier<NetworkEvent.Context> context) {
    ServerWorld level = context.get().getSender().getLevel();
    GameProfile senderProfile = context.get().getSender().getGameProfile();
    LevelUtil.getBlockEntity(level, this.blockPos, ActionSignalBoxBlockEntity.class)
        .filter(signalBox -> signalBox.canAccess(senderProfile))
        .ifPresent(signalBox -> {
          signalBox.getActionSignalAspects().clear();
          signalBox.getActionSignalAspects().addAll(this.actionSignalAspects);
          signalBox.getLockController().setCurrentState(this.lock);
          if (this.lock == SecureSignalBoxBlockEntity.Lock.LOCKED) {
            signalBox.setOwner(senderProfile);
          } else {
            signalBox.setOwner(null);
          }
        });
  }
}