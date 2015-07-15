package it.hellokitty.gt.ssoProfiler.repository.repositoryImpl;

import static it.hellokitty.gt.repository.utils.RepositoryUtils.persistenceUnitName;
import it.hellokitty.gt.repository.utils.ColumnDirection;
import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.ssoProfiler.entity.User;
import it.hellokitty.gt.ssoProfiler.repository.UserRepository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserRepositoryImpl extends RepositoryUtils<User> implements UserRepository{
	{
		persistenceUnitName = "SSOPROFILER_PU";
	}
	
	@Override
	public List<User> fetchAll(Integer start, Integer limit, List<ColumnDirection> cdList){
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);


		cq.select(user);

		cq = order(cq, cb, user, cdList);

		TypedQuery<User> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public User fetchById(Long id) throws Exception {
		return getEm().find(User.class, id);
	}

	@Override
	public void insert(User elem, String user) throws Exception{
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
	public void delete(User elem, String user) throws Exception{
		EntityTransaction transaction = null;
		try {
			transaction = getEm().getTransaction();
			transaction.begin();

			if(isAdmin(user) && !elem.isActive()){
				getEm().remove(getEm().find(User.class, elem.getId()));
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
	public User update(User elem, String user) throws Exception {
		User result = null;

		if(getEm().find(User.class, elem.getId()) == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - There's no User with that id.");
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
	public User merge(User elem, String user) throws Exception {
		User result = null;

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
	public List<User> fetchAll(String user, Integer start, Integer limit, List<ColumnDirection> cdList) throws Exception {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> userRoot = cq.from(User.class);

		if(isAdmin(user)){
			cq.where(cb.equal(userRoot.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(userRoot.get("userCreated"), user),
					cb.equal(userRoot.get("active"), true)));
		}

		cq.select(userRoot);

		cq = order(cq, cb, userRoot, cdList);

		TypedQuery<User> q = paginate(getEm(), cq, start, limit);

		return q.getResultList();
	}

	@Override
	public Long count(String user) throws Exception{
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<User> userRoot = cq.from(User.class);

		if(isAdmin(user)){
			cq.where(cb.equal(userRoot.get("userCreated"), user));
		} else {
			cq.where(cb.and(cb.equal(userRoot.get("userCreated"), user)),
					cb.equal(userRoot.get("active"), "1"));
		}
		cq.select(cb.count(userRoot));
		
		return getEm().createQuery(cq).getSingleResult();
	}
}
