package nl.reusenit.simpelfactureren.web.controller;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Adres;
import nl.reusenit.simpelfactureren.domain.Klant;
import nl.reusenit.simpelfactureren.service.KlantService;
import nl.reusenit.simpelfactureren.validation.KlantValidator;
import nl.reusenit.simpelfactureren.web.method.support.SessionAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author ReusenIT
 *
 */
@Controller
@RequestMapping(value = "klant/detail/{klantId}")
@SessionAttributes(types = Account.class)
public class KlantController {

	@Autowired
	private KlantService klantService;
	
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
		binder.setValidator(new KlantValidator());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, @PathVariable("klantId") long klantId) {
		Klant klant = new Klant();
		if (klantId != 0) {
			klant = this.klantService.findById(klantId);
		} else {
			klant.setAdres(new Adres());
			Locale locale = new Locale("nl", "NL");
			klant.getAdres().setLand(locale.getCountry());
		}
		model.addAttribute(klant);
		return "klant/detail";
	}

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(@Valid @ModelAttribute Klant klant, BindingResult result,
			@SessionAttribute(value = LoginController.ACCOUNT_ATTRIBUTE, exposeAsModelAttribute = false) Account account) {
		if (result.hasErrors()) {
			return "klant/detail";
		}
		klant.setAccount(account);
		klant = this.klantService.save(klant);
		return "redirect:/klant/detail/" + klant.getId();
	}
}
