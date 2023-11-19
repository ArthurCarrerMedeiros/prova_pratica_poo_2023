package prova;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Acidente {
	private Rodovia rodovia;
	private int qtVitimasFatais;
	private int qtVitimasFeridas;
	private int mes;
	private List<Veiculo> veiculos;
	
	public Acidente() {
	}

	public Acidente(Rodovia rodovia, int qtVitimasFatais, int qtVitimasFeridas, int mes, List<Veiculo> veiculos) {
		this.rodovia = rodovia;
		this.qtVitimasFatais = qtVitimasFatais;
		this.qtVitimasFeridas = qtVitimasFeridas;
		this.mes = mes;
		this.veiculos = veiculos;
	}
	
	public static Acidente cadastrar() {
		JOptionPane.showMessageDialog(null, "Cadastre primeiro a rodovia em que ocorreu o acidente: ");
		Rodovia rodovia = Rodovia.cadastrar();
		List<Veiculo> veiculos = new ArrayList<>();
		
		while(Integer.parseInt("Deseja cadastrar um novo veículo relacionado com o acidente?\n1-Sim, 2-Não") == 1) {
			veiculos.add(Veiculo.cadastrar());
		}
		
		int mes = Integer.parseInt("Digite o mês que ocorreu o acidente, de 1 até 12: ");
		int qtVitimasFatais = Integer.parseInt("Digite o número de vítimas fatais no acidente: ");
		int qtVitimasFeridas = Integer.parseInt("Digite o número de vítimas feridas no acidente: ");
		return new Acidente(rodovia, qtVitimasFatais, qtVitimasFeridas, mes, veiculos);
	}
	
	public static List<Acidente> listarPorPericulosidade(List<Acidente> acidentes, String periculosidade) {
		List<Acidente> acidentesFiltrados = new ArrayList<>();
		
		for(Acidente acidente: acidentes) {
			if(acidente.getRodovia().getPericulosidade().equals(periculosidade.toUpperCase())) {
				acidentesFiltrados.add(acidente);
			}
		}
		return acidentesFiltrados;
	}
	
	public static List<Acidente> listarEmbriagados(List<Acidente> acidentes) {
		List<Acidente> acidentesFiltrados = new ArrayList<>();
		
		for(Acidente acidente: acidentes) {
			for(Veiculo veiculo: acidente.getVeiculos()) {
				if(veiculo.getCondutor().isEmbriagado()) {
					acidentesFiltrados.add(acidente);
				}
			}
		}
		return acidentesFiltrados;
	}
	
	public static List<Acidente> listarAcidentesBicicleta(List<Acidente> acidentes) {
		List<Acidente> acidentesFiltrados = new ArrayList<>();
		
		for(Acidente acidente: acidentes) {
			for(Veiculo veiculo: acidente.getVeiculos()) {
				if(veiculo instanceof Bicicleta) {
					acidentesFiltrados.add(acidente);
				}
			}
		}
		return acidentesFiltrados;
	}
	
	public static List<Acidente> listarAcidentesVeiculoCarga(List<Acidente> acidentes) {
		List<Acidente> acidentesFiltrados = new ArrayList<>();
		
		for(Acidente acidente: acidentes) {
			for(Veiculo veiculo: acidente.getVeiculos()) {
				if(veiculo instanceof VeiculoCarga) {
					acidentesFiltrados.add(acidente);
				}
			}
		}
		return acidentesFiltrados;
	}
	
	public static List<Acidente> listarAcidentesVeiculoNovo(List<Acidente> acidentes) {
		List<Acidente> acidentesFiltrados = new ArrayList<>();
		
		for(Acidente acidente: acidentes) {
			for(Veiculo veiculo: acidente.getVeiculos()) {
				if(veiculo.getAno() >= 2013) {
					acidentesFiltrados.add(acidente);
				}
			}
		}
		return acidentesFiltrados;
	}
	
	public Rodovia getRodovia() {
		return rodovia;
	}

	public void setRodovia(Rodovia rodovia) {
		this.rodovia = rodovia;
	}

	public int getQtVitimasFatais() {
		return qtVitimasFatais;
	}

	public void setQtVitimasFatais(int qtVitimasFatais) {
		this.qtVitimasFatais = qtVitimasFatais;
	}

	public int getQtVitimasFeridas() {
		return qtVitimasFeridas;
	}

	public void setQtVitimasFeridas(int qtVitimasFeridas) {
		this.qtVitimasFeridas = qtVitimasFeridas;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
}
