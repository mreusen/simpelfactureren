package nl.reusenit.simpelfactureren.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author ReusenIT
 *
 */
@Entity
public class Factuur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int factuurnr;
	private String referentie;
	private String periode;
	private java.util.Date factuurDatum;
	private java.util.Date opvoerDatum;
	private java.util.Date wijzigDatum;
	private double factuurBedrag;
	private double btw;
	private double totaalBedrag;
	private Currency currency;
	private int betaalTermijn;
	private byte[] document;

	@ManyToOne(optional=false)
	private Bedrijf bedrijf;
	
	@ManyToOne(optional=false)
	private Klant klant;

	@JoinColumn(name = "factuur_id")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	private List<FactuurRegel> factuurRegels = new ArrayList<FactuurRegel>();

	/*
	 * Constructor without arguments
	 */	
	public Factuur() {
		super();
	}

	/*
	 * Constructor which takes an {@link #Bedrijf and @link #Klant} argument
	 */
	public Factuur(Bedrijf bedrijf, Klant klant) {
		super();
		this.bedrijf = bedrijf;
		this.klant = klant;
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

	public int getFactuurnr() {
		return factuurnr;
	}

	public void setFactuurnr(int factuurnr) {
		this.factuurnr = factuurnr;
	}

	public String getReferentie() {
		return referentie;
	}

	public void setReferentie(String referentie) {
		this.referentie = referentie;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public java.util.Date getFactuurDatum() {
		return factuurDatum;
	}

	public void setFactuurDatum(java.util.Date factuurDatum) {
		this.factuurDatum = factuurDatum;
	}

	public java.util.Date getOpvoerDatum() {
		return opvoerDatum;
	}

	public void setOpvoerDatum(java.util.Date opvoerDatum) {
		this.opvoerDatum = opvoerDatum;
	}

	public java.util.Date getWijzigDatum() {
		return wijzigDatum;
	}

	public void setWijzigDatum(java.util.Date wijzigDatum) {
		this.wijzigDatum = wijzigDatum;
	}

	public double getFactuurBedrag() {
		return factuurBedrag;
	}

	public void setFactuurBedrag(double factuurBedrag) {
		this.factuurBedrag = factuurBedrag;
	}

	public double getBtw() {
		return btw;
	}

	public void setBtw(double btw) {
		this.btw = btw;
	}

	public double getTotaalBedrag() {
		return totaalBedrag;
	}

	public void setTotaalBedrag(double totaalBedrag) {
		this.totaalBedrag = totaalBedrag;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public int getBetaalTermijn() {
		return betaalTermijn;
	}

	public void setBetaalTermijn(int betaalTermijn) {
		this.betaalTermijn = betaalTermijn;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public Bedrijf getBedrijf() {
		return bedrijf;
	}

	public void setBedrijf(Bedrijf bedrijf) {
		this.bedrijf = bedrijf;
	}

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	public List<FactuurRegel> getFactuurRegels() {
		return factuurRegels;
	}

	public void setFactuurRegels(List<FactuurRegel> factuurRegels) {
		this.factuurRegels = factuurRegels;
	}

}
