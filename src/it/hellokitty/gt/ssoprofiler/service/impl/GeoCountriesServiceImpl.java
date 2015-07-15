package it.hellokitty.gt.ssoprofiler.service.impl;

import it.hellokitty.gt.ssoprofiler.entity.GeoCountries;
import it.hellokitty.gt.ssoprofiler.repository.GeoCountriesRepository;
import it.hellokitty.gt.ssoprofiler.repository.impl.GeoCountriesRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.service.GeoCountriesService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class GeoCountriesServiceImpl implements GeoCountriesService{
	GeoCountriesRepository geoCountriesRepository = new GeoCountriesRepositoryImpl();

	public GeoCountriesServiceImpl(){
		super();
	}
	
	@Override
	public Long count() throws Exception {
		return geoCountriesRepository.count();
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
		
		return geoCountriesRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<GeoCountries> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return geoCountriesRepository.fetchAll(start, limit, orderColumn);
	}

	@Override
	public GeoCountries fetchById(Object id) throws Exception {
		return geoCountriesRepository.fetchById(id);
	}

	@Override
	public List<GeoCountries> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return geoCountriesRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
