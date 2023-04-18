package EMC.Web.emc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cheque implements Serializable{
	@Id
	private Long numCheque;
	private Float montant;
	private String devise;
	private Date dateCréation;
	private Date dateSortie;
	@ManyToOne
	private Bordereau bordereau;
	
	@ManyToOne
	private Client clientCh;
	
	@ManyToOne
	private Banque banque;
	
	@ManyToOne(cascade = CascadeType.ALL)
	User User;

	public Cheque(Long numCheque, Float montant, String devise, Date dateCréation, Date dateSortie, Bordereau bordereau,
			Client clientCh, Banque banque,User user) {
		super();
		this.numCheque = numCheque;
		this.montant = montant;
		this.devise = devise;
		this.dateCréation = dateCréation;
		this.dateSortie = dateSortie;
		this.bordereau = bordereau;
		this.clientCh = clientCh;
		this.banque = banque;
		User = user;
	}

	public Cheque() {
		super();
	}

	public Long getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(Long numCheque) {
		this.numCheque = numCheque;
	}

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public Date getDateCréation() {
		return dateCréation;
	}

	public void setDateCréation(Date dateCréation) {
		this.dateCréation = dateCréation;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Bordereau getBordereau() {
		return bordereau;
	}

	public void setBordereau(Bordereau bordereau) {
		this.bordereau = bordereau;
	}

	public Client getClientCh() {
		return clientCh;
	}

	public void setClientCh(Client clientCh) {
		this.clientCh = clientCh;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	@Override
	public String toString() {
		return "Cheque [numCheque=" + numCheque + ", montant=" + montant + ", devise=" + devise + ", dateCréation="
				+ dateCréation + ", dateSortie=" + dateSortie + ", bordereau=" + bordereau + ", clientCh=" + clientCh
				+ ", banque=" + banque + ", User=" + User + "]";
	}

	
	
	
}
