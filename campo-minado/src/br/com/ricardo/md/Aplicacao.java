package br.com.ricardo.md;


import br.com.ricardo.md.modelo.Tabuleiro;
import br.com.ricardo.md.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		new TabuleiroConsole(tabuleiro);
	}
}
