package prova;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Rodovia {
	private String nome;
	private String sigla;
	private String periculosidade;
	
	public Rodovia() {
	}
	
	public Rodovia(String nome, String sigla, String periculosidade) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.periculosidade = periculosidade.toUpperCase();
	}

	public static Rodovia cadastrar() {
		String nome = JOptionPane.showInputDialog("Digite o nome da rodovia que deseja cadastrar: ");
		String sigla = JOptionPane.showInputDialog("Digite a sigla da rodovia que deseja cadastrar: ");
		String periculosidade = JOptionPane.showInputDialog("Qual a perículosidade da rodovia que deseja cadastrar?\nDigite Baixo, Médio ou Alta: ").toUpperCase();
		return new Rodovia(nome, sigla, periculosidade);
	}
	
	public static Rodovia listarRodoviaMaisFatal(List<Acidente> acidentes) {
		Rodovia rodoviaMaisFatal = new Rodovia();
		double numeroAcidentesFatais = 0;
		
		for(Acidente acidente: acidentes) {
			List<Acidente> acidentesFiltrados = acidentes.stream().filter(acidenteAux -> acidenteAux.getRodovia().getNome().toUpperCase()
					.equals(acidente.getRodovia().getNome().toUpperCase())).collect(Collectors.toList());
			
			double totalAcidentes = acidentesFiltrados.stream().mapToDouble(acidenteAux -> acidenteAux.getQtVitimasFatais()).sum();
			
			if(totalAcidentes > numeroAcidentesFatais) {
				numeroAcidentesFatais = totalAcidentes;
				rodoviaMaisFatal = acidente.getRodovia();
			}
		}
		return rodoviaMaisFatal;
	}
	
	public static List<Rodovia> listarRodoviaAcidenteCarnaval(List<Acidente> acidentes) {
		List<Rodovia> rodoviasFiltradas = new ArrayList<>();
		
		for(Acidente acidente: acidentes) {
			if(acidente.getMes() == 2) {
				rodoviasFiltradas.add(acidente.getRodovia());
			}
		}
		return rodoviasFiltradas;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getPericulosidade() {
		return periculosidade;
	}
	
	public void setPericulosidade(String periculosidade) {
		this.periculosidade = periculosidade;
	}
}
