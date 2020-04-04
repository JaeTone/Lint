package me.hydos.lint.core.client;

import me.hydos.lint.containers.LilTaterInteractContainer;
import me.hydos.lint.containers.client.LilTaterContainerScreen;
import me.hydos.lint.core.Containers;
import me.hydos.lint.core.Entities;
import me.hydos.lint.entities.boss.BigTater;
import me.hydos.lint.entities.liltaterbattery.LilTaterBatteryRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public interface LintClient {

    static void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(Entities.LIL_TATER, (entityRenderDispatcher, context) -> new LilTaterBatteryRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(Entities.MINION, (entityRenderDispatcher, context) -> new LilTaterBatteryRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(Entities.BIG_TATER, (entityRenderDispatcher, context) -> new EntityRenderer<BigTater>(entityRenderDispatcher) {
            @Override
            public Identifier getTexture(BigTater entity) {
                return ModelLoader.MISSING;
            }
        });

        ScreenProviderRegistry.INSTANCE.registerFactory(Containers.TATER_CONTAINER_ID, (syncId, identifier, playerEntity, buf) -> new LilTaterContainerScreen(new LilTaterInteractContainer(null, syncId, buf.readInt(), playerEntity.inventory), playerEntity.inventory, new LiteralText("Lil Tater UI")));
    }
}
