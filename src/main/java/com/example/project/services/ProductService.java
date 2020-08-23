package com.example.project.services;


import com.example.project.models.Product;
import com.example.project.models.User;
import com.example.project.repositories.ProductRepository;

import com.example.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
  @Autowired
  ProductRepository repository;
  @Autowired
  UserRepository userRepository;

  List<Product> products = new ArrayList<Product>();{
  }

  public Product createProduct(Integer userId, Product product) {
    User user = userRepository.findUserById(userId);
    product.setOwner(user);
    user.addProduct(product);
    return repository.save(product);
  }
  public Product findProductById(Integer id) {
    return repository.findProductById(id);
  }


  public List<Product> findAllProduct() {
    return repository.findAllProducts();
  }

  public List<Product> deleteProduct(Integer pid) {
    repository.deleteById(pid);
    List<Product> result = new ArrayList<Product>();
    return result;
  }

  public List<Product> findAllProductByUserId(Integer uid) {
    User user = userRepository.findUserById(uid);
    List<Product> products = user.getProducts();
    return products;
  }

  //??
  public Product updateProduct(Integer pid, Product updatedProduct){
    Product product = repository.findProductById(pid);
    product.setPrice(updatedProduct.getPrice());
    product.setProductName(updatedProduct.getProductName());
    product.setDetails(updatedProduct.getDetails());
    return repository.save(product);
  }

}