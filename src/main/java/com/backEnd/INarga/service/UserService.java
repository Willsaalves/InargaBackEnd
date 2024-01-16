package com.backEnd.INarga.service;

//UserService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backEnd.INarga.entity.User;
import com.backEnd.INarga.exceptions.TelefoneAlreadyExistsException;
import com.backEnd.INarga.exceptions.TelefoneNotFoundException;
import com.backEnd.INarga.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		if (userRepository.existsByTelefone(user.getTelefone())) {
			throw new TelefoneAlreadyExistsException("Telefone já existe, escolha outro.");
		}

		return userRepository.save(user);
	}

	public User buscarPorTelefone(String telefone) {
		return userRepository.findByTelefone(telefone).orElseThrow(
				() -> new TelefoneNotFoundException("Telefone não encontrado com o username: " + telefone));
	}

}
