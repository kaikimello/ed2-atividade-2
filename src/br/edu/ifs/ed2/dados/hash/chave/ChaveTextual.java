/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.chave;

import java.util.Locale;

/**
 * Classe que implementa uma opera��o de constru��o de chaves textuais a partir
 * do exemplo a seguir:
 * 
 * Conte�do: Uva
 * 
 * 1� passo: transforma��o da palavra em letras min�scula e obten��o do c�digo
 * ASCII de cada caractere
 * 
 * u: 117 v: 118 a: 97
 * 
 * 2� passo: produto entre o c�digo de cada caractere e um n�mero primo elevado
 * � posi��o inversa desse caractere
 * 
 * u: 117 * 31 ^ 2 = 112 437 
 * v: 118 * 31 ^ 1 = 3 658 
 * a: 97 * 31 ^ 0 = 97
 * 
 * 3� passo: somat�rio dos valores calculados
 * 
 * chave = 116 192
 * 
 * 
 *
 */
public class ChaveTextual implements EstrategiaChave<String> {

	/**
	 * 
	 */
	@Override
	public int gerarChave(String conteudo) {

		/*
		 * Inicializa��o da chave.
		 */
		int chave = 0;
		int chaveASCII = 0;

		/*
		 * C�lculo da chave.
		 */

		/**
		 * Converte String para min�scula
		 */
		String conteudoMinusculo = conteudo.toLowerCase();

		for (int i = 0; i < conteudo.length(); ++i) {
			chaveASCII = conteudoMinusculo.charAt(i); // Pega o �ndice ASCII do Caractere
			int produtoChave = chaveASCII * (int) Math.pow(31, (conteudo.length() - (i + 1))); // Realiza o produto da chave ASCII
			chave += produtoChave;
		}

		/*
		 * Retorno da chave.
		 */
		return chave;
	}
}
