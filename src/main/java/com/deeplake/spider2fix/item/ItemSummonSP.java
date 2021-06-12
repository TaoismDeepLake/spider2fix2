package com.deeplake.spider2fix.item;

import com.deeplake.spider2fix.item.consumables.ItemConsumableBase;
import com.deeplake.spider2fix.util.CommonFunctions;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class ItemSummonSP extends ItemConsumableBase {
    public ItemSummonSP(String name) {
        super(name);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack stack = playerIn.getHeldItem(handIn);
        Biome biome = worldIn.getBiome(playerIn.getPosition());

        World world = worldIn;
        EntityLiving living = world.isRemote ? new EntitySheep(world) : new EntityCow(world);
        living.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
        world.spawnEntity(living);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
