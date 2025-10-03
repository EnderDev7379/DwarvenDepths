package net.gooseman.dwarvendepths.block;

import net.gooseman.dwarvendepths.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


public class PurificationCatalystBlock extends Block {
    public PurificationCatalystBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity && level.getBlockState(pos.above()).is(Blocks.WATER)) {
            ItemStack itemStack = itemEntity.getItem();
            Item resultItem = (itemStack.is(ModItems.RAW_IMPURE_MITHRIL) ? ModItems.RAW_WROUGHT_MITHRIL.get() : itemStack.is(ModItems.IMPURE_MITHRIL) ? ModItems.WROUGHT_MITHRIL.get() : null);
            if (resultItem != null && itemStack.getCount() >= 9) {
                itemEntity.setItem(itemStack.copyWithCount(itemStack.getCount() % 9));
                level.addFreshEntity(new ItemEntity(level, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), new ItemStack(resultItem, itemStack.getCount() / 9)));
            }
        }
        super.stepOn(level, pos, state, entity);
    }
}
