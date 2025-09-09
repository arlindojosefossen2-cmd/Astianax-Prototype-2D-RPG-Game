package br.com.astianax.object;

import br.com.ajf.game.animation.Animation;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.GameObject;

public final class GoldenChestObject extends GameObject
{
	public GoldenChestObject( int yPos, int xPos)
	{
		super("GoldenChest", yPos, xPos);
	}

	@Override
	public void start()
	{
		index = 0;
		solidArea.setHeight(48);
		solidArea.setWidth(48);
		this.animations.addAnimation(new Animation("/objects/chest.png",1,12,GameConstants.TILESIZE-16,3f,false));
		this.animations.addAnimation(new Animation("/objects/chestop.png",3,12,GameConstants.TILESIZE-16,3f,false));
		
		this.animations.setAnimationByIndex(index);
	}
	
}