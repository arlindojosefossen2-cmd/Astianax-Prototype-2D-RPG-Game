package br.com.astianax.scenes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import br.com.ajf.game.animation.IAnimationManager;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.util.GameRect;
import br.com.astianax.audio.GameAudio;
import br.com.astianax.collision.TileCollision;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.enemie.EnemieCyclop;
import br.com.astianax.enemie.EnemieDemon;
import br.com.astianax.enemie.EnemieFrankenstein;
import br.com.astianax.gameobject.AbstractGameObject;
import br.com.astianax.npc.BigJoeNpc;
import br.com.astianax.npc.LitlleBoyNpc;
import br.com.astianax.npc.LitlleGirlNpc;
import br.com.astianax.npc.LuceNpc;
import br.com.astianax.npc.OldManNpc;
import br.com.astianax.npc.OldWomanNpc;
import br.com.astianax.object.DoubleAxesObject;
import br.com.astianax.object.GoldenChestObject;
import br.com.astianax.object.HamerObject;
import br.com.astianax.object.HeartObject;
import br.com.astianax.object.ManaObject;
import br.com.astianax.object.SimpleAxesObject;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.player.PlayerAdelle;
import br.com.astianax.player.PlayerAstianax;
import br.com.astianax.player.PlayerElliot;
import br.com.astianax.tile.TileManager;


/**
 * 
 * Author A.J.F.
 * @version 1.0
 * 25 June 2025
 */
public final class IslandScenne extends AbstractScenne
{
	/** The rect. */
	private final GameRect rect = new GameRect(14*GameConstants.TILESIZE+16, 7*GameConstants.TILESIZE-32, 32,32);
	
	/** The rect 2. */
	private final GameRect rect2 = new GameRect(26*GameConstants.TILESIZE+16, 12*GameConstants.TILESIZE-32, 32,32);
	
	/** The rect 3. */
	private final GameRect rect3 = new GameRect(18*GameConstants.TILESIZE+16, 29*GameConstants.TILESIZE-32, 32,32);
	
	/** The rect 4. */
	private final GameRect rect4 = new GameRect(37*GameConstants.TILESIZE+16, 24*GameConstants.TILESIZE-32, 32,32);
	
	/** The city 1. */
	private final GameRect city1 = new GameRect(27*GameConstants.TILESIZE+32, 18*GameConstants.TILESIZE+16, 128,96);
	
	/** The city 2. */
	private final GameRect city2 = new GameRect(36*GameConstants.TILESIZE+32, 38*GameConstants.TILESIZE+16, 128,96);
	
	/** The temple */
	private final GameRect temple = new GameRect(37*GameConstants.TILESIZE, 11*GameConstants.TILESIZE-20, 64,18);
	
	/** The scene. */
	private AbstractScenne scene;
	
	private BufferedImage mask = IAnimationManager.LOADER.getScaledImage("/objects/templemask.png", 4);
	
	/**
	 * Instantiates a new play state.
	 *
	 * @param game the game
	 * @param selectedPlayer the selected player
	 * @param numOfEntities the num of entities
	 */
	public IslandScenne(final Game game,int selectedPlayer,final int numOfEntities)
	{
		super(game,numOfEntities);
		
		switch(selectedPlayer)
		{
			case 0:
				player = new PlayerElliot(7*GameConstants.TILESIZE,
						9*GameConstants.TILESIZE, 3);
				break;
			case 1:
				player = new PlayerAdelle(7*GameConstants.TILESIZE,
						9*GameConstants.TILESIZE, 3);
				break;
			case 2:
				player = new PlayerAstianax(7*GameConstants.TILESIZE,
						9*GameConstants.TILESIZE, 3);
				break;
				
		}
	}

	/**
	 * Instantiates a new island scenne.
	 *
	 * @param player the player
	 * @param game the game
	 * @param tmanager the tmanager
	 * @param entities the entities
	 * @param tCollision the t collision
	 */
	public IslandScenne(final AbstractPlayer player,final Game game,final TileManager tmanager,final AbstractGameObject[] entities,
			final TileCollision tCollision)
	{
		super(player, game, tmanager, entities, tCollision);
	}

