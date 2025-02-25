package net.treyvon.insomniacharm;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = InsomniaCharm.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue INSOMNIA_VALUE = BUILDER
            .comment("The number of ticks since the players last rest needed to reset the players insomnia")
            .defineInRange("insomniaValue", 20, 0, 24000);


    static final ModConfigSpec SPEC = BUILDER.build();


    public static int insomniaValue;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        insomniaValue = INSOMNIA_VALUE.get();
    }
}