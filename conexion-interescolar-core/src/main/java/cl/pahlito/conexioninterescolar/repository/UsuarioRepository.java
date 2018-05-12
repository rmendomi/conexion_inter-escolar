package cl.pahlito.conexioninterescolar.repository;

import org.springframework.data.repository.CrudRepository;

import cl.pahlito.conexioninterescolar.dominio.UsuarioJPA;

public interface UsuarioRepository extends CrudRepository<UsuarioJPA, Long> {
	
	public UsuarioJPA findByEmailAndPassword(String email, String password);

}
