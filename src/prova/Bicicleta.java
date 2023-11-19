package prova;

import java.util.List;

public class Bicicleta extends Veiculo {
	public Bicicleta() {
	}
	
	public Bicicleta(String nome, int ano, List<Pessoa> pessoasList, Pessoa condutor) {
		super(nome, ano, pessoasList, condutor);
	}
}
