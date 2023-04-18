package EMC.Web.emc.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client implements Serializable{
	
@Id
private Long numClient;
private String nomClient;
private String prenomClient;
private String numeroTelephone;
private String mailClient;


@OneToOne(mappedBy = "client")
private Compte compte;

@OneToMany(mappedBy = "clientCh")
private Set<Cheque> cheques;

@ManyToOne
private Agence agence;

public Client(Long numClient, String nomClient, String prenomClient, String numeroTelephone, String mailClient,
		Compte compte, Set<Cheque> cheques, Agence agence) {
	super();
	this.numClient = numClient;
	this.nomClient = nomClient;
	this.prenomClient = prenomClient;
	this.numeroTelephone = numeroTelephone;
	this.mailClient = mailClient;
	this.compte = compte;
	this.cheques = cheques;
	this.agence = agence;
}

public Client() {
	super();
}

public Long getNumClient() {
	return numClient;
}

public void setNumClient(Long numClient) {
	this.numClient = numClient;
}

public String getNomClient() {
	return nomClient;
}

public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}

public String getPrenomClient() {
	return prenomClient;
}

public void setPrenomClient(String prenomClient) {
	this.prenomClient = prenomClient;
}

public String getNumeroTelephone() {
	return numeroTelephone;
}

public void setNumeroTelephone(String numeroTelephone) {
	this.numeroTelephone = numeroTelephone;
}

public String getMailClient() {
	return mailClient;
}

public void setMailClient(String mailClient) {
	this.mailClient = mailClient;
}

public Compte getCompte() {
	return compte;
}

public void setCompte(Compte compte) {
	this.compte = compte;
}

public Set<Cheque> getCheques() {
	return cheques;
}

public void setCheques(Set<Cheque> cheques) {
	this.cheques = cheques;
}

public Agence getAgence() {
	return agence;
}

public void setAgence(Agence agence) {
	this.agence = agence;
}

@Override
public String toString() {
	return "Client [numClient=" + numClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
			+ ", numeroTelephone=" + numeroTelephone + ", mailClient=" + mailClient + ", compte=" + compte
			+ ", cheques=" + cheques + ", agence=" + agence + "]";
}


}
