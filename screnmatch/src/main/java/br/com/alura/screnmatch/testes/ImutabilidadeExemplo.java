package br.com.alura.screnmatch.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImutabilidadeExemplo {

	public static void main(String[] args) {
		
		List<String> listaOriginal = new ArrayList<>();
		listaOriginal.add("Rafael");
		listaOriginal.add("Marinelce");
		listaOriginal.add("Gabriel");
		listaOriginal.add("Manuella");
		
		List<String> listaImutavel =  Collections.unmodifiableList(listaOriginal);
		
		listaImutavel.add("PATRICIA");

	}

}
