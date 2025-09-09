package br.com.astianax.player;

import java.awt.event.KeyEvent;

import br.com.ajf.game.animation.Animation;
import br.com.ajf.game.input.container.GameInputContainer;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.GameObject;
import br.com.astianax.inventory.PlayerInventory;
import br.com.astianax.scenes.AbstractScenne;
import br.com.astianax.utils.SlotButton;

public final class PlayerElliot extends AbstractPlayer
{
	public PlayerElliot(final AbstractScenne scene,final  int yPos,final  int xPos,final  int speed)
	{
		super(scene, "Elliot", yPos, xPos, speed);

	}
	
	public PlayerElliot(final int yPos,final  int xPos,final  int speed)
	{
		this(null,yPos, xPos, speed);
	}

	@Override
	public void loadNoArmAnime()
	{
		animations.clear();
		
		this.animations.addAnimation(new Animation("/player/anime/elliot/idleupnoarm.png",
				2, 12,GameConstants.TILESIZE+32, 1));//0
		this.animations.addAnimation(new Animation("/player/anime/elliot/idledownnoarm.png",
				2, 12,GameConstants.TILESIZE+32 , 1));
		this.animations.addAnimation(new Animation("/player/anime/elliot/idleleftnoarm.png",
				2, 12,GameConstants.TILESIZE +32, 1));
		this.animations.addAnimation(new Animation("/player/anime/elliot/idlerightnoarm.png",
				2, 12,GameConstants.TILESIZE+32 , 1));//3
		
		this.animations.addAnimation(new Animation("/player/anime/elliot/walkupnoarm.png",
				8, 60/9,GameConstants.TILESIZE+32 , 1));//4
		this.animations.addAnimation(new Animation("/player/anime/elliot/walkdownnoarm.png",
				8, 60/9,GameConstants.TILESIZE+32 , 1));
		this.animations.addAnimation(new Animation("/player/anime/elliot/walkleftnoarm.png",
				8, 60/9,GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/player/anime/elliot/walkrightnoarm.png",
				8, 60/9,GameConstants.TILESIZE+32 , 1));//7
		//dead no arm
		this.animations.addAnimation(new Animation("/player/anime/elliot/deadnoarm.png",
				6, 60/5,GameConstants.TILESIZE+32 , 1,false));//8
		
	}
	@Override
	public void loadArmAnime()
	{
		animations.clear();
		
		//arm
				this.animations.addAnimation(new Animation("/player/anime/elliot/idleup.png",
						2, 12,GameConstants.TILESIZE+32, 1));//0
				this.animations.addAnimation(new Animation("/player/anime/elliot/idledown.png",
						2, 12,GameConstants.TILESIZE+32 , 1));
				this.animations.addAnimation(new Animation("/player/anime/elliot/idleleft.png",
						2, 12,GameConstants.TILESIZE +32, 1));
				this.animations.addAnimation(new Animation("/player/anime/elliot/idleright.png",
						2, 12,GameConstants.TILESIZE+32 , 1));//3
				
				this.animations.addAnimation(new Animation("/player/anime/elliot/walkup.png",
						8, 60/9,GameConstants.TILESIZE+32 , 1));//4
				this.animations.addAnimation(new Animation("/player/anime/elliot/walkdown.png",
						8, 60/9,GameConstants.TILESIZE+32 , 1));
				this.animations.addAnimation(new Animation("/player/anime/elliot/walkleft.png",
						8, 60/9,GameConstants.TILESIZE+32, 1));
				this.animations.addAnimation(new Animation("/player/anime/elliot/walkright.png",
						8, 60/9,GameConstants.TILESIZE+32 , 1));//7
				
		//attack
				this.animations.addAnimation(new Animation("/player/anime/elliot/attackup.png",
						4, 60/6,GameConstants.TILESIZE+32, 1,false));//8
				this.animations.addAnimation(new Animation("/player/anime/elliot/attackdown.png",
						4, 60/6,GameConstants.TILESIZE+32 , 1,false));//9
				this.animations.addAnimation(new Animation("/player/anime/elliot/attackleft.png",
						4, 60/6,GameConstants.TILESIZE+32 , 1,false));//10
				this.animations.addAnimation(new Animation("/player/anime/elliot/attackright.png",
						4, 60/6,GameConstants.TILESIZE+32 , 1,false));//11
				
				//dead arm
				this.animations.addAnimation(new Animation("/player/anime/elliot/deadaxes.png",
						5, 60/5,GameConstants.TILESIZE+32 , 1,false));//12
				
	}
	@Override
	public void checkeGameObjectCollision(final int index)
	{
		if(index != -1)
		{
			if(this.scene.gameobjects[index] != null)
			{
				switch(this.scene.gameobjects[index].name)
				{
					case "Heart":

						if(itens.size() < PlayerInventory.MAX_SIZE)
						{
							itens.add((GameObject) this.scene.gameobjects[index]);
						
							this.scene.gameobjects[index] = null;
						
							inventory.add(new SlotButton(
								() ->
								{
									if(life < maxLife)
									{
										life += 1;
									}
								}));
						}
						break;
						
					case "Mana":

						if(itens.size() < PlayerInventory.MAX_SIZE)
						{
							itens.add((GameObject) this.scene.gameobjects[index]);
					
							this.scene.gameobjects[index] = null;
							inventory.add(new SlotButton(
									() ->
							{
								if(mana < maxMana)
								{
									mana += 1;
								}
								
							}));
						}
						break;
					case "SimpleAxes":
						
						if(itens.size() < PlayerInventory.MAX_SIZE)
						{
							itens.add((GameObject) this.scene.gameobjects[index]);
							
							this.scene.gameobjects[index] = null;
							
							inventory.add(new SlotButton(
									() ->
							{
								if(!inHome)
								{
									haveArm = !haveArm;
									
									if(haveArm)
									{
										loadArmAnime();
									}
									else
									{
										loadNoArmAnime();
									}
								}
								
							}));
						}			
						break;
						
					case "GoldenChest":
						
						if(GameInputContainer.keys[KeyEvent.VK_ENTER])
						{
							this.scene.gameobjects[index].animations.setAnimationByIndex(1);
						}
						break;
				
				}
			}
		}
	}
}