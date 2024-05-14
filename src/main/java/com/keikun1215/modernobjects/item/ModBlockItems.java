package com.keikun1215.modernobjects.item;

import com.keikun1215.modernobjects.ModernObjects;
import com.keikun1215.modernobjects.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockItems {
    public static RegistryObject<BlockItem> bush0 = register("bush0", ModBlocks.bush);
    //public static RegistryObject<BlockItem> shovel = register("shovel", ModBlocks.shovel);
    public static RegistryObject<BlockItem> sandbagHalf = register("sandbaghalf", ModBlocks.sandbag);
    public static RegistryObject<BlockItem> sandbagFull = register("sandbagfull", ModBlocks.sandbagFull);
    public static RegistryObject<BlockItem> register(String name, RegistryObject<Block> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModernObjects.TAB)));
    }
    public static void init() {

    }
}
