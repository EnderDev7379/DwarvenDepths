package net.gooseman.dwarvendepths.block;

import net.gooseman.dwarvendepths.DwarvenDepths;
import net.gooseman.dwarvendepths.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DwarvenDepths.MOD_ID);

    public static DeferredBlock<Block> IMPURE_MITHRIL_ORE = BLOCKS.registerBlock("impure_mithril_ore", Block::new, BlockBehaviour.Properties.of());
    public static DeferredBlock<Block> RAW_IMPURE_MITHRIL_BLOCK = BLOCKS.registerBlock("raw_impure_mithril_block", Block::new, BlockBehaviour.Properties.of());
    public static DeferredBlock<Block> IMPURE_MITHRIL_BLOCK = BLOCKS.registerBlock("impure_mithril_block", Block::new, BlockBehaviour.Properties.of());

    public static DeferredBlock<Block> MITHRIL_ORE = BLOCKS.registerBlock("mithril_ore", Block::new, BlockBehaviour.Properties.of());
    public static DeferredBlock<Block> RAW_MITHRIL_BLOCK = BLOCKS.registerBlock("raw_mithril_block", Block::new, BlockBehaviour.Properties.of());
    public static DeferredBlock<Block> MITHRIL_BLOCK = BLOCKS.registerBlock("mithril_block", Block::new, BlockBehaviour.Properties.of());

    public static void registerBlockItems() {
        ModItems.ITEMS.registerSimpleBlockItem(IMPURE_MITHRIL_ORE);
        ModItems.ITEMS.registerSimpleBlockItem(RAW_IMPURE_MITHRIL_BLOCK);
        ModItems.ITEMS.registerSimpleBlockItem(IMPURE_MITHRIL_BLOCK);
        ModItems.ITEMS.registerSimpleBlockItem(MITHRIL_ORE);
        ModItems.ITEMS.registerSimpleBlockItem(RAW_MITHRIL_BLOCK);
        ModItems.ITEMS.registerSimpleBlockItem(MITHRIL_BLOCK);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
