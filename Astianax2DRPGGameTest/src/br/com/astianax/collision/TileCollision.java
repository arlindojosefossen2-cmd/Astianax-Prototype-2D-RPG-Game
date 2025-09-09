package br.com.astianax.collision;

import br.com.ajf.game.moviment.IDirection;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.AbstractGameObject;
import br.com.astianax.tile.TileManager;

public final class TileCollision
{
	public TileCollision()	
	{
	}

	public void checkTile(final AbstractGameObject gameobject,final TileManager tManager)
	{
		int gameobjectLeftWorldX = gameobject.xPos + gameobject.solidArea.getX();
		int gameobjectRightWorldX = gameobject.xPos + gameobject.solidArea.getX()+ gameobject.solidArea.getWidth();
		
		int gameobjectTopWorldY = gameobject.yPos + gameobject.solidArea.getY();
		int gameobjectBottomWorldY = gameobject.yPos + gameobject.solidArea.getY() + gameobject.solidArea.getHeight();
		
		int gameobjectLeftCollun = (gameobjectLeftWorldX ) / GameConstants.TILESIZE;
		int gameobjectRightCollun = (gameobjectRightWorldX ) / GameConstants.TILESIZE;
		int gameobjectTopRow = (gameobjectTopWorldY ) / GameConstants.TILESIZE;
		int gameobjectBottomRow = (gameobjectBottomWorldY) / GameConstants.TILESIZE;
		
		int tileId_1 ;
		int tileId_2 ;
		
		switch(gameobject.direction)
		{
		case IDirection.UP:
			gameobjectTopRow = (gameobjectTopWorldY - gameobject.speed) / GameConstants.TILESIZE;
			tileId_1 = tManager.getMapData()[gameobjectTopRow][gameobjectLeftCollun]-1;
            tileId_2 = tManager.getMapData()[gameobjectTopRow][gameobjectRightCollun]-1;
            
            if(tManager.getTiles()[tileId_1].isSolid() || tManager.getTiles()[tileId_2].isSolid())
    		{
    			gameobject.collision = true;
    		}
			break;
		case IDirection.DOWN:
			gameobjectBottomRow = (gameobjectBottomWorldY + gameobject.speed) / GameConstants.TILESIZE;
			tileId_1 = tManager.getMapData()[gameobjectBottomRow][gameobjectLeftCollun]-1;
            tileId_2 = tManager.getMapData()[gameobjectBottomRow][gameobjectRightCollun]-1;
            if(tManager.getTiles()[tileId_1].isSolid() || tManager.getTiles()[tileId_2].isSolid())
    		{
    			gameobject.collision = true;
    		}
			
			break;
		case IDirection.LEFT:
			gameobjectLeftCollun = (gameobjectLeftWorldX - gameobject.speed) / GameConstants.TILESIZE;
			tileId_1 = tManager.getMapData()[gameobjectTopRow][gameobjectLeftCollun]-1;
            tileId_2 = tManager.getMapData()[gameobjectBottomRow][gameobjectRightCollun]-1;
            if(tManager.getTiles()[tileId_1].isSolid() || tManager.getTiles()[tileId_2].isSolid())
    		{
    			gameobject.collision = true;
    		}
			
			break;
		case IDirection.RIGHT:
			gameobjectRightCollun = (gameobjectRightWorldX + gameobject.speed) / GameConstants.TILESIZE;
			tileId_1 = tManager.getMapData()[gameobjectTopRow][gameobjectLeftCollun]-1;
            tileId_2 = tManager.getMapData()[gameobjectBottomRow][gameobjectRightCollun]-1;
            if(tManager.getTiles()[tileId_1].isSolid() || tManager.getTiles()[tileId_2].isSolid())
    		{
    			gameobject.collision = true;
    		}
			
			break;
		}
	}
}