package br.com.astianax.collision;

import br.com.ajf.game.moviment.IDirection;
import br.com.astianax.gameobject.AbstractGameObject;
import br.com.astianax.scenes.AbstractScenne;

/**
 * The Class CheckePlayerCollision.
 */
public final class CheckePlayerCollision
{
	
	/**
	 * Checke player.
	 *
	 * @param scene the scene
	 * @param entity the entity
	 * @return true, if successful
	 */
	public boolean checkePlayer(final AbstractScenne scene,final AbstractGameObject entity)
	{
		boolean checker = false;
		
		entity.solidArea.setX(entity.solidArea.getX() + entity.xPos);
		entity.solidArea.setY(entity.solidArea.getY() + entity.yPos);
		
		scene.player.solidArea.setX(scene.player.solidArea.getX() + scene.player.xPos);
		scene.player.solidArea.setY(scene.player.solidArea.getY() + scene.player.yPos);
		
		switch(entity.direction)
		{
			case IDirection.UP:
				entity.solidArea.setY(entity.solidArea.getY() - entity.speed);
				break;
			case IDirection.DOWN:
				entity.solidArea.setY(entity.solidArea.getY() + entity.speed);
				break;
			case IDirection.LEFT:
				entity.solidArea.setX(entity.solidArea.getX() - entity.speed);
				break;
			case IDirection.RIGHT:
				entity.solidArea.setX(entity.solidArea.getX() + entity.speed);
					break;	
		}
		
		if(entity.solidArea.intersects(scene.player.solidArea))
		{
			entity.collision = true;
			checker = true;
		}
		
		entity.solidArea.setX(entity.solidAreaDefaultX);
		entity.solidArea.setY(entity.solidAreaDefaultY);
		
		scene.player.solidArea.setX(scene.player.solidAreaDefaultX);
		scene.player.solidArea.setY(scene.player.solidAreaDefaultY);
		
		return checker;
	}
}