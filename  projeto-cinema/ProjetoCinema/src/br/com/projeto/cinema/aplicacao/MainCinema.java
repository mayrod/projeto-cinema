package br.com.projeto.cinema.aplicacao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.cinema.dao.base.UtilDAO;

public class MainCinema implements Servlet
{
	 
	@Override
	public void init(ServletConfig arg0) throws ServletException
	{
		try
		{
			System.out.println("SISTEMA CINEMA INICIALIZADO COM SUCESSO");
			
			
		}
		catch(Exception e)
		{
			System.out.println("SISTEMA CINEMA NÃO INICIALIZADO");
			e.printStackTrace();

			return;
		}

	}

	@Override
	public void destroy()
	{
		try
		{
		}
		catch(Exception e)
		{
		}
	}

	@Override
	public ServletConfig getServletConfig() { return null; }

	@Override
	public String getServletInfo() { return null; }

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
    {  
      PrintWriter out = response.getWriter();  
      out.println(request.getRemoteAddr());  
      out.close();  
    }  
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException { 
	      PrintWriter out = arg1.getWriter();  
	      out.println(arg0.getRemoteAddr());  
	      out.close(); 
	}
	
	
}
