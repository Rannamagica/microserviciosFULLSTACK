package com.fullstack.login.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.login.model.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login , Long> {
}
