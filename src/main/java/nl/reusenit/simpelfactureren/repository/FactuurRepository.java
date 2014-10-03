package nl.reusenit.simpelfactureren.repository;

import java.util.List;

import nl.reusenit.simpelfactureren.domain.Factuur;
import nl.reusenit.simpelfactureren.domain.FactuurSearchCriteria;

/**
 * @author ReusenIT
 *
 */
public interface FactuurRepository {

	Factuur findById(Long id);

	List<Factuur> findByCriteria(FactuurSearchCriteria fsc, int count);
	
	Factuur save(Factuur factuur);
/*	
	List<Factuur> findByBedrijf(Bedrijf bedrijf);
	
	List<Factuur> findByKlant(Klant klant);
*/

}
