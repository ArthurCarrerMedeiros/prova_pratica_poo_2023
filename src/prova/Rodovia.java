package prova;

import javax.swing.JOptionPane;

public class Rodovia {
	private String sigla;
	private String periculosidade;
	
	public Rodovia() {
	}
	
	public Rodovia(String sigla, String periculosidade) {
		super();
		this.sigla = sigla;
		this.periculosidade = periculosidade;
	}

	public static Rodovia cadastrar() {
		String sigla = JOptionPane.showInputDialog("Digite a sigla da rodovia que deseja cadastrar: ");
		String periculosidade = JOptionPane.showInputDialog("Qual a perículosidade da rodovia que deseja cadastrar?\nDigite Baixo, Médio ou Alta: ").toUpperCase();
		return new Rodovia(sigla, periculosidade);
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
