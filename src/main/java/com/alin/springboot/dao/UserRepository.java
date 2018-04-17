package com.alin.springboot.dao;

import com.alin.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>{

}
