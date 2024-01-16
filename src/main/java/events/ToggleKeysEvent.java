package events;

import org.lwjgl.input.Keyboard;

import configmanager.ConfigController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ToggleKeysEvent {

	private Minecraft minecraft = Minecraft.getMinecraft();
	
	private final int forward_keycode = minecraft.gameSettings.keyBindForward.getKeyCode();
	private final int back_keycode = minecraft.gameSettings.keyBindBack.getKeyCode();
	private final int right_keycode = minecraft.gameSettings.keyBindRight.getKeyCode();
	private final int left_keycode = minecraft.gameSettings.keyBindLeft.getKeyCode();
	
	private final int click_code = 0;
	
	private boolean forwardtoggle = false;
	private boolean backtoggle = false;
	private boolean righttoggle = false;
	private boolean lefttoggle = false;
	
	private boolean clicktoggle = false;
	
	private static int count = 0;
	
	@SubscribeEvent()
	public void onKeyPressed(KeyInputEvent event) {
		
		if(!ConfigController.loadConfigBoolean("wasd", "toggle")) {
			return;
		}
		
		if(!(Keyboard.isKeyDown(forward_keycode)||Keyboard.isKeyDown(back_keycode)||Keyboard.isKeyDown(right_keycode)||Keyboard.isKeyDown(left_keycode))) return;
		
		if(Keyboard.isKeyDown(forward_keycode)) {
			forwardtoggle = !forwardtoggle;
			KeyBinding.setKeyBindState(back_keycode, false);
			KeyBinding.setKeyBindState(right_keycode, false);
			KeyBinding.setKeyBindState(left_keycode, false);
			backtoggle = false;
			righttoggle = false;
			lefttoggle = false;
		}
		if(Keyboard.isKeyDown(back_keycode)) {
			backtoggle = !backtoggle;
			KeyBinding.setKeyBindState(forward_keycode, false);
			KeyBinding.setKeyBindState(right_keycode, false);
			KeyBinding.setKeyBindState(left_keycode, false);
			forwardtoggle = false;
			righttoggle = false;
			lefttoggle = false;
		}
		if(Keyboard.isKeyDown(right_keycode)) {
			righttoggle = !righttoggle;
			KeyBinding.setKeyBindState(forward_keycode, false);
			KeyBinding.setKeyBindState(back_keycode, false);
			KeyBinding.setKeyBindState(left_keycode, false);
			forwardtoggle = false;
			backtoggle = false;
			lefttoggle = false;
		}
		if(Keyboard.isKeyDown(left_keycode)) {
			lefttoggle = !lefttoggle;
			KeyBinding.setKeyBindState(forward_keycode, false);
			KeyBinding.setKeyBindState(back_keycode, false);
			KeyBinding.setKeyBindState(right_keycode, false);
			forwardtoggle = false;
			backtoggle = false;
			righttoggle = false;
		}

	}
	
	@SubscribeEvent()
	public void onTick(TickEvent event) {
		
		if(ConfigController.loadConfigBoolean("wasd", "toggle")) {
			if(forwardtoggle) KeyBinding.setKeyBindState(forward_keycode, forwardtoggle);
			if(backtoggle) KeyBinding.setKeyBindState(back_keycode, backtoggle);
			if(righttoggle) KeyBinding.setKeyBindState(right_keycode, righttoggle);
			if(lefttoggle) KeyBinding.setKeyBindState(left_keycode, lefttoggle);
		}
		
//		if(ConfigController.loadConfigBoolean("mouse", "toggle")) {
//			if(clicktoggle) {
//				if(Mouse.isButtonDown(0)) {
//					ChatController.sendClientChat(minecraft.thePlayer, "HOLDING");
//					
//				}
//				
//			}
//		}
		
	}

}
