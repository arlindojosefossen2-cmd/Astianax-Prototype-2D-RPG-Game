package br.com.astianax.scenes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import br.com.ajf.game.animation.IAnimationManager;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.moviment.IDirection;
import br.com.ajf.game.util.GameRect;
import br.com.astianax.audio.GameAudio;
import br.com.astianax.collision.TileCollision;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.AbstractGameObject;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.tile.TileManager;

public final class TempleScenne extends AbstractScenne
{
	private BufferedImage mask = IAnimationManager.LOADER.getScaledImage("/objects/masktemple.png", 4);
	private GameRect templemask1 = new GameRect(20*GameConstants.TILESIZE,34*GameConstants.TILESIZE-37,64,64);
	private GameRect templemask2 = new GameRect(21*GameConstants.TILESIZE,18*GameConstants.TILESIZE-37,64,64);
	
	/** The rect. */
	private final GameRect rect = new GameRect(21*GameConstants.TILESIZE, 36*GameConstants.TILESIZE, 64,32);
	
	
	public TempleScenne(AbstractPlayer player, Game game, TileManager tmanager, AbstractGameObject[] entities,
			TileCollision tCollision)
	{
		super(player, game, tmanager, entities, tCollision);
	}
	
	@Override
	public void start()
	{
		super.start();
		
		player.xPos = 21*GameConstants.TILESIZE;
		player.yPos = 32*GameConstants.TILESIZE;
		player.inHome = false;
		player.direction = IDirection.UP;
		text = " Temple of ( D... ) ";
		play = true;
	}

	@Override
	public void updateScenne()
	{
		//debug
//		if(GameInputContainer.keys[KeyEvent.VK_G])
//		{
//			System.out.println(" xRow: "+player.xPos/GameConstants.TILESIZE+" yCol: "+player.yPos/GameConstants.TILESIZE);
//		}
		
		if((!isTransition && play))
		{
			GameAudio.tension.play();
			play = false;
		}
		
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
			
				final TileManager tmanager = new TileManager();
				tmanager.loadImages("/data/testtiles.txt",GameConstants.TILESIZE);
				tmanager.loadMapdata("/maps/worldtest.txt");
				final TileCollision tCollision = new TileCollision();
			
				final IslandScenne play = new IslandScenne(player, game, tmanager, entities, tCollision);
			
				play.start();
				player.xPos = 37*GameConstants.TILESIZE-16;
				player.yPos = 13*GameConstants.TILESIZE-32;
				player.direction = IDirection.DOWN;
				GameAudio.tension.stop();
				game.addScene(play);
			}
		}
	}

	@Override
	public void drawScenne(Graphics2D graphics2d)
	{
		graphics2d.drawImage(mask, templemask1.getX() - player.xPos + AbstractPlayer.SCREEN_X,
				templemask1.getY() - 27 - player.yPos + AbstractPlayer.SCREEN_Y, null);
		
		graphics2d.drawImage(mask, templemask2.getX() - player.xPos + AbstractPlayer.SCREEN_X,
				templemask2.getY() - 27 - player.yPos + AbstractPlayer.SCREEN_Y, null);
		//debug
//		graphics2d.setColor(Color.red);
//		graphics2d.drawRect(rect.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//				rect.getY() - 27 - player.yPos + AbstractPlayer.SCREEN_Y, rect.getWidth(),
//				rect.getHeight());
	}
}