package br.com.astianax.scenes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.ajf.game.animation.Animation;
import br.com.ajf.game.animation.IAnimation;
import br.com.ajf.game.audio.wav.IAudio;
import br.com.ajf.game.audio.wav.Music;
import br.com.ajf.game.button.GameButton;
import br.com.ajf.game.button.IGameButton;
import br.com.ajf.game.input.container.GameInputContainer;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.scene.Scene;
import br.com.astianax.collision.CheckeMonsterAttackCollision;
import br.com.astianax.collision.CheckePlayerCollision;
import br.com.astianax.collision.EntityCollision;
import br.com.astianax.collision.GameObjectCollision;
import br.com.astianax.collision.TileCollision;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.AbstractGameObject;
import br.com.astianax.gameobject.AbstractGameObjectComparator;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.tile.TileManager;

/**
 * The Class AbstractScenne.
 */
public abstract class AbstractScenne implements Scene
{
	
	/** The player. */
	public AbstractPlayer player;
	
	protected String text = "";
	
	/** The game. */
	protected Game game;
	
	/** The tmanager. */
	public TileManager tmanager;
	
	/** The entities. */
	public AbstractGameObject[] entities = new AbstractGameObject[20];
	
	/** The gameobjects. */
	public AbstractGameObject[] gameobjects = new AbstractGameObject[20];
	
	/** The enemies. */
	public AbstractGameObject[] enemies = new AbstractGameObject[20];
	
	/** The all elements. */
	protected List<AbstractGameObject> allElements = new ArrayList<AbstractGameObject>();
	
	/** The compare. */
	protected Comparator<AbstractGameObject> compare = new AbstractGameObjectComparator();
	
	/** The t collision. */
	public TileCollision tCollision;
	
	/** The e collision. */
	public GameObjectCollision eCollision = new GameObjectCollision();
	
	/** The entity collision. */
	public EntityCollision entityCollision = new EntityCollision();
	
	/** The c player collision. */
	public CheckePlayerCollision cPlayerCollision = new CheckePlayerCollision();
	
	public CheckeMonsterAttackCollision monCollision = new CheckeMonsterAttackCollision();
	
	/** The transition. */
	protected static IAnimation transition = new Animation("/images/transition.png", 7, 6, GameConstants.SCREEN_WIDHT,GameConstants.SCREEN_HEIGTH,8f);
	
	/** The is transition. */
	protected static boolean isTransition = true;
	
	/** The transition music. */
	protected static IAudio transitionMusic = new Music("/musics/stairs.wav");
	
	/** The paused. */
	public boolean paused;
	
	protected boolean restartGame;
	
	/** The play. */
	protected boolean play;
	
	/** The restart. */
	private IGameButton restart;

	/**
	 * Instantiates a new play state.
	 *
	 * @param game the game
	 * @param numOfEntities the num of entities
	 */
	public AbstractScenne(final Game game,final int numOfEntities)
	{
		this.game = game;
		entities = new AbstractGameObject[numOfEntities];
	}
	

	/**
	 * Instantiates a new abstract scenne.
	 *
	 * @param player the player
	 * @param game the game
	 * @param tmanager the tmanager
	 * @param entities the entities
	 * @param tCollision the t collision
	 */
	public AbstractScenne(final AbstractPlayer player,final Game game,final TileManager tmanager,final AbstractGameObject[] entities,
			final TileCollision tCollision)
	{
		this.game = game;
		this.tmanager = tmanager;
		this.entities = entities;
		this.tCollision = tCollision;
		this.player = player;	
	}
	
	/**
	 * Start.
	 */
	@Override
	public void start()
	{	
		 restart = new GameButton(" Restart ",
				GameConstants.TILESIZE*4,GameConstants.TILESIZE*7,
				GameConstants.TILESIZE,
				GameConstants.TILESIZE/2, 
				16f, 
				() ->
		{
			final Scene scene = new SelectPlayerScene(game);
			scene.start();
			this.game.addScene(scene);
		}
				);
		
		for(AbstractGameObject entity : entities)
		{
			if(entity != null)
			{
				entity.start();
				entity.setScene(this);
			}
		}
		
		for(AbstractGameObject obj : gameobjects)
		{
			if(obj != null)
			{
				obj.start();
			}
		}
		
		for(AbstractGameObject enemie : enemies)
		{
			if(enemie != null)
			{
				enemie.start();
			}
		}
		
		player.start();
		player.setScene(this);
		
		isTransition = true;
		transitionMusic.setVolume(5);
		transitionMusic.play();
	}

