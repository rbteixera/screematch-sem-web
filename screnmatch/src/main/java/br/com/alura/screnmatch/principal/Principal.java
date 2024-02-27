package br.com.alura.screnmatch.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.screnmatch.service.ConsumoApi;
import br.com.alura.screnmatch.service.ConverteDados;
import br.com.alura.srenmatch.model.DadosEpisodio;
import br.com.alura.srenmatch.model.DadosSerie;
import br.com.alura.srenmatch.model.DadosTemporada;

public class Principal {
	
	private Scanner leitura = new Scanner(System.in);
	
	//https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c
	private final String ENDERECO="https://omdbapi.com/?t=";
	private final String API_KEY="&apikey=6585022c";
	
	private ConsumoApi consumoApi = new ConsumoApi();
	private ConverteDados conversor = new ConverteDados();
	
	public void exibeMenu() {
		
		System.out.print("Digite o nome da série para busca: ");
		var nomeSerie = leitura.nextLine();
		
		var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ","+") + API_KEY);
		
		DadosSerie dados =conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		
		

		
		conversor = new ConverteDados();
		DadosEpisodio dadosEpsodios = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpsodios);
		List<DadosTemporada> listTemporada = new ArrayList<>();
		
		for(int i = 1; i<=dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ","+") + "&season="+i+  API_KEY );
		
			DadosTemporada dadosTemoradaDadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			listTemporada.add(dadosTemoradaDadosTemporada);
		}
		
		//Funções Lambda
		listTemporada.forEach(System.out::println);
		//listTemporada.forEach(t -> System.out.println(t)); o mesmo do de cima
		
		/*
		 * for(int i = 0; i < dados.totalTemporadas(); i++) { List<DadosEpisodio>
		 * episodiosTemporada = listTemporada.get(i).episodios();
		 * 
		 * for(int j = 0; j < episodiosTemporada.size(); j++) {
		 * System.out.println(episodiosTemporada.get(j).titulo()); } }
		 */
		
		//O dois for em uma só linha função Lambda
		listTemporada.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
	}

}
