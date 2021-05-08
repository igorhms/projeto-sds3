package com.igorhms.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igorhms.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
