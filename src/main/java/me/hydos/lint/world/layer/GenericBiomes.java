package me.hydos.lint.world.layer;

import me.hydos.lint.world.biome.Biomes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public class GenericBiomes implements InitLayer {
	@SuppressWarnings("rawtypes")
	private final RegistryKey[] biomes = {Biomes.MYSTICAL_FOREST_KEY, Biomes.MYSTICAL_FOREST_KEY, Biomes.CORRUPT_FOREST_KEY};

	private final Registry<Biome> biomeRegistry;

	public GenericBiomes(Registry<Biome> biomeRegistry, boolean beach) {
		this.biomeRegistry = biomeRegistry;

		if (beach) {
			for (int i = 0; i < this.biomes.length; ++i) {
				this.biomes[i] = this.biomes[i] == Biomes.CORRUPT_FOREST_KEY ? Biomes.CORRUPT_BEACH_KEY : Biomes.OCEAN_KEY;
			}
		}
	}

	@Override
	public int sample(LayerRandomnessSource randomPawn, int x, int y) {
		RegistryKey key = biomes[randomPawn.nextInt(biomes.length)];

		int absx = MathHelper.abs(x);
		int absy = MathHelper.abs(y);
		int absval = absx + absy;

		if (absval < 2) {
			key = Biomes.MYSTICAL_FOREST_KEY;
		}

		return id(key);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private int id(RegistryKey key) {
		return biomeRegistry.getRawId(biomeRegistry.get(key));
	}
}