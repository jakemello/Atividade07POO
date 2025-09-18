//Exercício 3: Herança (Hierarquia de Funcionários)

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SistemaFuncionarios {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Gerente("Ana Souza", new BigDecimal("10000.00")));
        funcionarios.add(new Desenvolvedor("João Silva", new BigDecimal("7500.00")));
        funcionarios.add(new Gerente("Carlos Lima", new BigDecimal("12000.00")));

        for (Funcionario f : funcionarios) {
            System.out.println("Funcionário: " + f.getNome() + ", Salário: R$" + f.getSalario() + ", Bônus: R$" + f.calcularBonus());
        }
    }
}