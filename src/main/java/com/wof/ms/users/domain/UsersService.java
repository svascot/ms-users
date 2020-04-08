package com.wof.ms.users.domain;

import com.wof.ms.users.domain.interfaces.IUserService;
import com.wof.ms.users.model.User;
import com.wof.ms.users.repository.IUsersRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUserService {

  @Autowired
  private IUsersRepository repository;

  @Override
  public List<User> getAll(){
    return repository.findAll();
  }

  @Override
  public User get(Integer id){
    return repository.findById(id).get();
  }

  @Override
  public User create(User user){
    return repository.insert(user);
  }

  @Override
  public User update(User user){
    return repository.save(user);
  }
}
