package nl.reusenit.simpelfactureren.web.controller;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import nl.reusenit.simpelfactureren.domain.Klant;
import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.KlantSearchCriteria;
import nl.reusenit.simpelfactureren.service.KlantService;
import nl.reusenit.simpelfactureren.web.method.support.SessionAttribute;

import org.hibernate.event.service.spi.DuplicationStrategy.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author ReusenIT
 *
 */
@Controller
@SessionAttributes(types = Account.class)
public class KlantSearchController {

	@Autowired
	private KlantService klantService;

	private Boolean klantenAanwezig = false;

	@ModelAttribute
	public KlantSearchCriteria criteria() {
		return new KlantSearchCriteria();
	}

	@ModelAttribute("countries")
	public Map<String, String> countries(Locale currentLocale) {
		Map<String, String> countries = new TreeMap<String, String>();
		for (Locale locale : Locale.getAvailableLocales()) {
			countries.put(locale.getCountry(), locale.getDisplayCountry(currentLocale));
		}
		return countries;
	}
/*
	@RequestMapping(value = "/klant/search", method = { RequestMethod.GET })
	public Collection<Klant> list(Model model, KlantSearchCriteria criteria, 
			@SessionAttribute(value = LoginController.ACCOUNT_ATTRIBUTE, exposeAsModelAttribute = true) Account account) {
		return this.klantService.findByCriteria(criteria, account);
	}
*/	
	@RequestMapping(value = "/klant/search", method = { RequestMethod.GET })
	public String list(Model model, KlantSearchCriteria criteria, @RequestParam (required = false) String action,
			@SessionAttribute(value = LoginController.ACCOUNT_ATTRIBUTE, exposeAsModelAttribute = false) Account account) {
		System.out.println("action: " + action);
		if (action != null) {
			return "redirect:/klant/detail/0";
		}
		Collection<Klant> klanten = this.klantService.findByCriteria(criteria, account);
		if (klanten.size() != 0 || klantenAanwezig) {
			model.addAttribute(klanten);
			klantenAanwezig = true;
			return "klant/search";
		} else {
			return "redirect:/klant/detail/0";
		}
	}
}
