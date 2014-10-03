package nl.reusenit.simpelfactureren.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author ReusenIT
 *
 */
@Entity
public class FactuurRegel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String omschrijving;
	private int uren;
	private double tarief;
	private double stukPrijs;
	private int aantal;
	private double btw;
	private double bedragExcl;
	private double bedragIncl;
	
	@ManyToOne(optional=false)
	private Factuur factuur;

	/*
	 * Constructor without arguments
	 */	
	public FactuurRegel() {
		super();
	}

	/*
	 * Constructor which takes an {@link #Factuur} argument
	 */
	public FactuurRegel(Factuur factuur) {
		super();
		this.factuur = factuur;
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

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public int getUren() {
		return uren;
	}

	public void setUren(int uren) {
		this.uren = uren;
	}

	public double getTarief() {
		return tarief;
	}

	public void setTarief(double tarief) {
		this.tarief = tarief;
	}

	public double getStukPrijs() {
		return stukPrijs;
	}

	public void setStukPrijs(double stukPrijs) {
		this.stukPrijs = stukPrijs;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public double getBtw() {
		return btw;
	}

	public void setBtw(double btw) {
		this.btw = btw;
	}

	public double getBedragExcl() {
		return bedragExcl;
	}

	public void setBedragExcl(double bedragExcl) {
		this.bedragExcl = bedragExcl;
	}

	public double getBedragIncl() {
		return bedragIncl;
	}

	public void setBedragIncl(double bedragIncl) {
		this.bedragIncl = bedragIncl;
	}

	public Factuur getFactuur() {
		return factuur;
	}

	public void setFactuur(Factuur factuur) {
		this.factuur = factuur;
	}

}
