package com.deeplake.spider2fix.events;

import com.deeplake.spider2fix.IdlFramework;
import com.deeplake.spider2fix.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import static com.deeplake.spider2fix.util.IDLNBT.getPlayerIdeallandIntSafe;
import static com.deeplake.spider2fix.util.NBTStrDef.IDLNBTDef.CUR_STARTER_KIT_VERSION;
import static com.deeplake.spider2fix.util.NBTStrDef.IDLNBTDef.STARTER_KIT_VERSION_TAG;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EntitySummonEvent {
    @SubscribeEvent
    public static void onSummon(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntitySheep || event.getEntity() instanceof EntityCow) {
            if (event.getWorld().isRemote) {
                IdlFramework.LogWarning(event.toString());
                Entity entity = event.getEntity();
                if (entity.serverPosX == 0 && entity.serverPosY == 0 && entity.serverPosZ == 0)
                {
                    event.getEntity().setDead();
                    //event.setCanceled(true);
                }
            } else {

            }
        }
    }
//
//    @SubscribeEvent
//    public static void onSummon(LivingSpawnEvent event) {
//        if (event.getEntity() instanceof EntitySheep || event.getEntity() instanceof EntityCow) {
//            if (event.getWorld().isRemote) {
//                IdlFramework.LogWarning("event");
//            } else {
//
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public static void onSummon(LivingSpawnEvent.SpecialSpawn event) {
//        if (event.getEntity() instanceof EntitySheep || event.getEntity() instanceof EntityCow)
//        {
//            if (event.getWorld().isRemote)
//            {
//                IdlFramework.LogWarning("LivingSpawnEvent.SpecialSpawn");
//            }else {
//                IdlFramework.Log("LivingSpawnEvent.SpecialSpawn");
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public static void onDig(BlockEvent.BreakEvent event)
//    {
//        IdlFramework.Log("BlockEvent.BreakEvent");
//        if (event.getState() == Blocks.BOOKSHELF.getDefaultState())
//        {
//            World world = event.getWorld();
//            EntityLiving living = world.isRemote ? new EntitySheep(world) : new EntityCow(world);
//            living.setPosition(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
//            world.spawnEntity(living);
//        }
//    }
}
