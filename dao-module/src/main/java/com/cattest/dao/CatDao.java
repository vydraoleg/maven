package com.cattest.dao;

import java.util.ArrayList;
import java.util.List;

import com.cattest.api.dao.ICatDao;
import com.cattest.entities.Cat;

public class CatDao implements ICatDao {

	public List<Cat> getCats() {
		List<Cat> cats = new ArrayList<>();
		Cat cat1 = new Cat("Vaska", 5);
		Cat cat2 = new Cat("Murzik", 6);
		cats.add(cat1);
		cats.add(cat2);
		return cats;
	}

}
