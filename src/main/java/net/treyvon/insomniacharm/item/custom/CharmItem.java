package net.treyvon.insomniacharm.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import static net.treyvon.insomniacharm.Config.insomniaValue;

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

            // Check if the stat is over the insomniaValue
            if (timeSinceLastRest > insomniaValue) {
                // Reset the "time since last rest" stat
                serverPlayer.resetStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));
                System.out.println("Player's insomnia has been reset.");
            }
        }
    }
}





