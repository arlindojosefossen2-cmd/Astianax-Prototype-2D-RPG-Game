package br.com.astianax.main;

import br.com.ajf.game.model.Game;
import br.com.ajf.game.thread.IGameThreadManager;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.scenes.MenuScenne;

/**
 * 
 * Author A.J.F.
 * @version 1.0
 * 25 June 2025
 */
public class Launcher
{	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{	
		Game game = new Game("Astianax",GameConstants.SCREEN_WIDHT,GameConstants.SCREEN_HEIGTH,IGameThreadManager.GAME_THREAD_TIMER_TASK);
		game.setIcon("/icon/statue.png");
		MenuScenne menu = new MenuScenne(game);
		menu.start();
		game.addScene(menu);
		game.init(IGameThreadManager.GAME_THREAD_TIMER_TASK);
	}
}