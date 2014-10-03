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

/**
 * @author ReusenIT
 *
 */
@Entity
public class Klant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String naam;

	private String alias;

	@Email
	private String emailAdres;

	private String telefoonnr;

	@Embedded
	@Valid
	private Adres adres = new Adres();

	@ManyToOne(optional=false)
	private Account account;

	@JoinColumn(name = "klant_id")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Factuur> facturen = new ArrayList<Factuur>();

	/*
	 * Constructor without arguments
	 */
	public Klant() {
		super();
	}

	/*
	 * Constructor which takes an {@link #Account} argument
	 */
	public Klant(Account account) {
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

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
