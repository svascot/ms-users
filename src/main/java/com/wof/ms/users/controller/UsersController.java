package com.wof.ms.users.controller;

import com.wof.ms.users.domain.interfaces.IUserService;
import com.wof.ms.users.model.Users;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handle the methods that call the Users domain.
 *
 * @author santiago.vasco
 */
@RestController
@RequestMapping("/users")
public class UsersController extends AbstractController<IUserService>{

  /**
   * Call the method that return a list of Users objects.
   * @return an List of Users.
   */
  @GetMapping
  public List<Users> getAll() {
    return service.getAll();
  }

}
