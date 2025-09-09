package br.com.astianax.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * The Class SubScreen.
 */
public final class SubScreen
{
	/** The x pos. */
	private int xPos;
	
	/** The y pos. */
	private int yPos;
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;

	/**
	 * Instantiates a new sub screen.
	 *
	 * @param xPos the x pos
	 * @param yPos the y pos
	 * @param width the width
	 * @param height the height
	 */
	public SubScreen(final int xPos,final int yPos,final int width,final int height)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	public void draw(final Graphics2D graphics2d)
	{
	     Color color = new Color(0, 0, 0, 210);
	     graphics2d.setColor(color);
	     graphics2d.fillRoundRect(xPos, yPos, width, height, 35, 35);

	     color = new Color(255, 255, 255);
	     graphics2d.setColor(color);
	     graphics2d.setStroke(new BasicStroke(5));
	     graphics2d.drawRoundRect(xPos + 5, yPos + 5, width - 10, height - 10, 25, 25);
	}
	
	/**
	 * Gets the x pos.
	 *
	 * @return the x pos
	 */
	public int getxPos()
	{
		return xPos;
	}
	
	/**
	 * Gets the y pos.
	 *
	 * @return the y pos
	 */
	public int getyPos()
	{
		return yPos;
	}
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight()
	{
		return height;
	}
}