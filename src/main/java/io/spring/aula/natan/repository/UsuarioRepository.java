package io.spring.aula.natan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.aula.natan.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
