package mainpackage;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;

public class ChatController {

	
	public static void sendClientChat(EntityPlayerSP player, String message) {
		player.addChatComponentMessage(new ChatComponentText(message));
	}
	
	public static void sendToChat(EntityPlayerSP player, String message) {
		player.sendChatMessage(message);
	}
	
	
}
