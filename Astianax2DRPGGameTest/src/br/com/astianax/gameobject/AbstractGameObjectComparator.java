package br.com.astianax.gameobject;

import java.util.Comparator;

public class AbstractGameObjectComparator implements Comparator<AbstractGameObject>
{
	@Override
	public int compare(AbstractGameObject o1, AbstractGameObject o2)
	{
		if(o1 == null || o2 == null)
			return -1;
		
		int yPoso1 = o1.yPos + o1.solidArea.getY() + o1.solidArea.getHeight();
		int yPoso2 = o2.yPos + o2.solidArea.getY() + o2.solidArea.getHeight();
		
		return(yPoso1 > yPoso2) ? 1 : (yPoso1 < yPoso2) ? -1 : 0;
	}

}
