package com.rapsol;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

import javax.swing.text.html.parser.Entity;
import java.util.UUID;

public class RapsolPlaceCrystal implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		/*dont steal the code or youre bad at cpvp!*/
		/*"only because the mod isnt allowed doesnt mean you shouldnt use it" - Muni´s__ Grandma*/

		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			if (client.world == null || client.player == null) return;

			if (client.player.getMainHandStack().getItem() == Items.END_CRYSTAL && client.options.useKey.isPressed()) {
				if (client.crosshairTarget instanceof BlockHitResult blockHitResult) {

					if (client.interactionManager != null) {
						client.interactionManager.interactBlock(client.player, Hand.MAIN_HAND, blockHitResult);
					}
				}
			}
		});
	}
}