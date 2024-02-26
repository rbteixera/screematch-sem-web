package br.com.alura.screnmatch.service;

public interface iConverteDados {
	
	public <T> T obterDados(String json, Class<T> classes);
		
	
}
