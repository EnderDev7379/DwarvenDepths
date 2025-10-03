package net.gooseman.dwarvendepths.datagen;

import net.gooseman.dwarvendepths.block.MithrilCoalLampBlock;
import net.gooseman.dwarvendepths.block.ModBlocks;
import net.gooseman.dwarvendepths.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.data.PackOutput;

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

        blockModels.createTrivialCube(ModBlocks.PURIFICATION_CATALYST.get());

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(ModBlocks.MITHRIL_COAL_LAMP.get()).with(BlockModelGenerators.createBooleanModelDispatch(
                MithrilCoalLampBlock.LIT,
                BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(ModBlocks.MITHRIL_COAL_LAMP.get(), "_lit", ModelTemplates.CUBE_ALL, TextureMapping::cube)),
                BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(ModBlocks.MITHRIL_COAL_LAMP.get(), "_unlit", ModelTemplates.CUBE_ALL, TextureMapping::cube))
        )));


        // Items
        itemModels.generateFlatItem(ModItems.RAW_IMPURE_MITHRIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.IMPURE_MITHRIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_WROUGHT_MITHRIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.WROUGHT_MITHRIL.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.TASTY_MTIHRIL.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.OIL_BARREL.get(), ModelTemplates.FLAT_ITEM);
    }
}

