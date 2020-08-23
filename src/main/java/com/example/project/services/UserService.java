package com.example.project.services;

import com.example.project.models.User;
import com.example.project.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
  @Autowired
  UserRepository repository;
  public User createUser(User user) {
    return repository.save(user);
  }

  public User findUserById(Integer id) {
    return repository.findUserById(id);
  }

  public User findUserByCredentials(String username, String password) {
    return repository.findUserByCredentials(username, password);
  }
  public User findUserByUsername(String username) {
    return repository.findUserByUsername(username);
  }

  public User updateUser(Integer id, User updatedUser){
    User user = repository.findUserById(id);
    user.setUsername(updatedUser.getUsername());
    user.setPassword(updatedUser.getPassword());
    user.setEmail(updatedUser.getEmail());
    user.setBirthday(updatedUser.getBirthday());
    user.setProducts(updatedUser.getProducts());
    repository.save(user);
    return user;
  }

  public User updateLikes(Integer id, User updatedUser) {
    User user = repository.findUserById(id);
    user.setLikes(updatedUser.getLikes());
    user.setLover(updatedUser.getLover());
    return repository.save(user);
  }
}