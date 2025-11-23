package com.fullstack.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.register.model.register;

@Repository
public interface ResgisterRepository extends JpaRepository<register, Long> {

}
