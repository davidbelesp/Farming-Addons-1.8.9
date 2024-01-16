package events;

import configmanager.ConfigController;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PreventStemBreaking {
	
	@SubscribeEvent()
	public void onBlockBreak(BreakEvent event){
		
		if(!ConfigController.loadConfigBoolean("break", "stem")) {
			return;
		}
		
		Block eventBlock = event.state.getBlock();
		
		if(eventBlock==Blocks.pumpkin_stem || eventBlock==Blocks.melon_stem) {
			event.setCanceled(true);
		}
		
	}
	
}
