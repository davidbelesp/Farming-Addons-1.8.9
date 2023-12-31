package mainpackage;

import commands.HelpCommand;
import commands.PresetCommand;
import commands.RotationCommand;
import configmanager.ConfigController;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import proxy.CommonProxy;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class FarmingAddons {

	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance(Reference.NAME)
	public static FarmingAddons instance;

	
	@EventHandler()
	public static void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler()
	public static void init(FMLInitializationEvent event) {
		proxy.registerRenders();
		
		ClientCommandHandler.instance.registerCommand(new HelpCommand());
		ClientCommandHandler.instance.registerCommand(new RotationCommand());
		ClientCommandHandler.instance.registerCommand(new PresetCommand());
		ClientCommandHandler.instance.registerCommand(new ListPresetCommand());
	}
	
	@EventHandler()
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
	
	
}
