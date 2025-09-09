package br.com.astianax.npc;

import br.com.ajf.game.animation.Animation;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.entity.Entity;
import br.com.astianax.scenes.AbstractScenne;


public final class LitlleBoyNpc extends Entity
{
	public LitlleBoyNpc(AbstractScenne scene, int yPos, int xPos, int speed)
	{
		super(scene, "Boy", yPos, xPos, speed);
	}

	public LitlleBoyNpc(int yPos, int xPos, int speed)
	{
		super(yPos, xPos, speed);
	}



	@Override
	public void start()
	{
		
		solidArea.setX(26); 
		solidArea.setY(26);
		solidArea.setWidth(15);
		solidArea.setHeight(20);
		solidAreaDefaultX = solidArea.getX();
		solidAreaDefaultY = solidArea.getY();
		//idle
		this.animations.addAnimation(new Animation("/npcs/boy/idleup.png", 2, 30, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/boy/idledown.png", 2, 30, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/boy/idleleft.png", 2, 30, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/boy/idleright.png", 2, 30, GameConstants.TILESIZE, 1));	
		//walk
		this.animations.addAnimation(new Animation("/npcs/boy/walkup.png", 8, 6, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/boy/walkdown.png", 8, 6, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/boy/walkleft.png", 8, 6, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/boy/walkright.png", 8, 6, GameConstants.TILESIZE, 1));	
		
		this.animations.setAnimationByIndex(2);
	}
}