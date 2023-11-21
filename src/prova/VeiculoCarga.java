package prova;

import java.util.List;

public class VeiculoCarga extends Veiculo {
	private double qtCarga;

	public VeiculoCarga() {
	}

	public VeiculoCarga(String nome, int ano, List<Pessoa> passageiros, Pessoa condutor, double qtCarga) {
		super(nome, ano, passageiros, condutor);
		this.qtCarga = qtCarga;
	}

	public double getQtCarga() {
		return qtCarga;
	}

	public void setQtCarga(double qtCarga) {
		this.qtCarga = qtCarga;
	}
}
