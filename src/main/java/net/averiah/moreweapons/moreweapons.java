package net.averiah.moreweapons;

import com.mojang.logging.LogUtils;
import net.averiah.moreweapons.item.ModCreativeModTabs;
import net.averiah.moreweapons.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(moreweapons.MOD_ID)
public class moreweapons {
    public static final String MOD_ID = "moreweapons";
    public static final Logger LOGGER = LogUtils.getLogger();

    public moreweapons() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.REINFORCEDIRON);
            event.accept(ModItems.STONESTICK);

        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.REINFORCEDIRONSWORD);
            event.accept(ModItems.IRONDAGGER);
            event.accept(ModItems.WOODENDAGGER);
            event.accept(ModItems.STONEDAGGER);
            event.accept(ModItems.GOLDENDAGGER);
            event.accept(ModItems.DIAMONDDAGGER);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
