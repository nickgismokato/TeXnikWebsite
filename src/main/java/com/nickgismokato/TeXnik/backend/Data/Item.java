package com.nickgismokato.TeXnik.backend.Data;

import com.nickgismokato.TeXnik.backend.Data.Enum.CategoryEnum;

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

	public int getSatyrID(){
		return this.satyrID;
	}
	public int getCatID(){
		return this.catID;
	}
	public int getEAN(){
		return this.EAN;
	}
	public String getName(){
		return this.name;
	}
	public int getAmount(){
		return this.amount;
	}
	public CategoryEnum getStatus(){
		return this.status;
	}
}
