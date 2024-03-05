package br.com.alura.srenmatch.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Episodio {
	
	private Integer temporada;
	private String titulo;
	private Integer numeroEpisodio;
	private Double avaliacao;
	private LocalDate dataLancamento;
	
	
	public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodios) {
		
		this.temporada = numeroTemporada;
		this.titulo = dadosEpisodios.titulo();
		this.numeroEpisodio = dadosEpisodios.numeroEpsodio();
		
		try {
		   this.avaliacao = Double.valueOf(dadosEpisodios.avaliacao());
		} catch (NumberFormatException e) {
			this.avaliacao = 0.0;
		}
		
		try {
			this.dataLancamento = LocalDate.parse(dadosEpisodios.dataLancamento());
		}catch (DateTimeParseException e) {
			this.dataLancamento = null;
		}
		
	}
	public Integer getTemporada() {
		return temporada;
	}
	public void setTemporada(Integer temporada) {
		this.temporada = temporada;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getNumeroEpisodio() {
		return numeroEpisodio;
	}
	public void setNumeroEpisodio(Integer numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
	}
	public Double getAvalicao() {
		return avaliacao;
	}
	public void setAvalicao(Double avalicao) {
		this.avaliacao = avalicao;
	}
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	@Override
	public String toString() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		if (dataLancamento !=null ) {
		  return "temporada=" + temporada +  ", numeroEpisodio=" + numeroEpisodio
				+", Nome=" + titulo + ", avaliacao=" + avaliacao + ",dataLancamento=" + dataLancamento.format(formatador)+ "";
		} else {
			return "temporada=" + temporada +  ", numeroEpisodio=" + numeroEpisodio
					+", Nome=" + titulo + ", avaliacao=" + avaliacao + ",dataLancamento=" + dataLancamento+ "";
		}
	}
	
	
	

}
