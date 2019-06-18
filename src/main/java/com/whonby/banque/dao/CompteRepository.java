package com.whonby.banque.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.whonby.banque.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{
      
	@Query("SELECT c FROM Compte c WHERE c.numCompte = :x")
	public Compte getCompte(@Param("x") String code);
}
