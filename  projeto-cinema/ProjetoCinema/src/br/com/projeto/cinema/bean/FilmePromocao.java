package br.com.projeto.cinema.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FILMEPROMOCAO")
public class FilmePromocao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "pkFilmePromocao")
	private Long pkFilmePromocao;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "dataInicio")
	private Date dataInicio;
	
	@Column(name = "dataTermino")
	private Date dataTermino;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "porcentagemPromocao")
	private Double porcentagemPromocao;

	@Column(name = "status")
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@ManyToOne @JoinColumn(name="fkFilme")
	private Filme filme;
	
	@OneToMany @JoinTable(name="filmeHorario" , joinColumns = @JoinColumn(name = "pkFilmePromocao"), inverseJoinColumns = @JoinColumn(name = "pkFilmeHorario"))
	private List<Sessao> horarios;
	
	public Long getPkFilmePromocao() {
		return pkFilmePromocao;
	}

	public void setPkFilmePromocao(Long pkFilmePromocao) {
		this.pkFilmePromocao = pkFilmePromocao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPorcentagemPromocao() {
		return porcentagemPromocao;
	}

	public void setPorcentagemPromocao(Double porcentagemPromocao) {
		this.porcentagemPromocao = porcentagemPromocao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<Sessao> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Sessao> horarios) {
		this.horarios = horarios;
	}

	@Override
	public String toString() {
		return codigo;
	}
}
