package com.salestaxes.data;

import java.util.HashMap;
import java.util.Map;

public class ClassificationMap {
	
	 private static ClassificationMap instance;
	 private Map<String, String> map;
	 
	private ClassificationMap() {
		
		this.map = new HashMap<>();
		
		map.put("chocolate", "food");
		map.put("chocolates", "food");
		map.put("pills", "medical");
		map.put("book", "book");
		
	}

	public static ClassificationMap getInstance() {
		
		if (instance == null) {
            instance = new ClassificationMap();
        }
		
        return instance;
		
	}

	public Map<String, String> getMap() {
		return map;
	}
	
	
	
}
