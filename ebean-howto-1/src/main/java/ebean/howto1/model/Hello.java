package ebean.howto1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hello {
	@Id
	private long id;
	@Column
	private String message;

	public Hello() {
	}

	public Hello(long id, String message) {
		this.id = id;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
