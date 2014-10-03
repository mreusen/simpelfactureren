package nl.reusenit.simpelfactureren.repository;

import java.util.List;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Bedrijf;

/**
 * @author ReusenIT
 *
 */
public interface BedrijfRepository {

	Bedrijf findById(Long id);

	List<Bedrijf> findByAccount(Account account);
	
//	Bedrijf findStandaardBedrijf(Account account);

	Bedrijf save(Bedrijf bedrijf);

}
