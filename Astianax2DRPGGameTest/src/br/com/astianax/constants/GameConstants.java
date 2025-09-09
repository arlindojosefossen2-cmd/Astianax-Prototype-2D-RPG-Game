package br.com.astianax.constants;

/**
 * Autor A.J.F.
 * @version 1.0
 * 25 de jun. de 2025
 */
public final class GameConstants
{
	/** The Constant ORIGINAL_TILESIZE. */
	public static final int ORIGINAL_TILESIZE = 32;
	
	/** The Constant SCALE. */
	public static final float SCALE = 2f;

	/** The Constant TILESIZE. */
	public static final int TILESIZE = (int) (ORIGINAL_TILESIZE*SCALE);
	
	/** The Constant MAX_SCREEN_COLUMN. */
	public static final int MAX_SCREEN_COLUMN = 15;
	
	/** The Constant MAX_SCREEN_ROW. */
	public static final int MAX_SCREEN_ROW = 9;

	/** The Constant SCREEN_WIDHT. */
	public static final int SCREEN_WIDHT = MAX_SCREEN_COLUMN*TILESIZE;
	
	/** The Constant SCREEN_HEIGTH. */
	public static final int SCREEN_HEIGTH = MAX_SCREEN_ROW*TILESIZE;
	
	/** The Constant MAX_WORLD_COLUMN. */
	public static final int MAX_WORLD_COLUMN = 50;
	
	/** The Constant MAX_WORLD_ROW. */
	public static final int MAX_WORLD_ROW = 50;
}