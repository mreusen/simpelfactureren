package nl.reusenit.simpelfactureren.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ReusenIT
 *
 */
@Embeddable
public class Adres implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String straat;

	@NotEmpty
	private String huisnr;

	private String huisnrToev;

	@NotEmpty
	private String postcode;

	@NotEmpty
	private String plaats;

	@NotEmpty
	private String land;

	public Adres() {
		super();
	}

	public Adres (Adres source) {
		this.straat = source.straat;
		this.huisnr = source.huisnr;
		this.huisnrToev = source.huisnrToev;
		this.postcode = source.postcode;
		this.plaats = source.plaats;
		this.land = source.land;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisnr() {
		return huisnr;
	}

	public void setHuisnr(String huisnr) {
		this.huisnr = huisnr;
	}

	public String getHuisnrToev() {
		return huisnrToev;
	}

	public void setHuisnrToev(String huisnrToev) {
		this.huisnrToev = huisnrToev;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

}
