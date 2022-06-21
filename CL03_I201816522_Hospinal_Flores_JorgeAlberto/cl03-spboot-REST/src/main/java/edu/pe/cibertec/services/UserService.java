package edu.pe.cibertec.services;

import java.util.List;

import edu.pe.cibertec.dao.entity.User;

public interface UserService 
{
	User addUser(User user);

	User saveUser(User user, Integer id);

	void removeUser(Integer idUser);

	User findUserById(Integer idUser);

	User findUserByUserName(String userName);

	List<User> findAll();

	User findFirstByOrderByIdDesc();
}
