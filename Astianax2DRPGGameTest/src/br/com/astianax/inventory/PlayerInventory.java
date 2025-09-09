package br.com.astianax.inventory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import br.com.astianax.constants.GameConstants;
import br.com.astianax.gameobject.GameObject;
import br.com.astianax.player.AbstractPlayer;
import br.com.astianax.utils.SlotButton;
import br.com.astianax.utils.SubScreen;

public final class PlayerInventory
{
	public static final int MAX_SIZE = 16;
	private List<SlotButton> slots = new ArrayList<SlotButton>();
	private SubScreen subWindow = new SubScreen(520,120,320,320);
	private AbstractPlayer player;
	
	public PlayerInventory(AbstractPlayer player)
	{
		this.player = player;
	}
	
	public void add(SlotButton slotButton)
	{
		if(slots.size() < MAX_SIZE)
			slots.add(slotButton);
	}
	
	public void update()
	{
		for (SlotButton slotButton : slots)
		{
			if(slotButton != null)
			{
				slotButton.update();
			}
		}
	}
	
	public void draw(Graphics2D graphics2d)
	{
		subWindow.draw(graphics2d);
		
		final int slotXStart = subWindow.getxPos() + 20;
	    final int slotYStart = subWindow.getyPos() + 20;
	        
	    int slotX = slotXStart;
	    int slotY = slotYStart;
	    int slotSize = GameConstants.TILESIZE+8;
		
		drawinventoryItens(graphics2d,slotXStart,slotX,slotY,slotSize);
	
	}
	
//	 private void drawItemDescriptionText(List<Asset> inventory, int descriptionFrameX, int descriptionFrameY, int descriptionFrameWidth, int descriptionFrameHeight, int slotCol, int slotRow) {
//    // DRAW DESCRIPTION TEXT
//    int textX = descriptionFrameX + 20;
//    int textY = descriptionFrameY + gamePanel.getTileSize();
//
//    graphics2D.setFont(graphics2D.getFont().deriveFont(28F));
//
//    int itemIndex = getItemIndexFromSlot(slotCol, slotRow);
//
//    if (itemIndex < inventory.size()) 
//		{
//
//        drawSubWindow(descriptionFrameX, descriptionFrameY, descriptionFrameWidth, descriptionFrameHeight);
//
//        for (String line : inventory.get(itemIndex).getDescription().split("\n"))
//			{
//            graphics2D.drawString(line, textX, textY);
//            textY += 32;
//        	}
//    	}
//	}
	
	private void drawinventoryItens(Graphics2D graphics2d, int slotXStart, int slotX, int slotY, int slotSize)
	{
		
		for (int i = 0;i < player.itens.size();i++)
		{
			if(player.itens.get(i) != null)
			{
				GameObject o = player.itens.get(i);
	
				if(o.image != null)
				{	
					if(!slots.isEmpty() && slots.get(i) != null)
					{
			    		if(slots.get(i).mousePressed && o.isConsumivel)
			    		{
			    				player.itens.remove(i);
			    				slots.remove(i);
			    				continue;		
			    		}
					}
			    	
				    slots.get(i).draw(graphics2d, slotX, slotY);
				    
				    graphics2d.drawImage(o.image, slotX, slotY, null);
			    	
				}
			}
			
			slotX += slotSize;

			if (i == 3 || i == 7 || i == 11) 
			{
        		slotX = slotXStart;
        		slotY += slotSize;
        	}
		}
		
    	graphics2d.setFont(graphics2d.getFont().deriveFont(48f));
    	graphics2d.setColor(Color.YELLOW);
    	graphics2d.drawString(" Inventory: ", 534,68 );
    	graphics2d.setColor(Color.BLACK);
    	graphics2d.drawString(" Inventory: ", 530,64 );
	}
}