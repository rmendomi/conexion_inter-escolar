package com.interescolar.conexioninterescolar.service;

import com.interescolar.conexioninterescolar.domain.UsuarioDTO;

public interface UsuarioService {

	@Deprecated
	UsuarioDTO login(String email, String password);

	UsuarioDTO cargarUsuario(String email);
	
}
