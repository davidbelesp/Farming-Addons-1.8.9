package commands;

import mainpackage.ChatController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class HelpCommand extends CommandBase{

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "fahelp";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		 
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		
		ChatController.sendClientChat(player, "\u00A7a---------- Farming addons Help ----------");
		ChatController.sendClientChat(player, "\u00A7b /savepreset \u00A7c<name> <horizontal> <vertical>  \u00A7r| Saves custom preset");
		ChatController.sendClientChat(player, "\u00A7b /presetlist \u00A7r| Shows all saved presets");
		ChatController.sendClientChat(player, "\u00A7b /rotate \u00A7c<horizontal> <vertical>  \u00A7r| Rotates camera to numbers given");
		ChatController.sendClientChat(player, "\u00A7b /rotate \u00A7c<name>  \u00A7r| Rotates camera to preset given");
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }

}
