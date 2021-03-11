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

import java.util.Random;

import me.hydos.lint.block.DirtLikeBlock;
import me.hydos.lint.block.LintBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeature;

public class CanopyTreeFeature extends Feature<DefaultFeatureConfig> {
	public CanopyTreeFeature(DefaultFeatureConfig config) {
		super(DefaultFeatureConfig.CODEC);
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos start, DefaultFeatureConfig config) {
		int startX = start.getX();
		int startY = start.getY();
		int startZ = start.getZ();
		BlockPos.Mutable pos = new BlockPos.Mutable().set(start);

		if (DirtLikeBlock.isUntaintedGrass(world.getBlockState(start.down()))) {
			int trunkHeight = 10 + random.nextInt(10);
			int trueHeight = trunkHeight + 3; // 3 blocks above trunk height

			if (startY + trueHeight < world.getHeight()) {
				for (int y = 0; y < trunkHeight; ++y) {
					pos.setY(startY + y);

					if (!TreeFeature.canTreeReplace(world, pos)) {
						return false;
					}
				}

				// 1. Canopy Leaves
				for (int dy = -4; dy < 0; ++dy) {
					float r = 1 - dy + 0.15f * dy * dy; // radius
					int max = MathHelper.ceil(r);
					pos.setY(startY + trueHeight + dy);

					for (int dx = -max; dx <= max; ++dx) {
						for (int dz = -max; dz <= max; ++dz) {
							if (dx * dx + dz * dz <= r) {
								pos.setX(startX + dx);
								pos.setZ(startZ + dz);

								if (TreeFeature.canReplace(world, pos)) {
									this.setBlockState(world, pos, LEAVES);
								}
							}
						}
					}
				}

				// 2. Branches

				// 3. Trunk
			}
		}

		return false;
	}

	public static final BlockState LEAVES = LintBlocks.CANOPY_LEAVES.getDefaultState();
	public static final BlockState LOG = LintBlocks.MYSTICAL_LOG.getDefaultState();
}