	/**
	 * Update.
	 */
	@Override
	public void update()
	{
		if(isTransition)
		{
			transition.update();
			
			if(transition.isFinished())
			{
				isTransition = false;
				transition.reset();
				transitionMusic.stop();
			}
		}
		
		if(GameInputContainer.keyTyped[KeyEvent.VK_P])
		{
			GameInputContainer.keyTyped[KeyEvent.VK_P] = false;
			paused = !paused;
		}	
		
		if(GameInputContainer.keyTyped[KeyEvent.VK_I])
		{
			GameInputContainer.keyTyped[KeyEvent.VK_I] = false;
			player.isInventory = !player.isInventory;
		}
		
		if(paused)
		{
			
		}
	
		if((!paused))
		{
			allElements.clear();
			
			updateScenne();
			
			for(AbstractGameObject entity : entities)
			{
				if(player != null)
				{
					if((entity != null  && !player.isInventory))
					{	
							entity.update();
					}
				}
			}
			
			for(AbstractGameObject obj : gameobjects)
			{
				if(obj != null)
				{
					obj.update();
				}
			}
			
			if(player != null)
			{
				player.update();
			
				if(player.isInventory)
				{
					player.inventory.update();
				}
			}
			
			for(AbstractGameObject enemie : enemies)
			{
				if(enemie != null && player != null)
				{
					enemie.update();
				}
			}
			
			addAllElements();
			
			Collections.sort(allElements,compare);
			
		}
		
		if(player.isDead)
		{
			if(player.haveArm)
			{
				if(player.animations.isFinished(12))
				{
					player.animations.reset(12);
					player.isDead = false;
				}
			}
			else
			{	
				if(player.animations.isFinished(8))
				{
					player.animations.reset(8);
					player.isDead = false;
				}
			}
			restartGame = true;
		}
		
		if(restartGame)
		{
			restart.update();
		}
	}

	/**
	 * Adds the all elements.
	 */
	private void addAllElements()
	{
		allElements.add(player);
		
		for(AbstractGameObject entity : entities)
		{
			allElements.add(entity);
		}
		
		for(AbstractGameObject obj : gameobjects)
		{
			allElements.add(obj);
		}
		
		for(AbstractGameObject enemie : enemies)
		{
			allElements.add(enemie);
		}
	}
	
	/**
	 * Update scenne.
	 */
	public abstract void updateScenne();
	
	/**
	 * Draw scenne.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	public abstract void drawScenne(Graphics2D graphics2d);
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	@Override
	public void draw(final Graphics2D graphics2d)
	{
		
		if(player != null)
		{
			tmanager.draw(graphics2d, player);
		}
			
		for(AbstractGameObject entity : allElements)
		{
			if(entity != null && player != null)
			{
				entity.draw(graphics2d,player);
			}
		}
	
		drawScenne(graphics2d);
		
		if(player != null)
		{
			player.drawPlayerHudAndInventiry(graphics2d);
		}
		
		if((paused && !player.isInventory))
		{	
			graphics2d.setFont(graphics2d.getFont().deriveFont(48f));
			graphics2d.setColor(Color.WHITE);
			graphics2d.drawString(" PAUSED ", GameConstants.SCREEN_WIDHT/2-32-GameConstants.TILESIZE+4, GameConstants.SCREEN_HEIGTH/2+4);
		
			graphics2d.setColor(Color.BLACK);
			graphics2d.drawString(" PAUSED ", GameConstants.SCREEN_WIDHT/2-32-GameConstants.TILESIZE, GameConstants.SCREEN_HEIGTH/2);
		}	
		
		if(restartGame)
		{
			graphics2d.setColor(Color.BLUE);
			graphics2d.fillRect(0, 0, GameConstants.SCREEN_WIDHT, GameConstants.SCREEN_HEIGTH);
			
			graphics2d.setFont(graphics2d.getFont().deriveFont(64f));
			graphics2d.setColor(Color.RED);
			graphics2d.drawString(" YOU DEAD! ", GameConstants.SCREEN_WIDHT/2-(GameConstants.TILESIZE*3), GameConstants.SCREEN_HEIGTH/2);
			
			restart.draw(graphics2d);
		}
	
		if(isTransition)
		{
			transition.draw(graphics2d, 0, 0);
			
			graphics2d.setFont(graphics2d.getFont().deriveFont(32F));
			graphics2d.setColor(Color.BLACK);
			graphics2d.drawString(text, 6*GameConstants.TILESIZE+3, 5*GameConstants.TILESIZE+3);
			graphics2d.setColor(Color.WHITE);
			graphics2d.drawString(text, 6*GameConstants.TILESIZE, 5*GameConstants.TILESIZE);
		}
	}	
}