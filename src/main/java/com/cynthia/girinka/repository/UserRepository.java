package com.cynthia.girinka.repository;

import com.cynthia.girinka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); //will retrieve a user object by email
}
