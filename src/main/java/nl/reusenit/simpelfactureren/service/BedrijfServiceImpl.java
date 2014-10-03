package nl.reusenit.simpelfactureren.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Bedrijf;
import nl.reusenit.simpelfactureren.repository.BedrijfRepository;

/**
 * @author ReusenIT
 *
 */
@Service
@Transactional(readOnly=true)
public class BedrijfServiceImpl implements BedrijfService {

	@Autowired
	private BedrijfRepository bedrijfRepository;

	@Override
	public Bedrijf findById(Long id) {
		Bedrijf bedrijf = this.bedrijfRepository.findById(id);
		return bedrijf;
	}

	@Override
	@Transactional(readOnly=false)
	public Bedrijf save(Bedrijf bedrijf) {
		return this.bedrijfRepository.save(bedrijf);
	}

	@Override
	public List<Bedrijf> findByAccount(Account account) {
		return this.bedrijfRepository.findByAccount(account);
	}
/*
	@Override
	public Bedrijf findStandaardBedrijf(Account account) {
		Bedrijf bedrijf = this.bedrijfRepository.findStandaardBedrijf(account);
		return bedrijf;
	}
*/
}
