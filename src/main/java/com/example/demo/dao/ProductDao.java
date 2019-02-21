package com.example.demo.dao;

import com.example.demo.model.Product;
import com.example.demo.model.Shop;

public interface ProductDao {

	void updateProduct(int idProduct, Product product);
	void addShop (int idProduct, Shop shop);
	
}
