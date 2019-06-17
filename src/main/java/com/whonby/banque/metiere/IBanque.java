package com.whonby.banque.metiere;

import org.springframework.data.domain.Page;

import com.whonby.banque.entity.Compte;
import com.whonby.banque.entity.Operation;

public interface IBanque {
	
	public Compte consulterCompte(String codeCpte);
	public void verser(String codeCpte,double montant);
	public void retirer(String codeCpte,double montant);
	public void virement(String codeCpte1, String codeCpte2,double montant);
	public Page<Operation> listOperation(String codeCpte,int page,int size);
}
