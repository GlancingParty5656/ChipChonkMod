package net.colby.chipchonkmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.Component;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.text.Style;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class PortalBlock extends Block {

    public BlockPos connectedPortalBlockPos;

    public static final EnumProperty<PortalBlockColor> COLOR = EnumProperty.of("color", PortalBlockColor.class);

    public PortalBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(COLOR, PortalBlockColor.BLUE));
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {

        BlockPos testBlockPosYay = new BlockPos(0, 64, 0);

        if (world.getBlockState(testBlockPosYay).getBlock() instanceof PortalBlock) {
            this.connectedPortalBlockPos = testBlockPosYay;
        } else {
            this.connectedPortalBlockPos = null;
        }

        super.onBlockAdded(state, world, pos, oldState, notify);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            if (this.connectedPortalBlockPos != null) {
                entity.teleport(serverWorld, this.connectedPortalBlockPos.getX(), this.connectedPortalBlockPos.getX(), this.connectedPortalBlockPos.getX(), Set.of(), entity.getYaw(), entity.getPitch());
            }
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }

}
