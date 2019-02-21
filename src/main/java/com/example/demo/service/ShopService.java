package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShopRepository;
import com.example.demo.exc.NoSuchShopException;
import com.example.demo.model.Message;

@Service
public class ShopService {

	private ShopRepository shopRepository;
	
	@Autowired
	public ShopService(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}
	
	public Message deleteShop (int id) {
		try {
			shopRepository.deleteById(id);
			return new Message("Shop is deleted.");
		}
		catch (EmptyResultDataAccessException exc) {
			throw new NoSuchShopException("There is no such a shop to delete.");
		}
	}
	
}
