package com.example.demo.controller;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductEntity;
import com.example.demo.serviceImpl.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@PostMapping(value="/products",consumes="application/json")
	public ProductEntity addProduct(@RequestBody ProductEntity product) {
		productServiceImpl.addProduct(product);
		return product;
	}
	
	@GetMapping(value = "/products")
	public List<ProductEntity> findAllProducts(){
		return productServiceImpl.findAllProducts();
	}
	
	@GetMapping(value="/products/{id}")
	public Optional<ProductEntity> findProductById(@PathVariable("id") Integer productId) {
		return productServiceImpl.findProductById(productId);
	}
	
	@PutMapping(value="/products",consumes="application/json")
	public ProductEntity updateProduct(@RequestBody ProductEntity product) {
		 productServiceImpl.updateProduct(product);
		 return product;
	}
	
	@RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
	public String deleteProductById(@PathVariable("id") Integer productId) {
		productServiceImpl.deleteProductById(productId);
		return "Product Deleted!!!";
	}
}