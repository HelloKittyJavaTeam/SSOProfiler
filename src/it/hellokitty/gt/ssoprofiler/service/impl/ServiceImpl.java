package it.hellokitty.gt.ssoprofiler.service.impl;

import it.hellokitty.gt.ssoprofiler.entity.Application;
import it.hellokitty.gt.ssoprofiler.entity.CompanyRole;
import it.hellokitty.gt.ssoprofiler.entity.Role;
import it.hellokitty.gt.ssoprofiler.repository.impl.ApplicationRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.repository.impl.CompanyRoleRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.repository.impl.RoleRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.service.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ServiceImpl implements Service{
	private ApplicationRepositoryImpl applicationRepository = new ApplicationRepositoryImpl();
	private RoleRepositoryImpl 		  roleRepository   	    = new RoleRepositoryImpl();
	private CompanyRoleRepositoryImpl companyRoleRepository = new CompanyRoleRepositoryImpl();
	
	private static ServiceImpl serviceImpl;
	
	private ServiceImpl(){}
	
	public static ServiceImpl getInstance(){
		if(serviceImpl == null){
			serviceImpl = new ServiceImpl();
		}
		return serviceImpl;
	}

	/*
	 *  GET BY ID
	 */
	@Override
	public Application getApplicationById(Object id)
			throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return applicationRepository.getById(id);
	}

	@Override
	public CompanyRole getCompanyRoleById(Object id)
			throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return companyRoleRepository.getById(id);
	}

	@Override
	public Role getRoleById(Object id) throws IllegalArgumentException,
			Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return roleRepository.getById(id);
	}

	/*
	 *  GET ALL
	 */
	@Override
	public List<Application> getApplicationAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn)
			throws IllegalArgumentException, Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return applicationRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<CompanyRole> getCompanyRoleAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn)
			throws IllegalArgumentException, Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return companyRoleRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<Role> getRoleAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return roleRepository.getAll(start, limit, orderColumn);
	}

	/*
	 *  COUNT
	 */
	@Override
	public Long countApplication() throws Exception {
		return applicationRepository.count();
	}

	@Override
	public Long countCompanyRole() throws Exception {
		return companyRoleRepository.count();
	}

	@Override
	public Long countRole() throws Exception {
		return roleRepository.count();
	}

	@Override
	public Long countApplication(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return applicationRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countCompanyRole(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return companyRoleRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countRole(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return roleRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	/*
	 *  SEARCH
	 */
	@Override
	public List<Application> searchApplication(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return applicationRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<CompanyRole> searchCompanyRole(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return companyRoleRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<Role> searchRole(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return roleRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	/*
	 *  INSERT
	 */
	@Override
	public void insertApplication(Application elem, String user)
			throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		applicationRepository.insert(elem, user);
	}

	@Override
	public void insertCompanyRole(CompanyRole elem, String user)
			throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		companyRoleRepository.insert(elem, user);
	}

	@Override
	public void insertRole(Role elem, String user)
			throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		roleRepository.insert(elem, user);
	}

	/*
	 *  MERGE
	 */
	@Override
	public Application mergeAttachment(Application elem, String user)
			throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (Application) applicationRepository.merge(elem, user);
	}

	@Override
	public CompanyRole mergeAttachmentHistory(CompanyRole elem, String user)
			throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (CompanyRole) companyRoleRepository.merge(elem, user);
	}

	@Override
	public Role mergeBulletin(Role elem, String user) throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (Role) roleRepository.merge(elem, user);
	}

	@Override
	public void deleteApplication(Application elem, String user)
			throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		applicationRepository.delete(elem, user);
	}

	@Override
	public void deleteCompanyRole(CompanyRole elem, String user)
			throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		companyRoleRepository.delete(elem, user);
	}

	@Override
	public void deleteRole(Role elem, String user)
			throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		roleRepository.delete(elem, user);
	}

}
