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
	
	public GeoRegionsServiceImpl(){
		super();
	}
	
	@Override
	public Long count() throws Exception {
		return geoRegionsRepository.count();
	}

	@Override
	public Long count(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception {
		if(paramEquals == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramEquals parameter cannot be null.");
		}
		
		if(paramLike == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramLike parameter cannot be null.");
		}
		
		if(paramGE == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramGE parameter cannot be null.");
		}
		
		if(paramLE == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+ this.getClass()+" - paramLE parameter cannot be null.");
		}
		
		return geoRegionsRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<GeoRegions> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return geoRegionsRepository.fetchAll(start, limit, orderColumn);
	}

	@Override
	public GeoRegions fetchById(Object id) throws Exception {
		return geoRegionsRepository.fetchById(id);
	}

	@Override
	public List<GeoRegions> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return geoRegionsRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
