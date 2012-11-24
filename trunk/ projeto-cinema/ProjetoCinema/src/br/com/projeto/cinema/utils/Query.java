package br.com.projeto.cinema.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Query
{
	private List<String> querys = new ArrayList<String>();
	private List<Object> parametros = new ArrayList<Object>();
		
	/*-*-*-* Construtores *-*-*-*/
	/**
	 * Construtor vazio, nao especifica a base de conversao
	 * <BR>Caso utilize este contrutor para obter a query utilize: toString(baseJDBC)
	 */
	public Query() { }
	
	public Query(String query, Object... parametros) { add(query, parametros); }

	
	/*-*-*-* Metodos Publicos *-*-*-*/
	/**
	 * Adiciona o trecho na query
	 * @param query a ser adicionada, para definir os parametros utilize o caractere '?'
	 * @param parametros lista de parametros a serem adicionados no trecho, os parametros devem estar na mesma ordem em que os '?' estao na query
	 * @throws Exception
	 */
	public void add(String query, Object... parametros)
	{
		this.querys.add(query);
		this.parametros.add(parametros);
	}
	
	/**
	 * Metodo que monta e retorna a query em formato String utlizando a base de conversao passada por parametro
	 * @param baseJDBC utilizada para a conversao dos objects em strings para query
	 * @return query
	 */
	public String toString()
	{
		StringBuffer querySQL = new StringBuffer();
		String query;
		Object[] parametros;
		
		for(int i=0; i<querys.size(); i++)
		{
			query = querys.get(i);
			parametros = (Object[])this.parametros.get(i);
			
			if(query!=null)
			{		
				int indexParametro=0;
				char caractere;
				for(int j=0; j<query.length(); j++)
				{
					caractere = query.charAt(j);
					if(caractere=='?')
					{
						Object ob = parametros[indexParametro];
						
						if(ob.getClass()==String.class) { querySQL.append("'" + ob.toString() + "'"); }		
						else if(ob.getClass()==Long.class) { querySQL.append(ob.toString()); }		
						else if(ob.getClass()==Date.class) { querySQL.append("'" + ob.toString() + "'"); }		
						else { querySQL.append(ob.toString()); }		
						
						indexParametro++;
					}
					else
					{
						querySQL.append(caractere);
					}
				}
			}
		}

		return querySQL.toString();
	}
	
	/**
	 * Este metodo e utilizado para a concatenacao de querys
	 * @return o ultimo caractere da ultima query inserida
	 */
	public Character getUltimoChar()
	{
		if(querys.size()>0)
		{
			String query = querys.get(querys.size()-1);
			if(query!=null && query.length()>0)
			{
				return query.charAt(query.length()-1);
			}
		}
		return null;
	}
}
