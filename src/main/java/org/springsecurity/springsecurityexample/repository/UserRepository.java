package org.springsecurity.springsecurityexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springsecurity.springsecurityexample.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
