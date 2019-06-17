package com.whonby.banque.dao;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.whonby.banque.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
