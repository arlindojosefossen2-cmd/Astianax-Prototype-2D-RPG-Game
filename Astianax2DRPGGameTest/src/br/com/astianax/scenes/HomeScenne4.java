package br.com.astianax.scenes;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import br.com.ajf.game.model.Game;
import br.com.ajf.game.moviment.IDirection;
import br.com.astianax.audio.GameAudio;
import br.com.astianax.collision.TileCollision;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.AbstractGameObject;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.tile.TileManager;

/**
 * 
 * Autor A.J.F.
 * @version 1.0
 * 25 de jun. de 2025
 */
public final class HomeScenne4 extends AbstractScenne
{
	
	/** The rect. */
	private final Rectangle rect = new Rectangle(11*GameConstants.TILESIZE, 19*GameConstants.TILESIZE+32, 128, 32);
	
	/** The porao 1. */
	private final Rectangle porao1 = new Rectangle(2*GameConstants.TILESIZE, 16*GameConstants.TILESIZE, 64, 64);
	
	/** The porao 2. */
	private final Rectangle porao2 = new Rectangle(16*GameConstants.TILESIZE, 16*GameConstants.TILESIZE, 64, 64);

	/**
	 * Instantiates a new home scenne 4.
	 *
	 * @param player the player
	 * @param game the game
	 * @param tmanager the tmanager
	 * @param entities the entities
	 * @param tCollision the t collision
	 */
	public HomeScenne4(final AbstractPlayer player,final Game game,final TileManager tmanager,final AbstractGameObject[] entities,
			final TileCollision tCollision)
	{
		super(player, game, tmanager, entities, tCollision);
	}
	
	/**
	 * Start.
	 */
	@Override
	public void start()
	{
		super.start();
//		tManager.loadImages("/data/tiles.txt",64);
//		tManager.loadMapdata("/maps/map2.txt");
		player.xPos = 11*GameConstants.TILESIZE;
		player.yPos = 17*GameConstants.TILESIZE;
		player.direction = IDirection.UP;
		player.inHome = true;
		text = " Casa Abandonada ";
		play = true;
	}

	/**
	 * Gets the t collision.
	 *
	 * @return the t collision
	 */
	public TileCollision gettCollision()
	{
		return tCollision;
	}

	/**
	 * Sets the t collision.
	 *
	 * @param tCollision the new t collision
	 */
	public void settCollision(final TileCollision tCollision)
	{
		this.tCollision = tCollision;
	}

	/**
	 * Update scenne.
	 */
	@Override
	public void updateScenne()
	{
		
//		System.out.println(player.geteContainer().worldX/GameConstants.TILESIZE+" "+
//				player.geteContainer().worldY/GameConstants.TILESIZE);	
			
		if(!isTransition && play)
		{
			GameAudio.merchan.play();
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
			player.yPos = 24*GameConstants.TILESIZE-32;
			player.direction = IDirection.DOWN;
			GameAudio.merchan.stop();
			game.addScene(play);
		}
		else if(porao1.intersects(xPos,yPos,player.solidArea.getWidth(),player.solidArea.getHeight()))
		{
			for (int i = 0; i < entities.length; i++)
			{
				entities[i] = null;
			}

			final TileManager tm = new TileManager();
			tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
			tm.loadMapdata("/maps/porao1.txt");
			final HomePoraoScenne1 home = new HomePoraoScenne1( player,game, tm,entities,new TileCollision());	
			home.homeNumber = 3;
			home.start();
			player.xPos = 3*GameConstants.TILESIZE;
			player.yPos = 15*GameConstants.TILESIZE;
			player.direction = IDirection.RIGHT;
			GameAudio.merchan.stop();
			game.addScene(home);
		}
		else if(porao2.intersects(xPos,yPos,player.solidArea.getWidth(),player.solidArea.getHeight()))
		{
			for (int i = 0; i < entities.length; i++)
			{
				entities[i] = null;
			}
			
			final TileManager tm = new TileManager();
			tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
			tm.loadMapdata("/maps/porao2.txt");
			final HomePoraoScenne2 home = new HomePoraoScenne2( player,game, tm,entities,new TileCollision());	
			home.homeNumber = 3;
			home.start();
			player.xPos = 17*GameConstants.TILESIZE;
			player.yPos = 15*GameConstants.TILESIZE;
			player.direction = IDirection.RIGHT;
			GameAudio.merchan.stop();
			game.addScene(home);
		}
	}

	/**
	 * Draw scenne.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	@Override
	public void drawScenne(final Graphics2D graphics2d)
	{
//		graphics2d.setColor(Color.RED);
//		graphics2d.drawRect(
//				rect.x - player.xPos + AbstractPlayer.SCREEN_X,
//				rect.y - player.yPos + AbstractPlayer.SCREEN_Y,
//				rect.width, 
//				rect.height);
//		
//		graphics2d.drawRect(
//				porao1.x - player.xPos + AbstractPlayer.SCREEN_X,
//				porao1.y - player.yPos + AbstractPlayer.SCREEN_Y,
//				porao1.width, 
//				porao1.height);
//		
//		graphics2d.drawRect(
//				porao2.x - player.xPos + AbstractPlayer.SCREEN_X,
//				porao2.y - player.yPos + AbstractPlayer.SCREEN_Y,
//				porao2.width, 
//				porao2.height);
	}
}