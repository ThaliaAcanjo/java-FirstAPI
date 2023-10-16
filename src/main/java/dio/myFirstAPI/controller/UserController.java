package dio.myFirstAPI.controller;

import dio.myFirstAPI.model.User;
import dio.myFirstAPI.repository.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
		@Autowired
		private UserRepositoy userRepositoy;

		@GetMapping()
		public List<User> getUsers(){
				return userRepositoy.findAll();
		}

		@GetMapping("/{username}")
		public User getOne(@PathVariable("username") String userName){
				return userRepositoy.findByName(userName);
		}

		@DeleteMapping("/{id}")
		public void deleteUser(@PathVariable("id") Integer id){
				userRepositoy.deleteById(id);
		}

		@PostMapping("/users")
		public void postUser(@RequestBody User user){
				userRepositoy.save(user);
		}
		@PutMapping()
		public void putUser(@RequestBody User user){
				userRepositoy.save(user);
		}
}
