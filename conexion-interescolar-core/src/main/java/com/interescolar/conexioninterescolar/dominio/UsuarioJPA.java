package com.interescolar.conexioninterescolar.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ci_usuarios")
public class UsuarioJPA {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="id_usuario")
	private Long id;
	
	@Column(name="nombre_usuario")
	private String nombre;

	
	@Column(name="email_usuario")
	private String email;

	
	@Column(name="pass_usuario")
	private String password;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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
