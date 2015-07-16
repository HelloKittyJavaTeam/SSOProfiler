package it.hellokitty.gt.ssoprofiler.service.impl;

import it.hellokitty.gt.entity.BaseObject;
import it.hellokitty.gt.ssoprofiler.entity.AdUsers;
import it.hellokitty.gt.ssoprofiler.repository.UserRepository;
import it.hellokitty.gt.ssoprofiler.repository.impl.UserRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.service.UserService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class UserServiceImpl implements UserService{
	UserRepository userRepository = new UserRepositoryImpl();
	private static UserServiceImpl userServiceImpl;

	private UserServiceImpl() {
		super();
	}
	
	public static UserServiceImpl getInstance(){
		if(userServiceImpl == null){
			userServiceImpl = new UserServiceImpl();
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
		return userRepository.fetchAll(start, limit, orderColumn);
	}

	
	public AdUsers fetchById(Object id) throws Exception {
		return userRepository.fetchById(id);
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

