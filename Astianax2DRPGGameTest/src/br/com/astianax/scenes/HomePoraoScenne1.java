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
 * The Class HomePoraoScenne1.
 */
public final class HomePoraoScenne1 extends AbstractScenne
{
	
	/** The rect. */
	private final Rectangle rect = new Rectangle(2*GameConstants.TILESIZE, 16*GameConstants.TILESIZE, 64, 64);
	
	/** The home number. */
	public int homeNumber = 0;
	
	/**
	 * Instantiates a new home porao scenne 1.
	 *
	 * @param player the player
	 * @param game the game
	 * @param tmanager the tmanager
	 * @param entities the entities
	 * @param tCollision the t collision
	 */
	public HomePoraoScenne1(final AbstractPlayer player,final Game game,final TileManager tmanager,final AbstractGameObject[] entities,
			final TileCollision tCollision)
	{
		super(player, game, tmanager, entities, tCollision);
	}

	/**
	 * Start.
	 */
	public void start()
	{
		GameAudio.dungeon.play();
		super.start();
//		tManager.loadImages("/data/tiles.txt",64);
//		tManager.loadMapdata("/maps/map2.txt");
		
		player.xPos = 11*GameConstants.TILESIZE;
		player.yPos = 17*GameConstants.TILESIZE;
		player.direction = IDirection.UP;
		player.inHome = true;
		
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
	public void settCollision(TileCollision tCollision)
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

//		player.geteContainer().worldY/GameConstants.TILESIZE);	

		if(!isTransition && play)
		{
			GameAudio.dungeon.play();
			play = false;
		}
	
		final int xPos = player.xPos+player.solidArea.getX();
		final int yPos = player.yPos + player.solidArea.getY();
		
			if(rect.intersects(xPos,yPos,player.solidArea.getWidth(),player.solidArea.getHeight()))
			{
			
				if(homeNumber == 0)
				{
					for (int i = 0; i < entities.length; i++)
					{
						entities[i] = null;
					}
					
					final TileManager tm = new TileManager();
					tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
					tm.loadMapdata("/maps/home.txt");
					final HomeScenne1 home = new HomeScenne1( player,game, tm,entities,new TileCollision());	
					home.start();
					player.xPos = 3*GameConstants.TILESIZE;
					player.yPos = 15*GameConstants.TILESIZE;
					player.direction = IDirection.RIGHT;
					GameAudio.dungeon.stop();
					game.addScene(home);
				}
				else if(homeNumber == 1)
				{
					for (int i = 0; i < entities.length; i++)
					{
						entities[i] = null;
					}
					
					final TileManager tm = new TileManager();
					tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
					tm.loadMapdata("/maps/home.txt");
					final HomeScenne2 home = new HomeScenne2( player,game, tm,entities,new TileCollision());	
					home.start();
					player.xPos = 3*GameConstants.TILESIZE;
					player.yPos = 15*GameConstants.TILESIZE;
					player.direction = IDirection.RIGHT;
					GameAudio.dungeon.stop();
					game.addScene(home);
				}
				else if(homeNumber == 2)
				{
					for (int i = 0; i < entities.length; i++)
					{
						entities[i] = null;
					}
					
					final TileManager tm = new TileManager();
					tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
					tm.loadMapdata("/maps/home.txt");
					final HomeScenne3 home = new HomeScenne3( player,game, tm,entities,new TileCollision());	
					
					home.start();
					player.xPos = 3*GameConstants.TILESIZE;
					player.yPos = 15*GameConstants.TILESIZE;
					player.direction = IDirection.RIGHT;
					GameAudio.dungeon.stop();
					game.addScene(home);
				}
				else if(homeNumber == 3)
				{
					for (int i = 0; i < entities.length; i++)
					{
						entities[i] = null;
					}
					
					final TileManager tm = new TileManager();
					tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
					tm.loadMapdata("/maps/home.txt");
					final HomeScenne4 home = new HomeScenne4( player,game, tm,entities,new TileCollision());	
					
					home.start();
					player.xPos = 3*GameConstants.TILESIZE;
					player.yPos = 15*GameConstants.TILESIZE;
					player.direction = IDirection.RIGHT;
					GameAudio.dungeon.stop();
					game.addScene(home);
				}
				
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
	}
}