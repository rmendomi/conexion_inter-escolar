package cl.pahlito.conexioninterescolar.service;

import cl.pahlito.conexioninterescolar.domain.UsuarioDTO;

public interface UsuarioService {

	@Deprecated
	UsuarioDTO login(String email, String password);

	UsuarioDTO cargarUsuario(String email);
	
}
