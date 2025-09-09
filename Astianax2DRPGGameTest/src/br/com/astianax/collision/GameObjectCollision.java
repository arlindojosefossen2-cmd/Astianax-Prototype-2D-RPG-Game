package br.com.astianax.collision;

import br.com.ajf.game.moviment.IDirection;
import br.com.astianax.gameobject.AbstractGameObject;


public final class GameObjectCollision
{
	public int checkeAbstractGameObjectCollision(AbstractGameObject entity,AbstractGameObject[] entities,boolean isPlayer)
	{
		int index = -1;
	
		for(int i = 0;i < entities.length;i++)
		{
			AbstractGameObject ent = entities[i];
			
			if(ent != null)
			{
				entity.solidArea.setX(entity.solidArea.getX() + entity.xPos);
				entity.solidArea.setY(entity.solidArea.getY() + entity.yPos);
				
				ent.solidArea.setX(ent.solidArea.getX() + ent.xPos);
				ent.solidArea.setY(ent.solidArea.getY() + ent.yPos);
				
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
				
				if(entity.solidArea.intersects(ent.solidArea))
				{
					if(ent.solid && ent != entity)
					{
						entity.collision = true;
					}
					if(isPlayer)
					{
						index = i;
					}
				}
				
				entity.solidArea.setX(entity.solidAreaDefaultX);
				entity.solidArea.setY(entity.solidAreaDefaultY);
				
				ent.solidArea.setX(ent.solidAreaDefaultX);
				ent.solidArea.setY(ent.solidAreaDefaultY);
			
			}
		}
		return index;
	}
}