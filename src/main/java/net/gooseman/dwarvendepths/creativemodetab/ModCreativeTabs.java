package net.gooseman.dwarvendepths.creativemodetab;

import net.gooseman.dwarvendepths.DwarvenDepths;
import net.gooseman.dwarvendepths.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DwarvenDepths.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DWARVEN_METALS_TAB = CREATIVE_TAB.register("dwarven_metals_tab",
            () -> CreativeModeTab.builder()
                    .icon(ModItems.MITHRIL::toStack)
                    .title(Component.translatable("creativetab.dwarvendepths.dwarven_metals_tab"))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TAB.register(eventBus);
    }
}
