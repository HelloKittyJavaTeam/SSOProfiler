package it.hellokitty.gt.ssoprofiler.service.impl;

import it.hellokitty.gt.entity.BaseObject;
import it.hellokitty.gt.ssoprofiler.entity.AdUsers;
import it.hellokitty.gt.ssoprofiler.repository.AdUserRepository;
import it.hellokitty.gt.ssoprofiler.repository.impl.AdUserRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.service.AdUserService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AdUserServiceImpl implements AdUserService{
	AdUserRepository userRepository = new AdUserRepositoryImpl();
	private static AdUserServiceImpl userServiceImpl;

	private AdUserServiceImpl() {
		super();
	}
	
	public static AdUserServiceImpl getInstance(){
		if(userServiceImpl == null){
			userServiceImpl = new AdUserServiceImpl();
		}
		return userServiceImpl;
	}
	
	public List<AdUsers> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> cdList, String user) throws IllegalArgumentException, Exception {
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
		
		return userRepository.fetchAll(start, limit, cdList, user);
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
		
		userRepository.insert(elem, user);
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
		
		userRepository.delete(elem, user);
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
		
		return userRepository.merge(elem, user);
	}

	
	public Long count() throws Exception {
		return userRepository.count();
	}

	
	public Long count(HashMap<String,Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception {
		return userRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	
	public List<AdUsers> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		return userRepository.getAll(start, limit, orderColumn);
	}

	
	public AdUsers fetchById(Object id) throws Exception {
		return userRepository.getById(id);
	}

	
	public List<AdUsers> search(Integer start, Integer limit, 
			LinkedHashMap<String,String> orderColumn,
			HashMap<String,Object> paramEquals,
			HashMap<String,Object> paramLike,
			HashMap<String,Object> paramGE,
			HashMap<String,Object> paramLE) {
		return userRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}
}

