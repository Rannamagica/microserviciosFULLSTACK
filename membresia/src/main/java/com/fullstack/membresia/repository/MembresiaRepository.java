package com.fullstack.membresia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.membresia.model.Membresia;

public interface MembresiaRepository extends JpaRepository<Membresia, Long> {

}
