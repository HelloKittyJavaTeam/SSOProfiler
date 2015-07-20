package it.hellokitty.gt.ssoprofiler.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.ssoprofiler.entity.AdUsers;
import it.hellokitty.gt.ssoprofiler.entity.Dealers;
import it.hellokitty.gt.ssoprofiler.entity.GeoAreas;
import it.hellokitty.gt.ssoprofiler.entity.GeoCountries;
import it.hellokitty.gt.ssoprofiler.entity.GeoRegions;
import it.hellokitty.gt.ssoprofiler.repository.impl.AdUserRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.repository.impl.DealersRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.repository.impl.GeoAreasRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.repository.impl.GeoCountriesRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.repository.impl.GeoRegionsRepositoryImpl;
import it.hellokitty.gt.ssoprofiler.service.ServiceExt;

public class ServiceImplExt implements ServiceExt{
	private GeoAreasRepositoryImpl 		geoAreasRepository     = new GeoAreasRepositoryImpl();
	private GeoRegionsRepositoryImpl 	geoRegionsRepository   = new GeoRegionsRepositoryImpl();
	private GeoCountriesRepositoryImpl  geoCountriesRepository = new GeoCountriesRepositoryImpl();
	private AdUserRepositoryImpl 		adUsersRepository 	   = new AdUserRepositoryImpl();
	private DealersRepositoryImpl 		dealersRepository      = new DealersRepositoryImpl();
	
	private static ServiceImplExt serviceImplExt;
	
	private ServiceImplExt(){}
	
	public static ServiceImplExt getInstance(){
		if(serviceImplExt == null){
			serviceImplExt = new ServiceImplExt();
		}
		return serviceImplExt;
	}

	/*
	 *  GET BY ID
	 */
	@Override
	public AdUsers getAdUsersById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return adUsersRepository.getById(id);
	}

	@Override
	public Dealers getDealersById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return dealersRepository.getById(id);
	}

	@Override
	public GeoAreas getAGeoAreasById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return geoAreasRepository.getById(id);
	}

	@Override
	public GeoCountries getGeoCountriesById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return geoCountriesRepository.getById(id);
	}

	@Override
	public GeoRegions getGeoRegionsById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return geoRegionsRepository.getById(id);
	}

	/*
	 *  GET ALL
	 */
	@Override
	public List<AdUsers> getAdUsersAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return adUsersRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<Dealers> getDealersAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return dealersRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<GeoAreas> getGeoAreasAll(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn)
			throws IllegalArgumentException, Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return geoAreasRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<GeoCountries> getGeoCountriesAll(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn)
			throws IllegalArgumentException, Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return geoCountriesRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<GeoRegions> getGeoRegionsAll(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn)
			throws IllegalArgumentException, Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return geoRegionsRepository.getAll(start, limit, orderColumn);
	}

	/*
	 *  COUNT
	 */
	@Override
	public Long countAdUsers() throws Exception {
		return adUsersRepository.count();
	}

	@Override
	public Long countDealers() throws Exception {
		return dealersRepository.count();
	}

	@Override
	public Long countGeoAreas() throws Exception {
		return geoAreasRepository.count();
	}

	@Override
	public Long countGeoCountries() throws Exception {
		return geoCountriesRepository.count();
	}

	@Override
	public Long countGeoRegions() throws Exception {
		return geoRegionsRepository.count();
	}

	@Override
	public Long countAdUsers(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return adUsersRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countDealers(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return dealersRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countGeoAreas(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return geoAreasRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countGeoCountries(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return geoCountriesRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countGeoRegions(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return geoRegionsRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	/*
	 *  SEARCH
	 */
	@Override
	public List<AdUsers> searchAdUsers(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return adUsersRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<Dealers> searchDealers(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return dealersRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<GeoAreas> searchGeoAreas(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return geoAreasRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<GeoCountries> searchGeoCountries(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return geoCountriesRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<GeoRegions> searchGeoRegions(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return geoRegionsRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

}
