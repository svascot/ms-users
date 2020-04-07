package com.wof.ms.users.domain;

import com.wof.ms.users.domain.interfaces.IUserService;
import com.wof.ms.users.model.Users;
import com.wof.ms.users.repository.IUsersRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUserService {

  @Autowired
  private IUsersRepository repository;

  public List<Users> getAll(){
    return repository.findAll();
  }

}
