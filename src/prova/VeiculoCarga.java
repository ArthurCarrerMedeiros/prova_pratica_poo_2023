package prova;

public class VeiculoCarga extends Veiculo {
	private double qtCarga;

	public VeiculoCarga() {
	}
	
	public VeiculoCarga(double qtCarga) {
		this.qtCarga = qtCarga;
	}

	public double getQtCarga() {
		return qtCarga;
	}

	public void setQtCarga(double qtCarga) {
		this.qtCarga = qtCarga;
	}
}
