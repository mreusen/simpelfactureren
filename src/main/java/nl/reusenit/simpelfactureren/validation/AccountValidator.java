package nl.reusenit.simpelfactureren.validation;

import nl.reusenit.simpelfactureren.domain.Account;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * @author ReusenIT
 *
 */
public class AccountValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return (Account.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "username", "required", new Object[] { "Username" });
		ValidationUtils.rejectIfEmpty(errors, "password", "required", new Object[] { "Password" });
		ValidationUtils.rejectIfEmpty(errors, "emailAdres", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.straat", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.huisnr", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.postcode", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.plaats", "required", new Object[] { "" });
		ValidationUtils.rejectIfEmpty(errors, "adres.land", "required", new Object[] { "" });

		Account account = (Account) target;
		if (!errors.hasFieldErrors("emailAdres")) {
			String email = account.getEmailAdres();
			if (!email.matches(EMAIL_PATTERN)) {
				errors.rejectValue("emailAdres", "invalid");
			}
		}
	}

}
