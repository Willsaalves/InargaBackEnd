package com.backEnd.INarga.controller;

//UserController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backEnd.INarga.DTO.UserDTO;
import com.backEnd.INarga.entity.User;
import com.backEnd.INarga.exceptions.TelefoneAlreadyExistsException;
import com.backEnd.INarga.exceptions.TelefoneNotFoundException;
import com.backEnd.INarga.service.AuthService;
import com.backEnd.INarga.service.UserService;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;

	@CrossOrigin(origins = "http://192.168.15.50:8081")
	@PostMapping("/criarUsers")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {

		try {
			User user = new User();
			user.setUsername(userDTO.username());
			user.setSenha(userDTO.senha());
			user.setTelefone(userDTO.telefone());

			// Salva o usuário usando o serviço
			User savedUser = userService.saveUser(user);

			// Retorna a resposta com o usuário salvo
			return ResponseEntity.ok(savedUser);

		} catch (TelefoneAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}

	}
	@CrossOrigin(origins = "http://192.168.15.50:8081")
	@PostMapping("/login")
	public ResponseEntity<?> autenticar(@RequestBody User usuario) {
		String telefone = usuario.getTelefone();
		String senha = usuario.getSenha();

		if (authService.autenticarUsuario(telefone, senha)) {
			return ResponseEntity.ok("Login bem-sucedido");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Telefone ou senha incorretos");
		}
	}

	@CrossOrigin(origins = "http://192.168.15.50:8081")
	@GetMapping("/verificarTelefone/{telefone}")
	public ResponseEntity<?> buscarPorTelefone(@PathVariable String telefone) {
		try {
			User usuario = userService.buscarPorTelefone(telefone);
			return ResponseEntity.ok(usuario);
		} catch (TelefoneNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
