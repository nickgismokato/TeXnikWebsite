package com.nickgismokato.TeXnik.backend.Data;

import com.nickgismokato.TeXnik.backend.Data.Item;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public final class ItemHandler{
	static Logger logger = LoggerFactory.getLogger(ItemHandler.class);
	public static List<Item> items = new ArrayList<Item>();
	public static int counter;

	private ItemHandler(){
		logger.info("ItemHandler being created.");
		counter = 1;
		logger.info("ItemHandler created.");
	}

	public static void AddToList(int sID, int cID, int ean, String name, int total){
		logger.info("Adding item to list.");
		items.add(new Item(sID, cID, ean, name, total));
		logger.info("Item added to list.");
	}

	public static void RemoveFromList(Item item){
		items.remove(item);
	}

	public static List<Item> ReturnItemList(){
		logger.info("Returning item list.");
		return items;
	}
}
