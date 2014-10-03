package nl.reusenit.simpelfactureren.web.controller;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Adres;
import nl.reusenit.simpelfactureren.service.AccountService;
import nl.reusenit.simpelfactureren.validation.AccountValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ReusenIT
 *
 */
@Controller
@RequestMapping("account/register")
public class RegistrationController {

	@Autowired
	private AccountService accountService;
	
	@ModelAttribute("countries")
	public Map<String, String> countries(Locale currentLocale) {
		Map<String, String> countries = new TreeMap<String, String>();
		for (Locale locale : Locale.getAvailableLocales()) {
			countries.put(locale.getCountry(), locale.getDisplayCountry(currentLocale));
		}
		return countries;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		binder.setValidator(new AccountValidator());
	}

	@RequestMapping(method = RequestMethod.GET)
	@ModelAttribute
	public Account register(Locale currentLocale) {
		Account account = new Account();
		account.setAdres(new Adres());
		Locale locale = new Locale("nl", "NL");
		account.getAdres().setLand(locale.getCountry());
		return account;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT})
	public String handleRegistration(@Valid @ModelAttribute Account account, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "account/register";
		}
		this.accountService.save(account);
		session.setAttribute(LoginController.ACCOUNT_ATTRIBUTE, account);
		return "redirect:/account/account"; // + account.getId();
	}
}
