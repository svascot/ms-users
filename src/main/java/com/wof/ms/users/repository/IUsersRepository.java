package com.wof.ms.users.repository;

import com.wof.ms.users.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsersRepository extends MongoRepository<Users, Integer> {

}
