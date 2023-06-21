package com.hollingsworth.arsnouveau.client.renderer.entity;

import com.hollingsworth.arsnouveau.ArsNouveau;
import com.hollingsworth.arsnouveau.common.entity.WildenStalker;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

import javax.annotation.Nullable;

public class WildenStalkerModel extends GeoModel<WildenStalker> {

    @Override
    public void setCustomAnimations(WildenStalker entity, long uniqueID, @Nullable AnimationState customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraData().get(0);
        head.setRotX(extraData.headPitch() * 0.017453292F);
        head.setRotY(extraData.netHeadYaw() * 0.017453292F);

        this.getBone("wing_fly_left").get().setHidden(!entity.isFlying());
        this.getBone("wing_fly_right").get().setHidden(!entity.isFlying());

        this.getBone("wing_run_left").get().setHidden(entity.isFlying());
        this.getBone("wing_run_right").get().setHidden(entity.isFlying());
    }

    @Override
    public ResourceLocation getModelResource(WildenStalker wildenStalker) {
        return new ResourceLocation(ArsNouveau.MODID, "geo/wilden_stalker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WildenStalker wildenStalker) {
        return new ResourceLocation(ArsNouveau.MODID, "textures/entity/wilden_stalker.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WildenStalker wildenStalker) {
        return new ResourceLocation(ArsNouveau.MODID, "animations/wilden_stalker_animations.json");
    }

}
