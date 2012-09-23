package br.com.projeto.cinema.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{

	   private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "pkUsuario")
		private Long pkUsuario;
		
		@Column(name = "senha")
		private String senha;
		
		@Column(name = "login")
		private String login;
		
		@Column(name = "administrador")
		private Integer administrador;

		public Long getPkUsuario() {
			return pkUsuario;
		}

		public void setPkUsuario(Long pkUsuario) {
			this.pkUsuario = pkUsuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public Integer getAdministrador() {
			return administrador;
		}

		public void setAdministrador(Integer administrador) {
			this.administrador = administrador;
		}


}
