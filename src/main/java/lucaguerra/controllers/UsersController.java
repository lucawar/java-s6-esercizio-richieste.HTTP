package lucaguerra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lucaguerra.entities.NewUserPayload;
import lucaguerra.entities.User;
import lucaguerra.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersService userService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody NewUserPayload body) {
		User createdUser = userService.save(body);
		return createdUser;
	}

	@GetMapping("")
	public List<User> getUsers() {
		return userService.getUsers();
	}

//	@GetMapping("/{userId}")
//	public User findById(@PathVariable int userId) throws Exception {
//		return userService.findById(userId).orElseThrow(() -> new Exception("UTENTE NON TROVATO"));
//	}
}
