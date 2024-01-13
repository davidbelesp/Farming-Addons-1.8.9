package commands;

import chat.ChatController;
import chat.Formatting;
import configmanager.ConfigController;
import configmanager.RotationModel;
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

public class RotationCommand extends CommandBase{

	@Override
	public String getCommandName() {
		return "rotate";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		
		float yaw;
		float pitch;
		
		if(args.length > 2 || args.length == 0) {
			ChatController.sendClientChat(player, Formatting.RED + "Invalid command arguments, use one below:");
			ChatController.sendClientChat(player, Formatting.RED + "/rotate {horizontal} {vertical}");
			ChatController.sendClientChat(player, Formatting.RED + "/rotate {preset name}");
			return;
		}

		if(args.length == 1) {
			RotationModel model = ConfigController.loadRotationConfig(args[0]);
			
			yaw = model.yaw;
			pitch = model.pitch;
			
			
		} else {
			yaw = Float.valueOf(args[0]);
			pitch = Float.valueOf(args[1]);
		}
	
		Vec3 position = player.getPositionVector();

		player.setPositionAndRotation(position.xCoord, position.yCoord, position.zCoord, yaw, pitch);
		ChatController.sendClientChat(player, "\u00A7aRotating to H: \u00A7b" + yaw + "\u00A7a - V:\u00A7b " + pitch);
		
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }
	
}
