/*------------------------------------------------------------------------------
 Copyright (c) Railcraft Reborn, 2023+

 This work (the API) is licensed under the "MIT" License,
 see LICENSE.md for details.
 -----------------------------------------------------------------------------*/
package mods.railcraft.api.core;

import net.minecraft.network.RegistryFriendlyByteBuf;

public interface NetworkSerializable {

  void writeToBuf(RegistryFriendlyByteBuf out);

  void readFromBuf(RegistryFriendlyByteBuf in);
}
