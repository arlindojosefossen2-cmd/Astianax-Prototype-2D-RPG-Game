package br.com.astianax.scenes;

import java.awt.Graphics2D;

import br.com.ajf.game.animation.Animation;
import br.com.ajf.game.animation.IAnimation;
import br.com.ajf.game.button.GameButton;
import br.com.ajf.game.button.IGameButton;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.scene.Scene;
import br.com.astianax.audio.GameAudio;
import br.com.astianax.constants.GameConstants;


/**
 * 
 * Autor A.J.F.
 * @version 1.0
 * 25 de jun. de 2025
 */
public final class MenuScenne implements Scene
{	

	final IAnimation logo = new Animation("/images/logoanime.png",2,30,GameConstants.SCREEN_WIDHT,
			GameConstants.SCREEN_HEIGTH,8f);
	/** The start. */
	private IGameButton startButton ;
	
	/** The game. */
	private final Game game;
	
	/**
	 * Instantiates a new menu state.
	 *
	 * @param game the game
	 */
	public MenuScenne(final Game game)
	{
		this.game = game;
	}

	/**
	 * Draw.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void draw(final Graphics2D arg0)
	{
		logo.draw(arg0, 0, 0);
		
		startButton.draw(arg0);
		
	}

	/**
	 * Start.
	 */
	@Override
	public void start()
	{
		startButton = new GameButton("START", GameConstants.SCREEN_WIDHT/4,
				GameConstants.SCREEN_HEIGTH/2+GameConstants.TILESIZE, 60, 30, 16, () -> {
			
				GameAudio.surf.stop();
				Scene play = new SelectPlayerScene(game);
				play.start();
				this.game.addScene(play);
		});
		GameAudio.surf.play();
	}

	/**
	 * Update.
	 */
	@Override
	public void update()
	{
		logo.update();
		startButton.update();
	
	}
}