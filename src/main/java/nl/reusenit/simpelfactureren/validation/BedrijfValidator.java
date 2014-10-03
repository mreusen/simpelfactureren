package nl.reusenit.simpelfactureren.validation;

import nl.reusenit.simpelfactureren.domain.Bedrijf;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * @author ReusenIT
 *
 */
public class BedrijfValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return (Bedrijf.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "naam", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "bankrelatie", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "bankRekeningnr", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "ibannr", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "kvknr", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "btwnr", "required", new Object[] { "" });

		ValidationUtils.rejectIfEmpty(errors, "emailAdres", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.straat", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.huisnr", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.postcode", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.plaats", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.land", "required", new Object[] { "" });

		Bedrijf bedrijf = (Bedrijf) target;
		if (!errors.hasFieldErrors("emailAdres")) {
			String email = bedrijf.getEmailAdres();
			if (!email.matches(EMAIL_PATTERN)) {
				errors.rejectValue("emailAdres", "invalid");
			}
		}
	}

}
