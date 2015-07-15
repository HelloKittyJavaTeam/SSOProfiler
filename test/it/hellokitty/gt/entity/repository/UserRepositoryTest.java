package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.ssoProfiler.entity.User;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.UserRepositoryImpl;

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
	private static User userAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			userAdd = new User();
			userAdd.setId(99999l+i);
			userAdd.setUserCreated("testADD"+i);
			userAdd.setCreateDate(new Date());
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
			userAdd = new User();
			userAdd.setId(99999l+i);
			em.remove(em.find(User.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void userFetchById(){
		try {
			User bull = userRep.fetchById(99999l);
			assertNotNull("No User returned from fetchById", bull);
			assertTrue("userFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getFirstName()+" "
					+ "Expected value: NAMETEST 0", bull.getFirstName().equals("NAMETEST 0"));
			bull= userRep.fetchById(987654321l);
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
			List<User> bullList = userRep.fetchAll(0, 20, cdMap);
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
			List<User> bullList = userRep.fetchAll(0, 20, cdMap);
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
			List<User> bullList = userRep.fetchAll(0, 17, cdMap);
			assertTrue("userFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in userFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void userInsert(){
		User bullToAdd = new User();
		bullToAdd.setId(98989898l);

		try{
			userRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(User.class, 98989898l));
		} catch (Exception e){
			fail("userInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(User.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void userMerge(){
		User bullToMerge = new User();
		bullToMerge = em.find(User.class, 99999l);
		bullToMerge.setFirstName("NAME TEST");
		
		try{
			userRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(User.class, 99999l);
			assertTrue("userMErge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+bullToMerge.getFirstName()+" "
					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getFirstName().equals("NAME TEST"));
			assertTrue("userMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("userMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new User();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreated("test");
			bullToMerge.setFirstName("NAME TEST");
			userRep.merge(bullToMerge, "testMERGE");
			assertNotNull("userMerge method fail. No element added.", em.find(User.class, 9898989898l));
		} catch (Exception e){
			fail("userMErge method fail during merge on inexistent user. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(User.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void userDelete(){
		User bullToDelete = new User();
		bullToDelete = em.find(User.class, 99999l);
		
		try {
			userRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(User.class, 99999l);
			assertFalse("userDelete method failed. User not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("userDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void userCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreated", "testADD0");
		
		try{
			result = userRep.count(map, null, null, null);
			assertTrue("userCount method failed. Number of User expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("userCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADDUNKNOW");
		
		try{
			result = userRep.count(map, null, null, null);
			assertTrue("userCount method failed. Number of User expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("userCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADD");
		
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
		List<User> userList = new ArrayList<User>();
		
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
			for(User user : userList){
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
			for(User user : userList){
				if(user.getId() > 100){
					fail("userSearch method failed on greaterEqual check. Id found: "+user.getId());
				}
			}
		} catch (Exception e){
			fail("userSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}