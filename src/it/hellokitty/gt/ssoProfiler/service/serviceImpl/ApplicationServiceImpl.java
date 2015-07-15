package it.hellokitty.gt.ssoProfiler.service.serviceImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.entity.BaseObject;
import it.hellokitty.gt.ssoProfiler.entity.Application;
import it.hellokitty.gt.ssoProfiler.repository.ApplicationRepository;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.ApplicationRepositoryImpl;
import it.hellokitty.gt.ssoProfiler.service.ApplicationService;

public class ApplicationServiceImpl implements ApplicationService{
	ApplicationRepository applicationRepository = new ApplicationRepositoryImpl();

	@Override
	public void delete(BaseObject arg0, String arg1)
			throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Application> fetchAll(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, String arg3) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(BaseObject arg0, String arg1)
			throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseObject merge(BaseObject arg0, String arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count(HashMap<String, Object> arg0,
			HashMap<String, Object> arg1, HashMap<String, Object> arg2,
			HashMap<String, Object> arg3) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> fetchAll(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application fetchById(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		// TODO Auto-generated method stub
		return null;
	}

}
