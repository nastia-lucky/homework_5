package com.otus.homeWorkStub.controllers;

import com.otus.homeWorkStub.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {


  HashMap<Long, UserModel> users = new HashMap<Long, UserModel>();

  @GetMapping(value = "/users/get/all")
  public List<Long> getAllUsers() {
    return new ArrayList<>(users.keySet());
  }

  @GetMapping(value = "/users/get/{id}")
  public UserModel getSingleUser(@PathVariable Long id) {
    if (users.keySet().isEmpty() || !users.keySet().contains(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return users.get(id);
  }

  @DeleteMapping(value = "/users/{id}")
  public void deleteUser(@PathVariable Long id) {
    users.remove(id);
  }

  @PostMapping(value = "/users/")
  public Long createUser(@RequestBody UserModel user) {
    if (user.getName() == null || user.getEmail() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    Long id = System.nanoTime();
    users.put(id, user);
    return id;
  }

  @PutMapping(value = "/users/{id}")
  public void updateUser(@RequestBody UserModel user, Long id) {
    if (users.keySet().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    UserModel myUser=users.get(id);
    myUser.setName(user.getName());
    myUser.setCourse(user.getCourse());
    myUser.setEmail(user.getEmail());
    myUser.setAge(myUser.getAge());
  }


}
