package br.com.astianax.scenes;

import java.awt.Color;
import java.awt.Graphics2D;

import br.com.ajf.game.animation.Animation;
import br.com.ajf.game.button.IGameButton;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.scene.Scene;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.utils.AnimeButton;

/**
 * The Class SelectPlayerScene.
 */
public final class SelectPlayerScene implements Scene
{
	
	/** The elliot button. */
	private IGameButton elliotButton;
	
	/** The adelle button. */
	private IGameButton adelleButton;
	
	/** The astianax button. */
	private IGameButton astianaxButton;
	
	/** The island. */
	private Scene island;
	
	/** The game. */
	private final Game game;
	
	/**
	 * Instantiates a new select player scene.
	 *
	 * @param game the game
	 */
	public SelectPlayerScene(final Game game)
	{
		this.game = game;
	}
	
	/**
	 * Start.
	 */
	@Override
	public void start()
	{
		
		elliotButton = new AnimeButton(new Animation("/player/anime/elliot/idledown.png",
				2, 12,GameConstants.TILESIZE+32 , 1),
				4*GameConstants.TILESIZE, 4*GameConstants.TILESIZE, 96, 96, () ->
		{
			island = new IslandScenne(game,0,20);
			island.start();
			
			game.addScene(island);
		});
		
		adelleButton = new AnimeButton(new Animation("/player/anime/adelle/idledown.png",
				2, 12,GameConstants.TILESIZE+32 , 1),
				7*GameConstants.TILESIZE, 4*GameConstants.TILESIZE, 96, 96, () ->
				{
					island = new IslandScenne(game,1,20);
					island.start();
				
					game.addScene(island);
				});
		
		astianaxButton = new AnimeButton(new Animation("/player/anime/astianax/idledownaxes.png",
				2, 12,GameConstants.TILESIZE+32 , 1),
				10*GameConstants.TILESIZE, 4*GameConstants.TILESIZE, 96, 96, () ->
				{
					island = new IslandScenne(game,2,20);
					island.start();
				
					game.addScene(island);
				});
	}

	/**
	 * Update.
	 */
	@Override
	public void update()
	{
		elliotButton.update();
		adelleButton.update();
		astianaxButton.update();
	}

	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	@Override
	public void draw(final Graphics2D graphics2d)
	{
		graphics2d.setColor(Color.GREEN);
		graphics2d.fillRect(0, 0, GameConstants.SCREEN_WIDHT,GameConstants.SCREEN_HEIGTH);
		
		elliotButton.draw(graphics2d);
		adelleButton.draw(graphics2d);
		astianaxButton.draw(graphics2d);
		
		graphics2d.setColor(Color.BLACK);
		graphics2d.setFont(graphics2d.getFont().deriveFont(32F));
		graphics2d.drawString(" Player Select ", 6*GameConstants.TILESIZE,2*GameConstants.TILESIZE);
	
	}
}