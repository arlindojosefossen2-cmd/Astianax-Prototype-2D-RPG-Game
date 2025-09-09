package br.com.astianax.hud;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import br.com.ajf.game.animation.IAnimationManager;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.player.AbstractPlayer;

public final class PlayerLifeHud
{
	private BufferedImage[] images = new BufferedImage[3];
	private AbstractPlayer player;
	
	public PlayerLifeHud(String[] paths, AbstractPlayer player)
	{
		this.images[0] = IAnimationManager.LOADER.getScaledImage(paths[0], 1.8f);
		this.images[1] =  IAnimationManager.LOADER.getScaledImage(paths[1], 1.8f);
		this.images[2] =  IAnimationManager.LOADER.getScaledImage(paths[2], 1.8f);	
		this.player = player;
	}
	
	public void draw(Graphics2D g2d)
	{
        int x = GameConstants.TILESIZE / 2;
        int y = GameConstants.TILESIZE / 3;
 
        for (int i = 0; i < player.maxLife / 2; i++) 
        {
            g2d.drawImage(this.images[2], x, y, null);
            x += GameConstants.TILESIZE ;
        }

        x = GameConstants.TILESIZE / 2;
        y = GameConstants.TILESIZE / 3;

        for (int i = 0; i < player.life; i++) 
        {
            g2d.drawImage(this.images[1] , x, y, null);
            i++;

            if (i < player.life) 
            {
                g2d.drawImage(this.images[0], x, y, null);
            }

            x += GameConstants.TILESIZE;
        }
        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(g2d.getFont().deriveFont(18f));
        g2d.drawString("LIFE: ", GameConstants.TILESIZE/2-16, GameConstants.TILESIZE/3); 
	}
}