package entities;

public class ContaPoupanca extends Conta {

	private Double taxaDeJuros;

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(Integer numero, String titular, Double saldo, Double taxaDeJuros) {
		super(numero, titular, saldo);
		this.taxaDeJuros = taxaDeJuros;
	}

	public void atualizarSaldo() {
		saldo += saldo * taxaDeJuros;
	}
	@Override
	public final void saque(Double quantia) {
		saldo -= quantia;
	}
}
