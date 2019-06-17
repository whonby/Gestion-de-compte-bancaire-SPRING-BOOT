package com.whonby.banque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.whonby.banque.entity.Operation;

public interface OperationRepository extends JpaRepository<Operation, String> {
    
	@Query("select o from Operation o where o.compte.numCompte=:x order by o.dateCreation desc")
	public Page<Operation> listeOperation(@Param("x")String codeCpte,Pageable pageable);
	
}
