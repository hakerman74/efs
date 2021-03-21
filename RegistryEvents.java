package com.charles.myMod.events;

import org.apache.logging.log4j.Logger;

import com.charles.myMod.main;
import com.charles.myMod.lists.BlockList;
import com.charles.myMod.lists.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents
{
	public static final Logger LOGGER = main.LOGGER;
	public static final String MOD_ID = main.MOD_ID;
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
				ItemList.copper_dust = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("copper_dust")),
				ItemList.copper_fragment = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("copper_fragment")),
				ItemList.copper_ore = new BlockItem(BlockList.copper_ore, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.copper_ore.getRegistryName()),
				ItemList.lime_linoleum = new BlockItem(BlockList.lime_linoleum, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.lime_linoleum.getRegistryName())
		);
		
	}
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll
		(
				BlockList.copper_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f).sound(SoundType.STONE)).setRegistryName(location("copper_ore")));
				BlockList.lime_linoleum = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f).sound(SoundType.STONE)).setRegistryName(location("lime_linoleum"));
				
	}
	
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(MOD_ID, name);
	}
}
