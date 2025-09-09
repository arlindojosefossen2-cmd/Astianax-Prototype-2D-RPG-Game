package br.com.astianax.entity;

import br.com.astianax.gameobject.AbstractGameObject;
import br.com.astianax.scenes.AbstractScenne;

public abstract class AbstractEntity extends AbstractGameObject
{	
	public AbstractEntity(AbstractScenne scene,String name, int yPos, int xPos,int speed)
	{
		super(name, yPos, xPos);
		this.scene = scene;
		this.speed = speed;
	}
	
	public AbstractEntity(int yPos, int xPos, int speed)
	{
		super(yPos, xPos, speed);
	}
}