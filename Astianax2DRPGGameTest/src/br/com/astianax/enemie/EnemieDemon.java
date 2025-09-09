package br.com.astianax.enemie;

import br.com.ajf.game.animation.Animation;
import br.com.astianax.constants.GameConstants;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.scenes.AbstractScenne;


public final class EnemieDemon extends AbstractEnemies
{
	public EnemieDemon(AbstractScenne scene, int yPos, int xPos, int speed, AbstractPlayer player)
	{
		super(scene, "Demon", yPos, xPos, speed, player);
	}

	@Override
	public void start()
	{
		animations.clear();
		
		//arm idle
		this.animations.addAnimation(new Animation("/enemies/demon/idleup.png",
		2, 12,GameConstants.TILESIZE+32, 1));//0
		this.animations.addAnimation(new Animation("/enemies/demon/idledown.png",
		2, 12,GameConstants.TILESIZE+32 , 1));
		this.animations.addAnimation(new Animation("/enemies/demon/idleleft.png",
		2, 12,GameConstants.TILESIZE +32, 1));
		this.animations.addAnimation(new Animation("/enemies/demon/idleright.png",
		2, 12,GameConstants.TILESIZE+32 , 1));//3
		
		//walk arm	
		this.animations.addAnimation(new Animation("/enemies/demon/walkup.png",
		8, 60/9,GameConstants.TILESIZE+32 , 1));//4
		this.animations.addAnimation(new Animation("/enemies/demon/walkdown.png",
		8, 60/9,GameConstants.TILESIZE+32 , 1));
		this.animations.addAnimation(new Animation("/enemies/demon/walkleft.png",
		8, 60/9,GameConstants.TILESIZE+32, 1));
		this.animations.addAnimation(new Animation("/enemies/demon/walkright.png",
		8, 60/9,GameConstants.TILESIZE+32 , 1));//7
				
		//attack
		this.animations.addAnimation(new Animation("/enemies/demon/attackup.png",
		5, 60/6,GameConstants.TILESIZE+32, 1,false));//8
		this.animations.addAnimation(new Animation("/enemies/demon/attackdown.png",
		5, 60/6,GameConstants.TILESIZE+32 , 1,false));//9
		this.animations.addAnimation(new Animation("/enemies/demon/attackleft.png",
		5, 60/6,GameConstants.TILESIZE+32 , 1,false));//10
		this.animations.addAnimation(new Animation("/enemies/demon/attackright.png",
		5, 60/6,GameConstants.TILESIZE+32 , 1,false));//11
				
		//dead arm
		this.animations.addAnimation(new Animation("/enemies/demon/dead.png",
		5, 60/5,GameConstants.TILESIZE+32 , 1,false));//12
		
		this.animations.setAnimationByIndex(1);
	}
}