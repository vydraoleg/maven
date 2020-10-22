package com.cattest.services;

import java.util.List;

import com.cattest.api.dao.ICatDao;
import com.cattest.api.servcies.ICatService;
import com.cattest.dao.CatDao;
import com.cattest.entities.Cat;

public class CatService implements ICatService {

	private ICatDao catDao = new CatDao();
	
	public List<Cat> getCats() {
		return catDao.getCats();
	}
}
