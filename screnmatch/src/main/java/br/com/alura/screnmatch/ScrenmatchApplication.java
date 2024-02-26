package br.com.alura.screnmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screnmatch.service.ConsumoApi;
import br.com.alura.screnmatch.service.ConverteDados;
import br.com.alura.srenmatch.model.DadosSerie;

@SpringBootApplication
public class ScrenmatchApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(ScrenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Funcionei");
		
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		
		System.out.println(json);
		
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}

}
