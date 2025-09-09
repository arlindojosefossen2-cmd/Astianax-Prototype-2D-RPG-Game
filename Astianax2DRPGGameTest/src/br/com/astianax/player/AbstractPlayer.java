package br.com.astianax.player;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import br.com.ajf.game.input.container.GameInputContainer;
import br.com.ajf.game.moviment.IDirection;
import br.com.ajf.game.util.GameRect;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.enemie.AbstractEnemies;
import br.com.astianax.entity.AbstractEntity;
import br.com.astianax.gameobject.GameObject;
import br.com.astianax.hud.PlayerLifeHud;
import br.com.astianax.hud.PlayerManaHud;
import br.com.astianax.inventory.PlayerInventory;
import br.com.astianax.scenes.AbstractScenne;

/**
 * The Class AbstractPlayer.
 */
public abstract class AbstractPlayer extends AbstractEntity
{
	/** The Constant SCREEN_X. */
	public static final int SCREEN_X = GameConstants.SCREEN_WIDHT/2 - (GameConstants.TILESIZE+32)/2;
	
	/** The Constant SCREEN_Y. */
	public static final int SCREEN_Y = GameConstants.SCREEN_HEIGTH/2 - (GameConstants.TILESIZE+32)/2;

	/** The attacking. */
	public boolean attacking;
	
	/** The attackcounter. */
	private int attackcounter;
	
	/** The attack area. */
	public GameRect attackArea = new GameRect(0,0,30,30);
	
	/** The have arm. */
	public boolean haveArm ;
	
	/** The is dead. */
	public boolean isDead;
	
	/** The max life. */
	public int maxLife = 6;
	
	/** The life. */
	public int life = maxLife-1;
	
	/** The max mana. */
	public int maxMana = 3;
	
	/** The mana. */
	public int mana = maxMana-1;
	
	/** The in home. */
	public boolean inHome;
	
	/** The inventory. */
	public final PlayerInventory 	inventory = new PlayerInventory(this);
	
	/** The itens. */
	public final List<GameObject> itens = new ArrayList<GameObject>();
	
	/** The is inventory. */
	public boolean isInventory = false;
	
	/** The life hud. */
	public final PlayerLifeHud lifeHud = new PlayerLifeHud(new String[]{
		"/objects/fullheart.png","/objects/halfheart.png","/objects/blankheart.png"},this);
	
	/** The mana hud. */
	public final PlayerManaHud manaHud = new PlayerManaHud(new String[]{
			"/objects/fullbluecristal.png","/objects/blankbluecristal.png"},this);

	/** The attack power. */
	public int attackPower = 10;		
	
	/** The defense power. */
	public int defensePower = 6;
	
	/**
	 * Instantiates a new abstract player.
	 *
	 * @param scene the scene
	 * @param name the name
	 * @param yPos the y pos
	 * @param xPos the x pos
	 * @param speed the speed
	 */
	public AbstractPlayer(final AbstractScenne scene,final String name,final int yPos,final int xPos,final int speed)
	{
		super(scene, name, yPos, xPos, speed);
	}
	
	/**
	 * Instantiates a new abstract player.
	 *
	 * @param yPos the y pos
	 * @param xPos the x pos
	 * @param speed the speed
	 */
	public AbstractPlayer(final int yPos,final int xPos,final int speed)
	{
		super(yPos, xPos, speed);
	}

	/**
	 * Load no arm anime.
	 */
	public abstract void loadNoArmAnime();
	
	/**
	 * Load arm anime.
	 */
	public abstract void loadArmAnime();
	
	/**
	 * Start.
	 */
	@Override
	public void start() 
	{
		solidArea.setX(38);
		solidArea.setY(38);
		solidArea.setWidth(22);
		solidArea.setHeight(36);
		
		solidAreaDefaultX = solidArea.getX();
		solidAreaDefaultY = solidArea.getY();
		
		if(haveArm)
			loadArmAnime();
		else
			loadNoArmAnime();
	}
	
