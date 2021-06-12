package com.deeplake.spider2fix.entity;

import com.deeplake.spider2fix.IdlFramework;
import com.deeplake.spider2fix.entity.creatures.moroon.EntityMoroonUnitBase;
import com.deeplake.spider2fix.entity.creatures.render.*;
import com.deeplake.spider2fix.entity.projectiles.EntityIdlProjectile;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMoroonUnitBase.class, RenderMoroonHumanoid::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityIdlProjectile.class, renderManager -> new RenderBullet<>(renderManager, new ResourceLocation(IdlFramework.MODID,
                "textures/entity/projectiles/bullet_norm.png")));
    }
}
