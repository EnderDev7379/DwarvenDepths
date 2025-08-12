package net.gooseman.dwarvendepths.item;

import net.gooseman.dwarvendepths.DwarvenDepths;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DwarvenDepths.MOD_ID);

    public static final DeferredItem<Item> RAW_IMPURE_MITHRIL = ITEMS.registerItem("raw_impure_mithril", Item::new, new Item.Properties());
    public static final DeferredItem<Item> IMPURE_MITHRIL = ITEMS.registerItem("impure_mithril", Item::new, new Item.Properties());

    public static final DeferredItem<Item> RAW_WROUGHT_MITHRIL = ITEMS.registerItem("raw_wrought_mithril", Item::new, new Item.Properties().fireResistant());
    public static final DeferredItem<Item> WROUGHT_MITHRIL = ITEMS.registerItem("wrought_mithril", Item::new, new Item.Properties().fireResistant());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}