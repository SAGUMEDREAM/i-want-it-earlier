package rs.onako2.iwie.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WeepingVinesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.WorldView;
import rs.onako2.iwie.Init;

public class PaleHangingMossBlock extends AbstractPlantStemBlock {

    public static final MapCodec<WeepingVinesBlock> CODEC = createCodec(WeepingVinesBlock::new);
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);

    public PaleHangingMossBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false, 0.1);
    }

    @Override
    protected Block getPlant() {
        return Init.PALE_HANGING_MOSS_PLANT;
    }

    @Override
    protected MapCodec<? extends AbstractPlantStemBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected int getGrowthLength(Random random) {
        return 0;
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return false;
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Block block = world.getBlockState(pos.up()).getBlock();

        return block == Init.PALE_OAK_LEAVES || block == Init.PALE_HANGING_MOSS_PLANT || super.canPlaceAt(state, world, pos);
    }
}
