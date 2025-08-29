package net.gooseman.dwarvendepths.item;

import net.gooseman.dwarvendepths.DwarvenDepths;
import net.gooseman.dwarvendepths.block.ModBlocks;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DwarvenDepths.MOD_ID);

    public static final DeferredItem<Item> RAW_IMPURE_MITHRIL = ITEMS.registerItem("raw_impure_mithril", Item::new, new Item.Properties());
    public static final DeferredItem<Item> IMPURE_MITHRIL = ITEMS.registerItem("impure_mithril", Item::new, new Item.Properties());

    public static final DeferredItem<Item> RAW_WROUGHT_MITHRIL = ITEMS.registerItem("raw_wrought_mithril", Item::new, new Item.Properties().fireResistant());
    public static final DeferredItem<Item> WROUGHT_MITHRIL = ITEMS.registerItem("wrought_mithril", Item::new, new Item.Properties().fireResistant());

    public static final DeferredItem<Item> TASTY_MTIHRIL = ITEMS.registerItem("tasty_mithril", Item::new, ModFoodProperties.TASTY_MITHRIL);

    // public static final DeferredItem<Item> OIL_BARREL = ITEMS.registerItem("oil_barrel", Item::new, ModFoodProperties.OIL_BARREL);
    public static final DeferredItem<BlockItem> OIL_BARREL = ITEMS.registerSimpleBlockItem(ModBlocks.OIL_BARREL_BLOCK, ModFoodProperties.OIL_BARREL);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}