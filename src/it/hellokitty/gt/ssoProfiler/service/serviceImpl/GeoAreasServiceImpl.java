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

	public GeoAreasServiceImpl(){
		super();
	}
	
	@Override
	public Long count() throws Exception {
		return geoAreasRepository.count();
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
		
		return geoAreasRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<GeoAreas> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return geoAreasRepository.fetchAll(start, limit, orderColumn);
	}

	@Override
	public GeoAreas fetchById(Object id) throws Exception {
		return geoAreasRepository.fetchById(id);
	}

	@Override
	public List<GeoAreas> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return geoAreasRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
