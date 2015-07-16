package it.hellokitty.gt.ssoprofiler.service.impl;

import it.hellokitty.gt.ssoprofiler.service.impl.ApplicationServiceImpl;
import it.hellokitty.gt.entity.BaseObject;
import it.hellokitty.gt.ssoprofiler.entity.Application;
import it.hellokitty.gt.ssoprofiler.repository.ApplicationRepository;
import it.hellokitty.gt.ssoprofiler.repository.impl.ApplicationRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.service.ApplicationService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ApplicationServiceImpl implements ApplicationService{
	ApplicationRepository applicationRepository = new ApplicationRepositoryImpl();
	private static ApplicationServiceImpl applicationServiceImpl;

	private ApplicationServiceImpl() {
		super();
	}
	
	public static ApplicationServiceImpl getInstance(){
		if(applicationServiceImpl == null){
			applicationServiceImpl = new ApplicationServiceImpl();
		}
		return applicationServiceImpl;
	}
	
	public List<Application> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> cdList, String user) throws IllegalArgumentException, Exception {
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
		
		return applicationRepository.fetchAll(start, limit, cdList, user);
	}

	
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
		
		applicationRepository.insert(elem, user);
	}

	
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
		
		applicationRepository.delete(elem, user);
	}

	
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
		
		return applicationRepository.merge(elem, user);
	}

	
	public Long count() throws Exception {
		return applicationRepository.count();
	}

	
	public Long count(HashMap<String,Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception {
		return applicationRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	
	public List<Application> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		return applicationRepository.fetchAll(start, limit, orderColumn);
	}

	
	public Application fetchById(Object id) throws Exception {
		return applicationRepository.fetchById(id);
	}

	
	public List<Application> search(Integer start, Integer limit, 
			LinkedHashMap<String,String> orderColumn,
			HashMap<String,Object> paramEquals,
			HashMap<String,Object> paramLike,
			HashMap<String,Object> paramGE,
			HashMap<String,Object> paramLE) {
		return applicationRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}
}
