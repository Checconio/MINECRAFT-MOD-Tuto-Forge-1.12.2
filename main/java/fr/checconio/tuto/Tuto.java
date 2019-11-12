package fr.checconio.tuto;

import fr.checconio.tuto.init.BlocksMod;
import fr.checconio.tuto.init.ItemsMod;
import fr.checconio.tuto.init.RecipesMod;
import fr.checconio.tuto.proxy.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptedMinecraftVersions = References.MINECRAFT_VERSION)
public class Tuto
{
	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY, modId = References.MODID)
	public static ServerProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		BlocksMod.init();
		ItemsMod.init();
		RecipesMod.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.register();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}