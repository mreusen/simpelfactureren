package nl.reusenit.simpelfactureren.domain.support;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Adres;
import nl.reusenit.simpelfactureren.domain.Klant;

/**
 * @author ReusenIT
 *
 */
public class KlantBuilder extends EntityBuilder<Klant> {

	@Override
	void initProduct() {
		this.product = new Klant();
	}

	public KlantBuilder adres(String straat, String huisnr, String huisnrToev, 
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

	public KlantBuilder klantGegevens (String naam, String telefoonnr, String emailAdres, String alias) {
		this.product.setNaam(naam);
		this.product.setTelefoonnr(telefoonnr);
		this.product.setEmailAdres(emailAdres);
		this.product.setAlias(alias);
		return this;
	}

	public KlantBuilder account(Account account) {
		this.product.setAccount(account);
		return this;
	}

	@Override
	Klant assembleProduct() {
		return this.product;
	}

	
}
