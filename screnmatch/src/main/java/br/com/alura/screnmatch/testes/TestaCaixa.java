package br.com.alura.screnmatch.testes;



public class TestaCaixa {
	
	

	public static void main(String[] args) {
		
		  Caixa<String> caixaDeTexto = new Caixa<String>();
		  caixaDeTexto.setConteudo("Guardando texto na minha caixa!");
		  System.out.println(caixaDeTexto.somaConteudoNaCaixa("Mais uma linha"));
		  
		  Caixa<Integer> caixaDeIdade = new Caixa<Integer>(); 
		  caixaDeIdade.setConteudo(30);
		  System.out.println(caixaDeIdade.somaConteudoNaCaixa(26));
		  
		  Caixa<Double> caixaDeValor = new Caixa<Double>();
		  caixaDeValor.setConteudo(150.50);
		  System.out.println(caixaDeValor.somaConteudoNaCaixa(350.50));
		  
		  
		  System.out.println(caixaDeTexto.somaConteudoNaCaixa("Rafael"));
		 
    }


	private Object conteudo=12.34;

	
	

}
