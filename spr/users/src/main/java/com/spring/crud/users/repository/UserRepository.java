package com.spring.crud.users.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.users.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    
}
