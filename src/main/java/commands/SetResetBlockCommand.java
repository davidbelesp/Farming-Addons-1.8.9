package commands;

import chat.ChatController;
import chat.Formatting;
import configmanager.ConfigController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class SetResetBlockCommand extends CommandBase{

	Minecraft minecraft = Minecraft.getMinecraft();
	
	@Override
	public String getCommandName() {
		return "setresetspawn";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		 
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		
		EntityPlayerSP player = minecraft.thePlayer;
		
		int posX = (int) player.posX;
		int posZ = (int) player.posZ;
		int posY = (int) player.posY + 1;
		
		
		ConfigController.saveConfigString("coordinates", "reset", posX + ":" + posY + ":" + posZ);
		
		ChatController.sendClientChat(player,
				Formatting.AQUA + "Saved reset block at: " + 
						Formatting.LIME + "'X=" + posX + "'" + 
						Formatting.LIME + "'Y=" + posY + "'" + 
						Formatting.LIME + "'Z=" + posZ + "'");
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }
	
}
