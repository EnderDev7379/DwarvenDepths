package net.gooseman.dwarvendepths;

import net.gooseman.dwarvendepths.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = DwarvenDepths.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = DwarvenDepths.MOD_ID, value = Dist.CLIENT)
public class DwarvenDepthsClient {
    public DwarvenDepthsClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        DwarvenDepths.LOGGER.info("HELLO FROM CLIENT SETUP");
        DwarvenDepths.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    static void addTooltips(ItemTooltipEvent event) {
        if (event.getItemStack().is(ModItems.RAW_IMPURE_MITHRIL)) {
            if (Screen.hasShiftDown()) event.getToolTip().add(Component.translatable("tooltip.dwarvendepths.raw_impure_mithril"));
            else event.getToolTip().add(Component.translatable("tooltip.dwarvendepths.common"));
        } else if (event.getItemStack().is(ModItems.IMPURE_MITHRIL)) {
            if (Screen.hasShiftDown()) event.getToolTip().add(Component.translatable("tooltip.dwarvendepths.impure_mithril"));
            else event.getToolTip().add(Component.translatable("tooltip.dwarvendepths.common"));
        } else if (event.getItemStack().is(ModItems.RAW_WROUGHT_MITHRIL)) {
            if (Screen.hasShiftDown()) event.getToolTip().add(Component.translatable("tooltip.dwarvendepths.raw_wrought_mithril"));
            else event.getToolTip().add(Component.translatable("tooltip.dwarvendepths.common"));
        } else if (event.getItemStack().is(ModItems.WROUGHT_MITHRIL)) {
            if (Screen.hasShiftDown()) event.getToolTip().add(Component.translatable("tooltip.dwarvendepths.wrought_mithril"));
            else event.getToolTip().add(Component.translatable("tooltip.dwarvendepths.common"));
        }
    }
}
