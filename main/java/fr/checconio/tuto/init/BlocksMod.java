package fr.checconio.tuto.init;

import fr.checconio.tuto.References;
import fr.checconio.tuto.blocks.BlockMod;
import fr.checconio.tuto.blocks.BlockOreMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class BlocksMod
{
	public static Block block_tuto, block_ore_tuto;
	
	public static void init()
	{
		block_tuto = new BlockMod("block_tuto", Material.ROCK);
		block_ore_tuto = new BlockOreMod("block_ore_tuto", 2, 1, 8);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(block_tuto, block_ore_tuto);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(
				new ItemBlock(block_tuto).setRegistryName(block_tuto.getRegistryName()),
				new ItemBlock(block_ore_tuto).setRegistryName(block_ore_tuto.getRegistryName())
				);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(Item.getItemFromBlock(block_tuto));
		registerRender(Item.getItemFromBlock(block_ore_tuto));
	}
	
	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}