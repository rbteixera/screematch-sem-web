package br.com.alura.screnmatch.testes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TesteComPeek {

	// Vamos multiplicar cada número de uma lista por 2 e depois somar os resultados 
	// Usando peek para espiar como o java faz como  acontece o processo
	
	public static void main(String[] args) {

       List<Integer> numeros = Arrays.asList(1,2,3,4,5);
       
       /* Aqui a função peek é usada corretamente. Ela recebe uma função lambda como parâmetro e atua sobre cada elemento da stream, neste caso abaixoimprime os números*/
       /* A operação collect transforma a stream de volta em uma lista*/
       numeros.stream()
       .peek(System.out::println)
       .collect(Collectors.toList());
       
       int soma = numeros.stream()
    		      .peek(n -> System.out.println("Elemento: "+n))
    		      .map(n -> n * 2)
    		      .peek(n -> System.out.println("Conteúdo depois do map: "+ n))
    		      .reduce(0, (total, numero) -> total + numero);
       
       System.out.println("\nA soma dos números é: "+soma);

	}

}
