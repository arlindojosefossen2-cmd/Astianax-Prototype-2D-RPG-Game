package br.com.astianax.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.AbstractGameObject;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.utils.GameUtils;

/**
 * The Class TileManager.
 */
public final class TileManager
{
	
	/** The map data. */
	private int[][] mapData;
	
	/** The tiles. */
	private Tile[] tiles;
	
	public TileManager()
	{

	}
	
	/**
	 * Instantiates a new tile manager.
	 *
	 * @param mapNUmOfRow the map N um of row
	 * @param mapNumOfCol the map num of col
	 */
	public TileManager(int mapNUmOfRow,int mapNumOfCol)
	{
		mapData = new int[mapNUmOfRow][mapNumOfCol];
	}
	
	/**
	 * Load images.
	 *
	 * @param path the path
	 */
	public void loadImages(String path)
	{
		
		GameUtils.setUp(path,tiles);
		
	}
	
	/**
	 * Load images.
	 *
	 * @param path the path
	 * @param tilesize the tilesize
	 */
	public void loadImages(String path,int tilesize)
	{
		
		tiles = GameUtils.setUp(path,tilesize);
		
	}
	
	
	/**
	 * Load mapdata.
	 *
	 * @param path the path
	 */
	public void loadMapdata(String path)
	{
		InputStream inpustrean = null;
    	BufferedReader bufferedRead = null; 	
    	
        try {

        	inpustrean = getClass().getResourceAsStream(path);
        	bufferedRead = new BufferedReader(new InputStreamReader(inpustrean));
        	
        	String au[] = bufferedRead.readLine().split(" ");
        	
        	int num = 0;
        	int row = Integer.parseInt(au[0]);
        	int col = Integer.parseInt(au[1]);
        	
        	mapData = new int[row][col];
        	
        	for(int r = 0;r < mapData.length;r++)
        	{
        		
        		String aux[] = bufferedRead.readLine().split(",");
        		
        		for(int c = 0;c < mapData[0].length;c++)
            	{
        			
        			if(!aux[c].isEmpty() && !aux[c].isBlank())
        				num  = Integer.parseInt(aux[c]);
        			
        			mapData[r][c] = num;
            	}
        		
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
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param player the player
	 */
	public void draw(Graphics2D graphics2d,AbstractGameObject player)
	{
		
		for(int r = 0;r < mapData.length;r++)
    	{
   
    		for(int c = 0;c < mapData[0].length;c++)
        	{
    			int num = mapData[r][c]-1;
    			
    			final int worldX = c * GameConstants.TILESIZE;
            	final int worldY = r * GameConstants.TILESIZE;
                
            	final int screenX = worldX - player.xPos + AbstractPlayer.SCREEN_X;
            	final int screenY = worldY -  player.yPos + AbstractPlayer.SCREEN_Y;

    			if(isplayerOnScreen(worldX, worldY, player))
    				graphics2d.drawImage(tiles[num].getImage(), screenX, screenY, null);
    			
        	}
    		
    	}
	}
	
	/**
	 * Checks if is player on screen.
	 *
	 * @param worldX the world X
	 * @param worldY the world Y
	 * @param player the player
	 * @return true, if is player on screen
	 */
	private static boolean isplayerOnScreen(final int worldX,final int worldY,AbstractGameObject player)
	{	
		return worldX + 6*GameConstants.TILESIZE > player.xPos - AbstractPlayer.SCREEN_X &&
                worldX - 6*GameConstants.TILESIZE < player.xPos + AbstractPlayer.SCREEN_X &&
                worldY + 6*GameConstants.TILESIZE > player.yPos - AbstractPlayer.SCREEN_Y &&
                worldY - 6*GameConstants.TILESIZE < player.yPos + AbstractPlayer.SCREEN_Y;
	}   

	/**
	 * Gets the map data.
	 *
	 * @return the map data
	 */
	public int[][] getMapData()
	{
		return mapData;
	}

	/**
	 * Gets the tiles.
	 *
	 * @return the tiles
	 */
	public Tile[] getTiles()
	{
		return tiles;
	}
}