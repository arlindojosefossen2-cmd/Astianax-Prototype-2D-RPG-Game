package br.com.astianax.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.ajf.game.animation.IAnimationManager;
import br.com.astianax.tile.Tile;

/**
 * The Class GameUtils.
 */
public final class GameUtils
{
	
	/**
	 * Sets the up.
	 *
	 * @param path the path
	 * @param tiles the tiles
	 */
	public static void setUp(final String path,final Tile[] tiles)
	{
        try
        {
        	final InputStream inpustrean = GameUtils.class.getResourceAsStream(path);
         	final BufferedReader bufferedRead = new BufferedReader(new InputStreamReader(inpustrean));
        	
        	for(int r = 0;r < tiles.length;r++)
        	{
        		
        		final String aux[] = bufferedRead.readLine().split(" ");
        		
        		
        		tiles[r]  = new Tile(r,Boolean.parseBoolean(aux[1]),IAnimationManager.LOADER.getScaledImage(aux[0], 4));
        	}
        	
        	inpustrean.close();
        	bufferedRead.close();
        }
        
        catch(Exception err)
       	{
        		err.printStackTrace();
       	}
	}
	
	/**
	 * Sets the up.
	 *
	 * @param path the path
	 * @param tilesize the tilesize
	 * @return the tile[]
	 */
	public static Tile[] setUp(final String path,final int tilesize)
	{
        try
        {
         	final InputStream inpustrean = GameUtils.class.getResourceAsStream(path);
         	final BufferedReader bufferedRead = new BufferedReader(new InputStreamReader(inpustrean));
        	
        	final String[] util = bufferedRead.readLine().split(" ");
        	
        	final BufferedImage bImage = IAnimationManager.LOADER.getScaledImage(util[0], 4);	
        	
        	final Tile[] tiles = new Tile[Integer.parseInt(util[1])];
        	
        	
        	for(int r = 0;r < tiles.length;r++)
        	{
        		
        		tiles[r]  = new Tile(r,Boolean.parseBoolean(bufferedRead.readLine()),bImage.getSubimage(r*tilesize, 0, tilesize, tilesize));
        	}
        	
        	inpustrean.close();
        	bufferedRead.close();
        	
        	return tiles;
        }
        
        catch(Exception err)
       	{
        		err.printStackTrace();
       	}
       return null;
	}
}