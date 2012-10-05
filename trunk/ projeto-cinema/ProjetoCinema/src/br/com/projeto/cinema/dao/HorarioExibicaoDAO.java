package br.com.projeto.cinema.dao;

import java.util.List;

import br.com.projeto.cinema.bean.Horario;
import br.com.projeto.cinema.dao.base.GenericDao;
import br.com.projeto.cinema.utils.Query;

public class HorarioExibicaoDAO extends GenericDao<Horario> 
{
	public List<Horario> obterTodos()
	{
		try 
		{
			return obtemTodos(new Query("SELECT * FROM Horario"), Horario.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Horario remover(Horario horario)
	{
		try {
			return obtem(new Query("DELETE FROM Horario WHERE pkHorario = ?", horario.getPkHorario()),Horario.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
