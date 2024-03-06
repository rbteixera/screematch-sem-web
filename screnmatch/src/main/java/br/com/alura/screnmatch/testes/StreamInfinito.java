package br.com.alura.screnmatch.testes;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import ch.qos.logback.core.net.SyslogOutputStream;

public class StreamInfinito {

	public static void main(String[] args) {

         Stream.iterate(0, n -> n + 1)
               .limit(10)
               .forEach(System.out::println);
               		
        List<List<String>> list01 = List.of(
        		List.of("a","b"),
        		List.of("c","d")
        );
        
        Stream<String> stream = list01.stream()
        		                .flatMap(Collection::stream);
        
        System.out.println("\n");
        stream.forEach(System.out::println);
        
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        
        Optional<Integer> result = numbers.stream().reduce(Integer::sum);
        result.ifPresent(System.out::println);
        

	}

}
