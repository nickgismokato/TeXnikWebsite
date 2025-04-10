package com.nickgismokato.TeXnik.backend.Data.Enum;

public enum CategoryEnum{
	Sound,
	Lightning,
	AV,
	Power,
	Extra;

	public static CategoryEnum fromInteger(int x){
		switch (x){
			case 0:
				return Sound;
			case 1:
				return Lightning;
			case 2:
				return AV;
			case 3:
				return Power;
			case 4:
				return Extra;
			default:
				return null;
		}
	}
}
