package br.com.astianax.tile;

import java.awt.image.BufferedImage;

/**
 * The Class Tile.
 */
public final class Tile
{
	
	/** The id. */
	private final int id;
	
	/** The solid. */
	private final boolean solid;
	
	/** The image. */
	private final BufferedImage image;
	
	/**
	 * Instantiates a new tile.
	 *
	 * @param id the id
	 * @param solid the solid
	 * @param image the image
	 */
	public Tile(final int id,final boolean solid,final BufferedImage image)
	{
		this.id = id;
		this.solid = solid;
		this.image = image;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Checks if is solid.
	 *
	 * @return true, if is solid
	 */
	public boolean isSolid()
	{
		return solid;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public BufferedImage getImage()
	{
		return image;
	}
}