package it.hellokitty.gt.ssoProfiler.service.serviceImpl;

import it.hellokitty.gt.ssoProfiler.entity.GeoRegions;
import it.hellokitty.gt.ssoProfiler.repository.GeoRegionsRepository;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.GeoRegionsRepositoryImpl;
import it.hellokitty.gt.ssoProfiler.service.GeoRegionsService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class GeoRegionsServiceImpl implements GeoRegionsService{
	GeoRegionsRepository geoRegionsRepository = new GeoRegionsRepositoryImpl();

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
	public List<GeoRegions> fetchAll(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeoRegions fetchById(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeoRegions> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		// TODO Auto-generated method stub
		return null;
	}

}