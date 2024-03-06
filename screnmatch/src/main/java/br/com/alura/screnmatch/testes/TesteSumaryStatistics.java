package br.com.alura.screnmatch.testes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class TesteSumaryStatistics {

	public static void main(String[] args) {
		
		List<Aluno> alunos = Arrays.asList(
				
				new Aluno("Alice", LocalDate.of(2002, 10, 20)),
				new Aluno("Bob", LocalDate.of(1980, 8, 9)),
				new Aluno("Carlos", LocalDate.of(2001, 01, 28)),
				new Aluno("David", LocalDate.of(2003, 05, 12)),
				new Aluno("Eva", LocalDate.of(2005, 12, 03))
				
				);
		
		IntSummaryStatistics stats = alunos.stream()
				                     .mapToInt(Aluno::getIdade)
				                     .summaryStatistics();
		
		
		System.out.println("Idade Média: "+stats.getAverage());
		System.out.println("Idade Mínima: "+stats.getMin());
		System.out.println("Idade Máxima: "+stats.getMax());
		System.out.println("Total de Alunos: "+stats.getCount());

	}

}
