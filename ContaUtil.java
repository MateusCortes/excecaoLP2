package questao04;

import java.util.Scanner;
public class ContaUtil {
    public static void main(String[] args) throws Exception {
        double valor;
        boolean continuar = true;

        Conta conta = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe Saldo Mínimo: ");
        valor = scanner.nextDouble(); // entrada de saldo mínimo de conta
        conta = new Conta(valor); // inicialização de objeto da classe Conta

        do {
            System.out.print("\nInforme um valor 'positivo' para deposito. Um valor 'negativo' para saque, '0' para sair)");
            valor = scanner.nextDouble();
            if (valor > 0) {
                conta.depositar(valor);
                System.out.println("Operação de depósito");
                System.out.println("Foi depositado o valor de: " + valor);
            } else if (valor < 0) {
                try {
                    conta.sacar(valor);
                    System.out.println("Operação de saque realizada com sucesso");
                } catch (Exception e) {
                    System.out.println("Saldo insuficente para realizar operação");
                }
            } else {
                continuar = false;
            }
        }
            while (continuar) ;

            System.out.println("\nSaldo Final: " + conta.getSaldo());
            System.out.println("Tributos Totalizados: " + conta.calcularTributos());

            scanner.close();
        }
    }






