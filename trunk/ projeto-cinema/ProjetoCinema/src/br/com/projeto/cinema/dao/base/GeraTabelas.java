package br.com.projeto.cinema.dao.base;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.projeto.cinema.bean.Ator;
import br.com.projeto.cinema.bean.AvaliacaoFilme;
import br.com.projeto.cinema.bean.Elenco;
import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.bean.FilmeHorarioExibicao;
import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.bean.HorarioExibicao;
import br.com.projeto.cinema.bean.Pessoa;
import br.com.projeto.cinema.bean.Preco;
import br.com.projeto.cinema.bean.Produtora;
import br.com.projeto.cinema.bean.Sala;
import br.com.projeto.cinema.bean.Usuario;

public class GeraTabelas {

	public static void main(String[] args) {

		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Ator.class);
		cfg.addAnnotatedClass(AvaliacaoFilme.class);
		cfg.addAnnotatedClass(Elenco.class);
		cfg.addAnnotatedClass(Filme.class);
		cfg.addAnnotatedClass(FilmeCartaz.class);
		cfg.addAnnotatedClass(FilmeCategoria.class);
		cfg.addAnnotatedClass(FilmeHorarioExibicao.class);
		cfg.addAnnotatedClass(FilmeLancamento.class);
		cfg.addAnnotatedClass(FilmePromocao.class);
		cfg.addAnnotatedClass(HorarioExibicao.class);		
		cfg.addAnnotatedClass(Pessoa.class);
		cfg.addAnnotatedClass(Preco.class);
		cfg.addAnnotatedClass(Produtora.class);
		cfg.addAnnotatedClass(Sala.class);
		cfg.addAnnotatedClass(Usuario.class);

		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

}
