package com.andrey.spring.demo.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.andrey.spring.demo.models.Greeting;
import com.andrey.spring.demo.persistence.dao.GreetingDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/Spring/persistence-config.xml" })
@Transactional
public class GreetingDaoTest {

	private static final String GREETING1_NAME = "name1";
	private static final String GREETING2_NAME = "name2";
	private static final String GREETING3_NAME = "name3";
	private static final String GREETING1_MSG = "hello1";
	private static final String GREETING2_MSG = "hello2";
	private static final String GREETING3_MSG = "hello3";
	private static final int GREETINGS_COUNT = 3;
	
	private Greeting greeting1, greeting2, greeting3;

	@Autowired
	private GreetingDao greetingDao;

	@Before
	public void before() {
		greeting1 = new Greeting(GREETING1_MSG, GREETING1_NAME);
		greeting2 = new Greeting(GREETING2_MSG, GREETING2_NAME);
		greeting3 = new Greeting(GREETING3_MSG, GREETING3_NAME);
		greetingDao.createGreeting(greeting1);
		greetingDao.createGreeting(greeting2);
		greetingDao.createGreeting(greeting3);
	}

	@Test
	public void testGetAllGreetingsWithResult() {
		List<Greeting> result = greetingDao.getAllGreetings();
		Assert.assertTrue(result.size() > 0);
		Assert.assertEquals(result.size(), GREETINGS_COUNT);
	}
	
	@Test
	public void testGetAllGreetingsWithoutResult() {
		greetingDao.deleteAllGreetings();
		List<Greeting> result = greetingDao.getAllGreetings();
		Assert.assertTrue(result.size() == 0);
	}	
	
	@Test
	public void testGetGreetingById() {
		String id = greeting2.getGreetingId();
		Greeting result = new Greeting(greetingDao.getGreetingById(id));
		Assert.assertNotNull(result);
		Assert.assertEquals(greeting2, result);
	}
	
}
