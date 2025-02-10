package com.nickgismokato.TeXnik.backend.Data;

import java.util.ArrayList;
import java.util.List;

public final class ItemHandler{

	public static List<Item> items;

	private ItemHandler(){
		items = new ArrayList<Item>();
	}

	public static void AddToList(int sID, int cID, int ean, String name, int total){
		items.add(new Item(sID, cID, ean, name, total));
	}

	public static void RemoveFromList(Item item){
		items.remove(item);
	}

	public static List<Item> ReturnItemList(){
		return items;
	}
}
