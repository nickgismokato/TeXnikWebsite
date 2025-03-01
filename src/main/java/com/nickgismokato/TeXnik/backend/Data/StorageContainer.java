package com.nickgismokato.TeXnik.backend.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.nickgismokato.TeXnik.backend.Data.Enum.CategoryEnum;

@Entity
public class StorageContainer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long internalID;
	private int satyrID;
	private String name;
	private int SID; //Storage ID
	private CategoryEnum status;

	public StorageContainer(int sID, String sName, int storageID) {
		this.satyrID = sID;
		this.name = sName;
		this.SID = storageID;
		this.status = CategoryEnum.fromInteger(storageID);
	}

	public Long getInternalID() {
		return internalID;
	}
	public int getSatyrID() {
		return satyrID;
	}
	public String getName() {
		return name;
	}
	public int getSID() {
		return SID;
	}
	public CategoryEnum getStatus() {
		return status;
	}
}
