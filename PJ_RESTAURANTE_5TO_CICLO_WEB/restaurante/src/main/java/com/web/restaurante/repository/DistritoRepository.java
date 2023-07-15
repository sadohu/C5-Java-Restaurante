package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {

}
