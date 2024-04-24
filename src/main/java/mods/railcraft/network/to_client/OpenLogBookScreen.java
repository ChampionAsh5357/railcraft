package mods.railcraft.network.to_client;

import java.util.List;
import mods.railcraft.api.core.RailcraftConstants;
import mods.railcraft.client.ScreenFactories;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record OpenLogBookScreen(List<List<String>> pages) implements CustomPacketPayload {

  public static final Type<OpenLogBookScreen> TYPE =
      new Type<>(RailcraftConstants.rl("open_log_book"));

  public static final StreamCodec<FriendlyByteBuf, OpenLogBookScreen> STREAM_CODEC =
      CustomPacketPayload.codec(OpenLogBookScreen::write, OpenLogBookScreen::read);

  private static OpenLogBookScreen read(FriendlyByteBuf buf) {
    return new OpenLogBookScreen(buf.readList(b -> b.readList(FriendlyByteBuf::readUtf)));
  }

  private void write(FriendlyByteBuf buf) {
    buf.writeCollection(pages, (b, strings) ->
        b.writeCollection(strings, (FriendlyByteBuf::writeUtf)));
  }

  @Override
  public Type<? extends CustomPacketPayload> type() {
    return TYPE;
  }

  public static void handle(OpenLogBookScreen message, IPayloadContext context) {
    ScreenFactories.openLogBookScreen(message.pages);
  }
}
