package br.com.projeto.cinema.dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class GeraTabelas {

	public static void main(String[] args) {

		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Filme.class);

		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

}
