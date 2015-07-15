package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.ssoProfiler.entity.Role;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.RoleRepositoryImpl;

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

public class RoleRepositoryTest {
	private RoleRepositoryImpl roleRep = new RoleRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("SSOPROFILER_PU").createEntityManager();
	private static Role roleAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			roleAdd = new Role();
			roleAdd.setId(99999l+i);
			roleAdd.setUserCreated("testADD"+i);
			roleAdd.setCreateDate(new Date());
			roleAdd.setName("NAMETEST "+i);
			roleAdd.setActive(true);
			em.persist(roleAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			roleAdd = new Role();
			roleAdd.setId(99999l+i);
			em.remove(em.find(Role.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void roleFetchById(){
		try {
			Role bull = roleRep.fetchById(99999l);
			assertNotNull("No Role returned from fetchById", bull);
			assertTrue("roleFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getName()+" "
					+ "Expected value: NAMETEST 0", bull.getName().equals("NAMETEST 0"));
			bull= roleRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in roleFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void roleFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<Role> bullList = roleRep.fetchAll(0, 20, cdMap);
			assertTrue("roleFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("roleFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("roleFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in roleFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Role> bullList = roleRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("roleFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in roleFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Role> bullList = roleRep.fetchAll(0, 17, cdMap);
			assertTrue("roleFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in roleFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void roleInsert(){
		Role bullToAdd = new Role();
		bullToAdd.setId(98989898l);

		try{
			roleRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(Role.class, 98989898l));
		} catch (Exception e){
			fail("roleInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(Role.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void roleMerge(){
		Role bullToMerge = new Role();
		bullToMerge = em.find(Role.class, 99999l);
		bullToMerge.setName("NAME TEST");
		
		try{
			roleRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(Role.class, 99999l);
			assertTrue("roleMErge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+bullToMerge.getName()+" "
					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getName().equals("NAME TEST"));
			assertTrue("roleMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("roleMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new Role();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreated("test");
			bullToMerge.setName("NAME TEST");
			roleRep.merge(bullToMerge, "testMERGE");
			assertNotNull("roleMerge method fail. No element added.", em.find(Role.class, 9898989898l));
		} catch (Exception e){
			fail("roleMErge method fail during merge on inexistent role. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(Role.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void roleDelete(){
		Role bullToDelete = new Role();
		bullToDelete = em.find(Role.class, 99999l);
		
		try {
			roleRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(Role.class, 99999l);
			assertFalse("roleDelete method failed. Role not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("roleDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void roleCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreated", "testADD0");
		
		try{
			result = roleRep.count(map, null, null, null);
			assertTrue("roleCount method failed. Number of Role expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("roleCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADDUNKNOW");
		
		try{
			result = roleRep.count(map, null, null, null);
			assertTrue("roleCount method failed. Number of Role expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("roleCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADD");
		
		try{
			result = roleRep.count(null, map, null, null);
			assertTrue("roleCount method with user parameter = 'unknowUser' failed. Number of Role expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("roleCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void roleSearch(){
		List<Role> roleList = new ArrayList<Role>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			roleList = roleRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("roleSearch method failed. Expected List of Role size: 20 Actual: "+roleList.size(),roleList.size() == 20);
			
			for(int index = 0; index < roleList.size() - 1; index++){
				assertTrue("roleSearch method failed on asc order check. Id at index "+index+": "+roleList.get(index).getId()+" next: "+roleList.get(index+1).getId(),
						roleList.get(index).getId() < roleList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("roleSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			roleList = roleRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("roleSearch method failed. Expected List of Role size: 20 Actual: "+roleList.size(),roleList.size() == 20);
			
			for(int index = 0; index < roleList.size() - 1; index++){
				assertTrue("roleSearch method failed on desc order check. Id at index "+index+": "+roleList.get(index).getId()+" next: "+roleList.get(index+1).getId(),
						roleList.get(index).getId() > roleList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("roleSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "NAMETEST 0");
		
		try{
			roleList = roleRep.search(0, 20, null, map, null, null, null);
			assertTrue("roleSearch method failed. Expected List of Role size: 1 Actual: "+roleList.size(),roleList.size() == 1);
		} catch (Exception e){
			fail("roleSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("name", "NAMETEST");

		try{
			roleList = roleRep.search(0, 20, null, null, map, null, null);
			assertTrue("roleSearch method failed. Expected List of Role size: 20 Actual: "+roleList.size(),roleList.size() == 20);
		} catch (Exception e){
			fail("roleSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			roleList = roleRep.search(0, 20, null, null, null, map, null);
			for(Role role : roleList){
				if(role.getId() < 100){
					fail("roleSearch method failed on lowerEqual check. Id found: "+role.getId());
				}
			}
		} catch (Exception e){
			fail("roleSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			roleList = roleRep.search(0, 20, null, null, null, null, map);
			for(Role role : roleList){
				if(role.getId() > 100){
					fail("roleSearch method failed on lowerEqual check. Id found: "+role.getId());
				}
			}
		} catch (Exception e){
			fail("roleSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}