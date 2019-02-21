package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController (ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET, produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts () {
		return new ResponseEntity<List<Product>> (productService.getAllProducts(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getOneProduct(@PathVariable("id") int id) {
		return new ResponseEntity<Product> (productService.getOneProduct(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> deleteProduct (@PathVariable("id") int id) {
		return new ResponseEntity<Message>(productService.deleteProduct(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> addProduct(@RequestBody Product product) {
		return new ResponseEntity<Message>(productService.addProduct(product), HttpStatus.OK);
	}
	
	@RequestMapping(value="/edition/{idProduct}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateProduct(@PathVariable("idProduct") int idProduct, @RequestBody Product product) {
		return new ResponseEntity<Message>(productService.updateProduct(idProduct, product), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{idProduct}/new/shop", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> addShop(@PathVariable("idProduct") int idProduct ,@RequestBody Shop shop) {
		return new ResponseEntity<Message>(productService.addShop(idProduct, shop), HttpStatus.OK);
	}
 	
}
