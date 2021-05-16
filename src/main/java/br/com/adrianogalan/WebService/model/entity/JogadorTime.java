package br.com.adrianogalan.WebService.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "JogadorTime")
@NamedNativeQuery(
		name = "JogadorTime.udfJogadorIdade",
		query = "SELECT codigo, nomeJogador, sexo, altura, dt_nasc, idade, id, nome, cidade"
				+ " from fn_jogadoridade(?1) ",
		resultClass = JogadorTime.class)
public class JogadorTime {

	@Id
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
	@Column
	private int idade;
	@Column
	private int id;
	@Column
	private String nome;
	@Column
	private String cidade;

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
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "JogadorTime [codigo=" + codigo + ", nomeJogador=" + nomeJogador + ", sexo=" + sexo + ", altura="
				+ altura + ", dtNasc=" + dtNasc + ", idade=" + idade + ", nome=" + nome + ", cidade=" + cidade + "]";
	}

}
