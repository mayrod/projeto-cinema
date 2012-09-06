package br.com.projeto.cinema.dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.Usuario;


public class GeraTabelas {

	public static void main(String[] args) {

		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Filme.class);
		cfg.addAnnotatedClass(Usuario.class);

		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

}
