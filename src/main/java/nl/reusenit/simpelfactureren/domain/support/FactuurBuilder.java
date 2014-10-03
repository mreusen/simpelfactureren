package nl.reusenit.simpelfactureren.domain.support;

import java.util.Currency;
import java.util.Date;
import java.util.Locale;

import nl.reusenit.simpelfactureren.domain.Bedrijf;
import nl.reusenit.simpelfactureren.domain.Factuur;
import nl.reusenit.simpelfactureren.domain.Klant;

/**
 * @author ReusenIT
 *
 */
public class FactuurBuilder extends EntityBuilder<Factuur> {

	@Override
	void initProduct() {
		this.product = new Factuur();
	}

	public FactuurBuilder bedrijf(Bedrijf bedrijf) {
		this.product.setBedrijf(bedrijf);
		return this;
	}

	public FactuurBuilder klant(Klant klant) {
		this.product.setKlant(klant);
		return this;
	}

	public FactuurBuilder gegevens(Date factuurDatum, String referentie, String periode, double factuurBedrag, int betaalTermijn, int factuurnr) {
		this.product.setPeriode(periode);
		this.product.setFactuurBedrag(factuurBedrag);
		this.product.setBtw(21);
		this.product.setTotaalBedrag(factuurBedrag * 1.21);
		this.product.setBetaalTermijn(betaalTermijn);
		this.product.setCurrency(Currency.getInstance(Locale.GERMAN));
		this.product.setFactuurDatum(factuurDatum);
		this.product.setFactuurnr(factuurnr);
		this.product.setReferentie(referentie);
		this.product.setOpvoerDatum(new Date());
		return this;
	}

	@Override
	Factuur assembleProduct() {
		return this.product;
	}

	
}
