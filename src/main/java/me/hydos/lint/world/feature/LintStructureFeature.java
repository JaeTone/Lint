/*
 * Lint
 * Copyright (C) 2020 hYdos, Valoeghese, ramidzkh
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package me.hydos.lint.world.feature;

import me.hydos.lint.world.structure2.StructureChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

/**
 * @author Valoeghese
 * Pastes the loaded structure state buffers into the world.
 */
public class LintStructureFeature extends Feature<DefaultFeatureConfig> {
	public LintStructureFeature() {
		super(DefaultFeatureConfig.CODEC);
	}

	@Override
	public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
		ChunkGenerator chunkGenerator = context.getGenerator();

		if (chunkGenerator instanceof StructureChunkGenerator) {
			((StructureChunkGenerator) chunkGenerator).getStructureManager().generateLoadedStructures(context.getWorld(), context.getRandom(), context.getOrigin().getX() >> 4, context.getOrigin().getZ() >> 4);
		}

		return true;
	}
}
