package commands;

import configmanager.ConfigController;
import mainpackage.ChatController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Vec3;
import scala.swing.TextComponent;

public class PresetCommand extends CommandBase{

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "savepreset";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		
		if(args.length != 3) {
			ChatController.sendClientChat(player, "\u00A7cInvalid command arguments, use:");
			ChatController.sendClientChat(player, "\u00A7c/savepreset {name} {number} {number}");
			return;
		}
		
		String name = args[0];
		float yaw = Float.valueOf(args[1]);
		float pitch = Float.valueOf(args[2]);

		ConfigController.saveConfig(name, "["+ yaw + "," + pitch +"]");
		
		ChatController.sendClientChat(player, "\u00A7aSaved preset name " + name + " successfully");
		
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }
	
	
	
	
}
