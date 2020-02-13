package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import com.example.demo.entity.ProductEntity;

public interface ProductService {
	
	public void addProduct(ProductEntity product);
	
	public List<ProductEntity> findAllProducts();
	
	public Optional<ProductEntity> findProductById(Integer productId);
	
	public void updateProduct(ProductEntity product);
	
	public void deleteProductById(Integer productId);
	

}