package com.nickgismokato.TeXnik.backend.Data;

public class Item{
	public int internalID;
	public int satyrID;
	public int catID;
	public int EAN;
	public String name;
	public int amount;
	public CategoryEnum status;

	public Item(int iID, int sID, int cID, int ean, String nam, int total){
		internalID = iID;
		satyrID = sID;
		catID = cID;
		EAN = ean;
		name = nam;
		amount = total;
		status = CategoryEnum.fromInteger(cID);
	}
}
