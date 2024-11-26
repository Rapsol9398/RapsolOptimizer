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

public class RapsolOptimizer implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		/*dont steal the code or youre gay!*/

		/*"only because the mod isnt allowed doesnt mean you shouldnt use it" - Muni´s__ Grandma*/

		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			if (client.player != null && client.world != null) {

				if (client.options.useKey.isPressed() && client.player.getMainHandStack().getItem() == Items.END_CRYSTAL) {
					if (client.crosshairTarget instanceof BlockHitResult blockHitResult) {

						World world = client.world;
						if (world != null) {

							if (world.getBlockState(blockHitResult.getBlockPos()).getBlock() == Blocks.OBSIDIAN ||
									world.getBlockState(blockHitResult.getBlockPos()).getBlock() == Blocks.BEDROCK) {

								assert client.interactionManager != null;
								client.interactionManager.interactBlock(client.player, Hand.MAIN_HAND, blockHitResult);
							}
						}
					}
				}
				if (client.options.attackKey.isPressed() && client.player.getMainHandStack().getItem() == Items.END_CRYSTAL) {
					if (client.crosshairTarget instanceof BlockHitResult blockHitResult) {

						World world = client.world;
						if (world != null) {assert client.interactionManager != null;
							client.interactionManager.attackBlock(blockHitResult.getBlockPos(), blockHitResult.getSide());
							assert client.player != null;
							client.player.swingHand(client.player.getActiveHand());
						}
					}
				}
			}
		});
	}
}