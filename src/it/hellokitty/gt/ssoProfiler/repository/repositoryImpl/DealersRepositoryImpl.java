package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import static it.hellokitty.gt.repository.utils.RepositoryUtils.persistenceUnitName;
import it.hellokitty.gt.repository.utils.ColumnDirection;
import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.Dealers;
import it.hellokitty.gt.ssoProfiler.repository.DealersRepository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DealersRepositoryImpl extends RepositoryUtils<Dealers> implements DealersRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
	}
	
	@Override
	public List<Dealers> fetchAll(Integer start, Integer limit, List<ColumnDirection> cdList){
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Dealers> cq = cb.createQuery(Dealers.class);
		Root<Dealers> geoArea = cq.from(Dealers.class);


		cq.select(geoArea);

		cq = order(cq, cb, geoArea, cdList);

		TypedQuery<Dealers> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Dealers fetchById(Long id) throws Exception {
		return getEm().find(Dealers.class, id);
	}

	@Override
	public void insert(Dealers elem, String user) throws Exception{
		EntityTransaction transaction;

		elem.setUserIns(user);
		elem.setDateIns(new Date());
		elem.setActive(true);

		transaction = getEm().getTransaction();
		try {
			transaction.begin();
			getEm().persist(elem);
			transaction.commit(); 
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			getEm().clear(); // Clears all the entities from the EntityManager
		}
	}

	@Override 
	public void delete(Dealers elem, String user) throws Exception{
		EntityTransaction transaction = null;
		try {
			transaction = getEm().getTransaction();
			transaction.begin();

			if(isAdmin(user) && !elem.isActive()){
				getEm().remove(getEm().find(Dealers.class, elem.getId()));
			} else {
				elem.setUserMod(user);
				elem.setDateMod(new Date());
				elem.setActive(false);

				getEm().merge(elem);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			getEm().clear(); // Clears all the entities from the EntityManager
		}
	}

	@Override
	public Dealers update(Dealers elem, String user) throws Exception {
		Dealers result = null;

		if(getEm().find(Dealers.class, elem.getId()) == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - There's no Dealers with that id.");
		}

		EntityTransaction transaction = null;
		try {
			transaction = getEm().getTransaction();
			transaction.begin();

			elem.setUserMod(user);
			elem.setDateMod(new Date());
			result = getEm().merge(elem);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			getEm().clear(); // Clears all the entities from the EntityManager
		}
		return result;
	}

	@Override
	public Dealers merge(Dealers elem, String user) throws Exception {
		Dealers result = null;

		EntityTransaction transaction = null;
		try {
			transaction = getEm().getTransaction();
			transaction.begin();

			elem.setUserMod(user);
			elem.setDateMod(new Date());
			result = getEm().merge(elem);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			getEm().clear(); // Clears all the entities from the EntityManager
		}
		return result;
	}

	@Override
	public List<Dealers> fetchAll(String user, Integer start, Integer limit, List<ColumnDirection> cdList) throws Exception {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Dealers> cq = cb.createQuery(Dealers.class);
		Root<Dealers> geoArea = cq.from(Dealers.class);

		if(isAdmin(user)){
			cq.where(cb.equal(geoArea.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(geoArea.get("userCreated"), user),
					cb.equal(geoArea.get("active"), true)));
		}

		cq.select(geoArea);

		cq = order(cq, cb, geoArea, cdList);

		TypedQuery<Dealers> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Long count(String user) throws Exception{
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Dealers> geoArea = cq.from(Dealers.class);

		if(isAdmin(user)){
			cq.where(cb.equal(geoArea.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(geoArea.get("userCreated"), user)),
					cb.equal(geoArea.get("active"), "1"));
		}
		cq.select(cb.count(geoArea));
		
		return getEm().createQuery(cq).getSingleResult();
	}
}
