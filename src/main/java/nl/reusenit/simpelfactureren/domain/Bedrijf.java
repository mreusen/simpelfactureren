package nl.reusenit.simpelfactureren.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ReusenIT
 *
 */
@Entity
public class Bedrijf implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String naam;

//	private Boolean standaardBedrijf;

	@NotEmpty
	@Email
	private String emailAdres;

	private String telefoonnr;

	@NotEmpty
	private String bankrelatie;

	@NotEmpty
	private String bankRekeningnr;

	@NotEmpty
	private String ibannr;

	@NotEmpty
	private String kvknr;

	@NotEmpty	
	private String btwnr;

	@Embedded
	@Valid
	private Adres adres = new Adres();

	@ManyToOne(optional=false)
	private Account account;

	@JoinColumn(name = "bedrijf_id")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Factuur> facturen = new ArrayList<Factuur>();

	/*
	 * Constructor without arguments
	 */
	public Bedrijf() {
		super();
	}

	/*
	 * Constructor which takes an {@link #Account} argument
	 */
	public Bedrijf(Account account) {
		super();
		this.account = account;
	}

	/*
	 * Getters and Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
/*
	public Boolean getStandaardBedrijf() {
		return standaardBedrijf;
	}

	public void setStandaardBedrijf(Boolean standaardBedrijf) {
		this.standaardBedrijf = standaardBedrijf;
	}
*/
	public String getEmailAdres() {
		return emailAdres;
	}

	public void setEmailAdres(String emailAdres) {
		this.emailAdres = emailAdres;
	}

	public String getTelefoonnr() {
		return telefoonnr;
	}

	public void setTelefoonnr(String telefoonnr) {
		this.telefoonnr = telefoonnr;
	}

	public String getBankrelatie() {
		return bankrelatie;
	}

	public void setBankrelatie(String bankrelatie) {
		this.bankrelatie = bankrelatie;
	}

	public String getBankRekeningnr() {
		return bankRekeningnr;
	}

	public void setBankRekeningnr(String bankRekeningnr) {
		this.bankRekeningnr = bankRekeningnr;
	}

	public String getIbannr() {
		return ibannr;
	}

	public void setIbannr(String ibannr) {
		this.ibannr = ibannr;
	}

	public String getKvknr() {
		return kvknr;
	}

	public void setKvknr(String kvknr) {
		this.kvknr = kvknr;
	}

	public String getBtwnr() {
		return btwnr;
	}

	public void setBtwnr(String btwnr) {
		this.btwnr = btwnr;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Factuur> getFacturen() {
		return facturen;
	}

	public void setFacturen(List<Factuur> facturen) {
		this.facturen = facturen;
	}

}
