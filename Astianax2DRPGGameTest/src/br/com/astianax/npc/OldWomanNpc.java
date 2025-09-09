package br.com.astianax.npc;

import br.com.ajf.game.animation.Animation;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.entity.Entity;
import br.com.astianax.scenes.AbstractScenne;

public final class OldWomanNpc extends Entity
{
	public OldWomanNpc(AbstractScenne scene, int yPos, int xPos, int speed)
	{
		super(scene, "OldWoman", yPos, xPos, speed);
	}

	@Override
	public void start()
	{
		solidArea.setX(24); 
		solidArea.setY(24);
		solidArea.setWidth(18);
		solidArea.setHeight(28);
		solidAreaDefaultX = solidArea.getX();
		solidAreaDefaultY = solidArea.getY();
		//idle
		this.animations.addAnimation(new Animation("/npcs/oldwoman/idleup.png", 2, 30, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldwoman/idledown.png", 2, 30, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldwoman/idleleft.png", 2, 30, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldwoman/idleright.png", 2, 30, GameConstants.TILESIZE, 1));	
		//walk
		this.animations.addAnimation(new Animation("/npcs/oldwoman/walkup.png", 8, 6, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldwoman/walkdown.png", 8, 6, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldwoman/walkleft.png", 8, 6, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldwoman/walkright.png", 8, 6, GameConstants.TILESIZE, 1));	
		
		this.animations.setAnimationByIndex(2);
	}
}