package main.java.com.interescolar.conexioninterescolar.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Messagebox;

import com.interescolar.conexioninterescolar.domain.UsuarioDTO;
import com.interescolar.conexioninterescolar.service.UsuarioService;

public class LoginVM {

	private String email;
	
	private String password;
	
	private UsuarioService usuarioService;
	
	@Init
	public void init() {
		usuarioService=(UsuarioService) SpringUtil.getBean("usuarioService");
	}
	
	@Command
	public void login() {
		UsuarioDTO usuario=usuarioService.login(email, password);
		if(null==usuario) {
			Messagebox.show("Usuario no existe");
		}else {
			Messagebox.show("Bienvenido "+usuario.getNombre());
		}
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
