package br.com.astianax.gameobject;

import java.awt.Graphics2D;

import br.com.ajf.game.animation.AnimationManager;
import br.com.ajf.game.animation.IAnimationManager;
import br.com.ajf.game.moviment.IDirection;
import br.com.ajf.game.util.GameRect;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.scenes.AbstractScenne;

public abstract class AbstractGameObject
{
	public int yPos ;
	public int xPos ;
	
	public int direction = IDirection.DOWN;
	public int speed ;
	public boolean moving;
		
	protected int index;
	
	public IAnimationManager animations = new AnimationManager();
	
	public String name;
	
	public boolean solid = true;
	public boolean collision;
	public GameRect solidArea = new GameRect(8,8,GameConstants.TILESIZE/2,GameConstants.TILESIZE/2);
	
	public int solidAreaDefaultX = solidArea.getX();
	public int solidAreaDefaultY = solidArea.getY();
	
	protected AbstractScenne scene;
	
	public AbstractGameObject(String name,int yPos, int xPos) 
	{
		this.name = name;
		this.yPos = yPos;
		this.xPos = xPos;
	}
	
	public AbstractGameObject(int yPos, int xPos, int speed)
	{
		this.yPos = yPos;
		this.xPos = xPos;
		this.speed = speed;
	}

	public abstract void start();
	
	public abstract void draw(Graphics2D arg0, AbstractPlayer player);
	
	public abstract void update();
	
	public void setScene(AbstractScenne scene)
	{
		this.scene = scene;			
	}
}
