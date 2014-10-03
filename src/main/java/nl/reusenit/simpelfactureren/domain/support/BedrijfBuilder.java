/**
 * 
 */
package nl.reusenit.simpelfactureren.domain.support;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Adres;
import nl.reusenit.simpelfactureren.domain.Bedrijf;

/**
 * @author ReusenIT
 *
 */
public class BedrijfBuilder extends EntityBuilder<Bedrijf> {

	@Override
	void initProduct() {
		this.product = new Bedrijf();
	}

	public BedrijfBuilder adres(String straat, String huisnr, String huisnrToev, 
			String postcode, String plaats, String land) {
		Adres adres = new Adres();
		adres.setStraat(straat);
		adres.setHuisnr(huisnr);
		adres.setHuisnrToev(huisnrToev);
		adres.setPostcode(postcode);
		adres.setPlaats(plaats);
		adres.setLand(land);
		
		this.product.setAdres(adres);
		return this;
	}

	public BedrijfBuilder bedrijfGegevens (String naam, String kvknr, String telefoonnr, String emailAdres, Boolean standaardBedrijf) {
		this.product.setNaam(naam);
		this.product.setKvknr(kvknr);
		this.product.setTelefoonnr(telefoonnr);
		this.product.setEmailAdres(emailAdres);
//		this.product.setStandaardBedrijf(standaardBedrijf);
		return this;
	}

	public BedrijfBuilder financieleGegevens (String bankrelatie, String bankreknr, String btwnr, String ibannr) {
		this.product.setBankrelatie(bankrelatie);
		this.product.setBtwnr(btwnr);
		this.product.setBankRekeningnr(bankreknr);
		this.product.setIbannr(ibannr);
		return this;
	}
	public BedrijfBuilder account(Account account) {
		this.product.setAccount(account);
		return this;
	}

	@Override
	Bedrijf assembleProduct() {
		return this.product;
	}

	
}
