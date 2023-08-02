package lucaguerra.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewUserPayload {

	private String name;
	private String surname;
	private String email;

	public NewUserPayload(String name, String surname, String email) {

		this.name = name;
		this.surname = surname;
		this.email = email;
	}

}
