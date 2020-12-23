package io.github.hydos.lint.block;

import io.github.hydos.lint.Lint;
import io.github.hydos.lint.client.LintClient;
import io.github.hydos.lint.item.group.ItemGroups;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

public interface LintBlocks {

    Block SMELTERY = new SmelteryBlock(FabricBlockSettings.of(Material.METAL).hardness(2).sounds(BlockSoundGroup.ANCIENT_DEBRIS));

    Block CRACKED_BASIC_CASTING = new Block(FabricBlockSettings.of(Material.STONE).hardness(0.5f).sounds(BlockSoundGroup.STONE));

    Block BASIC_CASTING = new Block(FabricBlockSettings.of(Material.STONE).hardness(0.5f).sounds(BlockSoundGroup.STONE));

    Block HAYKAMIUM_PORTAL = new HaykamiumPortalBlock(FabricBlockSettings.of(Material.STONE).hardness(1f).sounds(BlockSoundGroup.STONE).collidable(false));

    Block FUSED_STONE = new Block(FabricBlockSettings.of(Material.STONE).hardness(1f).sounds(BlockSoundGroup.STONE));

    Block TARSCAN = new Block(FabricBlockSettings.of(Material.STONE).hardness(1f).sounds(BlockSoundGroup.STONE));

    Block SICIERON = new Block(FabricBlockSettings.of(Material.STONE).hardness(1f).sounds(BlockSoundGroup.STONE));

    Block JUREL = new Block(FabricBlockSettings.of(Material.STONE).hardness(1f).sounds(BlockSoundGroup.STONE));

    FlowerBlock CORRUPT_STEM = new LintCorruptGrassBlock(StatusEffects.NAUSEA, FabricBlockSettings.of(Material.PLANT)
            .noCollision()
            .breakInstantly()
            .hardness(0)
            .sounds(BlockSoundGroup.GRASS)
            .nonOpaque()
    );

    FlowerBlock WILTED_FLOWER = new LintCorruptGrassBlock(StatusEffects.POISON, FabricBlockSettings.of(Material.PLANT)
            .noCollision()
            .breakInstantly()
            .hardness(0)
            .sounds(BlockSoundGroup.GRASS)
            .nonOpaque()
    );

    FlowerBlock MYSTICAL_STEM = new LintGrassBlock(StatusEffects.RESISTANCE, FabricBlockSettings.of(Material.PLANT)
            .noCollision()
            .breakInstantly()
            .hardness(0)
            .sounds(BlockSoundGroup.GRASS)
            .nonOpaque()
    );

    FlowerBlock MYSTICAL_DAISY = new LintGrassBlock(StatusEffects.BAD_OMEN, net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.of(Material.PLANT)
            .noCollision()
            .breakInstantly()
            .hardness(0)
            .sounds(BlockSoundGroup.GRASS)
            .nonOpaque()
    );

    Block RETURN_HOME = new ReturnHomeBlock(FabricBlockSettings.of(Material.STONE).hardness(-1.0f).sounds(BlockSoundGroup.METAL));

    Block RED_BUTTON = new KingTaterButton(FabricBlockSettings.of(Material.SOIL).hardness(-0.1f).sounds(BlockSoundGroup.WET_GRASS));

    Block GREEN_BUTTON = new KingTaterButton(FabricBlockSettings.of(Material.SOIL).hardness(-0.1f).sounds(BlockSoundGroup.WET_GRASS));

