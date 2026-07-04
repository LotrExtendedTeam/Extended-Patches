package com.github.lotrextendedteam.extendedfixes;

import com.github.maximuslotro.lotrrextended.ExtendedLog;

import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.fml.common.Mod;

@Mod("extended_patches")
public class ExtendedFixes {

	public ExtendedFixes() {
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.addListener(EventPriority.HIGH, ExtendedFixes::addRabbitPatch);
	}

	public static void addRabbitPatch(LivingSpawnEvent.CheckSpawn event) {
		if(event.getEntity().getType()==EntityType.RABBIT) {
			ExtendedLog.info("rabbit");
			if(event.getWorld().getBiome(new BlockPos(event.getX(), event.getY(), event.getZ())).getRegistryName().getNamespace().equals("lotr")) {
				ExtendedLog.info("lotr biome");
				event.setResult(Result.DENY);
			}
		}
	}
}
