package com.cattest.main;

import java.util.List;

import com.cattest.api.servcies.ICatService;
import com.cattest.entities.Cat;
import com.cattest.services.CatService;

public class Main {

	public static void main(String[] args) {
		
		ICatService catService = new CatService();
		List<Cat> getCats = catService.getCats();
		
		getCats.stream()
				.forEach(System.out::println);
	}
}
