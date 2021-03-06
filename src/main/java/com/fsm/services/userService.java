package com.fsm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsm.domain.User;
import com.fsm.dto.UserDTO;
import com.fsm.repository.UserRepository;
import com.fsm.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	public User insert (User user) {
		return userRepository.insert(user);
		
	}
	public void delete (String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User fromDto(UserDTO userDTO) {
		return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
	}
	public User update(User outdatedUser) {
		User toBeUpdateUser = findById(outdatedUser.getId());
		update(toBeUpdateUser,outdatedUser);
		return userRepository.save(toBeUpdateUser);
	}
	public void update(User toBeUpdateUser,User outdatedUser) {
		toBeUpdateUser.setName(outdatedUser.getName());
		toBeUpdateUser.setEmail(outdatedUser.getEmail());
	}
}
