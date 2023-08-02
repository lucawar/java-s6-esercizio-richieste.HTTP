package lucaguerra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String surname;
	private String email;

	public User(String name, String surname, String email) {

		this.name = name;
		this.surname = surname;
		this.email = email;
	}

}
