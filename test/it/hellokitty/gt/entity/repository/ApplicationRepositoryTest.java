package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.repository.utils.ColumnDirection;
import it.hellokitty.gt.ssoProfiler.entity.Application;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.ApplicationRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApplicationRepositoryTest{
	private ApplicationRepositoryImpl applicationRep = new ApplicationRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("SSOPROFILER_PU").createEntityManager();
	private static Application applicationAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		for(int i = 0; i < 20; i++){
			applicationAdd = new Application();
			applicationAdd.setUserCreated("testADD"+i);
			applicationAdd.setActive(true);
			applicationAdd.setId(99999l+i);
			applicationAdd.setName("testFILE"+i);
			em.persist(applicationAdd);
		}
		transaction.commit();
	}

	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
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
			Application application = applicationRep.fetchById(99999l);
			assertNotNull("No Application returned from fetchById", application);
			assertTrue("applicationFetchById method failed on retrieve content value. "
					+ "Actual value: "+application.getName()+" "
					+ "Expected value: testFILE0", application.getName().equals("testFILE0"));
			application = applicationRep.fetchById(987654321l);
			assertNull(application);
		} catch (Exception e) {
			fail("Caught Exception in applicationFetchById method. "+e.toString());
		}
	}

	@Test
	public void applicationFetchAll(){
		ColumnDirection cd = new ColumnDirection("id", "asc");
		List<ColumnDirection> cdList = new ArrayList<ColumnDirection>();
		cdList.add(cd);
		try {
			List<Application> applications = applicationRep.fetchAll(0, 20, cdList);
			assertTrue("applicationFetchAll returned a empty list.", applications.size() > 0);
			assertTrue("applicationFetchAll didn't return all the elements.", applications.size() >= 20);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in applicationFetchAll method.");
		}
	}

	/*
	 *  INSERT TEST
	 */
	@Test
	public void applicationInsert(){
		Application applicationAdd = new Application();
		applicationAdd.setId(98989898l);

		try{
			applicationRep.insert(applicationAdd, "testADD");
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
		Application applicationToMerge = new Application();
		applicationToMerge = em.find(Application.class, 99999l);
		applicationToMerge.setName("TESTNAMEMERGE");

		try{
			applicationRep.merge(applicationToMerge, "testMERGE");
			applicationToMerge = em.find(Application.class, 99999l);
			assertTrue("applicationMerge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+applicationToMerge.getName()+" "
					+ "Expected value: TESTNAMEMERGE.",applicationToMerge.getName().equals("TESTNAMEMERGE"));
			assertTrue("applicationMerge method failed. UserUpdate value not updated."
					+ "Current value: "+applicationToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", applicationToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("applicationMerge method failed. Unexpected Exception catched. "+e.toString());
		}

		try{
			applicationToMerge = new Application();
			applicationToMerge.setId(9898989898l);
			applicationToMerge.setUserCreated("test");
			applicationToMerge.setName("TESTNAMEMERGE");
			applicationRep.merge(applicationToMerge, "testMERGE");
			assertNotNull("applicationMerge method fail. No element added.", em.find(Application.class, 9898989898l));
		} catch (Exception e){
			fail("applicationMerge method fail during merge on inexistent application. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(Application.class, 9898989898l));
	}

	/*
	 *  UPDATE TEST
	 */
	@Test
	public void applicationUpdate(){
		Application applicationToUpdate = new Application();
		applicationToUpdate = em.find(Application.class, 99999l);
		applicationToUpdate.setName("TESTNAMEMERGE");

		try{
			applicationRep.update(applicationToUpdate, "testUPDATE");
			applicationToUpdate = em.find(Application.class, 99999l);
			assertTrue("applicationUpdate method failed. ItContent value wrong or not updated. "
					+ "Current value: "+applicationToUpdate.getName()+" "
					+ "Expected value: TESTNAMEMERGE.",applicationToUpdate.getName().equals("TESTNAMEMERGE"));
			assertTrue("applicationUpdate method failed. UserUpdate value not updated."
					+ "Current value: "+applicationToUpdate.getUserUpdate()+" "
					+ "Expected value: testUPDATE.", applicationToUpdate.getUserUpdate().equals("testUPDATE"));
		} catch (Exception e){
			fail("applicationUpdate method failed. Unexpected Exception catched. "+e.toString());
		}

		try{
			applicationToUpdate = new Application();
			applicationToUpdate.setId(9898989898l);
			applicationToUpdate.setUserCreated("test");
			applicationToUpdate.setName("NAME TEST ITA");
			applicationRep.update(applicationToUpdate, "testUPDATE");
			fail("applicationUpdate method failed. IllegalArgumentException not thrown.");
		} catch (IllegalArgumentException e){
			assertTrue(true); // Just for visibility :)
		} catch (Exception e){
			fail("applicationUpdate method fail during merge on inexistent application. Unexpected exception catched. "+e.toString());
		}
	}

	/*
	 *  DELETE TEST
	 */
	@Test
	public void applicationDelete(){
		Application applicationToDelete = new Application();
		applicationToDelete = em.find(Application.class, 99999l);

		try {
			applicationRep.delete(applicationToDelete, "testDELETE");
			applicationToDelete = em.find(Application.class, 99999l);
			assertFalse("applicationDelete method failed. EmailContact not disactivated.", applicationToDelete.isActive());
		} catch (Exception e){
			fail("applicationDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}

		applicationToDelete = new Application();
		applicationToDelete.setId(987987987l);
		applicationToDelete.setUserCreated("testUSER");
		applicationToDelete.setCreateDate(new Date());
		applicationToDelete.setActive(false);
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.persist(applicationToDelete);
		transaction.commit();

		try{
			applicationRep.delete(applicationToDelete, "admin");
			em = Persistence.createEntityManagerFactory("SSOPROFILER_PU").createEntityManager();
			assertNull("applicationDelete method failed. EmailContact with id 987987987 not deleted. ID: "+applicationToDelete.getId(), em.find(Application.class, 987987987l));

		} catch (Exception e){
			fail("applicationDelete method failed during delete from admin. Unexpected exception catched. "+e.toString());
		}
	}

	/*
	 *  COUNT TEST
	 */
	@Test
	public void applicationCount(){
		Long result;

		try{
			result = applicationRep.count("testADD0");
			assertTrue("applicationCount method failed. Number of Application expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("applicationCount method failed. Unexpected exception catched. "+e.toString());
		}

		try{
			result = applicationRep.count("unknowUser");
			assertTrue("applicationCount method with user parameter = 'unknowUser' failed. Number of Application expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("applicationCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
}