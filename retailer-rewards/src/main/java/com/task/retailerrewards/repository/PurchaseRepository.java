package com.task.retailerrewards.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.task.retailerrewards.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
	
	@Query("SELECT b FROM Purchase b WHERE b.purchaseDate >= :startDate and b.purchaseDate <= :endDate")
	List<Purchase> findByPurchaseDate(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
	
//	@Query("SELECT b FROM Bulk_repository b WHERE b.status = :status and b.campStartDate >=CURRENT_DATE and b.campEndDate <= CURRENT_DATE)
//			List<Bulk_repository>findAllByStatusAndCampTypeAndCampStartDateGreaterThanEqualAndCampEndDateLessThanEqual(@Param("status") int status);

}