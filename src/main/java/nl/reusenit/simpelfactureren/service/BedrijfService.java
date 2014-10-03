package nl.reusenit.simpelfactureren.service;

import java.util.List;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Bedrijf;

/**
 * @author ReusenIT
 *
 */
public interface BedrijfService {

	Bedrijf findById(Long id);

	List<Bedrijf> findByAccount(Account account);
	
//	Bedrijf findStandaardBedrijf(Account account);

	Bedrijf save(Bedrijf bedrijf);

}
