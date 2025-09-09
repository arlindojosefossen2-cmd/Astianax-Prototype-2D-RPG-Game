package br.com.astianax.object;

import br.com.ajf.game.animation.Animation;
import br.com.ajf.game.animation.IAnimationManager;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.GameObject;

public final class HeartObject extends GameObject
{
	public HeartObject( int yPos, int xPos)
	{
		super("Heart", yPos, xPos);
	}

	@Override
	public void start()
	{
		index = 0;
		solid = false;
		isConsumivel = true;
		image = IAnimationManager.LOADER.getScaledImage("/objects/fullheart.png", 2f);
		this.animations.addAnimation(new Animation("/objects/fullheartanime.png",5,12,GameConstants.TILESIZE-16,1.5f));
		this.animations.setAnimationByIndex(index);
	}
	
}