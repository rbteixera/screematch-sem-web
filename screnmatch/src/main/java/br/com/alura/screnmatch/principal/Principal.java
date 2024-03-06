package br.com.alura.screnmatch.principal;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.alura.screnmatch.service.ConsumoApi;
import br.com.alura.screnmatch.service.ConverteDados;
import br.com.alura.srenmatch.model.DadosEpisodio;
import br.com.alura.srenmatch.model.DadosSerie;
import br.com.alura.srenmatch.model.DadosTemporada;
import br.com.alura.srenmatch.model.Episodio;
import ch.qos.logback.core.net.SyslogOutputStream;

public class Principal {

	private Scanner leitura = new Scanner(System.in);

	// https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c
	private final String ENDERECO = "https://omdbapi.com/?t=";
	private final String API_KEY = "&apikey=6585022c";

	private ConsumoApi consumoApi = new ConsumoApi();
	private ConverteDados conversor = new ConverteDados();

	public void exibeMenu() {

		
		  System.out.print("Digite o nome da série para busca: "); var nomeSerie =
		  leitura.nextLine();
		  
		  var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ","+") +
		  API_KEY);
		  
		  System.out.println("---------> "+ENDERECO + nomeSerie.replace(" ","+") +
				  API_KEY);
		  
		  DadosSerie dados =conversor.obterDados(json, DadosSerie.class);
		  System.out.println(dados);
		  
		  
		  
		  
		  conversor = new ConverteDados(); 
		  DadosEpisodio dadosEpsodios = conversor.obterDados(json, DadosEpisodio.class);
		  System.out.println(dadosEpsodios); 
		  List<DadosTemporada> listTemporada = new ArrayList<>();
		  
		  for(int i = 1; i<=dados.totalTemporadas(); i++) { 
			  json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ","+") + "&season="+i+API_KEY );
		
			  
		      DadosTemporada dadosTemoradaDadosTemporada = conversor.obterDados(json,DadosTemporada.class); 
		      listTemporada.add(dadosTemoradaDadosTemporada); 
		  }
		  
		  //Funções Lambda
		  System.out.println("\n-- Lista da Temporada -- "+dados.totalTemporadas());
		  listTemporada.forEach(System.out::println);
		  //listTemporada.forEach(t -> System.out.println(t)); o mesmo do de cima
		  
//		  String nomeTemporada = "";
//		  for(int i = 0; i < dados.totalTemporadas(); i++) {
//			   
//			  List<DadosEpisodio> episodiosTemporada = listTemporada.get(i).episodios();
//
//		      for(int j = 0; j < episodiosTemporada.size(); j++) {
//		         System.out.println(" -- Episódio --> "+episodiosTemporada.get(j).titulo()); 
//		      } 
//		   }
//		  
		  
		  //Os dois for em uma só linha função Lambda 
		  listTemporada.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
		 
		
		  // 1 Série -> listas de temporadas -> lista de episódios
		
		  //Stream
		// List<String> nomes = Arrays.asList("Jaque","Iasmin","Paulo", "Rodrigo","Nico");
		 
		// nomes.stream() 
		// .sorted() 
		// .limit(5) 
		// .filter(n -> n.startsWith("P")) 
		// .map(n -> n.toUpperCase()) 
		// .forEach(System.out ::println);
		  
//		  List<DadosEpisodio> dadosEpisodios = listTemporada.stream()
//				  .flatMap(t -> t.episodios().stream())
//				  //.toList(); // Com tolist() não consigo incluir mais elementos na lista list é imutável
//				  .collect(Collectors.toList()); //Consigo incluir elementos na lista
//		  
		 // dadosEpisodios.add(new DadosEpisodio("teste", 3, "7.9", "2020-01-01"));
		  
//		  System.out.println("\nTop 10 Episódios"); 
//		  dadosEpisodios.stream()
//		  .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//		  .peek(e -> System.out.println("Primeiro Filtro(N/A "+e))
//		  .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
//		  .peek(e -> System.out.println("Ordenação "+e))
//		  .limit(10)
//		  .peek(e -> System.out.println("Limite de 10 "+e))
//		  .map(e -> e.titulo().toUpperCase())
//		  .peek(e -> System.out.println("Mapeamento "+e))
//		  .forEach(System.out::println);
//		  
		  System.out.println("\n"); 
		  
		  List<Episodio> episodio = listTemporada.stream()
				                   .flatMap(t -> t.episodios().stream()
				                   .map(d -> new Episodio(t.numero(), d)))
				                   .collect(Collectors.toList());
		  episodio.forEach(System.out::println);
		  
	
//		  System.out.print("Digite trecho do nome Episódio desejado: ");
//		  var trechoTitulo = leitura.nextLine();
//		  
//		  /* Optional é um objeto é um container que pode ter ou não um objeto tentro*/
//		  Optional<Episodio> episodioBuscado = episodio.stream()
//		          .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
//		          .findFirst();
//		  
//		  if(episodioBuscado.isPresent()) {
//			  System.out.println("Episódio encontrado!");
//			  System.out.println("Temporada: "+episodioBuscado.get().getTemporada()+" -> "+episodioBuscado.get().getTitulo());
//			  
//			  
//		  } else {
//			  System.out.println("Episódio não encontrado!");
//		  }
			 
		

//         System.out.println("A partir de que ano você deseja ver os episódios ? ");
//         var ano = leitura.nextInt();
//         leitura.nextLine();
//         LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//         
//         DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//         episodio.stream()
//                  .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                  .forEach(e -> System.out.println(
//                		  "Temporad: " + e.getTemporada() +
//                		        " Episódio: " + e.getTitulo() +
//                		        " Data lançamento: " + e.getDataLancamento().format(formatador)
//                		  
//                		  ));
//
//		
//		
		  Map<Integer, Double> avaliacoesPorTemporada = episodio.stream()
				  .filter(e -> e.getAvalicao() > 0.0)
				  .collect(Collectors.groupingBy(Episodio::getTemporada, 
				           Collectors.averagingDouble(Episodio::getAvalicao)));
		  System.out.println(avaliacoesPorTemporada);
		  
		  
		  DoubleSummaryStatistics est = episodio.stream()
				                        .filter(e -> e.getAvalicao() > 0.0)
				                        .collect(Collectors.summarizingDouble(Episodio::getAvalicao));
		  
		  System.out.println("\n"+est);
		  System.out.println("Média: "+est.getAverage());
		  System.out.println("Melhor Episódio: "+est.getMax());
		  System.out.println("Pior Episódio: "+est.getMin());
		  System.out.println("Quantidade: "+est.getCount());
		  
		  
	}

}
