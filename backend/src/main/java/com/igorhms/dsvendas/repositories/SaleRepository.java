package com.igorhms.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.igorhms.dsvendas.dto.SaleSuccessDTO;
import com.igorhms.dsvendas.dto.SaleSumDTO;
import com.igorhms.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

	@Query("SELECT new com.igorhms.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))   "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.igorhms.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))   "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> sucessGroupedBySeller();
}
