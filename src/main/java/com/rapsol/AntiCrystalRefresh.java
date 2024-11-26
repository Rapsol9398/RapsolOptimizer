package com.rapsol;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class AntiCrystalRefresh implements ClientModInitializer {

    public static MinecraftClient mc;

    @Override
    public void onInitializeClient() {
        mc = MinecraftClient.getInstance();
    }
}
