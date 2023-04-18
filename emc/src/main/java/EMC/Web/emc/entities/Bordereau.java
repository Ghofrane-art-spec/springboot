package EMC.Web.emc.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Bordereau implements Serializable {
	@Id
	private Long numBordereau;
	private Date dateBordereau;
	@OneToMany(mappedBy = "bordereau",cascade = CascadeType.ALL)
	private Set<Cheque> ListeCh;
	public Bordereau(Long numBordereau, Date dateBordereau, Set<Cheque> listeCh) {
		super();
		this.numBordereau = numBordereau;
		this.dateBordereau = dateBordereau;
		ListeCh = listeCh;
	}
	public Bordereau() {
		super();
	}
	public Long getNumBordereau() {
		return numBordereau;
	}
	public void setNumBordereau(Long numBordereau) {
		this.numBordereau = numBordereau;
	}
	public Date getDateBordereau() {
		return dateBordereau;
	}
	public void setDateBordereau(Date dateBordereau) {
		this.dateBordereau = dateBordereau;
	}
	public Set<Cheque> getListeCh() {
		return ListeCh;
	}
	public void setListeCh(Set<Cheque> listeCh) {
		ListeCh = listeCh;
	}
	@Override
	public String toString() {
		return "Bordereau [numBordereau=" + numBordereau + ", dateBordereau=" + dateBordereau + ", ListeCh=" + getListeCh()
				+ "]";
	}
	
}
