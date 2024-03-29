package commands;

import chat.ChatController;
import chat.Formatting;
import configmanager.ConfigController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class PresetCommand extends CommandBase{

	@Override
	public String getCommandName() {
		return "savepreset";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		
		if(args.length != 3) {
			ChatController.sendClientChat(player, Formatting.RED + "Invalid command arguments, use:");
			ChatController.sendClientChat(player, Formatting.RED + "/savepreset {name} {number} {number}");
			return;
		}
		
		String name = args[0];
		float yaw = Float.valueOf(args[1]);
		float pitch = Float.valueOf(args[2]);

		ConfigController.savePresetConfig(name, "["+ yaw + "," + pitch +"]");
		
		ChatController.sendClientChat(player, Formatting.LIME + "Saved preset name " + name + " successfully");
		
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }
	
}
