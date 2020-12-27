package me.hydos.lint.mixinimpl;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import me.hydos.lint.Lint;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3d;

public class LintSky {
	public static void renderLintSky(MatrixStack matrices, TextureManager textureManager,
			VertexBuffer lightSkyBuffer, VertexBuffer darkSkyBuffer, VertexBuffer starsBuffer,
			VertexFormat skyVertexFormat, MinecraftClient client, ClientWorld world, float tickDelta) {
		RenderSystem.disableTexture();
		Vec3d vec3d = world.method_23777(client.gameRenderer.getCamera().getBlockPos(), tickDelta);
		float f = (float)vec3d.x;
		float g = (float)vec3d.y;
		float h = (float)vec3d.z;
		BackgroundRenderer.setFogBlack();
		BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
		RenderSystem.depthMask(false);
		RenderSystem.enableFog();
		RenderSystem.color3f(f, g, h);
		lightSkyBuffer.bind();
		skyVertexFormat.startDrawing(0L);
		lightSkyBuffer.draw(matrices.peek().getModel(), 7);
		VertexBuffer.unbind();
		skyVertexFormat.endDrawing();
		RenderSystem.disableFog();
		RenderSystem.disableAlphaTest();
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		float[] fs = world.getSkyProperties().getFogColorOverride(world.getSkyAngle(tickDelta), tickDelta);
		float r;
		float s;
		float o;
		float p;
		float q;
		if (fs != null) {
			RenderSystem.disableTexture();
			RenderSystem.shadeModel(7425);
			matrices.push();
			matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(90.0F));
			r = MathHelper.sin(world.getSkyAngleRadians(tickDelta)) < 0.0F ? 180.0F : 0.0F;
			matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(r));
			matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(90.0F));
			float j = fs[0];
			s = fs[1];
			float l = fs[2];
			Matrix4f matrix4f = matrices.peek().getModel();
			bufferBuilder.begin(6, VertexFormats.POSITION_COLOR);
			bufferBuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(j, s, l, fs[3]).next();

			for(int n = 0; n <= 16; ++n) {
				o = (float)n * 6.2831855F / 16.0F;
				p = MathHelper.sin(o);
				q = MathHelper.cos(o);
				bufferBuilder.vertex(matrix4f, p * 120.0F, q * 120.0F, -q * 40.0F * fs[3]).color(fs[0], fs[1], fs[2], 0.0F).next();
			}

			bufferBuilder.end();
			BufferRenderer.draw(bufferBuilder);
			matrices.pop();
			RenderSystem.shadeModel(7424);
		}

		RenderSystem.enableTexture();
		RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
		matrices.push();
		r = 1.0F - world.getRainGradient(tickDelta);
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, r);
		matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-90.0F));
		matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(world.getSkyAngle(tickDelta) * 360.0F));
		Matrix4f matrix4f2 = matrices.peek().getModel();
		s = 30.0F;
		textureManager.bindTexture(HAYKAM_SUN);
		bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE);
		bufferBuilder.vertex(matrix4f2, -s, 100.0F, -s).texture(0.0F, 0.0F).next();
		bufferBuilder.vertex(matrix4f2, s, 100.0F, -s).texture(1.0F, 0.0F).next();
		bufferBuilder.vertex(matrix4f2, s, 100.0F, s).texture(1.0F, 1.0F).next();
		bufferBuilder.vertex(matrix4f2, -s, 100.0F, s).texture(0.0F, 1.0F).next();
		bufferBuilder.end();
		BufferRenderer.draw(bufferBuilder);
		s = 20.0F;
		textureManager.bindTexture(MOON_PHASES);
		int t = world.getMoonPhase();
		int u = t % 4;
		int v = t / 4 % 2;
		float w = (float)(u + 0) / 4.0F;
		o = (float)(v + 0) / 2.0F;
		p = (float)(u + 1) / 4.0F;
		q = (float)(v + 1) / 2.0F;
		bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE);
		bufferBuilder.vertex(matrix4f2, -s, -100.0F, s).texture(p, q).next();
		bufferBuilder.vertex(matrix4f2, s, -100.0F, s).texture(w, q).next();
		bufferBuilder.vertex(matrix4f2, s, -100.0F, -s).texture(w, o).next();
		bufferBuilder.vertex(matrix4f2, -s, -100.0F, -s).texture(p, o).next();
		bufferBuilder.end();
		BufferRenderer.draw(bufferBuilder);
		RenderSystem.disableTexture();
		float aa = world.method_23787(tickDelta) * r;
		if (aa > 0.0F) {
			RenderSystem.color4f(aa, aa, aa, aa);
			starsBuffer.bind();
			skyVertexFormat.startDrawing(0L);
			starsBuffer.draw(matrices.peek().getModel(), 7);
			VertexBuffer.unbind();
			skyVertexFormat.endDrawing();
		}

		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.disableBlend();
		RenderSystem.enableAlphaTest();
		RenderSystem.enableFog();
		matrices.pop();
		RenderSystem.disableTexture();
		RenderSystem.color3f(0.0F, 0.0F, 0.0F);
		double d = client.player.getCameraPosVec(tickDelta).y - world.getLevelProperties().getSkyDarknessHeight();

		if (d < 0.0D) {
			matrices.push();
			matrices.translate(0.0D, 12.0D, 0.0D);
			darkSkyBuffer.bind();
			skyVertexFormat.startDrawing(0L);
			darkSkyBuffer.draw(matrices.peek().getModel(), 7);
			VertexBuffer.unbind();
			skyVertexFormat.endDrawing();
			matrices.pop();
		}

		if (world.getSkyProperties().isAlternateSkyColor()) {
			RenderSystem.color3f(f * 0.2F + 0.04F, g * 0.2F + 0.04F, h * 0.6F + 0.1F);
		} else {
			RenderSystem.color3f(f, g, h);
		}

		RenderSystem.enableTexture();
		RenderSystem.depthMask(true);
		RenderSystem.disableFog();
	}

	private static final Identifier MOON_PHASES = new Identifier("textures/environment/moon_phases.png");
	private static final Identifier HAYKAM_SUN = Lint.id("textures/environment/twin_sun.png");
}