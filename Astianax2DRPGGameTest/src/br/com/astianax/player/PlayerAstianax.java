package br.com.astianax.player;

import java.awt.event.KeyEvent;

import br.com.ajf.game.animation.Animation;
import br.com.ajf.game.input.container.GameInputContainer;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.GameObject;
import br.com.astianax.inventory.PlayerInventory;
import br.com.astianax.scenes.AbstractScenne;
import br.com.astianax.utils.SlotButton;

public final class PlayerAstianax extends AbstractPlayer
{	
	public PlayerAstianax(final AbstractScenne scene,final  int yPos,final  int xPos,final  int speed)
	{
		super(scene, "Astianax", yPos, xPos, speed);
	}
	
	public PlayerAstianax(final int yPos,final  int xPos,final  int speed)
	{
		this(null,yPos, xPos, speed);
	}

	@Override
	public void loadNoArmAnime()
	{
		animations.clear();
		
		this.animations.addAnimation(new Animation("/player/anime/astianax/idleupnoarm.png",
				2, 12,GameConstants.TILESIZE+32, 1));//0
		this.animations.addAnimation(new Animation("/player/anime/astianax/idledownnoarm.png",
				2, 12,GameConstants.TILESIZE+32 , 1));
		this.animations.addAnimation(new Animation("/player/anime/astianax/idleleftnoarm.png",
				2, 12,GameConstants.TILESIZE +32, 1));
		this.animations.addAnimation(new Animation("/player/anime/astianax/idlerightnoarm.png",
				2, 12,GameConstants.TILESIZE+32 , 1));//3
		
		this.animations.addAnimation(new Animation("/player/anime/astianax/walkupnoarm.png",
				8, 60/8,GameConstants.TILESIZE+32 , 1));//4
		this.animations.addAnimation(new Animation("/player/anime/astianax/walkdownnoarm.png",
				8, 60/8,GameConstants.TILESIZE+32 , 1));
		this.animations.addAnimation(new Animation("/player/anime/astianax/walkleftnoarm.png",
				8, 60/8,GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/player/anime/astianax/walkrightnoarm.png",
				8, 60/8,GameConstants.TILESIZE+32 , 1));//7
		//dead no arm
		this.animations.addAnimation(new Animation("/player/anime/astianax/deadnoarm.png",
				6, 60/5,GameConstants.TILESIZE+32 , 1,false));//8
	}
	@Override
	public void loadArmAnime()
	{
		animations.clear();
		
		//arm
		this.animations.addAnimation(new Animation("/player/anime/astianax/idleupaxes.png",
				2, 12,GameConstants.TILESIZE+32, 1));//0
		this.animations.addAnimation(new Animation("/player/anime/astianax/idledownaxes.png",
				2, 12,GameConstants.TILESIZE+32 , 1));
		this.animations.addAnimation(new Animation("/player/anime/astianax/idleleftaxes.png",
				2, 12,GameConstants.TILESIZE +32, 1));
		this.animations.addAnimation(new Animation("/player/anime/astianax/idlerightaxes.png",
				2, 12,GameConstants.TILESIZE+32 , 1));//3
				
		this.animations.addAnimation(new Animation("/player/anime/astianax/walkupaxes.png",
				8, 60/9,GameConstants.TILESIZE+32 , 1));//4
		this.animations.addAnimation(new Animation("/player/anime/astianax/walkdownaxes.png",
				8, 60/9,GameConstants.TILESIZE+32 , 1));
		this.animations.addAnimation(new Animation("/player/anime/astianax/walkleftaxes.png",
				8, 60/9,GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/player/anime/astianax/walkrightaxes.png",
				8, 60/9,GameConstants.TILESIZE+32 , 1));//7
				
		//attack
		this.animations.addAnimation(new Animation("/player/anime/astianax/attackupaxes.png",
				5, 60/6,GameConstants.TILESIZE+32, 1,false));//8
		this.animations.addAnimation(new Animation("/player/anime/astianax/attackdownaxes.png",
				5, 60/6,GameConstants.TILESIZE+32 , 1,false));//9
		this.animations.addAnimation(new Animation("/player/anime/astianax/attackleftaxes.png",
				5, 60/6,GameConstants.TILESIZE+32 , 1,false));//10
		this.animations.addAnimation(new Animation("/player/anime/astianax/attackrightaxes.png",
				5, 60/6,GameConstants.TILESIZE+32 , 1,false));//11
				
		//dead arm
		this.animations.addAnimation(new Animation("/player/anime/astianax/deadaxes.png",
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
						
					case "DoubleAxes":
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