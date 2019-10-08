package application;

import entities.Conta;
import entities.ContaEmpresarial;
import entities.ContaPoupanca;

public class BancoMainProgram {

	public static void main(String[] args) {
		Conta conta = new Conta(1001, "Alex", 0.00);
		ContaEmpresarial contaEmpresarial1 = new ContaEmpresarial(1002, "Maria", 0.00, 500.00);

		// Upcasting Herança É-UM - atribui Objeto de uma SubClasse para o Objeto da
		// SuperClasse

		Conta conta1 = contaEmpresarial1;
		Conta conta2 = new ContaEmpresarial(1003, "Bob", 0.00, 200.00);
		Conta conta3 = new ContaPoupanca(1004, "Anna", 0.00, 0.01);

		// DownCasting - Converter Objeto da SuperClasse para um Objeto da Subclasse
		// ContaEmpresarial contaEmpresarial2 = conta2; // falha
		ContaEmpresarial contaEmpresarial2 = (ContaEmpresarial) conta2; // falha
		contaEmpresarial2.emprestimo(100.00);

		// Falha em Tempo de compilação.
		// ContaEmpresarial contaEmpresarial3 = (ContaEmpresarial)conta3;
		if (conta3 instanceof ContaEmpresarial) {
			ContaEmpresarial contaEmpresarial3 = (ContaEmpresarial) conta3;
			contaEmpresarial3.emprestimo(200.00);
			System.out.println("Emprétimo realizado!");
		}

		if (conta3 instanceof ContaPoupanca) {
			ContaPoupanca contaPoupanca = (ContaPoupanca) conta3;
			contaPoupanca.atualizarSaldo();
			System.out.println("Saldo Atualizado!");
		}
		
		// Sobreposição do método de saque na Subclasse ContaPoupança
		Conta acc1 = new Conta(1006, "Alex", 1000.00);
		acc1.saque(200.00);
		System.out.println(acc1.getSaldo());
		
		Conta acc2 = new ContaPoupanca(1007, "Maria", 1000.00, 0.01);
		acc2.saque(200.00);
		System.out.println(acc2.getSaldo());
		
		// Usando o super no método sobreposto
		Conta acc3 = new ContaEmpresarial(1008,  "Bob", 1000.00, 500.00);
		acc3.saque(200.00);
		System.out.println(acc3.getSaldo());
		
		// Polimorfismo
		Conta x = new Conta(1009, "Alex", 1000.00);
		Conta y = new ContaPoupanca(1023, "Maria", 1000.00, 0.01);
		x.saque(50.00);
		y.saque(50.00);
		System.out.println(x.getSaldo());
		System.out.println(y.getSaldo());

	}
}
