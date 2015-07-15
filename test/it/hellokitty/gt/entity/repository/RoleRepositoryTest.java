package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.repository.utils.ColumnDirection;
import it.hellokitty.gt.ssoProfiler.entity.Role;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.RoleRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
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
			roleAdd.setUserCreated("testADD"+i);
			roleAdd.setActive(true);
			roleAdd.setId(99999l+i);
			roleAdd.setName("testFILE"+i);
			em.persist(roleAdd);
		}
		transaction.commit();
	}

	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
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
			Role role = roleRep.fetchById(99999l);
			assertNotNull("No Role returned from fetchById", role);
			assertTrue("roleFetchById method failed on retrieve content value. "
					+ "Actual value: "+role.getName()+" "
					+ "Expected value: testFILE0", role.getName().equals("testFILE0"));
			role = roleRep.fetchById(987654321l);
			assertNull(role);
		} catch (Exception e) {
			fail("Caught Exception in roleFetchById method. "+e.toString());
		}
	}

	@Test
	public void roleFetchAll(){
		ColumnDirection cd = new ColumnDirection("id", "asc");
		List<ColumnDirection> cdList = new ArrayList<ColumnDirection>();
		cdList.add(cd);
		try {
			List<Role> roles = roleRep.fetchAll(0, 20, cdList);
			assertTrue("roleFetchAll returned a empty list.", roles.size() > 0);
			assertTrue("roleFetchAll didn't return all the elements.", roles.size() >= 20);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in roleFetchAll method.");
		}
	}

	/*
	 *  INSERT TEST
	 */
	@Test
	public void roleInsert(){
		Role roleAdd = new Role();
		roleAdd.setId(98989898l);

		try{
			roleRep.insert(roleAdd, "testADD");
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
		Role roleToMerge = new Role();
		roleToMerge = em.find(Role.class, 99999l);
		roleToMerge.setName("TESTNAMEMERGE");

		try{
			roleRep.merge(roleToMerge, "testMERGE");
			roleToMerge = em.find(Role.class, 99999l);
			assertTrue("roleMerge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+roleToMerge.getName()+" "
					+ "Expected value: TESTNAMEMERGE.",roleToMerge.getName().equals("TESTNAMEMERGE"));
			assertTrue("roleMerge method failed. UserUpdate value not updated."
					+ "Current value: "+roleToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", roleToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("roleMerge method failed. Unexpected Exception catched. "+e.toString());
		}

		try{
			roleToMerge = new Role();
			roleToMerge.setId(9898989898l);
			roleToMerge.setUserCreated("test");
			roleToMerge.setName("TESTNAMEMERGE");
			roleRep.merge(roleToMerge, "testMERGE");
			assertNotNull("roleMerge method fail. No element added.", em.find(Role.class, 9898989898l));
		} catch (Exception e){
			fail("roleMerge method fail during merge on inexistent role. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(Role.class, 9898989898l));
	}

	/*
	 *  UPDATE TEST
	 */
	@Test
	public void roleUpdate(){
		Role roleToUpdate = new Role();
		roleToUpdate = em.find(Role.class, 99999l);
		roleToUpdate.setName("TESTNAMEMERGE");

		try{
			roleRep.update(roleToUpdate, "testUPDATE");
			roleToUpdate = em.find(Role.class, 99999l);
			assertTrue("roleUpdate method failed. ItContent value wrong or not updated. "
					+ "Current value: "+roleToUpdate.getName()+" "
					+ "Expected value: TESTNAMEMERGE.",roleToUpdate.getName().equals("TESTNAMEMERGE"));
			assertTrue("roleUpdate method failed. UserUpdate value not updated."
					+ "Current value: "+roleToUpdate.getUserUpdate()+" "
					+ "Expected value: testUPDATE.", roleToUpdate.getUserUpdate().equals("testUPDATE"));
		} catch (Exception e){
			fail("roleUpdate method failed. Unexpected Exception catched. "+e.toString());
		}

		try{
			roleToUpdate = new Role();
			roleToUpdate.setId(9898989898l);
			roleToUpdate.setUserCreated("test");
			roleToUpdate.setName("NAME TEST ITA");
			roleRep.update(roleToUpdate, "testUPDATE");
			fail("roleUpdate method failed. IllegalArgumentException not thrown.");
		} catch (IllegalArgumentException e){
			assertTrue(true); // Just for visibility :)
		} catch (Exception e){
			fail("roleUpdate method fail during merge on inexistent role. Unexpected exception catched. "+e.toString());
		}
	}

	/*
	 *  DELETE TEST
	 */
	@Test
	public void roleDelete(){
		Role roleToDelete = new Role();
		roleToDelete = em.find(Role.class, 99999l);

		try {
			roleRep.delete(roleToDelete, "testDELETE");
			roleToDelete = em.find(Role.class, 99999l);
			assertFalse("roleDelete method failed. EmailContact not disactivated.", roleToDelete.isActive());
		} catch (Exception e){
			fail("roleDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}

		roleToDelete = new Role();
		roleToDelete.setId(987987987l);
		roleToDelete.setUserCreated("testUSER");
		roleToDelete.setCreateDate(new Date());
		roleToDelete.setActive(false);
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.persist(roleToDelete);
		transaction.commit();

		try{
			roleRep.delete(roleToDelete, "admin");
			em = Persistence.createEntityManagerFactory("SSOPROFILER_PU").createEntityManager();
			assertNull("roleDelete method failed. EmailContact with id 987987987 not deleted. ID: "+roleToDelete.getId(), em.find(Role.class, 987987987l));

		} catch (Exception e){
			fail("roleDelete method failed during delete from admin. Unexpected exception catched. "+e.toString());
		}
	}

	/*
	 *  COUNT TEST
	 */
	@Test
	public void roleCount(){
		Long result;

		try{
			result = roleRep.count("testADD0");
			assertTrue("roleCount method failed. Number of Role expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("roleCount method failed. Unexpected exception catched. "+e.toString());
		}

		try{
			result = roleRep.count("unknowUser");
			assertTrue("roleCount method with user parameter = 'unknowUser' failed. Number of Role expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("roleCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
}