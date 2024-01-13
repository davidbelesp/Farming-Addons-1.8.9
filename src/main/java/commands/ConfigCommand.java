package commands;

import chat.ChatController;
import chat.Formatting;
import configmanager.ConfigController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ConfigCommand extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "faconfig";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

		if (args.length < 1) {
			showCommandUsage(player);
			return;
		}
		
		String option = args[0];

		if (option.equals("help")) {
			ChatController.sendClientChat(player, Formatting.LIME + "---------- Farming config manager ----------");
			ChatController.sendClientChat(player, Formatting.AQUA + "/faconfig stem " + Formatting.RED + "<true / false> \u00A7r| Disables or enables the breaking option for Pumpkin and Melon stems");
			return;
		}

		if (args.length < 2) {
			showCommandUsage(player);
			return;
		}

		String value = args[1];

		if (option.equals("stem")) {
			if (value.equals("true")) {
				ConfigController.saveConfigBoolean("break", "stem", true);
				ChatController.sendClientChat(player,
						Formatting.AQUA + "Disable destroy stems : " + Formatting.LIME + "true");
			}
			if (value.equals("false")) {
				ConfigController.saveConfigBoolean("break", "stem", false);
				ChatController.sendClientChat(player,
						Formatting.AQUA + "Disable destroy stems : " + Formatting.RED + "false");
			}
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}
	
	private void showCommandUsage(EntityPlayerSP player) {
		ChatController.sendClientChat(player, Formatting.RED + "Invalid command arguments, use:");
		ChatController.sendClientChat(player, Formatting.RED + "/faconfig help");
	}

}
