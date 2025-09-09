package br.com.astianax.scenes;

import java.awt.Graphics2D;

import br.com.ajf.game.model.Game;
import br.com.ajf.game.moviment.IDirection;
import br.com.ajf.game.util.GameRect;
import br.com.astianax.audio.GameAudio;
import br.com.astianax.collision.TileCollision;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.AbstractGameObject;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.tile.TileManager;

public final class City2Scenne extends AbstractScenne
{
	/** The rect. */
	private final GameRect rect = new GameRect(24*GameConstants.TILESIZE+16, 49*GameConstants.TILESIZE-32, 96,64);
	
	
	public City2Scenne(AbstractPlayer player, Game game, TileManager tmanager, AbstractGameObject[] entities,
			TileCollision tCollision)
	{
		super(player, game, tmanager, entities, tCollision);
	}
	@Override
	public void start()
	{
		super.start();
		
		text = " City Of Rinus ";
		player.xPos = 25*GameConstants.TILESIZE;
		player.yPos = 47*GameConstants.TILESIZE;
		player.inHome = false;
		player.direction = IDirection.UP;
		play = true;
	}

	@Override
	public void updateScenne()
	{
		if(!isTransition && play)
		{
			GameAudio.surf1.play();
			play = false;
		}
		
		final int xPos = player.xPos+player.solidArea.getX();
		final int yPos = player.yPos + player.solidArea.getY();
		
		if(rect.intersects(xPos,yPos,player.solidArea.getWidth(),player.solidArea.getHeight()))
		{
			for (int i = 0; i < entities.length; i++)
			{
				entities[i] = null;
			}
		
			final TileManager tmanager = new TileManager();
			tmanager.loadImages("/data/testtiles.txt",GameConstants.TILESIZE);
			tmanager.loadMapdata("/maps/worldtest.txt");
			final TileCollision tCollision = new TileCollision();
		
			final IslandScenne play = new IslandScenne(player, game, tmanager, entities, tCollision);
		
			play.start();
			player.xPos = 37*GameConstants.TILESIZE-16;
			player.yPos = 40*GameConstants.TILESIZE-32;
			player.direction = IDirection.DOWN;
			GameAudio.surf1.stop();
			game.addScene(play);
		}
	}

	@Override
	public void drawScenne(Graphics2D graphics2d)
	{
//		debug	
//		graphics2d.setColor(Color.RED);
//		graphics2d.drawRect(
//				rect.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//				rect.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//				rect.getWidth(), 
//				rect.getHeight());
	}
}