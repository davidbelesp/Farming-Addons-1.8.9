package configmanager;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import chat.ChatController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import scala.collection.mutable.HashSet;

public class ConfigController {

	private final static String CATEGORY_PRESETS = "presets";
	
	public static boolean loadConfigBoolean(String key, String category) {
		
		Configuration config = loadConfigFile();
		
		config.load();
		
		Boolean value = Boolean.valueOf(config.getString(category, key, "false", "breaking stem configuration"));
		
		return value;
	}
	
	public static void saveConfigBoolean(String key, String category, boolean bool) {
		
		Configuration config = loadConfigFile();
		
		config.load();
		
		Property p = config.get(key, category, false, "breaking stem configuration");
		p.set(bool);
		
		config.save();
	}
	
	public static RotationModel loadRotationConfig(String key) {
		
		Configuration config = loadConfigFile();
		
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
	
	public static void savePresetConfig(String key, String value) {
		
		Configuration config = loadConfigFile();
		
		config.load();
		
		Property p = config.get(CATEGORY_PRESETS, key, value);
		p.set(value);
		
		config.save();
	}
	
	public static HashSet<RotationModel> getAllPresets() {
		
		Configuration config = loadConfigFile();
		
		config.load();
		
		HashSet<RotationModel> models = new HashSet();
		
		ConfigCategory cat = config.getCategory(CATEGORY_PRESETS);
		
		for (String key : cat.keySet()) {
			models.add(ConfigController.loadRotationConfig(key));
		}
		
		return models;
		
		
	}
	
	public static Configuration loadConfigFile() {
		File configFile = new File(Loader.instance().getConfigDir(), "farmingaddons.cfg");
		return new Configuration(configFile);
	}
	
}
