package br.com.astianax.object;

import br.com.ajf.game.animation.Animation;
import br.com.ajf.game.animation.IAnimationManager;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.GameObject;


public final class HamerObject extends GameObject
{
	public HamerObject(int yPos, int xPos)
	{
		super("Hamer", yPos, xPos);
	}

	@Override
	public void start()
	{
		index = 0;
		solid = false;
		image = IAnimationManager.LOADER.getScaledImage("/objects/marreta.png", 2f);
		this.animations.addAnimation(new Animation("/objects/maretaanime.png",4,12,GameConstants.TILESIZE-16,1.5f));
		this.animations.setAnimationByIndex(index);
	}
}