package br.com.astianax.npc;

import br.com.ajf.game.animation.Animation;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.entity.Entity;
import br.com.astianax.scenes.AbstractScenne;

public final class OldManNpc extends Entity
{
	public OldManNpc(AbstractScenne scene, int yPos, int xPos, int speed)
	{
		super(scene, "OldMan", yPos, xPos, speed);
	}
	public OldManNpc(int yPos, int xPos, int speed)
	{
		super(null,"OldMan",yPos, xPos, speed);
	}

	@Override
	public void start()
	{
		solidArea.setX(24); 
		solidArea.setY(24);
		solidArea.setWidth(18);
		solidArea.setHeight(22);
		solidAreaDefaultX = solidArea.getX();
		solidAreaDefaultY = solidArea.getY();
		//idle
		this.animations.addAnimation(new Animation("/npcs/oldman/anciao/idleup.png", 2, 30, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldman/anciao/idledown.png", 2, 30, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldman/anciao/idleleft.png", 2, 30, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldman/anciao/idleright.png", 2, 30, GameConstants.TILESIZE, 1));	
		//walk
		this.animations.addAnimation(new Animation("/npcs/oldman/anciao/walkup.png", 8, 6, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldman/anciao/walkdown.png", 8, 6, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldman/anciao/walkleft.png", 8, 6, GameConstants.TILESIZE, 1));
		this.animations.addAnimation(new Animation("/npcs/oldman/anciao/walkright.png", 8, 6, GameConstants.TILESIZE, 1));	
		
		this.animations.setAnimationByIndex(2);
	}
}