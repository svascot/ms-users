package com.wof.ms.users.controller;

import com.wof.ms.users.domain.interfaces.IUserService;
import com.wof.ms.users.model.User;
import java.net.URI;
import java.util.Arrays;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handle the methods that call the User domain.
 *
 * @author santiago.vasco
 */
@RestController
@RequestMapping(UsersController.API_PATH)
public class UsersController extends AbstractController<IUserService>{

  public static final String API_PATH = "/users";
  /**
   * Call the method that return a list of User objects.
   * @return an List of User.
   */
  @GetMapping
  public ResponseEntity getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity get(@RequestParam String id) {
    try{
      return ResponseEntity.ok(service.get(Integer.valueOf(id)));
    }catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity create(@RequestBody User user){
    final URI uri = URI.create(API_PATH + "/" +service.create(user).getId());
    return ResponseEntity.created(uri).build();
  }

  @PutMapping
  public ResponseEntity update(@RequestBody User user){
    final URI uri = URI.create(API_PATH + "/" +service.update(user).getId());
    return ResponseEntity.ok().body(uri);
  }
}
