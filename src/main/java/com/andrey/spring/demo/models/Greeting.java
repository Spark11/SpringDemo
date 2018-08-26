package com.andrey.spring.demo.models;

import java.util.UUID;

public class Greeting {
	private String message;
	private String name;
	private String greetingId;

	public Greeting() {
		super();
	}

	public Greeting(String message, String name) {
		super();
		this.message = message;
		this.name = name;
		this.greetingId = UUID.randomUUID().toString();
	}

	public Greeting(Greeting greeting) {
		setGreetingId(greeting.getGreetingId());
		setMessage(greeting.getMessage());
		setName(greeting.getName());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreetingId() {
		return greetingId;
	}

	public void setGreetingId(String greetingId) {
		this.greetingId = greetingId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((greetingId == null) ? 0 : greetingId.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Greeting other = (Greeting) obj;
		if (greetingId == null) {
			if (other.greetingId != null)
				return false;
		} else if (!greetingId.equals(other.greetingId))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Greeting [message=" + message + ", name=" + name + ", greetingId=" + greetingId + "]";
	}

}
