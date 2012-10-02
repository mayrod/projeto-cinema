package br.com.projeto.cinema.dao;

import br.com.projeto.cinema.bean.Usuario;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class UsuarioDAO extends GenericDao<Usuario> 
{

	public Usuario verificarLogin(Usuario usuario)
	{
		try 
		{
			Query query = new Query();

			query.add("SELECT *");
			query.add(" FROM Usuario");
			query.add(" WHERE login = ?", usuario.getLogin());
			query.add(" AND senha = ?", usuario.getSenha());
			
			Usuario usu = obtem(query, Usuario.class);
			
			if(usu!=null)
			{
				return usu;				
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
