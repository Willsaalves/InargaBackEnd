package com.backEnd.INarga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backEnd.INarga.entity.User;
import com.backEnd.INarga.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean autenticarUsuario(String telefone, String senha) {
        User usuario = userRepository.findByTelefone(telefone).orElse(null);

        // Verifica se o usuário existe e se a senha está correta
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
