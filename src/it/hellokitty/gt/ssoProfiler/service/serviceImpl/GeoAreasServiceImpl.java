package it.hellokitty.gt.ssoProfiler.service.serviceImpl;

import it.hellokitty.gt.ssoProfiler.entity.GeoAreas;
import it.hellokitty.gt.ssoProfiler.repository.GeoAreasRepository;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.GeoAreasRepositoryImpl;
import it.hellokitty.gt.ssoProfiler.service.GeoAreasService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class GeoAreasServiceImpl implements GeoAreasService{
	GeoAreasRepository geoAreasRepository = new GeoAreasRepositoryImpl();

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
	public List<GeoAreas> fetchAll(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeoAreas fetchById(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeoAreas> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		// TODO Auto-generated method stub
		return null;
	}
}

