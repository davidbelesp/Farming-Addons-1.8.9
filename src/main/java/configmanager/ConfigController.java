package configmanager;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import com.sun.security.auth.login.ConfigFile;

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
	private static Configuration configFile = null;
	
	public static boolean loadConfigBoolean(String key, String category) {
		
		Configuration config = loadConfigFile();

		Boolean value = Boolean.valueOf(config.getString(category, key, "false", "breaking stem configuration"));
		
		return value;
	}
	
	public static String loadConfigString(String key, String category) {
		
		Configuration config = loadConfigFile();
		
		String value = config.getString(key, category, "", "");
		
		return value;
	}
	
	public static void saveConfigBoolean(String key, String category, boolean bool) {
		
		Configuration config = loadConfigFile();
		
		Property p = config.get(key, category, false, "breaking stem configuration");
		p.set(bool);
		
		config.save();
		
		updateConfigFile();
	}
	
	public static void saveConfigString(String key, String category, String coordinates) {
		
		Configuration config = loadConfigFile();
		
		Property p = config.get(category, key, coordinates);
		p.set(coordinates);
		
		config.save();
		
		updateConfigFile();
	}
	
	public static RotationModel loadRotationConfig(String key) {
		
		Configuration config = loadConfigFile();
		
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
		
		Property p = config.get(CATEGORY_PRESETS, key, value);
		p.set(value);
		
		config.save();
		
		updateConfigFile();
	}
	
	public static HashSet<RotationModel> getAllPresets() {
		
		Configuration config = loadConfigFile();
		
		HashSet<RotationModel> models = new HashSet();
		
		ConfigCategory cat = config.getCategory(CATEGORY_PRESETS);
		
		for (String key : cat.keySet()) {
			models.add(ConfigController.loadRotationConfig(key));
		}
		
		return models;
	}
	
	public static Configuration loadConfigFile() {
		if(configFile == null) {
			updateConfigFile();
			return ConfigController.configFile;
		}
		
		return ConfigController.configFile;
	}
	
	public static void updateConfigFile() {
		File configFile = new File(Loader.instance().getConfigDir(), "farmingaddons.cfg");
		ConfigController.configFile = new Configuration(configFile);
		ConfigController.configFile.load();
	}
	
}
