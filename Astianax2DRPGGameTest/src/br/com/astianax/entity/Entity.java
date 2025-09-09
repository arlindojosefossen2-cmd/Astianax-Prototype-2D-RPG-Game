package br.com.astianax.entity;

import java.awt.Graphics2D;
import java.util.Random;

import br.com.ajf.game.moviment.IDirection;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.scenes.AbstractScenne;

public abstract class Entity extends AbstractEntity
{
	protected Random random = new Random();
	protected int counter;
	
	public Entity(AbstractScenne scene,String name, int yPos, int xPos,int speed)
	{
		super(scene,name, yPos, xPos,speed);
	}
	
	public Entity(int yPos, int xPos, int speed)
	{
		super(yPos, xPos, speed);
	}

	public void draw(Graphics2D arg0, AbstractPlayer player)
	{
		if(player != null)
			this.animations.draw(arg0, xPos - player.xPos + AbstractPlayer.SCREEN_X,
				yPos - player.yPos + AbstractPlayer.SCREEN_Y);
		//debug
//		arg0.setColor(Color.red);
//		arg0.drawRect(xPos+solidArea.getX() - player.xPos + AbstractPlayer.SCREEN_X,
//				yPos+solidArea.getY() - player.yPos + AbstractPlayer.SCREEN_Y,
//				solidArea.getWidth(),solidArea.getHeight());
	}
	
	public void update()
	{
		counter++;
		
		if(counter >= 120)
		{
			randomDirection(random.nextInt(6));
			counter = 0;
		}
		
		collision = false;
		this.scene.tCollision.checkTile(this, this.scene.tmanager);
		this.scene.eCollision.checkeAbstractGameObjectCollision(this, this.scene.gameobjects,false);
		this.scene.entityCollision.checkeEntityCollision(this, this.scene.entities);
		boolean checker = scene.cPlayerCollision.checkePlayer(scene, this);
		checkerplayer(checker);
			
		if(moving && !collision)
		{
			switch (direction)
			{
				case IDirection.UP:
					yPos -= speed;
					animations.setAnimationByIndex(4);
					break;
				case IDirection.DOWN:
					yPos += speed;
					animations.setAnimationByIndex(5);		
					break;
				case IDirection.LEFT:
					xPos -= speed;
					animations.setAnimationByIndex(6);
					break;
				case IDirection.RIGHT:
					xPos += speed;
					animations.setAnimationByIndex(7);
					break;
			}
		}
		else
		{
			switch (direction)
			{
				case IDirection.UP:
				
					animations.setAnimationByIndex(0);
					break;
				case IDirection.DOWN:
				
					animations.setAnimationByIndex(1);		
					break;
				case IDirection.LEFT:
			
					animations.setAnimationByIndex(2);
					break;
				case IDirection.RIGHT:
			
					animations.setAnimationByIndex(3);
					break;
			}
		}
		
		this.animations.update();
	}

	private void checkerplayer(boolean checker)
	{
		if(checker)
		{
			System.out.println("Player");
		}
	}

	private void randomDirection(int rand)
	{
		if(rand == IDirection.UP)
		{
			direction = IDirection.UP;
			moving = true;
		}
		else if(rand == IDirection.DOWN)
		{
			direction = IDirection.DOWN;
			moving = true;
		}
		else if(rand == IDirection.LEFT)
		{
			direction = IDirection.LEFT;
			moving = true;
		}
		else if(rand == IDirection.RIGHT)
		{
			direction = IDirection.RIGHT;
			moving = true;
		}
		else
		{
			moving = false;
		}
	}
}