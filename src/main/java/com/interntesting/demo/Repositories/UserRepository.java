package com.interntesting.demo.Repositories;

import com.interntesting.demo.Models.User;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository @JaversSpringDataAuditable
public interface UserRepository extends JpaRepository<User, Long>{


}
