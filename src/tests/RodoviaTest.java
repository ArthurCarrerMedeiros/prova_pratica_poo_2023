package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import prova.Acidente;
import prova.Rodovia;

class RodoviaTest {
	@Test
	void listarRodoviaMaisFatalTest() {
		Rodovia rodovia1 = new Rodovia("Miranda das Flores", "TESTE", "Alta");
		Rodovia rodovia2 = new Rodovia("Joaquim da Serra", "TESTE", "Alta");
		Rodovia rodovia3 = new Rodovia("Lurdes do Amanhã", "TESTE", "Alta");
		Rodovia rodovia4 = new Rodovia("Jhon Kanabby", "TESTE", "Alta");
		Rodovia rodovia5 = new Rodovia("Newan Kewn", "TESTE", "Alta");
		Rodovia rodovia6 = new Rodovia("Jiuca Plate", "TESTE", "Alta");
		Rodovia rodovia7 = new Rodovia("Grande Jardim", "TESTE", "Alta");
		Rodovia rodovia8 = new Rodovia("Invernada Do Gelo", "TESTE", "Alta");
		
		Acidente acidente1 = new Acidente(rodovia1, 24, 0, 1, null);
		Acidente acidente2 = new Acidente(rodovia2, 12, 0, 1, null);
		Acidente acidente3 = new Acidente(rodovia3, 1, 0, 1, null);
		Acidente acidente4 = new Acidente(rodovia4, 3, 0, 1, null);
		Acidente acidente5 = new Acidente(rodovia5, 76, 0, 1, null);
		Acidente acidente6 = new Acidente(rodovia6, 42, 0, 1, null);
		Acidente acidente7 = new Acidente(rodovia7, 21, 0, 1, null);
		Acidente acidente8 = new Acidente(rodovia8, 123, 0, 1, null);
		
		List<Acidente> acidentes = new ArrayList<>();
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		acidentes.add(acidente3);
		acidentes.add(acidente4);
		acidentes.add(acidente5);
		acidentes.add(acidente6);
		acidentes.add(acidente7);
		acidentes.add(acidente8);
		
		Rodovia rodoviaMaisFatal = Rodovia.listarRodoviaMaisFatal(acidentes);
		assertEquals(rodoviaMaisFatal, acidente8.getRodovia());
	}
	
	@Test
	void listarRodoviaAcidenteCarnaval() {
		Rodovia rodovia1 = new Rodovia("Miranda das Flores", "TESTE", "Alta");
		Rodovia rodovia2 = new Rodovia("Joaquim da Serra", "TESTE", "Alta");
		Rodovia rodovia3 = new Rodovia("Lurdes do Amanhã", "TESTE", "Alta");
		Rodovia rodovia4 = new Rodovia("Jhon Kanabby", "TESTE", "Alta");
		
		Acidente acidente1 = new Acidente(rodovia1, 24, 0, 2, null);
		Acidente acidente2 = new Acidente(rodovia2, 12, 0, 1, null);
		Acidente acidente3 = new Acidente(rodovia3, 1, 0, 2, null);
		Acidente acidente4 = new Acidente(rodovia4, 3, 0, 2, null);
		
		List<Acidente> acidentes = new ArrayList<>();
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		acidentes.add(acidente3);
		acidentes.add(acidente4);
		
		List<Rodovia> rodoviasFiltradas = Rodovia.listarRodoviaAcidenteCarnaval(acidentes);
		assertEquals(rodovia1, rodoviasFiltradas.get(0));
		assertEquals(rodovia3, rodoviasFiltradas.get(1));
		assertEquals(rodovia4, rodoviasFiltradas.get(2));
	}
}
