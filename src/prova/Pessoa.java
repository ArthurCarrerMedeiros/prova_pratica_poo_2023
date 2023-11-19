package prova;

import javax.swing.JOptionPane;

public class Pessoa {
	private String nome;
	private int idade;
	private char sexo;
	private boolean embriagado;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, int idade, char sexo, boolean embriagado) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.embriagado = embriagado;
	}
	
	public static Pessoa cadastrar() {
		String nome = JOptionPane.showInputDialog("Digite o nome da pessoa que deseja cadastrar: ");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da pessoa que deseja cadastrar: "));
		char sexo = JOptionPane.showInputDialog("Digite o sexo da pessoa que deseja cadastrar\nM ou F: ").toUpperCase().charAt(0);
		boolean embriagado = JOptionPane.showInputDialog("A pessoa que deseja cadastrar estava embriagada?\nDigite S ou N: ").toUpperCase().equals("S") ? true : false;
		return new Pessoa(nome, idade, sexo, embriagado);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public boolean isEmbriagado() {
		return embriagado;
	}

	public void setEmbriagado(boolean embriagado) {
		this.embriagado = embriagado;
	}
}
