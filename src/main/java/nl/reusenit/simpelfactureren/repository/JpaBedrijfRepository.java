package nl.reusenit.simpelfactureren.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Bedrijf;

/**
 * @author ReusenIT
 *
 */
@Repository("bedrijfRepository")
public class JpaBedrijfRepository implements BedrijfRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Bedrijf findById(Long id) {
		return this.entityManager.find(Bedrijf.class, id);
	}

	@Override
	public List<Bedrijf> findByAccount(Account account) {
		String hql = "select b from Bedrijf b where b.account=:account";
		TypedQuery<Bedrijf> query = this.entityManager.createQuery(hql, Bedrijf.class);
		query.setParameter("account", account);
		return query.getResultList();
	}
/*
	@Override
	public Bedrijf findStandaardBedrijf(Account account) {
		String hql = "select b from Bedrijf b where b.account=:account and b.standaardBedrijf=true";
		TypedQuery<Bedrijf> query = this.entityManager.createQuery(hql, Bedrijf.class);
		query.setParameter("account", account);
		List<Bedrijf> bedrijven = query.getResultList();
		return bedrijven.size() == 1 ? bedrijven.get(0) : null;
	}
*/
	@Override
	public Bedrijf save(Bedrijf bedrijf) {
		if (bedrijf.getId() != null) {
			return this.entityManager.merge(bedrijf);
		} else {
			this.entityManager.persist(bedrijf);
			return bedrijf;
		}
	}

}
