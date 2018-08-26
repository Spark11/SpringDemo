package com.andrey.spring.demo.persistence.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.andrey.spring.demo.models.Greeting;

@Entity
@Table(name = "sd_greetings")
public class GreetingEntity extends Greeting {

	public GreetingEntity() {
		super();
	}

	public GreetingEntity(Greeting greeting) {
		super(greeting);
	}

	public GreetingEntity(String message, String name) {
		super(message, name);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column
	@Access(AccessType.PROPERTY)
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	@Column
	@Access(AccessType.PROPERTY)
	public String getName() {
		return super.getName();
	}

	@Override
	@Column(unique = true)
	@Access(AccessType.PROPERTY)
	public String getGreetingId() {
		return super.getGreetingId();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(
				this.getClass().getSimpleName() + " [id=" + id + ", version=" + version + ", ");
		result.append(super.toString()).append("]");
		return result.toString();
	}
}
