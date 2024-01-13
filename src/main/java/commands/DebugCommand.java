package commands;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.client.settings.KeyBinding;

public class DebugCommand extends CommandBase{

	private final Minecraft minecraft = Minecraft.getMinecraft();
	
	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "fadev";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		PlayerControllerMP pController = minecraft.playerController;
		EntityPlayerSP player = minecraft.thePlayer;
		
		
		
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }
	
}
