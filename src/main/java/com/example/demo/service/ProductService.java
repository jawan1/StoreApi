package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ProductRepository;
import com.example.demo.exc.NoSuchProductException;
import com.example.demo.model.Message;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;

@Service
public class ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Product getOneProduct(int id) {
		Optional <Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new NoSuchProductException("There is no such a product.");
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Message deleteProduct (int id) {
		try {
			productRepository.deleteById(id);
			return new Message("Product is deleted.");
		}
		catch (EmptyResultDataAccessException exc) {
			throw new NoSuchProductException("There is no such a product to delete.");
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Message addProduct(Product product) {
		productRepository.save(product);
		return new Message("Product is added.");
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Message updateProduct(int idProduct, Product product) {
		productRepository.updateProduct(idProduct, product);
		return new Message("Product is updated.");
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Message addShop(int idProduct, Shop shop) {
		productRepository.addShop(idProduct, shop);
		return new Message("Shop is added.");
	}
	
}
