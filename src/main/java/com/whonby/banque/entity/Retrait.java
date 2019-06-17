package com.whonby.banque.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateCreation, double montant, Compte compte) {
		super(dateCreation, montant, compte);
		// TODO Auto-generated constructor stub
	}

}
