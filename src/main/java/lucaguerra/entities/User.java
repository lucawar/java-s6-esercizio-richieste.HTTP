package lucaguerra.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

	private int id;
	private String name;
	private String surname;
	private String email;

	public User(int id, String name, String surname, String email) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

}
