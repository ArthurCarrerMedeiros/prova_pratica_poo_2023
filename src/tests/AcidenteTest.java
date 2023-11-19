package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import prova.Rodovia;
import prova.Veiculo;
import prova.VeiculoCarga;
import prova.Acidente;
import prova.Bicicleta;
import prova.Pessoa;

import java.util.ArrayList;

class AcidenteTest {
	@Test
	void listarPorPericulosidadeTest() {
		Rodovia rodovia1 = new Rodovia("Teste Rodovia 1", "TESTE", "Alta");
		Rodovia rodovia2 = new Rodovia("Teste Rodovia 2", "TESTE2", "Baixa");
		Rodovia rodovia3 = new Rodovia("Teste Rodovia 3", "TESTE", "Média");
		Rodovia rodovia4 = new Rodovia("Teste Rodovia 4", "TESTE4", "Alta");
		
		Acidente acidente1 = new Acidente(rodovia1, 0, 0, 0, null);
		Acidente acidente2 = new Acidente(rodovia2, 0, 0, 0, null);
		Acidente acidente3 = new Acidente(rodovia3, 0, 0, 0, null);
		Acidente acidente4 = new Acidente(rodovia4, 0, 0, 0, null);
		
		List<Acidente> acidentes = new ArrayList<>();
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		acidentes.add(acidente3);
		acidentes.add(acidente4);
		
		List<Acidente> acidentesFiltrados = Acidente.listarPorPericulosidade(acidentes, "Alta");
		assertEquals(acidentesFiltrados.get(0).getRodovia().getPericulosidade(), "ALTA");
		assertEquals(acidentesFiltrados.get(1).getRodovia().getPericulosidade(), "ALTA");
	}
	
	@Test
	void listarEmbriagadosTest() {
		Rodovia rodovia1 = new Rodovia("Newan Clear", "TESTE", "Alta");
		Pessoa pessoa1 = new Pessoa("Joaquim", 18, 'F', true);
		Pessoa pessoa2 = new Pessoa("João", 23, 'F', false);
		Pessoa pessoa3 = new Pessoa("Cleber", 32, 'F', false);
		Pessoa pessoa4 = new Pessoa("Maria", 24, 'F', true);
		
		Veiculo veiculo1 = new Veiculo("Gol", 2011, null, pessoa1);
		Veiculo veiculo2 = new Veiculo("Captur", 2013, null, pessoa2);
		Veiculo veiculo3 = new Veiculo("Fusca", 2001, null, pessoa3);
		Veiculo veiculo4 = new Veiculo("Mercedes", 2002, null, pessoa4);
		
		List<Veiculo> veiculos1 = new ArrayList<>();
		List<Veiculo> veiculos2 = new ArrayList<>();
		List<Veiculo> veiculos3 = new ArrayList<>();
		List<Veiculo> veiculos4 = new ArrayList<>();
		
		veiculos1.add(veiculo1);
		veiculos2.add(veiculo2);
		veiculos3.add(veiculo3);
		veiculos4.add(veiculo4);
		
		Acidente acidente1 = new Acidente(rodovia1, 0, 0, 1, veiculos1);
		Acidente acidente2 = new Acidente(rodovia1, 0, 0, 1, veiculos2);
		Acidente acidente3 = new Acidente(rodovia1, 0, 0, 1, veiculos3);
		Acidente acidente4 = new Acidente(rodovia1, 0, 0, 1, veiculos4);
		
		List<Acidente> acidentes = new ArrayList<>();
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		acidentes.add(acidente3);
		acidentes.add(acidente4);
		
		List<Acidente> acidentesFiltados = Acidente.listarEmbriagados(acidentes);
		assertEquals(acidentesFiltados.get(0).getVeiculos().get(0).getCondutor().isEmbriagado(), true);
		assertEquals(acidentesFiltados.get(1).getVeiculos().get(0).getCondutor().isEmbriagado(), true);
	}
	
	@Test
	void listarAcidentesBicicletaTest() {
		Rodovia rodovia1 = new Rodovia("João Miranda" ,"TESTE", "Alta");
		Veiculo veiculo1 = new Bicicleta("Gol", 2011, null, null);
		Veiculo veiculo2 = new Veiculo("Captur", 2013, null, null);
		Veiculo veiculo3 = new VeiculoCarga("Fusca", 2001, null, null, 12.5);
		
		List<Veiculo> veiculos1 = new ArrayList<>();
		List<Veiculo> veiculos2 = new ArrayList<>();
		List<Veiculo> veiculos3 = new ArrayList<>();
		
		veiculos1.add(veiculo1);
		veiculos2.add(veiculo2);
		veiculos3.add(veiculo3);
		
		Acidente acidente1 = new Acidente(rodovia1, 0, 0, 1, veiculos1);
		Acidente acidente2 = new Acidente(rodovia1, 0, 0, 1, veiculos2);
		Acidente acidente3 = new Acidente(rodovia1, 0, 0, 1, veiculos3);
		
		List<Acidente> acidentes = new ArrayList<>();
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		acidentes.add(acidente3);
		
		List<Acidente> acidentesFiltados = Acidente.listarAcidentesBicicleta(acidentes);
		assertInstanceOf(Bicicleta.class, acidentesFiltados.get(0).getVeiculos().get(0));
	}
	
