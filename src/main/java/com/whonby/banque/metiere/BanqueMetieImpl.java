package com.whonby.banque.metiere;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whonby.banque.dao.CompteRepository;
import com.whonby.banque.dao.OperationRepository;
import com.whonby.banque.entity.Compte;
import com.whonby.banque.entity.CompteCourant;
import com.whonby.banque.entity.Operation;
import com.whonby.banque.entity.Retrait;
import com.whonby.banque.entity.Versement;


import org.apache.commons.logging. Log;
import org.apache.commons.logging. LogFactory;
@Service
@Transactional
public class BanqueMetieImpl implements IBanque{
	static Log log = LogFactory.getLog(BanqueMetieImpl.class.getName());
	
@Autowired
private CompteRepository compteRepository;
@Autowired
private OperationRepository operationRepository;
	@Override
	public Compte consulterCompte(String codeCpte) {
		 
		Compte cp=compteRepository.findById(codeCpte).orElseThrow();
		log.info(codeCpte);
		if(cp==null) throw new RuntimeException("compte introuvable");	
    
	 return cp;
	}
	

	@Override
	public void verser(String codeCpte, double montant) {
	Compte cp=consulterCompte(codeCpte);	
	Versement v=new Versement(new Date(), montant, cp);
	operationRepository.save(v);
	cp.setSolde(cp.getSolde()+montant);
	compteRepository.save(cp);
	
	}


	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp=consulterCompte(codeCpte);	
		double faciliteCaise=0;
		if(cp instanceof CompteCourant)
			faciliteCaise=((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+faciliteCaise<montant)
			throw new RuntimeException("Votre sold est insuffisant");	
		Retrait v=new Retrait(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
	}


	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
		
	}


	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		
		return operationRepository.listeOperation(codeCpte, new PageRequest(page, size));
	}
	


}
