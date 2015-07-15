package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.CompanyRole;
import it.hellokitty.gt.ssoProfiler.repository.CompanyRoleRepository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CompanyRoleRepositoryImpl extends RepositoryUtils<CompanyRoleRepository> implements CompanyRoleRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
	}
	
	@Override
	public List<CompanyRole> fetchAll(Integer start, Integer limit, List<ColumnDirection> cdList){
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<CompanyRole> cq = cb.createQuery(CompanyRole.class);
		Root<CompanyRole> companyRole = cq.from(CompanyRole.class);


		cq.select(companyRole);

		cq = order(cq, cb, companyRole, cdList);

		TypedQuery<CompanyRole> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public CompanyRole fetchById(Long id) throws Exception {
		return getEm().find(CompanyRole.class, id);
	}

	@Override
	public void insert(CompanyRole elem, String user) throws Exception{
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
	public void delete(CompanyRole elem, String user) throws Exception{
		EntityTransaction transaction = null;
		try {
			transaction = getEm().getTransaction();
			transaction.begin();

			if(isAdmin(user) && !elem.isActive()){
				getEm().remove(getEm().find(CompanyRole.class, elem.getId()));
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
	public CompanyRole update(CompanyRole elem, String user) throws Exception {
		CompanyRole result = null;

		if(getEm().find(CompanyRole.class, elem.getId()) == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - There's no CompanyRole with that id.");
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
	public CompanyRole merge(CompanyRole elem, String user) throws Exception {
		CompanyRole result = null;

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
	public List<CompanyRole> fetchAll(String user, Integer start, Integer limit, List<ColumnDirection> cdList) throws Exception {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<CompanyRole> cq = cb.createQuery(CompanyRole.class);
		Root<CompanyRole> companyRole = cq.from(CompanyRole.class);

		if(isAdmin(user)){
			cq.where(cb.equal(companyRole.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(companyRole.get("userCreated"), user),
					cb.equal(companyRole.get("active"), true)));
		}

		cq.select(companyRole);

		cq = order(cq, cb, companyRole, cdList);

		TypedQuery<CompanyRole> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Long count(String user) throws Exception{
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<CompanyRole> companyRole = cq.from(CompanyRole.class);

		if(isAdmin(user)){
			cq.where(cb.equal(companyRole.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(companyRole.get("userCreated"), user)),
					cb.equal(companyRole.get("active"), "1"));
		}
		cq.select(cb.count(companyRole));
		
		return getEm().createQuery(cq).getSingleResult();
	}
}
