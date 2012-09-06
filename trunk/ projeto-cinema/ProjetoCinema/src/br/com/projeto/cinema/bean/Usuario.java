package br.com.projeto.cinema.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	
		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name = "pkfuncionario")
		private Long pkFuncionario;
		
		@Column(name = "nome")
		private String nome;
		
		@Column(name = "login")
		private String login;
		
		@Column(name = "senha")
		private String senha;
		
		@Column(name = "administrador")
		private int administrador;

		public Long getPkFuncionario() {
			return pkFuncionario;
		}

		public void setPkFuncionario(Long pkFuncionario) {
			this.pkFuncionario = pkFuncionario;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public int getAdministrador() {
			return administrador;
		}

		public void setAdministrador(int administrador) {
			this.administrador = administrador;
		}
		

}
