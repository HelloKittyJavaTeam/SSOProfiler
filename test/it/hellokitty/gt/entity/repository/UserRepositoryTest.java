package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.repository.utils.ColumnDirection;
import it.hellokitty.gt.ssoProfiler.entity.User;
import it.hellokitty.gt.ssoProfiler.repository.repositoryImpl.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
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
			userAdd.setUserCreated("testADD"+i);
			userAdd.setActive(true);
			userAdd.setId(99999l+i);
			userAdd.setFirstName("testFILE"+i);
			em.persist(userAdd);
		}
		transaction.commit();
	}

	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
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
			User user = userRep.fetchById(99999l);
			assertNotNull("No User returned from fetchById", user);
			assertTrue("userFetchById method failed on retrieve content value. "
					+ "Actual value: "+user.getFirstName()+" "
					+ "Expected value: testFILE0", user.getFirstName().equals("testFILE0"));
			user = userRep.fetchById(987654321l);
			assertNull(user);
		} catch (Exception e) {
			fail("Caught Exception in userFetchById method. "+e.toString());
		}
	}

	@Test
	public void userFetchAll(){
		ColumnDirection cd = new ColumnDirection("id", "asc");
		List<ColumnDirection> cdList = new ArrayList<ColumnDirection>();
		cdList.add(cd);
		try {
			List<User> users = userRep.fetchAll(0, 20, cdList);
			assertTrue("userFetchAll returned a empty list.", users.size() > 0);
			assertTrue("userFetchAll didn't return all the elements.", users.size() >= 20);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in userFetchAll method.");
		}
	}

	/*
	 *  INSERT TEST
	 */
	@Test
	public void userInsert(){
		User userAdd = new User();
		userAdd.setId(98989898l);

		try{
			userRep.insert(userAdd, "testADD");
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
		User userToMerge = new User();
		userToMerge = em.find(User.class, 99999l);
		userToMerge.setFirstName("TESTNAMEMERGE");

		try{
			userRep.merge(userToMerge, "testMERGE");
			userToMerge = em.find(User.class, 99999l);
			assertTrue("userMerge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+userToMerge.getFirstName()+" "
					+ "Expected value: TESTNAMEMERGE.",userToMerge.getFirstName().equals("TESTNAMEMERGE"));
			assertTrue("userMerge method failed. UserUpdate value not updated."
					+ "Current value: "+userToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", userToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("userMerge method failed. Unexpected Exception catched. "+e.toString());
		}

		try{
			userToMerge = new User();
			userToMerge.setId(9898989898l);
			userToMerge.setUserCreated("test");
			userToMerge.setFirstName("TESTNAMEMERGE");
			userRep.merge(userToMerge, "testMERGE");
			assertNotNull("userMerge method fail. No element added.", em.find(User.class, 9898989898l));
		} catch (Exception e){
			fail("userMerge method fail during merge on inexistent user. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(User.class, 9898989898l));
	}

	/*
	 *  UPDATE TEST
	 */
	@Test
	public void userUpdate(){
		User userToUpdate = new User();
		userToUpdate = em.find(User.class, 99999l);
		userToUpdate.setFirstName("TESTNAMEMERGE");

		try{
			userRep.update(userToUpdate, "testUPDATE");
			userToUpdate = em.find(User.class, 99999l);
			assertTrue("userUpdate method failed. ItContent value wrong or not updated. "
					+ "Current value: "+userToUpdate.getFirstName()+" "
					+ "Expected value: TESTNAMEMERGE.",userToUpdate.getFirstName().equals("TESTNAMEMERGE"));
			assertTrue("userUpdate method failed. UserUpdate value not updated."
					+ "Current value: "+userToUpdate.getUserUpdate()+" "
					+ "Expected value: testUPDATE.", userToUpdate.getUserUpdate().equals("testUPDATE"));
		} catch (Exception e){
			fail("userUpdate method failed. Unexpected Exception catched. "+e.toString());
		}

		try{
			userToUpdate = new User();
			userToUpdate.setId(9898989898l);
			userToUpdate.setUserCreated("test");
			userToUpdate.setFirstName("NAME TEST ITA");
			userRep.update(userToUpdate, "testUPDATE");
			fail("userUpdate method failed. IllegalArgumentException not thrown.");
		} catch (IllegalArgumentException e){
			assertTrue(true); // Just for visibility :)
		} catch (Exception e){
			fail("userUpdate method fail during merge on inexistent user. Unexpected exception catched. "+e.toString());
		}
	}

	/*
	 *  DELETE TEST
	 */
	@Test
	public void userDelete(){
		User userToDelete = new User();
		userToDelete = em.find(User.class, 99999l);

		try {
			userRep.delete(userToDelete, "testDELETE");
			userToDelete = em.find(User.class, 99999l);
			assertFalse("userDelete method failed. EmailContact not disactivated.", userToDelete.isActive());
		} catch (Exception e){
			fail("userDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}

		userToDelete = new User();
		userToDelete.setId(987987987l);
		userToDelete.setUserCreated("testUSER");
		userToDelete.setCreateDate(new Date());
		userToDelete.setActive(false);
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.persist(userToDelete);
		transaction.commit();

		try{
			userRep.delete(userToDelete, "admin");
			em = Persistence.createEntityManagerFactory("SSOPROFILER_PU").createEntityManager();
			assertNull("userDelete method failed. EmailContact with id 987987987 not deleted. ID: "+userToDelete.getId(), em.find(User.class, 987987987l));

		} catch (Exception e){
			fail("userDelete method failed during delete from admin. Unexpected exception catched. "+e.toString());
		}
	}

	/*
	 *  COUNT TEST
	 */
	@Test
	public void userCount(){
		Long result;

		try{
			result = userRep.count("testADD0");
			assertTrue("userCount method failed. Number of User expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("userCount method failed. Unexpected exception catched. "+e.toString());
		}

		try{
			result = userRep.count("unknowUser");
			assertTrue("userCount method with user parameter = 'unknowUser' failed. Number of User expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("userCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
}