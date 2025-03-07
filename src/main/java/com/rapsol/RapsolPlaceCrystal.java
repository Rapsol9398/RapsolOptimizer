package com.rapsol;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;

public class RapsolPlaceCrystal implements ClientModInitializer {

	private Item lastItem = null;

	public void onInitializeClient() {
		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			if (client.world == null || client.player == null || client.getNetworkHandler() == null) return;
			Item currentItem = client.player.getMainHandStack().getItem();

			if (client.options.useKey.isPressed()) {
				if (client.crosshairTarget instanceof BlockHitResult blockHitResult) {
					if (currentItem == Items.END_CRYSTAL && lastItem == Items.END_CRYSTAL) {
						PlayerInteractBlockC2SPacket packet = new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, blockHitResult, 0);
						client.getNetworkHandler().sendPacket(packet);
						client.player.swingHand(Hand.MAIN_HAND);
					}
				}
			}
			lastItem = currentItem;
		});
	}
}