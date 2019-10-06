package com.bhoj.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhoj.springboot.domain.Login;

/**
 * Login Repository class
 * 
 * @author Bhoj Sao
 *
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

}
