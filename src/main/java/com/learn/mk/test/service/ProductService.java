package com.learn.mk.test.service;

import java.util.List;

import com.learn.mk.test.entity.Product;

public interface ProductService {

	public Product saveProduct(Product product);

	public Product getProductById(Long productId);

	public Product getProductByName(String productName);
	
	public List<Product> getProducts();

	public List<Product> saveProducts(List<Product> products);

	public Product updateProduct(Product product);

	public String deleteProduct(Long productId);

}