	private void genarateAbstractGameObjectsByPlayer(AbstractPlayer player)
	{
		if(player instanceof PlayerElliot)
		{
			//objects test
			gameobjects[0] = new HeartObject(10*GameConstants.TILESIZE, 
					10*GameConstants.TILESIZE);
			gameobjects[1] = new SimpleAxesObject(10*GameConstants.TILESIZE, 
					11*GameConstants.TILESIZE);
			gameobjects[2] = new ManaObject(9*GameConstants.TILESIZE, 
					9*GameConstants.TILESIZE);		
			gameobjects[3] = new GoldenChestObject(7*GameConstants.TILESIZE, 
					13*GameConstants.TILESIZE);		
			
			//entities test
			entities[0] = new OldManNpc(this,11*GameConstants.TILESIZE, 
					11*GameConstants.TILESIZE,1);
			entities[1] = new OldWomanNpc(this,6*GameConstants.TILESIZE, 
					12*GameConstants.TILESIZE,1);
			entities[2] = new LitlleBoyNpc(this,6*GameConstants.TILESIZE, 
					11*GameConstants.TILESIZE,1);
			entities[3] = new LitlleGirlNpc(this,6*GameConstants.TILESIZE, 
					10*GameConstants.TILESIZE,1);
			entities[4] = new LuceNpc(this,7*GameConstants.TILESIZE, 
					7*GameConstants.TILESIZE,1);
			entities[5] = new BigJoeNpc(this,9*GameConstants.TILESIZE, 
					8*GameConstants.TILESIZE,1);
			
			//enemies
			enemies[0] = new EnemieCyclop(this,19*GameConstants.TILESIZE, 
					12*GameConstants.TILESIZE,1,player);
		}
		else if(player instanceof PlayerAdelle)
		{
			//objects test
			gameobjects[0] = new HeartObject(10*GameConstants.TILESIZE, 
					10*GameConstants.TILESIZE);
			gameobjects[1] = new HamerObject(10*GameConstants.TILESIZE, 
					11*GameConstants.TILESIZE);
			gameobjects[2] = new ManaObject(9*GameConstants.TILESIZE, 
					9*GameConstants.TILESIZE);		
			gameobjects[3] = new GoldenChestObject(7*GameConstants.TILESIZE, 
					13*GameConstants.TILESIZE);		
			
			//entities test
			entities[0] = new OldManNpc(this,11*GameConstants.TILESIZE, 
					11*GameConstants.TILESIZE,1);
			entities[1] = new OldWomanNpc(this,6*GameConstants.TILESIZE, 
					12*GameConstants.TILESIZE,1);
			entities[2] = new LitlleBoyNpc(this,6*GameConstants.TILESIZE, 
					11*GameConstants.TILESIZE,1);
			entities[3] = new LitlleGirlNpc(this,6*GameConstants.TILESIZE, 
					10*GameConstants.TILESIZE,1);
			entities[4] = new LuceNpc(this,7*GameConstants.TILESIZE, 
					7*GameConstants.TILESIZE,1);
			entities[5] = new BigJoeNpc(this,9*GameConstants.TILESIZE, 
					8*GameConstants.TILESIZE,1);
			
			//enemies
			enemies[0] = new EnemieDemon(this,19*GameConstants.TILESIZE, 
					12*GameConstants.TILESIZE,1,player);
		}
		else if(player instanceof PlayerAstianax)
		{
			//objects test
			gameobjects[0] = new HeartObject(10*GameConstants.TILESIZE, 
					10*GameConstants.TILESIZE);
			gameobjects[1] = new DoubleAxesObject(10*GameConstants.TILESIZE, 
					11*GameConstants.TILESIZE);
			gameobjects[2] = new ManaObject(9*GameConstants.TILESIZE, 
					9*GameConstants.TILESIZE);		
			gameobjects[3] = new GoldenChestObject(7*GameConstants.TILESIZE, 
					13*GameConstants.TILESIZE);		
			
			//entities test
			entities[0] = new OldManNpc(this,11*GameConstants.TILESIZE, 
					11*GameConstants.TILESIZE,1);
			entities[1] = new OldWomanNpc(this,6*GameConstants.TILESIZE, 
					12*GameConstants.TILESIZE,1);
			entities[2] = new LitlleBoyNpc(this,6*GameConstants.TILESIZE, 
					11*GameConstants.TILESIZE,1);
			entities[3] = new LitlleGirlNpc(this,6*GameConstants.TILESIZE, 
					10*GameConstants.TILESIZE,1);
			entities[4] = new LuceNpc(this,7*GameConstants.TILESIZE, 
					7*GameConstants.TILESIZE,1);
			entities[5] = new BigJoeNpc(this,9*GameConstants.TILESIZE, 
					8*GameConstants.TILESIZE,1);
			
			//enemies
			enemies[0] = new EnemieFrankenstein(this,19*GameConstants.TILESIZE, 
					12*GameConstants.TILESIZE,1,player);
		}
	}
	
	/**
	 * Start.
	 */
	@Override
	public void start()
	{	
		tmanager = new TileManager();
		//45 true //false
		tmanager.loadImages("/data/testtiles.txt",GameConstants.TILESIZE);
		tmanager.loadMapdata("/maps/worldtest.txt");
		tCollision = new TileCollision();
		genarateAbstractGameObjectsByPlayer(player);
		player.inHome = false;
		super.start();
		text = " Island Of Crotona ";
		play = true;
	}

