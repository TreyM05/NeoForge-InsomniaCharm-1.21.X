package net.treyvon.insomniacharm.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.treyvon.insomniacharm.InsomniaCharm;
import net.treyvon.insomniacharm.item.custom.CharmItem;
import top.theillusivec4.curios.api.CuriosApi;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(InsomniaCharm.MOD_ID);

    public static final DeferredItem<Item> CHARMINSOMNIA = ITEMS.register("insomniacharm",
            () -> new CharmItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
