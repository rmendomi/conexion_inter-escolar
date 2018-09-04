package com.interescolar.conexioninterescolar.repository;

import org.springframework.data.repository.CrudRepository;

import com.interescolar.conexioninterescolar.dominio.UsuarioJPA;

public interface UsuarioRepository extends CrudRepository<UsuarioJPA, Long> {
	
	public UsuarioJPA findByEmailAndPassword(String email, String password);

	public UsuarioJPA findByEmail(String email);

}
