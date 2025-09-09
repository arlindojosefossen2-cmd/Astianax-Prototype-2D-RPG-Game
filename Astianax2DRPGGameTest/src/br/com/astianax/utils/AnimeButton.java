package br.com.astianax.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import br.com.ajf.game.animation.IAnimation;
import br.com.ajf.game.button.IButtonClicked;
import br.com.ajf.game.button.IGameButton;
import br.com.ajf.game.input.container.GameMouseContainer;
import br.com.ajf.game.util.GameRect;

/**
 * The Class AnimeButton.
 */
public final class AnimeButton implements IGameButton
{
	/** The rect. */
	private GameRect rect ;

	/** The mousein. */
	private boolean mousein;
	
	/** The i button clicked. */
	private IButtonClicked iButtonClicked;
	
	/** The animation. */
	private IAnimation animation ;

	/** The is pressed. */
	public boolean isPressed;
	
	/**
	 * Instantiates a new anime button.
	 *
	 * @param animation the animation
	 * @param xPos the x pos
	 * @param yPos the y pos
	 * @param width the width
	 * @param height the height
	 * @param iButtonClicked the i button clicked
	 */
	public AnimeButton(final IAnimation animation,final int xPos,final int yPos,final int width,final int height,final IButtonClicked iButtonClicked)
	{
		this.iButtonClicked = iButtonClicked;
		this.animation = animation;
		this.rect = new GameRect(xPos, yPos,width, height);
	}

	/**
	 * Update.
	 */
	@Override
	public void update()
	{
		if(rect.contains(GameMouseContainer.mouseXPosition,GameMouseContainer.mouseYPosition))
		{
			mousein = true;
		}
		else
		{
			mousein = false;
		}
		if(mousein)
		{
			if(GameMouseContainer.mouseButtonLeft)
			{
				isPressed = true;
				this.iButtonClicked.onClicked();
			}
		}	
		
		animation.update();
	}

	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	@Override
	public void draw(final Graphics2D graphics2d)
	{
		graphics2d.setStroke(new BasicStroke(5F));		
		graphics2d.setColor(Color.BLUE);
		graphics2d.drawRoundRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), 5, 5);
		
		if(isPressed)
		{
			graphics2d.setColor(Color.ORANGE);	
		}
		else if(mousein && !isPressed)
		{
			graphics2d.setColor(Color.GRAY);		
		}
		else if(!mousein && !isPressed)
		{
			graphics2d.setColor(Color.LIGHT_GRAY);
		}
		
		graphics2d.fillRoundRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), 10, 10);
		
		animation.draw(graphics2d, rect.getX(), rect.getY());
	}
}