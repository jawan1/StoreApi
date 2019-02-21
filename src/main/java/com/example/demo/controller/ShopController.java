package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;
import com.example.demo.service.ShopService;

@RestController
@RequestMapping("/shop")
@CrossOrigin(origins = "http://localhost:4200")
public class ShopController {

	private ShopService shopService;
	
	@Autowired
	public ShopController(ShopService shopService) {
		this.shopService = shopService;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> deleteShop (@PathVariable("id") int id) {
		return new ResponseEntity<Message>(shopService.deleteShop(id), HttpStatus.OK);
	}
}
