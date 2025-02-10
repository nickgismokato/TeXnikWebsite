package com.nickgismokato.TeXnik.backend.Data;

import java.util.ArrayList;
import java.util.List;

public final class ItemHandler{

	public static List<Item> items;
	public static List<Integer> IIDs;
	public static int counter;

	private ItemHandler(){
		items = new ArrayList<Item>();
		IIDs = new ArrayList<Integer>();
		counter = 1;
	}

	public static void AddToList(int sID, int cID, int ean, String name, int total){
		int internalID = counter;
		if(IIDs != null && !IIDs.isEmpty()){
			internalID = IIDs.get(0);
			IIDs.remove(0);
		}
		items.add(new Item(internalID, sID, cID, ean, name, total));
	}

	public static void RemoveFromList(Item item){
		IIDs.add(item.internalID);
		items.remove(item);
	}

	public static List<Item> ReturnItemList(){
		return items;
	}
}
