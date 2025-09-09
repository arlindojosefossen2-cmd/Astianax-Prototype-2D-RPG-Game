package br.com.astianax.gameobject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import br.com.astianax.player.AbstractPlayer;

public abstract class GameObject extends AbstractGameObject
{
	public BufferedImage image;
	public boolean isConsumivel;
	
	public GameObject(String name, int yPos, int xPos)
	{
		super(name, yPos, xPos);
	}
	
	@Override
	public void draw(Graphics2D arg0, AbstractPlayer player)
	{
		this.animations.draw(arg0, xPos - player.xPos + AbstractPlayer.SCREEN_X,
				yPos - player.yPos + AbstractPlayer.SCREEN_Y);
		//debug
//		arg0.setColor(Color.red);
//		arg0.drawRect(xPos+solidArea.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//			yPos+solidArea.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//			solidArea.getWidth(),solidArea.getHeight());
				
	}
	@Override
	public void update()
	{
		this.animations.update();
	}
}