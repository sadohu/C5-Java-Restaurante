package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.MedioPago;

@Repository
public interface MedioPagoRepository extends JpaRepository<MedioPago, Integer>{

}
