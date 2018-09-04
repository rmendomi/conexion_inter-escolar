package main.java.com.interescolar.conexioninterescolar.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.interescolar.conexioninterescolar.domain.UsuarioDTO;
import com.interescolar.conexioninterescolar.service.UsuarioService;

@Service("applicationUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		final User user = cargarUsuario(email);
		
		return user;
	}

	private User cargarUsuario(String email) { 
		User user = null;
		final UsuarioDTO usuario= usuarioService.cargarUsuario(email);
		if(usuario!=null) { 
			//TODO implementar for real 
			final List<GrantedAuthority> authorities=new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			user = new User(usuario.getEmail(), usuario.getPassword(), authorities);
		}
		return user;
	}

}
