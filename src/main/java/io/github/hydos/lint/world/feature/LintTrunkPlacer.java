package io.github.hydos.lint.world.feature;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class LintTrunkPlacer extends TrunkPlacer {

    public static final Codec<StraightTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return method_28904(instance).apply(instance, StraightTrunkPlacer::new);
    });

    public LintTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    protected TrunkPlacerType<?> getType() {
        return TrunkPlacerType.STRAIGHT_TRUNK_PLACER;
    }

    public List<FoliagePlacer.TreeNode> generate(ModifiableTestableWorld world, Random random, int trunkHeight, BlockPos pos, Set<BlockPos> set, BlockBox blockBox, TreeFeatureConfig treeFeatureConfig) {
        method_27400(world, pos.down());

        for (int i = 0; i < trunkHeight; ++i) {
            method_27402(world, random, pos.up(i), set, blockBox, treeFeatureConfig);
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(pos.up(trunkHeight), 0, false));
    }
}