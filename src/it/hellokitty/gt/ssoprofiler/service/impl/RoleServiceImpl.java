package it.hellokitty.gt.ssoprofiler.service.impl;

import it.hellokitty.gt.entity.BaseObject;
import it.hellokitty.gt.ssoprofiler.entity.Role;
import it.hellokitty.gt.ssoprofiler.repository.RoleRepository;
import it.hellokitty.gt.ssoprofiler.repository.impl.RoleRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.service.RoleService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class RoleServiceImpl implements RoleService{
	RoleRepository roleRepository = new RoleRepositoryImpl();
	private static RoleServiceImpl roleServiceImpl;

	private RoleServiceImpl() {
		super();
	}
	
	public static RoleServiceImpl getInstance(){
		if(roleServiceImpl == null){
			roleServiceImpl = new RoleServiceImpl();
		}
		return roleServiceImpl;
	}
	
	public List<Role> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> cdList, String user) throws IllegalArgumentException, Exception {
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
		
		return roleRepository.fetchAll(start, limit, cdList, user);
	}

	
	public void insert(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		roleRepository.insert(elem, user);
	}

	
	public void delete(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		roleRepository.delete(elem, user);
	}

	
	public BaseObject merge(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
			
		}
		
		return roleRepository.merge(elem, user);
	}

	
	public Long count() throws Exception {
		return roleRepository.count();
	}

	
	public Long count(HashMap<String,Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception {
		return roleRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	
	public List<Role> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		return roleRepository.getAll(start, limit, orderColumn);
	}

	
	public Role fetchById(Object id) throws Exception {
		return roleRepository.getById(id);
	}

	
	public List<Role> search(Integer start, Integer limit, 
			LinkedHashMap<String,String> orderColumn,
			HashMap<String,Object> paramEquals,
			HashMap<String,Object> paramLike,
			HashMap<String,Object> paramGE,
			HashMap<String,Object> paramLE) {
		return roleRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}
}

