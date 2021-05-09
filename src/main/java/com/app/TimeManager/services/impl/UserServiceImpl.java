package com.app.TimeManager.services.impl;

import com.app.TimeManager.entities.User;
import com.app.TimeManager.repositories.UsersRepository;
import com.app.TimeManager.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UsersRepository usersRepository;

	@Override
	public Boolean login(String login, String password) {
		Boolean result = usersRepository.getUserByLoginAndPassword(login, password) != null;

		if (result) {
			log.info("Successful login [{}]", login);
		} else {
			log.warn("Failed login [{}]", login);
		}
		return result;
	}

	@Override
	public List<User> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public void addUser(User user) {
		usersRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}
}