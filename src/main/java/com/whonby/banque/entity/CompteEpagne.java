package com.whonby.banque.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@DiscriminatorValue("CE")
public class CompteEpagne extends Compte{
  private double taux;

public CompteEpagne() {
	super();
}

public CompteEpagne(String numCompte, Date dateCreate, double solde, Client client, double taux) {
	super(numCompte, dateCreate, solde, client);
	this.taux = taux;
}

public double getTaux() {
	return taux;
}

public void setTaux(double taux) {
	this.taux = taux;
}
  
}