	@Test
	void listarAcidentesVeiculoCargaTest() {
		Rodovia rodovia1 = new Rodovia("Miranda das Flores", "TESTE", "Alta");
		Veiculo veiculo1 = new Bicicleta("Gol", 2011, null, null);
		Veiculo veiculo2 = new Veiculo("Captur", 2013, null, null);
		Veiculo veiculo3 = new VeiculoCarga("Fusca", 2001, null, null, 24.52);
		
		List<Veiculo> veiculos1 = new ArrayList<>();
		List<Veiculo> veiculos2 = new ArrayList<>();
		List<Veiculo> veiculos3 = new ArrayList<>();
		
		veiculos1.add(veiculo1);
		veiculos2.add(veiculo2);
		veiculos3.add(veiculo3);
		
		Acidente acidente1 = new Acidente(rodovia1, 0, 0, 1, veiculos1);
		Acidente acidente2 = new Acidente(rodovia1, 0, 0, 1, veiculos2);
		Acidente acidente3 = new Acidente(rodovia1, 0, 0, 1, veiculos3);
		
		List<Acidente> acidentes = new ArrayList<>();
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		acidentes.add(acidente3);
		
		List<Acidente> acidentesFiltados = Acidente.listarAcidentesVeiculoCarga(acidentes);
		assertInstanceOf(VeiculoCarga.class, acidentesFiltados.get(0).getVeiculos().get(0));
	}
	
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
	void listarAcidentesVeiculoNovoTest() {
		Rodovia rodovia = new Rodovia();
		rodovia.setNome("Miranda das Flores");
		rodovia.setSigla("TESTE");
		rodovia.setPericulosidade("Alta");
		
		Veiculo veiculo1 = new Bicicleta("Gol", 2011, null, null);
		Veiculo veiculo2 = new Veiculo("Captur", 2013, null, null);
		Veiculo veiculo3 = new VeiculoCarga("Fusca", 2001, null, null, 24.52);
		Veiculo veiculo4 = new Bicicleta("Pálio", 1999, null, null);
		Veiculo veiculo5 = new Veiculo("Celta", 2008, null, null);
		Veiculo veiculo6 = new VeiculoCarga("Ferrari", 2020, null, null, 24.52);
		
		List<Veiculo> veiculos1 = new ArrayList<>();
		List<Veiculo> veiculos2 = new ArrayList<>();
		List<Veiculo> veiculos3 = new ArrayList<>();
		List<Veiculo> veiculos4 = new ArrayList<>();
		List<Veiculo> veiculos5 = new ArrayList<>();
		List<Veiculo> veiculos6 = new ArrayList<>();
		
		veiculos1.add(veiculo1);
		veiculos2.add(veiculo2);
		veiculos3.add(veiculo3);
		veiculos4.add(veiculo4);
		veiculos5.add(veiculo5);
		veiculos6.add(veiculo6);
		
		Acidente acidente1 = new Acidente(rodovia, 24, 0, 1, veiculos1);
		Acidente acidente2 = new Acidente(rodovia, 12, 0, 1, veiculos2);
		Acidente acidente3 = new Acidente(rodovia, 1, 0, 1, veiculos3);
		Acidente acidente4 = new Acidente(rodovia, 3, 0, 1, veiculos4);
		Acidente acidente5 = new Acidente(rodovia, 76, 0, 1, veiculos5);
		Acidente acidente6 = new Acidente(rodovia, 42, 0, 1, veiculos6);
		
		List<Acidente> acidentes = new ArrayList<>();
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		acidentes.add(acidente3);
		acidentes.add(acidente4);
		acidentes.add(acidente5);
		acidentes.add(acidente6);

		List<Acidente> acidentesFiltrados = Acidente.listarAcidentesVeiculoNovo(acidentes);
		assertEquals(veiculo2, acidentesFiltrados.get(0).getVeiculos().get(0));
		assertEquals(veiculo6, acidentesFiltrados.get(1).getVeiculos().get(0));
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
