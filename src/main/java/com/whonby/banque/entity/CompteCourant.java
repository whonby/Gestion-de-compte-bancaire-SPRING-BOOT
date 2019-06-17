package com.whonby.banque.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte  {
private double decouvert;

public CompteCourant() {
	
}

public CompteCourant(String numCompte, Date dateCreate, double solde, Client client, double decouvert) {
	
	this.decouvert = decouvert;
}

public double getDecouvert() {
	return decouvert;
}

public void setDecouvert(double decouvert) {
	this.decouvert = decouvert;
}

}
