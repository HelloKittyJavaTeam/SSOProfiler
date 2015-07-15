package it.hellokitty.gt.ssoProfiler.service.serviceImpl;

import it.hellokitty.gt.entity.BaseObject;
import it.hellokitty.gt.ssoProfiler.entity.User;
import it.hellokitty.gt.ssoProfiler.repository.UserRepository;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.UserRepositoryImpl;
import it.hellokitty.gt.ssoProfiler.service.UserService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class UserServiceImpl implements UserService{
	UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public void delete(BaseObject arg0, String arg1)
			throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> fetchAll(Integer arg0, Integer arg1,
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
	public List<User> fetchAll(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User fetchById(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		// TODO Auto-generated method stub
		return null;
	}

}

