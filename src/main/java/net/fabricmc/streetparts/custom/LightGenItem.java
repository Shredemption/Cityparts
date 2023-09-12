package net.fabricmc.streetparts.custom;

import net.fabricmc.streetparts.StreetParts;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StructureBlock;
import net.minecraft.block.enums.StructureBlockMode;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class LightGenItem extends Item {

    public LightGenItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();

        final Map<String, NbtElement> entries;

        if (!world.isClient()) {
            //Update block and item

            //Get pos and state
            BlockPos pos = context.getBlockPos().add(0, 1, 0);
            BlockState state = Blocks.STRUCTURE_BLOCK.getDefaultState().with(StructureBlock.MODE, StructureBlockMode.LOAD);

            //Generate NBT
            String color = "black";

            NbtCompound nbt = new NbtCompound();
            nbt.putString("name", StreetParts.MOD_ID + ":" + color + "/" + color + "_light_post_4_1");
            nbt.putInt("powered", 1);


            //Place Block
            world.setBlockState(pos, state);

            //posX:0,posY:1,posZ:0,rotation:"CLOCKWISE_180",showboundingbox:1b,sizeX:0,sizeY:0,sizeZ:0}
        } else {
            //Play sound
            context.getPlayer().playSound(SoundEvents.BLOCK_STONE_PLACE, 1.0f, 1.0f);
        }

        return super.useOnBlock(context);
    }
}
