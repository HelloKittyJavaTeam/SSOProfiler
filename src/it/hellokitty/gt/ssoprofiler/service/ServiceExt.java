package it.hellokitty.gt.ssoprofiler.service;

import it.hellokitty.gt.ssoprofiler.entity.AdUsers;
import it.hellokitty.gt.ssoprofiler.entity.Dealers;
import it.hellokitty.gt.ssoprofiler.entity.GeoAreas;
import it.hellokitty.gt.ssoprofiler.entity.GeoCountries;
import it.hellokitty.gt.ssoprofiler.entity.GeoRegions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface ServiceExt {
	/*
	 *  GET BY ID
	 */
	
	AdUsers getAdUsersById(Object id) throws IllegalArgumentException, Exception;
	
	Dealers getDealersById(Object id) throws IllegalArgumentException, Exception;
	
	GeoAreas getAGeoAreasById(Object id) throws IllegalArgumentException, Exception;
	
	GeoCountries getGeoCountriesById(Object id) throws IllegalArgumentException, Exception;
	
	GeoRegions getGeoRegionsById(Object id) throws IllegalArgumentException, Exception;
	
	/*
	 *  GET ALL
	 */
	
	List<AdUsers> getAdUsersAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
		
	List<Dealers> getDealersAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	List<GeoAreas> getGeoAreasAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	List<GeoCountries> getGeoCountriesAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	List<GeoRegions> getGeoRegionsAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
		
	/*
	 *  COUNT
	 */
	
	Long countAdUsers() throws Exception;
	
	Long countDealers() throws Exception;
	
	Long countGeoAreas() throws Exception;
	
	Long countGeoCountries() throws Exception;
	
	Long countGeoRegions() throws Exception;
	
	Long countAdUsers(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	Long countDealers(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;

	Long countGeoAreas(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	Long countGeoCountries(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	Long countGeoRegions(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	/*
	 *  SEARCH
	 */
	
	List<AdUsers> searchAdUsers(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;

	List<Dealers> searchDealers(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;

	List<GeoAreas> searchGeoAreas(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<GeoCountries> searchGeoCountries(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<GeoRegions> searchGeoRegions(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
}
