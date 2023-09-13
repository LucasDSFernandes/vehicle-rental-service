package com.lucasdsf.api.vechiclerental.enums;

import java.util.stream.Stream;

public enum CategoryVehicleEnums {
	COMPACT_HATCH(1, "Compact Hatch"),
	MEDIUM_HATCH(2, "Medium Hatch"),
	VAN(3, "Van"),
	PICKUP(4, "Pickup"),
	SEDAN(5, "Sedan");
	
	private Integer id;
	private String desciption;

	private CategoryVehicleEnums(Integer id, String desciption) {
		this.id = id;
		this.desciption = desciption;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDesciption() {
		return desciption;
	}
	
    public static String[] getNames() {
    	String[] names = new String[values().length];
    	for(int index = 0; index < values().length; index++) {
    		names[index] = values()[index].getDesciption();
    	}
    	return names;
    }
    
    public static CategoryVehicleEnums findById(Integer id) {
		return Stream.of(CategoryVehicleEnums.values())
			.filter(value -> value.getId().equals(id))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(String.format("Categoria %s não localizada.",id)));
	}
    public static CategoryVehicleEnums findByName(String name) {
    	return Stream.of(CategoryVehicleEnums.values())
    			.filter(value -> value.getDesciption().equalsIgnoreCase(name))
    			.findFirst()
    			.orElseThrow(() -> new IllegalArgumentException(String.format("Categoria %s não localizada.", name)));
    }
}
