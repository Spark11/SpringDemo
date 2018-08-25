package com.andrey.spring.demo.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.andrey.spring.demo.models.Greeting;
import com.andrey.spring.demo.persistence.entities.GreetingEntity;

@Component
public class GreetingDaoImpl implements GreetingDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Greeting> getAllGreetings() {
		String queryString = "SELECT g FROM GreetingEntity g";
		Query query = entityManager.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<Greeting> greetings = query.getResultList();
		return greetings;
	}

	@Override
	public Greeting getGreetingById(String id) {
		String queryString = "SELECT g FROM GreetingEntity g WHERE g.greetingId = :id";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Greeting> greetings = query.getResultList();
		
		if(!greetings.isEmpty()) {
			return greetings.get(0);
		}
		
		return null;
	}

	@Override
	public void createGreeting(Greeting greeting) {
		GreetingEntity greetingEntity = new GreetingEntity(greeting);
		entityManager.merge(greetingEntity);
	}

	@Override
	public void deleteGreetingById(String id) {
		Greeting greeting = getGreetingById(id);
		entityManager.remove(greeting);
	}

	@Override
	public void deleteAllGreetings() {
		List<Greeting> greetings = getAllGreetings();
		for(Greeting greeting : greetings) {
			entityManager.remove(greeting);			
		}
	}

}
