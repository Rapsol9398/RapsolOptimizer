package com.rapsol;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

public class RapsolDestroyCrystal implements ClientModInitializer {
    public void onInitializeClient() {

        /*dont steal the code or youre gay!*/
        /*"only because the mod isnt allowed doesnt mean you shouldnt use it" - Muni´s__ Grandma*/

        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (client.world == null || client.player == null) return;
            HitResult crosshairTarget = client.crosshairTarget;
            if (crosshairTarget instanceof EntityHitResult entityHitResult) {
                Entity target = entityHitResult.getEntity();
                if (target instanceof EndCrystalEntity) {
                    if (client.options.attackKey.isPressed()) {
                        if (client.interactionManager != null) {
                            client.interactionManager.attackEntity(client.player, target);
                        }
                    }
                }
            }
        });
    }
}
