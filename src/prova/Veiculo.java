package prova;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Veiculo {
	private String nome;
	private int ano;
	private List<Pessoa> pessoasList;
	private Pessoa condutor;
	
	public Veiculo() {
	}
	
	public Veiculo(String nome, int ano, List<Pessoa> pessoasList, Pessoa condutor) {
		super();
		this.nome = nome;
		this.ano = ano;
		this.pessoasList = pessoasList;
		this.condutor = condutor;
	}
	
	public static Veiculo cadastrar() {
		String nome = JOptionPane.showInputDialog("Digite o nome do veículo que deseja cadastrar: ");
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do veículo que deseja cadastrar: "));
		JOptionPane.showMessageDialog(null, "Cadastre o condutor: ");
		Pessoa condutor = Pessoa.cadastrar();
		List<Pessoa> pessoasList = new ArrayList<>();
		
		while(Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar uma pessoa que estava no veículo?\n1-Sim, 2-Não")) == 1) {
			pessoasList.add(Pessoa.cadastrar());
		}
		return new Veiculo(nome, ano, pessoasList, condutor);
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

	public List<Pessoa> getPessoasList() {
		return pessoasList;
	}

	public void setPessoasList(List<Pessoa> pessoasList) {
		this.pessoasList = pessoasList;
	}

	public Pessoa getCondutor() {
		return condutor;
	}

	public void setCondutor(Pessoa condutor) {
		this.condutor = condutor;
	}
}
