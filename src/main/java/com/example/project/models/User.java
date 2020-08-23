package com.example.project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;


  private String username;
  private String password;
  private String email;
  private String birthday;
  private String type;
  private Integer likes = 0;
  private String lover;

  @OneToMany(mappedBy = "owner")
  private List<Product> products = new ArrayList<>();

  @OneToMany(mappedBy = "reviewer")
  private List<Review> reviews = new ArrayList<>();



  @ManyToMany
  @JoinTable(
          name="favorites",
          joinColumns = @JoinColumn(name="USER_ID", referencedColumnName = "ID"),
          inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"))
  private List<Product> favoriteProducts;


  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public List<Product> getFavoriteProducts() {
    return favoriteProducts;
  }

  public void setFavoriteProducts(List<Product> favoriteProducts) {
    this.favoriteProducts = favoriteProducts;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void products(Product course)
  {this.products.add(course);
    if(course.getOwner() != this) {
      course.setOwner(this);
    }}


  public Integer getLikes() {
    return likes;
  }

  public void setLikes(Integer likes) {
    this.likes = likes;
  }

  public String getLover() {
    return lover;
  }

  public void setLover(String lover) {
    this.lover = lover;
  }

  public void addReviews(Review review) {
    this.reviews.add(review);
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getBirthday() {
    return birthday;
  }

  public void addProduct(Product p) {
    products.add(p);
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
