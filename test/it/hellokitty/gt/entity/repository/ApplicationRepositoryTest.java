package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.ssoProfiler.entity.Application;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.ApplicationRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApplicationRepositoryTest{
	private ApplicationRepositoryImpl applicationRep = new ApplicationRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static Application applicationAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			applicationAdd = new Application();
			applicationAdd.setId(99999l+i);
			applicationAdd.setUserCreated("testADD"+i);
			applicationAdd.setCreateDate(new Date());
			applicationAdd.setName("NAMETEST "+i);
			applicationAdd.setActive(true);
			em.persist(applicationAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			applicationAdd = new Application();
			applicationAdd.setId(99999l+i);
			em.remove(em.find(Application.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void applicationFetchById(){
		try {
			Application bull = applicationRep.fetchById(99999l);
			assertNotNull("No Application returned from fetchById", bull);
			assertTrue("applicationFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getName()+" "
					+ "Expected value: NAMETEST 0", bull.getName().equals("NAMETEST 0"));
			bull= applicationRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in applicationFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void applicationFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<Application> bullList = applicationRep.fetchAll(0, 20, cdMap);
			assertTrue("applicationFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("applicationFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("applicationFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in applicationFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Application> bullList = applicationRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("applicationFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in applicationFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Application> bullList = applicationRep.fetchAll(0, 17, cdMap);
			assertTrue("applicationFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in applicationFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void applicationInsert(){
		Application bullToAdd = new Application();
		bullToAdd.setId(98989898l);

		try{
			applicationRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(Application.class, 98989898l));
		} catch (Exception e){
			fail("applicationInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(Application.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void applicationMerge(){
		Application bullToMerge = new Application();
		bullToMerge = em.find(Application.class, 99999l);
		bullToMerge.setName("NAME TEST");
		
		try{
			applicationRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(Application.class, 99999l);
			assertTrue("applicationMErge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+bullToMerge.getName()+" "
					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getName().equals("NAME TEST"));
			assertTrue("applicationMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("applicationMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new Application();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreated("test");
			bullToMerge.setName("NAME TEST");
			applicationRep.merge(bullToMerge, "testMERGE");
			assertNotNull("applicationMerge method fail. No element added.", em.find(Application.class, 9898989898l));
		} catch (Exception e){
			fail("applicationMErge method fail during merge on inexistent application. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(Application.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void applicationDelete(){
		Application bullToDelete = new Application();
		bullToDelete = em.find(Application.class, 99999l);
		
		try {
			applicationRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(Application.class, 99999l);
			assertFalse("applicationDelete method failed. Application not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("applicationDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void applicationCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreated", "testADD0");
		
		try{
			result = applicationRep.count(map, null, null, null);
			assertTrue("applicationCount method failed. Number of Application expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("applicationCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADDUNKNOW");
		
		try{
			result = applicationRep.count(map, null, null, null);
			assertTrue("applicationCount method failed. Number of Application expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("applicationCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADD");
		
		try{
			result = applicationRep.count(null, map, null, null);
			assertTrue("applicationCount method with user parameter = 'unknowUser' failed. Number of Application expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("applicationCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void applicationSearch(){
		List<Application> applicationList = new ArrayList<Application>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			applicationList = applicationRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("applicationSearch method failed. Expected List of Application size: 20 Actual: "+applicationList.size(),applicationList.size() == 20);
			
			for(int index = 0; index < applicationList.size() - 1; index++){
				assertTrue("applicationSearch method failed on asc order check. Id at index "+index+": "+applicationList.get(index).getId()+" next: "+applicationList.get(index+1).getId(),
						applicationList.get(index).getId() < applicationList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("applicationSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			applicationList = applicationRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("applicationSearch method failed. Expected List of Application size: 20 Actual: "+applicationList.size(),applicationList.size() == 20);
			
			for(int index = 0; index < applicationList.size() - 1; index++){
				assertTrue("applicationSearch method failed on desc order check. Id at index "+index+": "+applicationList.get(index).getId()+" next: "+applicationList.get(index+1).getId(),
						applicationList.get(index).getId() > applicationList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("applicationSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("fileName", "NAMETEST 0");
		
		try{
			applicationList = applicationRep.search(0, 20, null, map, null, null, null);
			assertTrue("applicationSearch method failed. Expected List of Application size: 1 Actual: "+applicationList.size(),applicationList.size() == 1);
		} catch (Exception e){
			fail("applicationSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("fileName", "NAMETEST");

		try{
			applicationList = applicationRep.search(0, 20, null, null, map, null, null);
			assertTrue("applicationSearch method failed. Expected List of Application size: 20 Actual: "+applicationList.size(),applicationList.size() == 20);
		} catch (Exception e){
			fail("applicationSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			applicationList = applicationRep.search(0, 20, null, null, null, map, null);
			for(Application application : applicationList){
				if(application.getId() < 100){
					fail("applicationSearch method failed on lowerEqual check. Id found: "+application.getId());
				}
			}
		} catch (Exception e){
			fail("applicationSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			applicationList = applicationRep.search(0, 20, null, null, null, null, map);
			for(Application application : applicationList){
				if(application.getId() > 100){
					fail("applicationSearch method failed on lowerEqual check. Id found: "+application.getId());
				}
			}
		} catch (Exception e){
			fail("applicationSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}