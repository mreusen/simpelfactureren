package nl.reusenit.simpelfactureren.web.controller;

import java.io.Serializable;
import java.util.Currency;

/**
 * @author ReusenIT
 *
 */
public class FactuurForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long bedrijfId;

	private Long klantId;

	private String factuurDatum;

	private String referentie;

	private String omschrijving;

	private String periode;

	private double tarief;

	private Integer aantalUren;

	private double btw;

	private Currency currency;


	public Long getBedrijfId() {
		return bedrijfId;
	}

	public void setBedrijfId(Long bedrijfId) {
		this.bedrijfId = bedrijfId;
	}

	public Long getKlantId() {
		return klantId;
	}

	public void setKlantId(Long klantId) {
		this.klantId = klantId;
	}

	public String getFactuurDatum() {
		return factuurDatum;
	}

	public void setFactuurDatum(String factuurDatum) {
		this.factuurDatum = factuurDatum;
	}

	public String getReferentie() {
		return referentie;
	}

	public void setReferentie(String referentie) {
		this.referentie = referentie;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public double getTarief() {
		return tarief;
	}

	public void setTarief(double tarief) {
		this.tarief = tarief;
	}

	public Integer getAantalUren() {
		return aantalUren;
	}

	public void setAantalUren(Integer aantalUren) {
		this.aantalUren = aantalUren;
	}

	public double getBtw() {
		return btw;
	}

	public void setBtw(double btw) {
		this.btw = btw;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
