package com.nickgismokato.TeXnik.backend.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.nickgismokato.TeXnik.backend.Data.Enum.CategoryEnum;

@Entity
@Table(name = "Items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;
	private int satyrID;
	private int catID;
	private Long EAN;
	private String name;
	private int amount;
	private CategoryEnum status;

	public Item(){
		
	}
	public Item(int sID, int cID, Long ean, String nam, int total){
		this.satyrID = sID;
		this.catID = cID;
		this.EAN = ean;
		this.name = nam;
		this.amount = total;
		this.status = CategoryEnum.fromInteger(cID);
	}


	public Long getId(){
		return this.id;
	}
	public int getSatyrID(){
		return this.satyrID;
	}
	public int getCatID(){
		return this.catID;
	}
	public Long getEAN(){
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

	public void setName(String name){
		this.name = name;
	}
	public void setSatyrID(int satyrID){
		this.satyrID = satyrID;
	}
	public void setCatID(int catID){
		this.catID = catID;
	}
	public void setEAN(Long ean){
		this.EAN = ean;
	}
	public void setAmount(int amount){
		this.amount = amount;
	}
}

