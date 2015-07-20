package it.hellokitty.gt.ssoprofiler.service.impl;

import it.hellokitty.gt.ssoprofiler.entity.GeoAreas;
import it.hellokitty.gt.ssoprofiler.repository.GeoAreasRepository;
import it.hellokitty.gt.ssoprofiler.repository.impl.GeoAreasRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.service.GeoAreasService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class GeoAreasServiceImpl implements GeoAreasService{
	GeoAreasRepository geoAreasRepository = new GeoAreasRepositoryImpl();
	private static GeoAreasServiceImpl geoAreasServiceImpl;

	private GeoAreasServiceImpl() {
		super();
	}
	
	public static GeoAreasServiceImpl getInstance(){
		if(geoAreasServiceImpl == null){
			geoAreasServiceImpl = new GeoAreasServiceImpl();
		}
		return geoAreasServiceImpl;
	}
	
	public Long count() throws Exception {
		return geoAreasRepository.count();
	}

	
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

	
	public List<GeoAreas> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return geoAreasRepository.getAll(start, limit, orderColumn);
	}

	public GeoAreas fetchById(Object id) throws Exception {
		return geoAreasRepository.getById(id);
	}

	public List<GeoAreas> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return geoAreasRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
