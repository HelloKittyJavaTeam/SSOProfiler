package it.hellokitty.gt.ssoprofiler.service.impl;

import it.hellokitty.gt.entity.BaseObject;
import it.hellokitty.gt.ssoprofiler.entity.CompanyRole;
import it.hellokitty.gt.ssoprofiler.repository.CompanyRoleRepository;
import it.hellokitty.gt.ssoprofiler.repository.impl.CompanyRoleRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.service.CompanyRoleService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CompanyRoleServiceImpl implements CompanyRoleService{
	CompanyRoleRepository companyRoleRepository = new CompanyRoleRepositoryImpl();

	public CompanyRoleServiceImpl() {
		super();
	}
	
	@Override
	public List<CompanyRole> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> cdList, String user) throws IllegalArgumentException, Exception {
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(start < 0){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be < 0. Current value:"+start+".");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		if(limit <= 0){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be <= 0. Current value:"+limit+".");
		}
		
		if(cdList == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - cdList parameter can't be null.");
		}
		
		return companyRoleRepository.fetchAll(start, limit, cdList, user);
	}

	@Override
	public void insert(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		companyRoleRepository.insert(elem, user);
	}

	@Override
	public void delete(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		companyRoleRepository.delete(elem, user);
	}

	@Override
	public BaseObject merge(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
			
		}
		
		return companyRoleRepository.merge(elem, user);
	}

	@Override
	public Long count() throws Exception {
		return companyRoleRepository.count();
	}

	@Override
	public Long count(HashMap<String,Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception {
		return companyRoleRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<CompanyRole> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		return companyRoleRepository.fetchAll(start, limit, orderColumn);
	}

	@Override
	public CompanyRole fetchById(Object id) throws Exception {
		return companyRoleRepository.fetchById(id);
	}

	@Override
	public List<CompanyRole> search(Integer start, Integer limit, 
			LinkedHashMap<String,String> orderColumn,
			HashMap<String,Object> paramEquals,
			HashMap<String,Object> paramLike,
			HashMap<String,Object> paramGE,
			HashMap<String,Object> paramLE) {
		return companyRoleRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}
}

