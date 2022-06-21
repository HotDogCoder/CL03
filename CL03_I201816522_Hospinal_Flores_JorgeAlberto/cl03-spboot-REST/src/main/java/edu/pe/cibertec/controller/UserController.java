package edu.pe.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.cibertec.dao.entity.User;
import edu.pe.cibertec.services.UserService;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService ;
	
	@PostMapping ("/user")
	public User addUser (@RequestBody User user)
	{
		return getUserService ().addUser(user);
	}
	
	@PutMapping ("/user/{id}")
	public User saveUser (@RequestBody User user, @PathVariable Integer id)
	{
		return getUserService ().saveUser(user, id);
	}
	
	@DeleteMapping ("/user/{id}")
	public User removeUser ( @PathVariable Integer id)
	{
		 User user = getUserService ().findUserById(id);
		 if (user!=null);
		   getUserService ().removeUser(id);
		 
		 return user;
	}
	
	@GetMapping ("/user")
	public List<User> findAll ()
	{
		return getUserService().findAll();
	}
	
	
	@GetMapping ("/user/{id}")
	public User findAll (@PathVariable Integer id)
	{
		return getUserService().findUserById(id);
	}
	
	@GetMapping ("/lastUser")
	public User lastUser()
	{
		return getUserService().findFirstByOrderByIdDesc();
	}
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


}
