package br.com.astianax.collision;

import br.com.ajf.game.moviment.IDirection;
import br.com.astianax.enemie.AbstractEnemies;
import br.com.astianax.scenes.AbstractScenne;

/**
 * The Class CheckePlayerCollision.
 */
public final class CheckeMonsterAttackCollision
{
	
	/**
	 * Check player.
	 *
	 * @param scene the scene
	 * @param entity the entity
	 * @return true, if successful
	 */
	public boolean checkePlayer(final AbstractScenne scene,final AbstractEnemies entity)
	{
		boolean checker = false;
		
		entity.attackArea.setX(entity.attackArea.getX() + entity.xPos);
		entity.attackArea.setY(entity.attackArea.getY() + entity.yPos);
		
		scene.player.attackArea.setX(scene.player.attackArea.getX() + scene.player.xPos);
		scene.player.attackArea.setY(scene.player.attackArea.getY() + scene.player.yPos);
		
		switch(entity.direction)
		{
			case IDirection.UP:
				entity.attackArea.setY(entity.attackArea.getY() - entity.speed);
				break;
			case IDirection.DOWN:
				entity.attackArea.setY(entity.attackArea.getY() + entity.speed);
				break;
			case IDirection.LEFT:
				entity.attackArea.setX(entity.attackArea.getX() - entity.speed);
				break;
			case IDirection.RIGHT:
				entity.attackArea.setX(entity.attackArea.getX() + entity.speed);
					break;	
		}
		
		if(entity.attackArea.intersects(scene.player.attackArea))
		{
			entity.collision = true;
			checker = true;
		}
		
		entity.attackArea.setX(entity.solidAreaDefaultX);
		entity.attackArea.setY(entity.solidAreaDefaultY);
		
		scene.player.attackArea.setX(scene.player.solidAreaDefaultX);
		scene.player.attackArea.setY(scene.player.solidAreaDefaultY);
		
		return checker;
	}
}