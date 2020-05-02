package com.wof.ms.users.controller;

import com.wof.ms.users.domain.interfaces.IUserService;
import com.wof.ms.users.model.Login;
import com.wof.ms.users.model.User;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

  /**
   * Call the method that return an User object by the ID provided.
   * @param id Is the id of the user.
   * @return an List of User.
   */
  @GetMapping("/{id}")
  public ResponseEntity get(@PathVariable int id) {
    try{
      return ResponseEntity.ok(service.get(id));
    }catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  /**
   * Call the method that create a new User.
   * @param user is the user object that will be created.
   * @return an Uri to find the user.
   */
  @PostMapping
  public ResponseEntity create(@RequestBody User user){
    final URI uri = URI.create(API_PATH + "/" +service.create(user).getId());
    return ResponseEntity.ok().body(uri);
  }

  /**
   * Call the method that pdate an User.
   * @param user is the user object that contains the new information.
   * @return an Uri to find the user.
   */
  @PutMapping
  public ResponseEntity update(@RequestBody User user){
    final URI uri = URI.create(API_PATH + "/" +service.update(user).getId());
    return ResponseEntity.ok().body(uri);
  }

  /**
   * Call the method that return a List of User objects with the Rol provided.
   * @param rol Is the rol of the user.
   * @return an List of User.
   */
  @GetMapping("/rol/{rol}")
  public ResponseEntity get(@PathVariable String rol) {
    try{
      return ResponseEntity.ok(service.getByRol(rol));
    }catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  /**
   * Call the method that Logs the User.
   * @param login is the user information object.
   * @return an Uri to find the user.
   */
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody Login login){
    try{
      return ResponseEntity.ok(service.login(login));
    }catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
