package com.andrey.spring.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andrey.spring.demo.models.Greeting;
import com.andrey.spring.demo.persistence.dao.GreetingDao;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Autowired
	private GreetingDao greetingDao;

	@Transactional(readOnly = true)
	public List<Greeting> getAllMessages() {
		// return GreetingDatabase.getInstance().getAllMessages();
		return greetingDao.getAllGreetings();
	}

	@Transactional(readOnly = true)
	public Greeting getMessageById(String id) {
		// return GreetingDatabase.getInstance().getMessageById(id);
		return greetingDao.getGreetingById(id);
	}

	@Override
	@Transactional
	public void createGreeting(Greeting greeting) {
		greetingDao.createGreeting(greeting);
	}

}
