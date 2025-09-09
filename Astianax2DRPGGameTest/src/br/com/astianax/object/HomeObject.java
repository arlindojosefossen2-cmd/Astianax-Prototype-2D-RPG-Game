package br.com.astianax.object;

import br.com.ajf.game.animation.Animation;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.GameObject;

public final class HomeObject extends GameObject
{
	public HomeObject(int yPos, int xPos)
	{
		super("Home", yPos, xPos);
	}

	@Override
	public void start()
	{
		index = 0;
		solid = false;
		
		this.animations.addAnimation(new Animation("/objects/homeanime.png",4,12,GameConstants.TILESIZE,4f));
		this.animations.setAnimationByIndex(index);
		
		solidArea.setX(8);
		solidArea.setY(16);
		solidArea.setWidth(48);
		solidArea.setHeight(48);
		
		solidAreaDefaultX = solidArea.getX();
		solidAreaDefaultY = solidArea.getY();
	
	}
}