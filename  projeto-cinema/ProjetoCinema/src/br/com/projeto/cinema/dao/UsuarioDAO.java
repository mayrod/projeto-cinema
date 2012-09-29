package br.com.projeto.cinema.dao;

import br.com.projeto.cinema.bean.Usuario;
import br.com.projeto.cinema.dao.base.GenericDao;

public class UsuarioDAO extends GenericDao<Usuario> 
{

	public Usuario verificarLogin(Usuario usuario)
	{
		try 
		{
			String query = new String();

			query = "SELECT *";
			query = query + " FROM Usuario";
			
			Usuario usu = obtem(query, Usuario.class);
			
			if(usu!=null)
			{
				if(usu.getLogin().equals(usuario.getLogin()) && usu.getSenha().equals(usuario.getSenha()))
				{
					return usu;
				}					
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
