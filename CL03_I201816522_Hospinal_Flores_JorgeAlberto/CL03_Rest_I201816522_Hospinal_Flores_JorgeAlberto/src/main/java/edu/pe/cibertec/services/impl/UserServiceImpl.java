package edu.pe.cibertec.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pe.cibertec.dao.entity.User;
import edu.pe.cibertec.dao.repository.UserRepository;
import edu.pe.cibertec.services.UserService;

@Repository
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User addUser(User user) {
		return getUserRepository().save(user);
	}

	@Override
	public User saveUser(User user, Integer id) {
		//return getUserRepository().save(user);
	    return getUserRepository().findById(id)
	    	      .map(data -> {
	    	    	  data.setUserName(user.getUserName());
	    	    	  data.setFirstName(user.getFirstName());
	    	    	  data.setLastName(user.getLastName());
	    	    	  data.setPassword(user.getPassword());
	    	    	  data.setPicture(user.getPicture());
	    	    	  data.setEmail(user.getEmail());
	    	        return getUserRepository().save(data);
	    	      })
	    	      .orElseGet(() -> {
	    	    	  user.setId(id);
	    	        return getUserRepository().save(user);
	    	      });
	}

	@Override
	public void removeUser(Integer idUser) {
		getUserRepository().deleteById(idUser);
	}

	@Override
	public User findUserById(Integer idUser) {
		Optional<User> found = getUserRepository().findById(idUser);
		return ( found.isPresent() ? found.get() : null);
	}

	@Override
	public User findUserByUserName(String userName) {
		Optional<User> found = getUserRepository().findUserByUserName(userName);
		return ( found.isPresent() ? found.get() : null);		
	}

	@Override
	public List<User> findAll() {
		return getUserRepository().findAll();
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findFirstByOrderByIdDesc() {
		return getUserRepository().findFirstByOrderByIdDesc();
	}


}
