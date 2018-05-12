package cl.pahlito.conexioninterescolar.service;

import cl.pahlito.conexioninterescolar.domain.UsuarioDTO;

public interface UsuarioService {

	UsuarioDTO login(String email, String password);
	
}
