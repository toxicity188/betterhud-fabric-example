package kr.toxicity.hud.example.fabric;

import kr.toxicity.hud.api.fabric.event.entity.PlayerAttackEntityEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Main implements ModInitializer {

    public static final String MOD_ID = "betterhud-fabric-example";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTING.register(minecraftServer -> {
            PlayerAttackEntityEvent.REGISTRY.register(s -> LOGGER.info("{} hits some entity!", s.player().getNameForScoreboard()));
            LOGGER.info("Mod enabled.");
        });
    }
}