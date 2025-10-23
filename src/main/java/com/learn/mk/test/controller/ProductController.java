package com.learn.mk.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.mk.test.entity.Product;
import com.learn.mk.test.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> list) {
		return productService.saveProducts(list);

	}
	
	@GetMapping("/all")
	public List<Product> getProducts(){
		return productService.getProducts();
		
	}

	@GetMapping("/name/{name}")
	public Product getProductByName(@PathVariable("name") String productName) {
		return productService.getProductByName(productName);
	}

	@GetMapping("/id/{id}")
	public Product getProductById(@PathVariable("id") Long productId) {
		Product product = null;
		product = productService.getProductById(productId);
		if (product != null) {
			product = productService.getProductById(productId);
		}
		return product;
	}

	@PutMapping("/update/{id}")
	public Product updateProductById(@PathVariable("id") Long productId,@RequestBody Product product) {
		Product existingProduct = productService.getProductById(productId);
		if (existingProduct != null) {
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setQuantity(product.getQuantity());
		}
		return productService.saveProduct(existingProduct);

	}

	@DeleteMapping("/id/{productId}")
	public String deleteProductById(@PathVariable("productId") Long productId) {
		productService.deleteProduct(productId);
		return "Product deleted sussessfully..";
	}
}
