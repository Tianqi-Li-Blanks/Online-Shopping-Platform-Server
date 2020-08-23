package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String productName;
  private Double price;
  private String details;

  @ManyToOne
  @JsonIgnore
  private User owner;


  @ManyToMany(mappedBy = "favoriteProducts")
  @JsonIgnore
  public List<User> favoriteUsers;

  public List<User> getFavoriteUsers() {
    return favoriteUsers;
  }

  public void setFavoriteUsers(List<User> favoriteUsers) {
    this.favoriteUsers = favoriteUsers;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
    if (!owner.getProducts().contains(this)){
      owner.getProducts().add(this);
    }
  }

  public Double getPrice() {
    return price;
  }

  public String getProductName() {
    return productName;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getDetails() {
    return details;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
  
  public Integer getId() {
    return id;
  }
}
