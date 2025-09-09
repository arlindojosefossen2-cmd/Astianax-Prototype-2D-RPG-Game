package br.com.astianax.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import br.com.ajf.game.button.IButtonClicked;
import br.com.ajf.game.input.container.GameMouseContainer;
import br.com.ajf.game.util.GameRect;
import br.com.astianax.constants.GameConstants;

/**
 * The Class SlotButton.
 */
public final class SlotButton
{
    
    /** The Constant BLACK. */
    public static final Color BLACK = new Color(0, 0, 0, 10);
    
    /** The b clicked. */
    private final IButtonClicked bClicked;
    
    /** The mousein. */
    public boolean mousein;
    
    /** The mouse pressed. */
    public boolean mousePressed;

	/** The rect. */
	public GameRect rect;
	
	/**
	 * Instantiates a new slot button.
	 *
	 * @param bClicked the b clicked
	 */
	public SlotButton(final IButtonClicked bClicked)
	{
		this.bClicked = bClicked;
	}

	/**
	 * Update.
	 */
	public void update()
	{	
		if(rect != null)
		{
			mousein = false;
			mousePressed = false;
			
			if(rect.contains(GameMouseContainer.mouseXPosition,GameMouseContainer.mouseYPosition))
			{
				mousein = true;
			
				if(mousein && GameMouseContainer.mouseButtonLeft)
			    {
			    	bClicked.onClicked();
			    	mousePressed = true;
			    	GameMouseContainer.mouseButtonLeft = false;
			    }		
			}	
		}
	}
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param x the x
	 * @param y the y
	 */
	public void draw(final Graphics2D graphics2d,final int x,final int y)
	{
		if(rect == null)
		{
			rect = new GameRect(x, y, GameConstants.TILESIZE, GameConstants.TILESIZE);
		}
		else if(rect != null)
		{
			rect.setX(x);
			rect.setY(y);
			
			if(mousein)
			{
				graphics2d.setColor(Color.ORANGE);
			}
			else
			{
	    		graphics2d.setColor(SlotButton.BLACK);
			}
			graphics2d.fillRoundRect(rect.getX(), rect.getY(),
	    			rect.getWidth(), rect.getHeight(),16,16);
	    
	    	graphics2d.setColor(Color.WHITE);
	    	graphics2d.setStroke(new BasicStroke(2f));
	    	graphics2d.drawRoundRect(rect.getX(), rect.getY(),
	    			rect.getWidth(), rect.getHeight(), 16,16);
		}
	}
}