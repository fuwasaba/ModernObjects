package com.keikun1215.modernobjects.block;

import com.keikun1215.modernobjects.ModernObjects;
import com.keikun1215.modernobjects.block.natural.Bush;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModernObjects.MODID);

    public static RegistryObject<Block> bush = register("bush0", Bush::new);

    public static RegistryObject<Block> register(String name, Supplier<? extends Block> supplier) {
        return BLOCKS.register(name, supplier);
    }
    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
