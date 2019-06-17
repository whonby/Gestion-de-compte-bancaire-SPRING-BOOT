package com.whonby.banque.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Compte implements Serializable {
	@Id
	private String numCompte;
	private Date dateCreate;
	private double solde;
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	@OneToMany(mappedBy = "compte")
	private Collection<Operation> operations;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String numCompte, Date dateCreate, double solde, Client client) {
		super();
		this.numCompte = numCompte;
		this.dateCreate = dateCreate;
		this.solde = solde;
		this.client = client;
	}
	public String getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
}
