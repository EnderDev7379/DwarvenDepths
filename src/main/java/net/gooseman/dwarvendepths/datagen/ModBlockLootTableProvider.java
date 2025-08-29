package net.gooseman.dwarvendepths.datagen;

import net.gooseman.dwarvendepths.block.ModBlocks;
import net.gooseman.dwarvendepths.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(ModBlocks.IMPURE_MITHRIL_ORE.get(), createOreDrop(ModBlocks.IMPURE_MITHRIL_ORE.get(), ModItems.IMPURE_MITHRIL.get()));
        dropSelf(ModBlocks.RAW_IMPURE_MITHRIL_BLOCK.get());
        dropSelf(ModBlocks.IMPURE_MITHRIL_BLOCK.get());

        add(ModBlocks.WROUGHT_MITHRIL_ORE.get(), createOreDrop(ModBlocks.WROUGHT_MITHRIL_ORE.get(), ModItems.IMPURE_MITHRIL.get()));
        dropSelf(ModBlocks.RAW_WROUGHT_MITHRIL_BLOCK.get());
        dropSelf(ModBlocks.WROUGHT_MITHRIL_BLOCK.get());

        dropSelf(ModBlocks.OIL_BARREL_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
