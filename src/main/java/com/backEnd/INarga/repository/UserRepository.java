package com.backEnd.INarga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backEnd.INarga.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByTelefone(String telefone);

	 Optional<User> findByTelefone(String telefone);
   
}
