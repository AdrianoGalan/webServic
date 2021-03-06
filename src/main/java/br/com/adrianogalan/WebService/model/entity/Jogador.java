package br.com.adrianogalan.WebService.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;



@Entity
@Table(name = "Jogador")
@NamedNativeQuery(
		name = "Jogador.findJogadoresDataConv",
		query = "SELECT j.codigo, j.nomeJogador, j.sexo, j.altura,"
				+ " CONVERT(CHAR(10), j.dt_nasc, 103) as dt_nasc, j.id_time,"
				+ " t.Id, t.nome, t.cidade"
				+ " FROM jogador j, times t"
				+ " WHERE j.id_time = t.id",
		resultClass = Jogador.class)

@NamedNativeQuery(
		name = "Jogador.findJogadorDataConv",
		query = "SELECT j.codigo, j.nomeJogador, j.sexo, j.altura,"
				+ " CONVERT(CHAR(10), j.dt_nasc, 103) as dt_nasc, j.id_time,"
				+ " t.Id, t.nome, t.cidade"
				+ " FROM jogador j, times t"
				+ " WHERE j.id_time = t.id"
				+ " AND j.codigo = ?1",
		resultClass = Jogador.class)
	
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int codigo;
	
	@Column
	private String nomeJogador;
	
	@Column
	private String sexo;
	
	@Column
	private float altura;
	
	@Column
	private String dtNasc;
	
	@ManyToOne(targetEntity = Times.class)
	@JoinColumn(name = "id_time")
	private Times times;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Times getTimes() {
		return times;
	}

	public void setTimes(Times times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "Jogador [codigo=" + codigo + ", nomeJogador=" + nomeJogador + ", sexo=" + sexo + ", altura=" + altura
				+ ", dtNasc=" + dtNasc + ", times=" + times + "]";
	}

}