	/**
	 * Update.
	 */
	@Override
	public void update() 
	{
		attackcounter++;

		if(GameInputContainer.keys[KeyEvent.VK_UP] || 
				GameInputContainer.keys[KeyEvent.VK_DOWN] ||
				GameInputContainer.keys[KeyEvent.VK_LEFT] || 
				GameInputContainer.keys[KeyEvent.VK_RIGHT] ||
				GameInputContainer.keys[KeyEvent.VK_W] ||
				GameInputContainer.keys[KeyEvent.VK_D] ||
				GameInputContainer.keys[KeyEvent.VK_A] ||
				GameInputContainer.keys[KeyEvent.VK_S])
		{
			if(GameInputContainer.keys[KeyEvent.VK_UP] || GameInputContainer.keys[KeyEvent.VK_W])
			{
				direction = 0;
			}
			else if(GameInputContainer.keys[KeyEvent.VK_DOWN] || GameInputContainer.keys[KeyEvent.VK_S])
			{
				direction = 1;
			}
			else if(GameInputContainer.keys[KeyEvent.VK_LEFT] || GameInputContainer.keys[KeyEvent.VK_A])
			{
				direction = 2;
			}
			else if(GameInputContainer.keys[KeyEvent.VK_RIGHT] || GameInputContainer.keys[KeyEvent.VK_D])
			{
				direction = 3;
			}
			moving = true;
			attacking = false;
		}
		else
		{
			moving = false;
			attacking = false;
		}
		

		if(GameInputContainer.keys[KeyEvent.VK_SPACE] && attackcounter > 30 && haveArm && !inHome)
		{
			attacking = true;
			moving = false;
		}

		collision = false;
		this.scene.tCollision.checkTile(this,this.scene.tmanager);
		int index = this.scene.entityCollision.checkeEntityCollision(this, this.scene.entities);
		index = this.scene.eCollision.checkeAbstractGameObjectCollision(this, this.scene.gameobjects, true);
		checkeGameObjectCollision(index);
		
		if(inHome)
		{
			attacking = false;
		}
		
		if(moving && !attacking && !collision)
		{
			switch(direction)
			{
				case IDirection.UP:
					yPos -= speed;
					this.animations.setAnimationByIndex(4);
					break;
				case IDirection.DOWN:
					yPos += speed;
					this.animations.setAnimationByIndex(5);
					break;
				case IDirection.LEFT:
					xPos -= speed;
					this.animations.setAnimationByIndex(6);
					break;
				case IDirection.RIGHT:
					xPos += speed;
					this.animations.setAnimationByIndex(7);
					break;
			}
		}
		else if(!this.moving && !attacking)
		{
			switch(this.direction)
			{
			case IDirection.UP:
				
					this.animations.setAnimationByIndex(0);
				
				break;
			case IDirection.DOWN:
			
					this.animations.setAnimationByIndex(1);
				
				break;
			case IDirection.LEFT:
				
					this.animations.setAnimationByIndex(2);
				
				break;
			case IDirection.RIGHT:
				
					this.animations.setAnimationByIndex(3);
				
				break;
			}
		}
		else if(attacking && haveArm && !inHome)
		{
			//if attacking begin
			final int currentX = xPos;
			final int currentY = yPos;
			
			final int currentWidth = solidArea.getWidth();
			final int currentHeight = solidArea.getHeight();
			
			switch(direction)
			{
				case IDirection.UP -> yPos = currentY - attackArea.getHeight();
				case IDirection.DOWN -> yPos = currentY + attackArea.getHeight();
				case IDirection.LEFT -> xPos = currentX - attackArea.getWidth();
				case IDirection.RIGHT -> xPos = currentX + attackArea.getWidth();
			}
		
			solidArea.setWidth(attackArea.getWidth());
			solidArea.setHeight(attackArea.getHeight());
			
			index = this.scene.entityCollision.checkeEntityCollision(this, this.scene.enemies);
			damageEnemies(index);
			
			xPos = currentX;
			yPos = currentY;
			
			solidArea.setWidth(currentWidth);
			solidArea.setHeight(currentHeight);
			
			//if attacking end
			
			switch(this.direction)
			{
			case IDirection.UP:
				this.animations.setAnimationByIndex(8);
				
				break;
			case IDirection.DOWN:
				this.animations.setAnimationByIndex(9);
				
				break;
			case IDirection.LEFT:
				this.animations.setAnimationByIndex(10);
				
				break;
			case IDirection.RIGHT:
				this.animations.setAnimationByIndex(11);
				
				break;
			}
		}
		
		
		if(isDead)
		{
			if(haveArm)
			{
				this.animations.setAnimationByIndex(12);
				
//				if(this.animations.isFinished(12))
//				{
//					this.animations.reset(12);
//					isDead = false;
//				}
			}
			else
			{
				this.animations.setAnimationByIndex(8);
//				
//				if(this.animations.isFinished(8))
//				{
//					this.animations.reset(8);
//					isDead = false;
//				}
			}
		}
		
		if(haveArm)
		{
			if(this.animations.isFinished(8) || this.animations.isFinished(9) || 
					this.animations.isFinished(10) || this.animations.isFinished(11))
			{
				attacking = false;
				attackcounter = 0;
				
				this.animations.reset(8);
				this.animations.reset(9);
				this.animations.reset(10);
				this.animations.reset(11);
			}
		}
		
		this.animations.update();
	}

	/**
	 * Damage enemies.
	 *
	 * @param index the index
	 */
	private void damageEnemies(final int index)
	{
		if(index != -1)
		{
			if(((this.scene.enemies[index] != null) && (this.scene.enemies[index] instanceof AbstractEnemies)))
			{
				AbstractEnemies e = (AbstractEnemies) this.scene.enemies[index];
				
				e.life -= 1;
		
				if(e.life <= 0)
				{		
					e.isDead = true;
	
					if(this.scene.enemies[index].animations.isFinished(12))
					{
						this.scene.enemies[index] = null;
						e = null;
					}
				}
			}
		}
	}

	/**
	 * Checke game object collision.
	 *
	 * @param index the index
	 */
	public abstract void checkeGameObjectCollision(int index);

	/**
	 * Draw.
	 *
	 * @param arg0 the arg 0
	 * @param player the player
	 */
	@Override
	public void draw(final Graphics2D arg0,final AbstractPlayer player) 
	{
		
		animations.draw(arg0, SCREEN_X, SCREEN_Y);
		//debug
//		arg0.setColor(Color.red);
//		arg0.drawRect(solidArea.getX() + SCREEN_X,solidArea.getY() + SCREEN_Y,
//				solidArea.getWidth(),solidArea.getHeight());
	}
	
	/**
	 * Draw player hud and inventiry.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	public void drawPlayerHudAndInventiry(final Graphics2D graphics2d)
	{
		if(lifeHud != null)
		{
			lifeHud.draw(graphics2d);
		}
		if(manaHud != null)
		{
			manaHud.draw(graphics2d);
		}
		if(isInventory)
		{
			inventory.draw(graphics2d);
		}
	}
}