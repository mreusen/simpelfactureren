package nl.reusenit.simpelfactureren.web.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Adres;
import nl.reusenit.simpelfactureren.domain.Bedrijf;
import nl.reusenit.simpelfactureren.service.BedrijfService;
import nl.reusenit.simpelfactureren.validation.BedrijfValidator;
import nl.reusenit.simpelfactureren.web.method.support.SessionAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author ReusenIT
 *
 */
@Controller
@RequestMapping("bedrijf/detail")
@SessionAttributes(types = Account.class)
public class BedrijfController {

	@Autowired
	private BedrijfService bedrijfService;

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
		binder.setValidator(new BedrijfValidator());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model,
			@SessionAttribute(value = LoginController.ACCOUNT_ATTRIBUTE, exposeAsModelAttribute = false) Account account) {
		List<Bedrijf> bedrijven = this.bedrijfService.findByAccount(account);
		Bedrijf bedrijf = new Bedrijf();
		if (bedrijven.size() != 0) {
			bedrijf = this.bedrijfService.findByAccount(account).get(0);
		} else {
			bedrijf.setAdres(new Adres());
			Locale locale = new Locale("nl", "NL");
			bedrijf.getAdres().setLand(locale.getCountry());
		}
		model.addAttribute(bedrijf);
		return "bedrijf/detail";
	}

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(@Valid @ModelAttribute Bedrijf bedrijf, BindingResult result,
			@SessionAttribute(value = LoginController.ACCOUNT_ATTRIBUTE, exposeAsModelAttribute = false) Account account) {
		if (result.hasErrors()) {
			return "bedrijf/detail";
		}
		bedrijf.setAccount(account);
		this.bedrijfService.save(bedrijf);
		return "redirect:/bedrijf/detail";
	}

}
