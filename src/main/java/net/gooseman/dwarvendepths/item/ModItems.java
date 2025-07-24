package net.gooseman.dwarvendepths.item;

import net.gooseman.dwarvendepths.DwarvenDepths;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DwarvenDepths.MODID);

    public static final DeferredItem<Item> RAW_IMPURE_MITHRIL = ITEMS.registerItem("raw_impure_mithril", Item::new, new Item.Properties());
    public static final DeferredItem<Item> IMPURE_MITHRIL = ITEMS.registerItem("impure_mithril", Item::new, new Item.Properties());

    public static final DeferredItem<Item> RAW_MITHRIL = ITEMS.registerItem("raw_mithril", Item::new, new Item.Properties().fireResistant());
    public static final DeferredItem<Item> MITHRIL = ITEMS.registerItem("mithril", Item::new, new Item.Properties().fireResistant());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
