package com.keikun1215.modernobjects.block.artifical;

import com.keikun1215.modernobjects.ModernObjects;
import com.keikun1215.modernobjects.block.ModBlocks;
import com.keikun1215.modernobjects.item.ModBlockItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HalfSandbag extends Block {

    public HalfSandbag() {
        super(Properties.of(Material.METAL).strength(5f).noOcclusion());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return Shapes.box(0, 0, 0, 1, .5, 1);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player.getItemInHand(hand).getItem() == ModBlockItems.sandbagHalf.get()) {
            ModernObjects.LOGGER.info("used");
            level.setBlock(pos, ModBlocks.sandbagFull.get().defaultBlockState(), 3);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
}
