package com.example.demo.serviceImpl;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void addProduct(ProductEntity product) {
		productRepository.save(product);
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<ProductEntity> findProductById(Integer productId) {
		return productRepository.findById(productId);
	}

	@Transactional
	@Override
	public void updateProduct(ProductEntity product) {
		ProductEntity productEntity=entityManager.find(ProductEntity.class, product.getProductId());
		productEntity.setProductName(product.getProductName());
		productEntity.setProductPrice(product.getProductPrice());
		productEntity.setProductQuantity(product.getProductQuantity());
		productRepository.save(productEntity);
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
		
	}

	
}