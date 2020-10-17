package io.github.hydos.lint.old.client;

import io.github.hydos.lint.container.LilTaterInteractContainer;
import io.github.hydos.lint.container.client.LilTaterContainerScreen;
import io.github.hydos.lint.old.Containers;
import io.github.hydos.lint.old.Entities;
import io.github.hydos.lint.entity.beetater.BeeTaterEntityRenderer;
import io.github.hydos.lint.entity.boss.KingTaterRenderer;
import io.github.hydos.lint.entity.tater.LilTaterEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.text.LiteralText;

@Environment(EnvType.CLIENT)
public interface LintClient {

    static void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(Entities.LIL_TATER, (entityRenderDispatcher, context) -> new LilTaterEntityRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(Entities.BEE_TATER, (entityRenderDispatcher, context) -> new BeeTaterEntityRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(Entities.MINION, (entityRenderDispatcher, context) -> new LilTaterEntityRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(Entities.KING_TATER, (entityRenderDispatcher, context) -> new KingTaterRenderer(entityRenderDispatcher));

        ScreenProviderRegistry.INSTANCE.registerFactory(Containers.TATER_CONTAINER_ID, (syncId, identifier, playerEntity, buf) -> new LilTaterContainerScreen(new LilTaterInteractContainer(null, syncId, buf.readInt(), playerEntity.inventory), playerEntity.inventory, new LiteralText("Lil Tater UI")));
    }
}