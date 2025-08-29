package net.gooseman.dwarvendepths.datagen;

import net.gooseman.dwarvendepths.DwarvenDepths;
import net.gooseman.dwarvendepths.block.ModBlocks;
import net.gooseman.dwarvendepths.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.List;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, "dwarvendepths");
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Blocks
        blockModels.createTrivialCube(ModBlocks.IMPURE_MITHRIL_ORE.get());
        blockModels.createTrivialCube(ModBlocks.RAW_IMPURE_MITHRIL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.IMPURE_MITHRIL_BLOCK.get());

        blockModels.createTrivialCube(ModBlocks.WROUGHT_MITHRIL_ORE.get());
        blockModels.createTrivialCube(ModBlocks.RAW_WROUGHT_MITHRIL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.WROUGHT_MITHRIL_BLOCK.get());

        blockModels.createTrivialCube(ModBlocks.OIL_BARREL_BLOCK.get());

        // Items
        itemModels.generateFlatItem(ModItems.RAW_IMPURE_MITHRIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.IMPURE_MITHRIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_WROUGHT_MITHRIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.WROUGHT_MITHRIL.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.TASTY_MTIHRIL.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.OIL_BARREL.get(), ModelTemplates.FLAT_ITEM);
    }
}

