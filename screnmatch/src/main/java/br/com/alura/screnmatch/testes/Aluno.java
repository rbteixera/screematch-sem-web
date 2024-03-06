package br.com.alura.screnmatch.testes;

import java.time.LocalDate;
import java.time.Period;

public class Aluno {
	
	private String nome;
	private LocalDate nascimento;
	
	public Aluno(String nome, LocalDate nascimento) {
		
		this.nome = nome;
		this.nascimento = nascimento;
	}
	
	public int getIdade() {
		Period periodo = Period.between(nascimento, LocalDate.now());
		return periodo.getYears();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", nascimento=" + nascimento + "]";
	}
	
	

}
