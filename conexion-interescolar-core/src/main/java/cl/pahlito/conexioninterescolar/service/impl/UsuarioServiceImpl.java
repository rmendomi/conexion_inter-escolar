package cl.pahlito.conexioninterescolar.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.pahlito.conexioninterescolar.domain.UsuarioDTO;
import cl.pahlito.conexioninterescolar.dominio.UsuarioJPA;
import cl.pahlito.conexioninterescolar.repository.UsuarioRepository;
import cl.pahlito.conexioninterescolar.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	private final static Logger logger=LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDTO login(String email, String password) {
		UsuarioDTO usuario = null;
		UsuarioJPA usuarioJPA = usuarioRepository.findByEmailAndPassword(email, convertirHash(password));
		if (null != usuarioJPA) {
			usuario = new UsuarioDTO();
			usuario.setId(usuarioJPA.getId());
			usuario.setNombre(usuarioJPA.getNombre());
			usuario.setEmail(usuarioJPA.getEmail());
		}
		return usuario;
	}

	private String convertirHash(String password) {
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.toString());
		}
		return hash;
	}

}
