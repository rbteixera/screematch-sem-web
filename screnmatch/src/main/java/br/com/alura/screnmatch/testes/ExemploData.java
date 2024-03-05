package br.com.alura.screnmatch.testes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExemploData {

	public static void main(String[] args) {
		
		String pattern = "E, dd MMM YYYY HH:mm:ss z";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		
		String date = simpleDateFormat.format(new Date());
		
		System.out.println(date);
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate aniversarioNel = LocalDate.of(1969, 3, 23);
		System.out.println("Aniver. Nel "+aniversarioNel);
		
		int idadeNel = hoje.getYear() - aniversarioNel.getYear();
		System.out.println("Idade: "+idadeNel);
		
		Period periodo = Period.between(hoje, aniversarioNel);
		System.out.println(periodo);
	}

}
