package com.rapsol;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;

public class RapsolPlaceCrystal implements ClientModInitializer {

	public void onInitializeClient() {
		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			if (client.world == null || client.player == null) return;

			if (client.player.getMainHandStack().getItem() == Items.END_CRYSTAL && client.options.useKey.wasPressed()) {
				if (client.crosshairTarget instanceof BlockHitResult blockHitResult) {

					if (client.interactionManager != null) {
						client.player.swingHand(Hand.MAIN_HAND);
						client.interactionManager.interactBlock(client.player, Hand.MAIN_HAND, blockHitResult);
						client.player.getInventory().markDirty();
					}
				}
			}
		});
	}
}