    Block MYSTICAL_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD).hardness(2).sounds(BlockSoundGroup.WOOD));

    Block DUNGEON_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(4).sounds(BlockSoundGroup.STONE));

    Block MOSSY_DUNGEON_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(4).sounds(BlockSoundGroup.STONE));

    Block.Settings PLANK_SETTINGS = FabricBlockSettings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);
    Block.Settings SAND_SETTINGS = FabricBlockSettings.of(Material.AGGREGATE).hardness(0.5f).sounds(BlockSoundGroup.SAND);

    Block WHITE_SAND = new FallingBlock(SAND_SETTINGS);

    Block CORRUPT_PLANKS = new Block(PLANK_SETTINGS);

    Block MYSTICAL_PLANKS = new Block(PLANK_SETTINGS);

    Block RICH_DIRT = new Block(FabricBlockSettings.of(Material.SOIL).hardness(0.5f).sounds(BlockSoundGroup.WET_GRASS));
    Block LIVELY_GRASS = new Block(FabricBlockSettings.of(Material.SOIL).hardness(0.5f).sounds(BlockSoundGroup.GRASS));

    Block MYSTICAL_LEAVES = new LintLeavesBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(0.5f).sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
    Block MYSTICAL_FALLEN_LEAVES = new FallenLeavesBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(0.5f).sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
    Block MYSTICAL_LOG = createLogBlock(MaterialColor.LIME_TERRACOTTA, MaterialColor.LIME_TERRACOTTA);
    FlowerBlock MYSTICAL_GRASS = new LintGrassBlock(StatusEffects.BAD_OMEN, FabricBlockSettings.of(Material.PLANT)
            .noCollision()
            .breakInstantly()
            .hardness(0)
            .sounds(BlockSoundGroup.GRASS)
            .nonOpaque()
    );
    Block MYSTICAL_SAND = new FallingBlock(SAND_SETTINGS);

    Block CORRUPT_LEAVES = new LintLeavesBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(0.5f).sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
    Block CORRUPT_FALLEN_LEAVES = new FallenLeavesBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(0.5f).sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
    Block CORRUPT_LOG = createLogBlock(MaterialColor.PURPLE, MaterialColor.PURPLE);
    Block CORRUPT_GRASS = new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(00.5f).sounds(BlockSoundGroup.GRASS));
    Block CORRUPT_SAND = new FallingBlock(SAND_SETTINGS);

    Block MYSTICAL_SLAB = new SlabBlock(AbstractBlock.Settings.of(Material.WOOD));
    Block CORRUPT_SLAB = new SlabBlock(AbstractBlock.Settings.of(Material.WOOD));
    Block DUNGEON_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.of(Material.WOOD));

    static PillarBlock createLogBlock(MaterialColor topMaterialColor, MaterialColor sideMaterialColor) {
        return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (blockState) -> blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }

    static void registerBlock(ItemGroup itemGroup, Block block, String path) {
        Registry.register(Registry.BLOCK, Lint.id(path), block);
        Registry.register(Registry.ITEM, Lint.id(path), new BlockItem(block, new Item.Settings().group(itemGroup)));
    }

    static void registerFlower(FlowerBlock flower, String path) {
        registerBlock(ItemGroups.LINT_DECORATIONS, flower, path);
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT){
            LintClient.putBlock(flower, LintClient.ServerRenderLayer.cutout);
        }
    }

    static void initialize() {
        registerBlock(ItemGroups.LINT_BLOCKS, SMELTERY, "smeltery");

        registerBlock(ItemGroups.LINT_BLOCKS, CRACKED_BASIC_CASTING, "cracked_basic_casting");

        registerBlock(ItemGroups.LINT_BLOCKS, BASIC_CASTING, "basic_casting");
        registerBlock(ItemGroups.LINT_BLOCKS, HAYKAMIUM_PORTAL, "haykamium_portal");

        registerBlock(ItemGroups.LINT_BLOCKS, FUSED_STONE, "fused_stone");

        registerBlock(ItemGroups.LINT_BLOCKS, TARSCAN, "tarscan_ore");

        registerBlock(ItemGroups.LINT_BLOCKS, SICIERON, "sicieron_ore");

        registerBlock(ItemGroups.LINT_BLOCKS, JUREL, "jurel_ore");
        
        registerFlower(CORRUPT_STEM, "corrupt_stem");
        registerFlower(WILTED_FLOWER, "wilted_flower");
        registerFlower(MYSTICAL_GRASS, "mystical_grass");
        registerFlower(MYSTICAL_STEM, "mystical_stem");
        registerFlower(MYSTICAL_DAISY, "yellow_daisy");

        registerBlock(ItemGroups.LINT_DECORATIONS, RED_BUTTON, "red_button");

        registerBlock(ItemGroups.LINT_BLOCKS, GREEN_BUTTON, "green_button");

        registerBlock(ItemGroups.LINT_BLOCKS, MYSTICAL_TRAPDOOR, "mystical_trapdoor");

        registerBlock(ItemGroups.LINT_BLOCKS, DUNGEON_BRICKS, "dungeon_bricks");
        registerBlock(ItemGroups.LINT_BLOCKS, MOSSY_DUNGEON_BRICKS, "mossy_dungeon_bricks");

        registerBlock(ItemGroups.LINT_BLOCKS, WHITE_SAND, "white_sand");

        registerBlock(ItemGroups.LINT_BLOCKS, CORRUPT_PLANKS, "corrupt_planks");

        registerBlock(ItemGroups.LINT_BLOCKS, MYSTICAL_PLANKS, "mystical_planks");
        registerBlock(ItemGroups.LINT_BLOCKS, RICH_DIRT, "rich_dirt");
        registerBlock(ItemGroups.LINT_BLOCKS, LIVELY_GRASS, "lively_grass");

        registerBlock(ItemGroups.LINT_BLOCKS, MYSTICAL_LEAVES, "mystical_leaves");
        registerBlock(ItemGroups.LINT_BLOCKS, MYSTICAL_LOG, "mystical_log");
        registerBlock(ItemGroups.LINT_BLOCKS, MYSTICAL_SAND, "mystical_sand");

        registerBlock(ItemGroups.LINT_BLOCKS, CORRUPT_LEAVES, "corrupt_leaves");
        registerBlock(ItemGroups.LINT_BLOCKS, CORRUPT_LOG, "corrupt_log");
        registerBlock(ItemGroups.LINT_BLOCKS, CORRUPT_GRASS, "corrupt_grass");
        registerBlock(ItemGroups.LINT_BLOCKS, CORRUPT_SAND, "corrupt_sand");

        registerBlock(ItemGroups.LINT_DECORATIONS, RETURN_HOME, "return_home");

        registerBlock(ItemGroups.LINT_DECORATIONS, MYSTICAL_FALLEN_LEAVES, "mystical_fallen_leaves");
        registerBlock(ItemGroups.LINT_DECORATIONS, CORRUPT_FALLEN_LEAVES, "corrupt_fallen_leaves");

        registerBlock(ItemGroups.LINT_BLOCKS, MYSTICAL_SLAB, "mystical_slab");
        registerBlock(ItemGroups.LINT_BLOCKS, CORRUPT_SLAB, "corrupt_slab");
        registerBlock(ItemGroups.LINT_BLOCKS, DUNGEON_BRICK_SLAB, "dungeon_brick_slab");
    }
}