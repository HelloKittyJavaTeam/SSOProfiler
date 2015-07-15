package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import static it.hellokitty.gt.repository.utils.RepositoryUtils.persistenceUnitName;
import it.hellokitty.gt.repository.utils.ColumnDirection;
import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.Role;
import it.hellokitty.gt.ssoProfiler.repository.RoleRepository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class RoleRepositoryImpl extends RepositoryUtils<Role> implements RoleRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
	}
	
	@Override
	public List<Role> fetchAll(Integer start, Integer limit, List<ColumnDirection> cdList){
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Role> cq = cb.createQuery(Role.class);
		Root<Role> role = cq.from(Role.class);


		cq.select(role);

		cq = order(cq, cb, role, cdList);

		TypedQuery<Role> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Role fetchById(Long id) throws Exception {
		return getEm().find(Role.class, id);
	}

	@Override
	public void insert(Role elem, String user) throws Exception{
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
	public void delete(Role elem, String user) throws Exception{
		EntityTransaction transaction = null;
		try {
			transaction = getEm().getTransaction();
			transaction.begin();

			if(isAdmin(user) && !elem.isActive()){
				getEm().remove(getEm().find(Role.class, elem.getId()));
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
	public Role update(Role elem, String user) throws Exception {
		Role result = null;

		if(getEm().find(Role.class, elem.getId()) == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - There's no Role with that id.");
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
	public Role merge(Role elem, String user) throws Exception {
		Role result = null;

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
	public List<Role> fetchAll(String user, Integer start, Integer limit, List<ColumnDirection> cdList) throws Exception {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Role> cq = cb.createQuery(Role.class);
		Root<Role> role = cq.from(Role.class);

		if(isAdmin(user)){
			cq.where(cb.equal(role.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(role.get("userCreated"), user),
					cb.equal(role.get("active"), true)));
		}

		cq.select(role);

		cq = order(cq, cb, role, cdList);

		TypedQuery<Role> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Long count(String user) throws Exception{
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Role> role = cq.from(Role.class);

		if(isAdmin(user)){
			cq.where(cb.equal(role.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(role.get("userCreated"), user)),
					cb.equal(role.get("active"), "1"));
		}
		cq.select(cb.count(role));
		
		return getEm().createQuery(cq).getSingleResult();
	}
}
