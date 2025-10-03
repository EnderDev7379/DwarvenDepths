package net.gooseman.dwarvendepths.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class MithrilCoalLampBlock extends Block {
    public static final IntegerProperty COAL_LEVEL = IntegerProperty.create("coal_level", 0, 15);
    public static final BooleanProperty LIT = BooleanProperty.create("lit");
    public MithrilCoalLampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(COAL_LEVEL, 0));
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (state.getValue(LIT))
                player.setRemainingFireTicks(player.getRemainingFireTicks() + state.getValue(COAL_LEVEL) * 40);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            int coalLevel = state.getValue(COAL_LEVEL);
            boolean lit = state.getValue(LIT);
            if (stack.is(Items.COAL) && coalLevel < 15) {
                level.setBlockAndUpdate(pos, state.setValue(COAL_LEVEL, coalLevel + 1));
                player.setItemInHand(hand, stack.copyWithCount(stack.getCount() - 1));
            }
            else if (stack.is(Items.NETHERITE_SHOVEL) && coalLevel > 0) {
                level.setBlockAndUpdate(pos, state.setValue(COAL_LEVEL, coalLevel - 1).setValue(LIT, !(coalLevel - 1 <= 0) && lit));
                if (!lit) player.addItem(new ItemStack(Items.COAL));
            }
            else if (stack.is(Items.FLINT_AND_STEEL) && coalLevel > 0) {
                level.setBlockAndUpdate(pos, state.setValue(LIT,  true));
            }
            else if (stack.is(Items.WATER_BUCKET) && lit) {
                level.setBlockAndUpdate(pos, state.setValue(LIT, false));
                player.setItemInHand(hand, new ItemStack(Items.BUCKET, stack.getCount()));
            } else return InteractionResult.TRY_WITH_EMPTY_HAND;
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COAL_LEVEL, LIT);
    }
}
