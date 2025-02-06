package net.treyvon.insomniacharm.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.stats.StatsCounter;

public class PhantomsGrace extends MobEffect {
    public PhantomsGrace(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if(entity instanceof ServerPlayer player) {

            if (!player.level().isClientSide()) {
                StatsCounter stats = player.getStats();

                int timeSinceLastSlept = stats.getValue(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));

                if (timeSinceLastSlept > 23000) {
                    stats.setValue(player, Stats.CUSTOM.get(Stats.TIME_SINCE_REST), 0);

                    System.out.println("Reset sleep timer for player: " + player.getName().getString());
                }
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
