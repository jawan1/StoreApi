package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.exc.NoSuchProductException;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;

@Repository
public class ProductRepositoryImpl implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void updateProduct(int idProduct, Product product) {
		String query = "UPDATE Product p SET "
				+ "p.name = :name, "
				+ "p.country = :country, "
				+ "p.price = :price "
				+ "WHERE p.idProduct = :idProduct";
		
		entityManager.createQuery(query)
				.setParameter("name", product.getName())
				.setParameter("country", product.getCountry())
				.setParameter("price", product.getPrice())
				.setParameter("idProduct", idProduct)
				.executeUpdate();
	}

	@Override
	public void addShop(int idProduct, Shop shop) {
		Product product = entityManager.find(Product.class, idProduct);
		if (product != null) {
			shop.setProduct(product);
			entityManager.persist(shop);
		}
		else {
			throw new NoSuchProductException("There is no such a product.");
		}
	}
}