	/**
	 * Update scenne.
	 */
	@Override
	public void updateScenne()
	{
		if((!isTransition && play))
		{
			GameAudio.tension.play();
			play = false;
		}
		//debug
//		if(GameInputContainer.keys[KeyEvent.VK_G])
//		{
//			System.out.println(" xRow: "+player.xPos/GameConstants.TILESIZE+" yCol: "+player.yPos/GameConstants.TILESIZE);
//		}
		
		if(player != null)
		{
			
			int xPos = player.xPos+player.solidArea.getX();
			int yPos = player.yPos + player.solidArea.getY();
			
			if(rect.intersects(xPos, yPos, player.solidArea.getWidth(), player.solidArea.getHeight()))
			{
				for (int i = 0; i < entities.length; i++)
				{
					entities[i] = null;
				}
			
				final TileManager tm = new TileManager();
				tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
				tm.loadMapdata("/maps/home.txt");
				
				scene = new HomeScenne1( player,game, tm,entities,new TileCollision());			
				scene.start();
				GameAudio.tension.stop();
				game.addScene(scene);
			
			}
			else if(rect2.intersects(xPos, yPos, player.solidArea.getWidth(), player.solidArea.getHeight()))
			{
				for (int i = 0; i < entities.length; i++)
				{
					entities[i] = null;
				}
				
				final TileManager tm = new TileManager();
				tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
				tm.loadMapdata("/maps/home.txt");
				scene = new HomeScenne2( player,game, tm,entities,new TileCollision());	
				scene.start();
				GameAudio.tension.stop();
				game.addScene(scene);
			
			}
			else if(rect3.intersects(xPos, yPos, player.solidArea.getWidth(), player.solidArea.getHeight()))
			{
				for (int i = 0; i < entities.length; i++)
				{
					entities[i] = null;
				}
								
				final TileManager tm = new TileManager();
				tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
				tm.loadMapdata("/maps/home.txt");
				scene = new HomeScenne3( player,game, tm,entities,new TileCollision());	
				scene.start();
				GameAudio.tension.stop();
				game.addScene(scene);
			
			}
			else if(rect4.intersects(xPos, yPos, player.solidArea.getWidth(), player.solidArea.getHeight()))
			{
				for (int i = 0; i < entities.length; i++)
				{
					entities[i] = null;
				}			
				
				final TileManager tm = new TileManager();
				tm.loadImages("/data/interior.txt",GameConstants.TILESIZE);
				tm.loadMapdata("/maps/home.txt");
				scene = new HomeScenne4( player,game, tm,entities,new TileCollision());	
				scene.start();
				GameAudio.tension.stop();
				game.addScene(scene);
			
			}
			else if(city1.intersects(xPos, yPos, player.solidArea.getWidth(), player.solidArea.getHeight()))
			{
				for (int i = 0; i < entities.length; i++)
				{
					entities[i] = null;
				}			
				
				final TileManager tm = new TileManager();
				tm.loadImages("/data/city1.txt",GameConstants.TILESIZE);
				tm.loadMapdata("/maps/city1.txt");
				scene = new City1Scenne(player,game, tm,entities,new TileCollision());	
				scene.start();
				GameAudio.tension.stop();
				game.addScene(scene);
			
			}
			else if(city2.intersects(xPos, yPos, player.solidArea.getWidth(), player.solidArea.getHeight()))
			{
				for (int i = 0; i < entities.length; i++)
				{
					entities[i] = null;
				}			
				
				final TileManager tm = new TileManager();
				tm.loadImages("/data/city1.txt",GameConstants.TILESIZE);
				tm.loadMapdata("/maps/city1.txt");
				scene = new City2Scenne( player,game, tm,entities,new TileCollision());	
				scene.start();
				GameAudio.tension.stop();
				game.addScene(scene);
			
			}
			
			else if(temple.intersects(xPos, yPos, player.solidArea.getWidth(), player.solidArea.getHeight()))
			{
				for (int i = 0; i < entities.length; i++)
				{
					entities[i] = null;
				}			
				
				final TileManager tm = new TileManager();
				tm.loadImages("/data/templedata.txt",GameConstants.TILESIZE);
				tm.loadMapdata("/maps/temple.txt");
				scene = new TempleScenne(player,game, tm,entities,new TileCollision());	
				scene.start();
				GameAudio.tension.stop();
				game.addScene(scene);
			
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
		if(player != null)
		{
//			graphics2d.setColor(Color.RED);
//			graphics2d.drawRect(
//					rect.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//					rect.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//					rect.getWidth(), 
//					rect.getHeight());	
//			graphics2d.drawRect(
//					rect2.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//					rect2.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//					rect2.getWidth(), 
//					rect2.getHeight());	
//			
//			graphics2d.drawRect(
//					rect3.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//					rect3.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//					rect3.getWidth(), 
//					rect3.getHeight());	
//			graphics2d.drawRect(
//					rect4.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//					rect4.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//					rect4.getWidth(), 
//					rect4.getHeight());	
//			graphics2d.drawRect(
//					city1.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//					city1.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//					city1.getWidth(), 
//					city1.getHeight());	
//			graphics2d.drawRect(
//					city2.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//					city2.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//					city2.getWidth(), 
//					city2.getHeight());	
//			graphics2d.drawRect(
//					temple.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//					temple.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//					temple.getWidth(), 
//					temple.getHeight());	
			
			graphics2d.drawImage(mask, temple.getX() - player.xPos + AbstractPlayer.SCREEN_X,
					temple.getY() - 27 - player.yPos + AbstractPlayer.SCREEN_Y, null);

		}
	}
}