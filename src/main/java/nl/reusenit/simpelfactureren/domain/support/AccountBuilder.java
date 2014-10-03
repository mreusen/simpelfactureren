package nl.reusenit.simpelfactureren.domain.support;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Adres;
import nl.reusenit.simpelfactureren.domain.Permission;
import nl.reusenit.simpelfactureren.domain.Role;

/**
 * @author ReusenIT
 *
 */
public class AccountBuilder extends EntityBuilder<Account> {

	@Override
	void initProduct() {
		this.product = new Account();
	}

	public AccountBuilder credentials(String username, String password) {
		this.product.setUsername(username);
		this.product.setPassword(DigestUtils.sha256Hex(password + "{" + username + "}"));
		return this;
	}

	public AccountBuilder adres(String straat, String huisnr, String huisnrToev, 
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

	public AccountBuilder roleWithPermissions(Role role, Permission... permissions) {
		this.product.getRoles().add(role);
		
		for (Permission p : permissions) {
			role.getPermissions().add(p);
		}
		return this;
	}

	public AccountBuilder email(String emailAdres) {
		this.product.setEmailAdres(emailAdres);
		return this;
	}

	public AccountBuilder naam(String roepnaam, String naam) {
		this.product.setRoepnaam(roepnaam);
		this.product.setNaam(naam);
		return this;
	}

	public AccountBuilder gebdatum(Date geboorteDatum) {
		this.product.setGeboorteDatum(geboorteDatum);
		return this;
	}

	@Override
	Account assembleProduct() {
		return this.product;
	}

}
