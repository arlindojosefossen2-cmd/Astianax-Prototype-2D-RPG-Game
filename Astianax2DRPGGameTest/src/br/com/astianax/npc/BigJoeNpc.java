package br.com.astianax.npc;

import br.com.ajf.game.animation.Animation;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.entity.Entity;
import br.com.astianax.scenes.AbstractScenne;


public final class BigJoeNpc extends Entity
{
	public BigJoeNpc(AbstractScenne scene, int yPos, int xPos, int speed)
	{
		super(scene, "BigJoe", yPos, xPos, speed);
		solidArea.setX(40);
		solidArea.setY(32); 
		solidArea.setWidth(28);
		solidArea.setHeight(40);
	}

	@Override
	public void start()
	{
		solidArea.setX(40); 
		solidArea.setY(40);
		solidArea.setWidth(20);
		solidArea.setHeight(36);
		solidAreaDefaultX = solidArea.getX();
		solidAreaDefaultY = solidArea.getY();
		//idle
		this.animations.addAnimation(new Animation("/npcs/bigjoe/idleup.png", 2, 30, GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/npcs/bigjoe/idledown.png", 2, 30, GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/npcs/bigjoe/idleleft.png", 2, 30, GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/npcs/bigjoe/idleright.png", 2, 30, GameConstants.TILESIZE+32, 1));	
		//walk
		this.animations.addAnimation(new Animation("/npcs/bigjoe/walkup.png", 8, 6, GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/npcs/bigjoe/walkdown.png", 8, 6, GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/npcs/bigjoe/walkleft.png", 8, 6, GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/npcs/bigjoe/walkright.png", 8, 6, GameConstants.TILESIZE+32, 1));	
		
		this.animations.setAnimationByIndex(2);
	}
}