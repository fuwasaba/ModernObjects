package com.keikun1215.modernobjects.item;

import com.keikun1215.modernobjects.ModernObjects;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernObjects.MODID);
    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }
}
