package proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders() {
		
	}
	
	@Override
	public void doClientRightClick() {
		super.doClientRightClick();
		
		KeyBinding.onTick(Minecraft.getMinecraft().gameSettings.keyBindAttack.getKeyCode());
	}
	
}
