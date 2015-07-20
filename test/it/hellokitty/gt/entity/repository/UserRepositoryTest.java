package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.ssoprofiler.entity.AdUsers;
import it.hellokitty.gt.ssoprofiler.repository.impl.UserRepositoryImpl;

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

public class UserRepositoryTest {
	private UserRepositoryImpl userRep = new UserRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("SSOPROFILER_PU").createEntityManager();
	private static AdUsers userAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			userAdd = new AdUsers();
			userAdd.setId(99999l+i);
			userAdd.setUserIns("testADD"+i);
			userAdd.setDateIns(new Date());
			userAdd.setFirstName("NAMETEST "+i);
			userAdd.setActive(true);
			em.persist(userAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			userAdd = new AdUsers();
			userAdd.setId(99999l+i);
			em.remove(em.find(AdUsers.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void userFetchById(){
		try {
			AdUsers bull = userRep.getById(99999l);
			assertNotNull("No User returned from fetchById", bull);
			assertTrue("userFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getFirstName()+" "
					+ "Expected value: NAMETEST 0", bull.getFirstName().equals("NAMETEST 0"));
			bull= userRep.getById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in userFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void userFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<AdUsers> bullList = userRep.getAll(0, 20, cdMap);
			assertTrue("userFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("userFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("userFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in userFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<AdUsers> bullList = userRep.getAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("userFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in userFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<AdUsers> bullList = userRep.getAll(0, 17, cdMap);
			assertTrue("userFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in userFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void userCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "NAMETEST 0");
		
		try{
			result = userRep.count(map, null, null, null);
			assertTrue("userCount method failed. Number of User expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("userCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("firstName", "testADDUNKNOW");
		
		try{
			result = userRep.count(map, null, null, null);
			assertTrue("userCount method failed. Number of User expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("userCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("firstName", "NAMETEST");
		
		try{
			result = userRep.count(null, map, null, null);
			assertTrue("userCount method with user parameter = 'unknowUser' failed. Number of User expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("userCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void userSearch(){
		List<AdUsers> userList = new ArrayList<AdUsers>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			userList = userRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("userSearch method failed. Expected List of User size: 20 Actual: "+userList.size(),userList.size() == 20);
			
			for(int index = 0; index < userList.size() - 1; index++){
				assertTrue("userSearch method failed on asc order check. Id at index "+index+": "+userList.get(index).getId()+" next: "+userList.get(index+1).getId(),
						userList.get(index).getId() < userList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("userSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			userList = userRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("userSearch method failed. Expected List of User size: 20 Actual: "+userList.size(),userList.size() == 20);
			
			for(int index = 0; index < userList.size() - 1; index++){
				assertTrue("userSearch method failed on desc order check. Id at index "+index+": "+userList.get(index).getId()+" next: "+userList.get(index+1).getId(),
						userList.get(index).getId() > userList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("userSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "NAMETEST 0");
		
		try{
			userList = userRep.search(0, 20, null, map, null, null, null);
			assertTrue("userSearch method failed. Expected List of User size: 1 Actual: "+userList.size(),userList.size() == 1);
		} catch (Exception e){
			fail("userSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("firstName", "NAMETEST");

		try{
			userList = userRep.search(0, 20, null, null, map, null, null);
			assertTrue("userSearch method failed. Expected List of User size: 20 Actual: "+userList.size(),userList.size() == 20);
		} catch (Exception e){
			fail("userSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			userList = userRep.search(0, 20, null, null, null, map, null);
			for(AdUsers user : userList){
				if(user.getId() < 100){
					fail("userSearch method failed on lowerEqual check. Id found: "+user.getId());
				}
			}
		} catch (Exception e){
			fail("userSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			userList = userRep.search(0, 20, null, null, null, null, map);
			for(AdUsers user : userList){
				if(user.getId() > 100){
					fail("userSearch method failed on greaterEqual check. Id found: "+user.getId());
				}
			}
		} catch (Exception e){
			fail("userSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}