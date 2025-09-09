package br.com.astianax.enemie;

import java.awt.Color;
import java.awt.Graphics2D;

import br.com.ajf.game.moviment.IDirection;
import br.com.ajf.game.util.GameRect;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.entity.Entity;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.scenes.AbstractScenne;

public abstract class AbstractEnemies extends Entity
{
	protected boolean attack;
	protected int counterAttack;
	public GameRect attackArea = new GameRect(0,0,30,30);
	
	public boolean isDead;
	
	protected AbstractPlayer player;
	
	protected int maxLife = 2;
	public int life = maxLife;
	
	public int defensePower = 8;
	public int attackPower = 6;	
	
	public AbstractEnemies(AbstractScenne scene, String name, int yPos, int xPos, int speed, AbstractPlayer player)
	{
		super(scene, name, yPos, xPos, speed);
		this.player = player;
		
		solidArea.setX(40);
		solidArea.setY(48);
		solidArea.setWidth(20);
		solidArea.setHeight(28);
		
		solidAreaDefaultX = solidArea.getX();
		solidAreaDefaultY = solidArea.getY();
	}

	@Override
	public void update()
	{
		collision = false;
		this.scene.tCollision.checkTile(this, this.scene.tmanager);
		this.scene.entityCollision.checkeEntityCollision(this, this.scene.entities);
		
		if(!attack)
			super.update();
		
		int xPos = Math.abs(player.xPos-this.xPos);
		int yPos =  Math.abs(player.yPos-this.yPos);
		
		int distance = Math.max(xPos, yPos);
		
		if(distance < GameConstants.TILESIZE)
			attacking();
		else if(counterAttack < 60)
			reset();
		
	}
	
	public void attacking()
	{
		counterAttack++;
		
		if(counterAttack >= 60)
		{
			attack = true;
			counterAttack = 0;
		}
		
		if(attack && counterAttack < 60)
		{
			//if attacking begin
			int currentX = xPos;
			int currentY = yPos;
			
			int currentWidth = solidArea.getWidth();
			int currentHeight = solidArea.getHeight();
			
			switch(direction)
			{
				case IDirection.UP -> yPos = currentY - attackArea.getHeight();
				case IDirection.DOWN -> yPos = currentY + attackArea.getHeight();
				case IDirection.LEFT -> xPos = currentX - attackArea.getWidth();
				case IDirection.RIGHT -> xPos = currentX + attackArea.getWidth();
			}
		
			solidArea.setWidth(attackArea.getWidth());
			solidArea.setHeight(attackArea.getHeight());
			
			boolean index = this.scene.monCollision.checkePlayer(scene, this);
			damagePlayer(index);
			
			xPos = currentX;
			yPos = currentY;
			
			solidArea.setWidth(currentWidth);
			solidArea.setHeight(currentHeight);
			
			//if attacking end
			if(player != null)
				switch(player.direction)
				{
				case IDirection.UP:
					this.animations.setAnimationByIndex(9);
					
					break;
				case IDirection.DOWN:
					this.animations.setAnimationByIndex(8);
					
					break;
				case IDirection.LEFT:
					this.animations.setAnimationByIndex(11);
					
					break;
				case IDirection.RIGHT:
					this.animations.setAnimationByIndex(10);
					
					break;
			}
		}
		
		if(isDead )
		{
			this.animations.setAnimationByIndex(12);
		}
			
		if(this.animations.isFinished(8) || this.animations.isFinished(9) || 
					this.animations.isFinished(10) || this.animations.isFinished(11))
		{
				reset();
		}
		
		this.animations.update();
	}
	
	private void damagePlayer(boolean index)
	{
		if(index)
		{
			if(((player != null)))
			{
					player.life -= 1;
					
					if(player.life <= 0)
					{	
						this.scene.player.isDead = true;
					}
			}
		}
	}

	public void reset()
	{
		attack = false;
		counterAttack = 0;
		
		this.animations.reset(8);
		this.animations.reset(9);
		this.animations.reset(10);
		this.animations.reset(11);
	}
	
	@Override
	public void draw(Graphics2D arg0, AbstractPlayer player)
	{
		if(player != null)
		{
			super.draw(arg0, player);
			
			final int xBarPos = xPos + solidArea.getX() - 8 - player.xPos + AbstractPlayer.SCREEN_X;
			final int yBarPos = yPos + solidArea.getY() - player.yPos - 32 + AbstractPlayer.SCREEN_Y;
				
			final float width = (float)GameConstants.TILESIZE/(float)maxLife;
			float widBar = (width*life)-32;
				
			if(widBar <= 0)
				widBar = 0;
				
			arg0.setColor(Color.BLACK);
			arg0.drawRoundRect(xBarPos-1, yBarPos-1, GameConstants.TILESIZE/2+2, 10, 5, 5);
			arg0.setColor(Color.red);
			
			if(widBar == 0)
			{
				arg0.fillRoundRect(xBarPos, yBarPos, (int)widBar+16, 8, 5, 5);
			}
			else
			{
				arg0.fillRoundRect(xBarPos, yBarPos, (int)widBar, 8, 5, 5);
			}	
		}	
	}
}