package com.keikun1215.modernobjects;

import com.keikun1215.modernobjects.block.ModBlocks;
import com.keikun1215.modernobjects.item.ModBlockItems;
import com.keikun1215.modernobjects.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("modernobjects")
public class ModernObjects {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "modernobjects";
    public static final CreativeModeTab TAB = new CreativeModeTab("modernobjects") {
        @Override
        public ItemStack makeIcon() {
            return ModBlockItems.bush0.get().getDefaultInstance();
        }
    };
    public ModernObjects() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::clientSetup);
        ModBlocks.init(bus);
        ModItems.init(bus);
        ModBlockItems.init();
    }
    private void clientSetup(FMLClientSetupEvent ev) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.bush.get(), RenderType.cutout());
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MODID, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public void registerBlockColors(ColorHandlerEvent.Block event){
            BlockColors colors = event.getBlockColors();
            colors.register((blockState, blockAndTintGetter, blockPos, a) ->
                    FoliageColor.getEvergreenColor(), ModBlocks.bush.get());
        }
    }
}
