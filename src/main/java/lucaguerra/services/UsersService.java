package lucaguerra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucaguerra.entities.NewUserPayload;
import lucaguerra.entities.User;
import lucaguerra.exceptions.BadRequestException;
import lucaguerra.exceptions.NotFoundException;
import lucaguerra.repositories.UserRepository;

@Service
public class UsersService {

	@Autowired
	UserRepository userRepository;

	// SALVA NUOVO UTENTE + ECCEZIONE SE VIENE USATA LA STESSA EMAIL
	public User save(NewUserPayload body) {
		userRepository.findByEmail(body.getEmail()).ifPresent(user -> {
			throw new BadRequestException("L'email " + body.getEmail() + " è gia stata utilizzata");
		});
		User newUser = new User(body.getName(), body.getSurname(), body.getEmail());
		return userRepository.save(newUser);
	}

	// TORNA LA LISTA DEGLI UTENTI
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	// CERCA UTENTE TRAMITE ID
	public User findById(int id) throws NotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	// CERCA E MODIFICA UTENTE TRAMITE ID
	public User findByIdAndUpdate(int id, NewUserPayload body) throws NotFoundException {
		User found = this.findById(id);
		found.setName(body.getName());
		found.setSurname(body.getSurname());
		found.setEmail(body.getEmail());
		return userRepository.save(found);
	}

	// CERCA E CANCELLA UTENTE TRAMITE ID
	public void findByIdAndDelete(int id) throws NotFoundException {
		User found = this.findById(id);
		userRepository.delete(found);
	}
}
