package nl.reusenit.simpelfactureren.validation;

import nl.reusenit.simpelfactureren.domain.Klant;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * @author ReusenIT
 *
 */
public class KlantValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return (Klant.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "naam", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.straat", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.huisnr", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.postcode", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.plaats", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.land", "required", new Object[] { "" });
//		ValidationUtils.rejectIfEmpty(errors, "emailAdres", "required", new Object[] { "" });
//		ValidationUtils.rejectIfEmpty(errors, "alias", "required", new Object[] { "" });

		Klant klant = (Klant) target;
		if (!errors.hasFieldErrors("emailAdres")) {
			String email = klant.getEmailAdres();
			if (email != null && email != "") {
				if (!email.matches(EMAIL_PATTERN)) {
					errors.rejectValue("emailAdres", "invalid");
				}
			}
		}
	}

}
