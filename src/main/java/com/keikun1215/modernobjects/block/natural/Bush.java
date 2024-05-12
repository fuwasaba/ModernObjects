package com.keikun1215.modernobjects.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Bush extends Block {
    public Bush() {
        super(Properties.of(Material.LEAVES).color(MaterialColor.COLOR_GRAY).noOcclusion().instabreak());
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Shapes.empty();
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        entity.makeStuckInBlock(blockState, new Vec3(0.7F, 1.5D, 0.7F));
    }
}
