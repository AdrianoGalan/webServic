package br.com.adrianogalan.WebService.model.dto;



public class JogadorDTO {

	private int codigo;
	private String nomeJogador;
	private String sexo;
	private float altura;
	private String dtNasc;
	private int idade;
	private TimeDTO times;

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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public TimeDTO getTimes() {
		return times;
	}

	public void setTimes(TimeDTO times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "Jogador [codigo=" + codigo + ", nomeJogador=" + nomeJogador + ", sexo=" + sexo + ", altura=" + altura
				+ ", dtNasc=" + dtNasc + ", idade=" + idade + ", times=" + times + "]";
	}

}
