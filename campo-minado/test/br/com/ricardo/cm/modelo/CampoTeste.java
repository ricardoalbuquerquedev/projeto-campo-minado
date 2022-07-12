package br.com.ricardo.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ricardo.md.modelo.Campo;
import br.com.ricardo.md.modelo.ExplosaoException;

public class CampoTeste {

	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testeVizinhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado); 			
	}
	
	@Test
	void testeVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado); 			
	}
	
	@Test
	void testeVizinhoDistancia1EmCima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado); 			
	}
	
	@Test
	void testeVizinhoDistancia1EmBaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado); 			
	}
	
	@Test
	void testeVizinhoDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado); 			
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado); 			
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
	assertFalse(campo.isMarcado());	
		
	}
	
	@Test
	void testAlternarMarcacao() {
		campo.alternarMarcacao(); 
	assertTrue(campo.isMarcado());	
		
	}
	
	@Test
	void testAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao(); 
		campo.alternarMarcacao(); 
	    assertFalse(campo.isMarcado());	
		
	}
	
	@Test
	void testAbrirNaoMinadoNaoMarcado() throws ExplosaoException {
	    assertTrue(campo.abrir());	
	}
	
	@Test
	void testAbrirNaoMinadoMarcado() throws ExplosaoException {
		campo.alternarMarcacao();
	    assertFalse(campo.abrir());	
	}
	
	@Test
	void testAbrirMinadoMarcado() throws ExplosaoException {
		campo.alternarMarcacao();
		campo.minar(); 
	    assertFalse(campo.abrir());	
	}
	
	@Test
	void testAbrirMinadoNaoMarcado() throws ExplosaoException {
		campo.alternarMarcacao();
		campo.minar(); 
	    assertFalse(campo.abrir());	
	}
	
	@Test
	void testAbrirComVizinhos1() throws ExplosaoException {
		
		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2); 
		campo22.adicionarVizinho(campo11); 
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());	
	}
	
	@Test
	void testAbrirComVizinhos2() throws ExplosaoException {
		
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 1);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2); 
		campo22.adicionarVizinho(campo11); 
		campo22.adicionarVizinho(campo12); 
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());	
	}
}
