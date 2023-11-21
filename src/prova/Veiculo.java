package prova;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Veiculo {
	protected String nome;
	protected int ano;
	protected List<Pessoa> passageiros;
	protected Pessoa condutor;

	public Veiculo() {
	}

	public Veiculo(String nome, int ano, List<Pessoa> passageiros, Pessoa condutor) {
		super();
		this.nome = nome;
		this.ano = ano;
		this.passageiros = passageiros;
		this.condutor = condutor;
	}

	public static Veiculo cadastrar() {
		String nome = JOptionPane.showInputDialog("Digite o nome do veículo que deseja cadastrar: ");
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do veículo que deseja cadastrar: "));
		JOptionPane.showMessageDialog(null, "Cadastre o condutor: ");
		Pessoa condutor = Pessoa.cadastrar();
		List<Pessoa> passageiros = new ArrayList<>();

		while (Integer.parseInt(
				JOptionPane.showInputDialog("Deseja cadastrar uma pessoa que estava no veículo?\n1-Sim, 2-Não")) == 1) {
			passageiros.add(Pessoa.cadastrar());
		}

		int escolha = Integer.parseInt(JOptionPane
				.showInputDialog("O que é o seu veículo?\n1-Veiculo normal, 2-Veículo de carga, 3-Bicicleta"));
		if (escolha == 1) {
			return new Veiculo(nome, ano, passageiros, condutor);
		} else if (escolha == 2) {
			double carga = Double.parseDouble(JOptionPane.showInputDialog("Digite a carga do veículo em Kg: "));
			return new VeiculoCarga(nome, ano, passageiros, condutor, carga);
		} else {
			return new Bicicleta(nome, ano, passageiros, condutor);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Pessoa> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(List<Pessoa> passageiros) {
		this.passageiros = passageiros;
	}

	public Pessoa getCondutor() {
		return condutor;
	}

	public void setCondutor(Pessoa condutor) {
		this.condutor = condutor;
	}
}
