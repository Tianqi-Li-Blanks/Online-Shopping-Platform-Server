package com.example.project.controllers;

import com.example.project.models.Product;
import com.example.project.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class ProductController {

  @Autowired
  ProductService productService;

  @PutMapping("/api/products/{id}")
  public Product updateProduct(
          @PathVariable("id") Integer ProductId,
          @RequestBody Product updateProduct) {
    return productService.updateProduct(ProductId, updateProduct);
  }

  @PostMapping("/api/users/{uid}")
  public Product createProduct(
          @PathVariable("uid") Integer userId,
          @RequestBody Product newProduct) {
    return productService.createProduct(userId, newProduct);
  }

  @GetMapping("/api/products")
  public List<Product> findAllProduct() {
    return productService.findAllProduct();
  }

  @GetMapping("/api/products/{id}")
  public Product findProductById(
          @PathVariable("id") Integer pid) {
    return productService.findProductById(pid);
  }

  @GetMapping("/api/users/{uid}/products")
  public List<Product> findAllProductByUserId(
          @PathVariable("uid") Integer userId)
          {return productService.findAllProductByUserId(userId);
  }


  @DeleteMapping("/api/products/{id}")
  public List<Product> deleteProduct(
          @PathVariable("id") Integer pid) {
    return productService.deleteProduct(pid);
  }

}
