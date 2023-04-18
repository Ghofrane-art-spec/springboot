package EMC.Web.emc.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Banque implements Serializable{
	@Id
	private Long codeBanque;
	private String nomAgence;
	private Long swiftBanque;
	private Long tarifBanque;
	private Long fraiBanque;
	
	@OneToMany(mappedBy = "banque")
	private Set<Cheque> cheque;

	public Banque(Long codeBanque, String nomAgence, Long swiftBanque, Long tarifBanque, Long fraiBanque,
			Set<Cheque> cheque) {
		super();
		this.codeBanque = codeBanque;
		this.nomAgence = nomAgence;
		this.swiftBanque = swiftBanque;
		this.tarifBanque = tarifBanque;
		this.fraiBanque = fraiBanque;
		this.cheque = cheque;
	}

	public Banque() {
		super();
	}

	public Long getCodeBanque() {
		return codeBanque;
	}

	public void setCodeBanque(Long codeBanque) {
		this.codeBanque = codeBanque;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public Long getSwiftBanque() {
		return swiftBanque;
	}

	public void setSwiftBanque(Long swiftBanque) {
		this.swiftBanque = swiftBanque;
	}

	public Long getTarifBanque() {
		return tarifBanque;
	}

	public void setTarifBanque(Long tarifBanque) {
		this.tarifBanque = tarifBanque;
	}

	public Long getFraiBanque() {
		return fraiBanque;
	}

	public void setFraiBanque(Long fraiBanque) {
		this.fraiBanque = fraiBanque;
	}

	public Set<Cheque> getCheque() {
		return cheque;
	}

	public void setCheque(Set<Cheque> cheque) {
		this.cheque = cheque;
	}

	@Override
	public String toString() {
		return "Banque [codeBanque=" + codeBanque + ", nomAgence=" + nomAgence + ", swiftBanque=" + swiftBanque
				+ ", tarifBanque=" + tarifBanque + ", fraiBanque=" + fraiBanque + ", cheque=" + cheque + "]";
	}

	

}
