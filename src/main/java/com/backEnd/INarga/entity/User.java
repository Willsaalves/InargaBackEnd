package com.backEnd.INarga.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UsersApp")
public class User {

 @Id
 @GeneratedValue(strategy = GenerationType.UUID)
 private Long id;

 private String username;
 private String senha;
 @Column(name = "telefone", nullable = false, unique = true)
 private String telefone;

}

