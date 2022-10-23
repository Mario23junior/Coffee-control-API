package br.com.coffe.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.coffe.model.Coffe;

public class cofferRepository {
  
	private static List<Coffe> listAllCoffer = null;
	
	static {
		listAllCoffer = new ArrayList<>();
		
		Coffe trescoracoes = new Coffe();
		trescoracoes.setId(10l);
		trescoracoes.setNome("Cafe tres corações");
		trescoracoes.setDataDeFabricacao(LocalDate.now());
		trescoracoes.setDataDeValidade(LocalDate.now().plusYears(1));
		trescoracoes.setPreco(8.20);
		
		listAllCoffer.add(trescoracoes);
		
		Coffe pilao = new Coffe();
		trescoracoes.setId(11l);
		trescoracoes.setNome("Cafe Pilão");
		trescoracoes.setDataDeFabricacao(LocalDate.now());
		trescoracoes.setDataDeValidade(LocalDate.now().plusYears(1));
		trescoracoes.setPreco(5.10);
		listAllCoffer.add(pilao);	
 	}
	
	public static List<Coffe> findAll(){
		return listAllCoffer;
	}
}
