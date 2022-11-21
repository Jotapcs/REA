package br.senac.BackEnd.Reserva;

public class DadosDaReserva {
	
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private String telefone;
	private String email;
	private String dataNascimento;
	private String dataCheckin;
	private String dataCheckout;
	private int numeroAcompanhantes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataCheckin() {
		return dataCheckin;
	}

	public void setDataCheckin(String dataCheckin) {
		this.dataCheckin = dataCheckin;
	}

	public String getDataCheckout() {
		return dataCheckout;
	}

	public void setDataCheckout(String dataCheckout) {
		this.dataCheckout = dataCheckout;
	}

	public int getNumeroAcompanhantes() {
		return numeroAcompanhantes;
	}

	public void setNumeroAcompanhantes(int numeroAcompanhantes) {
		this.numeroAcompanhantes = numeroAcompanhantes;
	}
}
