package lucaguerra.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import lucaguerra.entities.User;

@Service
public class UsersService {

	private List<User> users = new ArrayList<>();

	public User save(User user) {
		Random rndm = new Random();
		user.setId(rndm.nextInt());
		this.users.add(user);
		return user;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public Optional<User> findById(int id) {
		User u = null;

		for (User user : users) {
			if (user.getId() == id)
				u = user;
		}
		return Optional.ofNullable(u);
	}
}
