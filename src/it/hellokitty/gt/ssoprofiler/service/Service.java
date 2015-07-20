package it.hellokitty.gt.ssoprofiler.service;

import it.hellokitty.gt.ssoprofiler.entity.Application;
import it.hellokitty.gt.ssoprofiler.entity.CompanyRole;
import it.hellokitty.gt.ssoprofiler.entity.Role;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface Service {
	/*
	 *  GET BY ID
	 */
	Application getApplicationById(Object id) throws IllegalArgumentException, Exception;
	CompanyRole getCompanyRoleById(Object id) throws IllegalArgumentException, Exception;
	Role		getRoleById(Object id)		  throws IllegalArgumentException, Exception;
	
	/*
	 *  GET ALL
	 */
	List<Application> getApplicationAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	List<CompanyRole> getCompanyRoleAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	List<Role>		  getRoleAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn)		 throws IllegalArgumentException, Exception;
	
	/*
	 *  COUNT
	 */
	Long countApplication() throws Exception;
	Long countCompanyRole() throws Exception;
	Long countRole()		throws Exception;
	
	Long countApplication(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countCompanyRole(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countRole		 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) 		 throws Exception;

	/*
	 *  SEARCH
	 */
	List<Application> searchApplication(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<CompanyRole> searchCompanyRole(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<Role> 		  searchRole	   (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) 	   throws IllegalArgumentException, Exception;

	/*
	 *  INSERT
	 */
	void insertApplication (Application elem, String user) throws IllegalArgumentException, Exception;
	void insertCompanyRole (CompanyRole elem, String user) throws IllegalArgumentException, Exception;
	void insertRole		   (Role elem, String user) 	   throws IllegalArgumentException, Exception;
	
	/*
	 *  MERGE
	 */
	Application mergeAttachment		   (Application elem, String user) throws Exception;
	CompanyRole mergeAttachmentHistory (CompanyRole elem, String user) throws Exception;
	Role 		mergeBulletin		   (Role elem, String user) 	   throws Exception;
	
	/*
	 *  DELETE
	 */
	void deleteApplication (Application elem, String user) throws IllegalArgumentException, Exception;
	void deleteCompanyRole (CompanyRole elem, String user) throws IllegalArgumentException, Exception;
	void deleteRole		   (Role elem, String user) 	   throws IllegalArgumentException, Exception;
}
