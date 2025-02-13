package com.nickgismokato.TeXnik.backend.Data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public final class ItemHandler{
	static Logger logger = LoggerFactory.getLogger(ItemHandler.class);
	public static List<Item> items = new ArrayList<Item>();
	public static List<Integer> IIDs = new ArrayList<Integer>();
	public static int counter;

	private ItemHandler(){
		logger.info("ItemHandler being created.");
		counter = 1;
		logger.info("ItemHandler created.");
	}

	public static void AddToList(int sID, int cID, int ean, String name, int total){
		logger.info("Adding item to list.");
		int internalID = counter;
		if(IIDs != null && !IIDs.isEmpty()){
			internalID = IIDs.get(0);
			IIDs.remove(0);
		}
		boolean exist = false;
		for(Item item : items){
			if(item.satyrID == sID){
				logger.warn("satyrID already exists");
				exist = true;
			}

		}
		if(!exist){items.add(new Item(internalID, sID, cID, ean, name, total));}
		logger.info("Item added to list.");
	}

	public static void RemoveFromList(Item item){
		IIDs.add(item.internalID);
		items.remove(item);
	}

	public static List<Item> ReturnItemList(){
		logger.info("Returning item list.");
		return items;
	}
}
