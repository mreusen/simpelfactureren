package nl.reusenit.simpelfactureren.service;

import java.util.List;

import nl.reusenit.simpelfactureren.config.GlobalConstants;
import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Klant;
import nl.reusenit.simpelfactureren.domain.KlantSearchCriteria;
import nl.reusenit.simpelfactureren.repository.KlantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ReusenIT
 *
 */
@Service
@Transactional(readOnly=true)
public class KlantServiceImpl implements KlantService {

	@Autowired
	private KlantRepository klantRepository;

	@Override
	@Transactional(readOnly=false)
	public Klant save(Klant klant) {
		return this.klantRepository.save(klant);
	}

	@Override
	public Klant findById(long id) {
		return this.klantRepository.findById(id);
	}

	@Override
	public List<Klant> findByAccount(Account account) {
		return this.klantRepository.findByAccount(account);
	}

	@Override
	public List<Klant> findByCriteria(KlantSearchCriteria criteria, Account account) {
		return this.klantRepository.findByCriteria(criteria, account, GlobalConstants.MAX_KLANTEN);
	}

}
