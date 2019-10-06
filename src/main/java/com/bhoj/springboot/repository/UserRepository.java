package com.bhoj.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhoj.springboot.domain.User;

/**
 * User Repository class
 * 
 * @author Bhoj Sao
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
