package com.fullstack.posteo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.posteo.model.Posteo;

@Repository
public interface PosteoRepository extends JpaRepository<Posteo,Long> {

}
