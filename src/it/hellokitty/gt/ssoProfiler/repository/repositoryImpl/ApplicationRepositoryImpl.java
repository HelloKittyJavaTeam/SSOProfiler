package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.Application;
import it.hellokitty.gt.ssoProfiler.repository.ApplicationRepository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ApplicationRepositoryImpl extends RepositoryUtils<Application> implements ApplicationRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
	}
	
	@Override
	public List<Application> fetchAll(Integer start, Integer limit, List<ColumnDirection> cdList){
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Application> cq = cb.createQuery(Application.class);
		Root<Application> application = cq.from(Application.class);


		cq.select(application);

		cq = order(cq, cb, application, cdList);

		TypedQuery<Application> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Application fetchById(Long id) throws Exception {
		return getEm().find(Application.class, id);
	}

	@Override
	public void insert(Application elem, String user) throws Exception{
		EntityTransaction transaction;

		elem.setUserCreated(user);
		elem.setCreateDate(new Date());
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
	public void delete(Application elem, String user) throws Exception{
		EntityTransaction transaction = null;
		try {
			transaction = getEm().getTransaction();
			transaction.begin();

			if(isAdmin(user) && !elem.isActive()){
				getEm().remove(getEm().find(Application.class, elem.getId()));
			} else {
				elem.setUserUpdate(user);
				elem.setUpdate(new Date());
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
	public Application update(Application elem, String user) throws Exception {
		Application result = null;

		if(getEm().find(Application.class, elem.getId()) == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - There's no Application with that id.");
		}

		EntityTransaction transaction = null;
		try {
			transaction = getEm().getTransaction();
			transaction.begin();

			elem.setUserUpdate(user);
			elem.setUpdate(new Date());
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
	public Application merge(Application elem, String user) throws Exception {
		Application result = null;

		EntityTransaction transaction = null;
		try {
			transaction = getEm().getTransaction();
			transaction.begin();

			elem.setUserUpdate(user);
			elem.setUpdate(new Date());
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
	public List<Application> fetchAll(String user, Integer start, Integer limit, List<ColumnDirection> cdList) throws Exception {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Application> cq = cb.createQuery(Application.class);
		Root<Application> application = cq.from(Application.class);

		if(isAdmin(user)){
			cq.where(cb.equal(application.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(application.get("userCreated"), user),
					cb.equal(application.get("active"), true)));
		}

		cq.select(application);

		cq = order(cq, cb, application, cdList);

		TypedQuery<Application> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Long count(String user) throws Exception{
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Application> application = cq.from(Application.class);

		if(isAdmin(user)){
			cq.where(cb.equal(application.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(application.get("userCreated"), user)),
					cb.equal(application.get("active"), "1"));
		}
		cq.select(cb.count(application));
		
		return getEm().createQuery(cq).getSingleResult();
	}
}
