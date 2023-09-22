package questao04;

public class Conta implements Tributavel{
    private double saldo; // saldo corrente
    private double saldoMinimo; // saldo mínimo (saldo atual não pode ser inferior a este saldo)
    private double tributosTotalizados; //Variável que armazena os tributos

    // método construtor de inicialização de saldo mínimo
    public Conta(double saldoMinimo) {
        this.saldo = 0; // inicialização de saldo atual (corrente) com 0 (zero)
        this.saldoMinimo = saldoMinimo;
        this.tributosTotalizados = 0;
    }

    @Override
    public double calcularTributos() {
        return tributosTotalizados;
    }

    // retorno de valor atual do saldo mínimo
    public double getSaldoMinimo() {

        return saldoMinimo;
    }

    // atualização de valor atual do saldo mínimo
    public void setSaldoMinimo(double saldoMinimo) {

        this.saldoMinimo = saldoMinimo;
    }

    // retorno de valor atual do saldo corrente
    public double getSaldo() {
        return saldo;
    }

    // operação de registro de depósito em conta, com atualização de saldo corrente
    public void depositar(double deposito)
    {
        //Na operação de deposito teremos o acréscimo do tributo
        double tributos = deposito*0.01;
        saldo += deposito - tributos;
        tributosTotalizados+= tributos;
    }

    // operação de registro de saque em conta, com atualização de saldo corrente
    public void sacar(double saque) throws Exception {
        if (saldo - saque >= saldoMinimo) {
            double tributos= saque*0.01;
            saldo = saldo - (saque+tributos);
            tributosTotalizados = tributosTotalizados + tributos;
            System.out.println(saldo);
        } else {
            throw new Exception("Erro ao realizar operação");
        }
    }
}
