package com.interescolar.conexioninterescolar.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interescolar.conexioninterescolar.domain.UsuarioDTO;
import com.interescolar.conexioninterescolar.dominio.UsuarioJPA;
import com.interescolar.conexioninterescolar.repository.UsuarioRepository;
import com.interescolar.conexioninterescolar.service.UsuarioService;

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

	@Override
	public UsuarioDTO cargarUsuario(String email) {
		UsuarioDTO usuario=null;
		final UsuarioJPA usuarioJPA = usuarioRepository.findByEmail(email);
		if(null!=usuarioJPA) {
			usuario=new UsuarioDTO();
			usuario.setId(usuarioJPA.getId());
			usuario.setEmail(usuarioJPA.getEmail());
			usuario.setNombre(usuarioJPA.getNombre());
			usuario.setPassword(usuarioJPA.getPassword());
		}
		
		return usuario;
	}

}
