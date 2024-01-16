package events;

import chat.ChatController;
import chat.Formatting;
import configmanager.ConfigController;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import utils.WorldPosition;

public class ResetBlockEvent {

	//tick management to just warp 1 time and not 102381
	private int triggered_tick = 0;
	private int tick = 0;
	
	@SubscribeEvent()
	public void onPlayerTickEvent(PlayerTickEvent event) {
		
		String values[] = ConfigController.loadConfigString("coordinates", "reset").replace(",", ".").split(":");
		
		if(values.length < 3) return;
		
		WorldPosition pos = new WorldPosition((int)event.player.posX, (int)event.player.posY, (int)event.player.posZ);
		
		WorldPosition worldPoint = new WorldPosition(Integer.valueOf(values[0]), Integer.valueOf(values[1]), Integer.valueOf(values[2]));
		
		if(pos.equals(worldPoint) && tick - triggered_tick > 300) {
			triggered_tick = tick;
			ChatController.sendClientChat(Minecraft.getMinecraft().thePlayer, Formatting.AQUA + "Detected end, warping...");
			ChatController.sendToChat(Minecraft.getMinecraft().thePlayer, "/warp garden");
		}
		tick++;
	}
	
}
