package configmanager;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import mainpackage.ChatController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import scala.collection.mutable.HashSet;

public class ConfigController {

	private final static String CATEGORY_PRESETS = "presets";
	
	public static RotationModel loadConfig(String key) {
		
		File configFile = new File(Loader.instance().getConfigDir(), "farmingaddons.cfg");
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		String value = config.getString(key, CATEGORY_PRESETS, "", "");
		
		value = value.replace("[", "");
		value = value.replace("]", "");
		String[] values = value.split(",");

		float yaw = Float.valueOf(values[0]);
		float pitch = Float.valueOf(values[1]);
		String name = key;
		
		RotationModel rotationModel = new RotationModel(yaw, pitch, name);
		
		return rotationModel;
	}
	
	public static void saveConfig(String key, String value) {
		File configFile = new File(Loader.instance().getConfigDir(), "farmingaddons.cfg");
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		Property p = config.get(CATEGORY_PRESETS, key, value);
		p.set(value);
		
		config.save();
	}
	
	public static HashSet<RotationModel> getAllPresets() {
		File configFile = new File(Loader.instance().getConfigDir(), "farmingaddons.cfg");
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		HashSet<RotationModel> models = new HashSet();
		
		ConfigCategory cat = config.getCategory(CATEGORY_PRESETS);
		
		for (String key : cat.keySet()) {
			models.add(ConfigController.loadConfig(key));
		}
		
		return models;
		
		
	}
	
	
	
	
}
