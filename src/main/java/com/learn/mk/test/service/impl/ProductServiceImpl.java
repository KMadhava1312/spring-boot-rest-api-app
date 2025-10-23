package com.learn.mk.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.mk.test.entity.Product;
import com.learn.mk.test.repositary.ProductRepositary;
import com.learn.mk.test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepositary repositary;

	@Override
	public Product saveProduct(Product product) {
		return repositary.save(product);
	}

	@Override
	public Product getProductById(Long productId) {
		return repositary.findById(productId).orElse(null);
	}

	@Override
	public Product getProductByName(String productName) {
		return repositary.findByName(productName);
	}

	@Override
	public List<Product> saveProducts(List<Product> products) {
		return repositary.saveAll(products);
	}

	@Override
	public Product updateProduct(Product product) {
		Product existingProduct = repositary.findById(product.getId()).orElse(null);
		if (existingProduct != null) {
			existingProduct.setName(product.getName());
			existingProduct.setQuantity(product.getQuantity());
			existingProduct.setPrice(product.getPrice());
		}
		return repositary.save(existingProduct);
	}

	@Override
	public String deleteProduct(Long productId) {
		if (repositary.existsById(productId)) {
			repositary.deleteById(productId);
			return "Product  removed with id" + productId;
		}
		return "Product not found with id:" + productId;

	}

	@Override
	public List<Product> getProducts() {
		return repositary.findAll();
	}

}
