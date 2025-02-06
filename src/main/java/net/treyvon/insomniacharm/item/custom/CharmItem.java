package net.treyvon.insomniacharm.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CharmItem extends Item implements ICurioItem{
    public CharmItem(Properties properties) {
        super(new Item.Properties().stacksTo(1).durability(0));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        // Get the player wearing the item
        Player player = (Player) slotContext.entity();

        // Check if the player is a ServerPlayer (to avoid client-side issues)
        if (player instanceof ServerPlayer serverPlayer) {
            int timeSinceLastRest = serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));

            // Check if the stat is over 23000 ticks
            if (timeSinceLastRest > 23000) {
                // Reset the "time since last rest" stat
                serverPlayer.resetStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));
            }
        }
    }
}





