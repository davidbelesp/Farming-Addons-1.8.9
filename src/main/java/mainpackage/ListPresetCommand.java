package mainpackage;


import configmanager.ConfigController;
import configmanager.RotationModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import scala.collection.Iterator;
import scala.collection.mutable.HashSet;

public class ListPresetCommand extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "presetlist";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		// TODO Auto-generated method stub
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		
		HashSet<RotationModel> models = ConfigController.getAllPresets();
		
		ChatController.sendClientChat(player, "\u00A7a-----------------PRESET LIST-----------------");
		Iterator<RotationModel> it = models.iterator();
		while(it.hasNext()) {
			RotationModel actual = it.next();
			ChatController.sendClientChat(player, "\u00A7b Name:" + "\"\u00A7c" + actual.name + "\u00A7b\" - H:\u00A7c " + actual.yaw + "\u00A7b - V:\u00A7c " + actual.pitch);
		}
		ChatController.sendClientChat(player, "\u00A7a---------------------------------------------");
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }
	

}
