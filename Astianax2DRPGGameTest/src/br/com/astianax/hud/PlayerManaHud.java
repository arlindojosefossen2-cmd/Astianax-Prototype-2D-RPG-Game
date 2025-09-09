package br.com.astianax.hud;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import br.com.ajf.game.util.ImageLoader;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.player.AbstractPlayer;

public final class PlayerManaHud
{
	private BufferedImage image[] = new BufferedImage[2];	

	private AbstractPlayer player;
	/**
	 * 
	 * @param paths
	 * @param player
	 */
	public PlayerManaHud(String paths[],AbstractPlayer player)
	{
		ImageLoader loader = new ImageLoader();
		image[0] = loader.getScaledImage(paths[0],2);
		image[1] = loader.getScaledImage(paths[1],2);
		this.player = player;
	}

	/**
	 * 
	 * @param g2d
	 */
	public void draw(Graphics2D g2d)
	{
        int x = (GameConstants.TILESIZE / 2) - 5;
        int y = (int) (GameConstants.TILESIZE * 1.5)+10;

        for (int i = 0; i < player.maxMana; i++) {
            g2d.drawImage(image[1], x, y, null);
            x += 49;
        }

        x = (GameConstants.TILESIZE / 2) - 5;
        y = (int) (GameConstants.TILESIZE * 1.5)+10;

        for (int i = 0; i < player.mana; i++) {
            g2d.drawImage(image[0], x, y, null);
            x += 49;
        }
   	 g2d.setColor(Color.DARK_GRAY);
     g2d.setFont(g2d.getFont().deriveFont(18f));
     g2d.drawString("Mana: ", GameConstants.TILESIZE/2-16,  2*GameConstants.TILESIZE-32);

	}
}