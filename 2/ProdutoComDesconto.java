//Exercício 2: Encapsulamento com Validação de Regra (Desconto)

import java.math.BigDecimal;
import java.math.RoundingMode;

class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException(String message) {
        super(message);
    }
}

public class ProdutoComDesconto extends Produto {
    public ProdutoComDesconto(String nome, BigDecimal preco, int quantidadeEmEstoque) {
        super(nome, preco, quantidadeEmEstoque);
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new DescontoInvalidoException("A porcentagem de desconto deve estar entre 0 e 50 (inclusive).");
        }
        BigDecimal valorDesconto = getPreco().multiply(BigDecimal.valueOf(porcentagem / 100));
        BigDecimal novoPreco = getPreco().subtract(valorDesconto).setScale(2, RoundingMode.HALF_UP);
        setPreco(novoPreco);
    }

    public static void main(String[] args) {
        try {
            ProdutoComDesconto produto = new ProdutoComDesconto("Mouse Gamer", new BigDecimal("7500.00"), 50);
            System.out.println("Preço original do PC Gamer Ryzem 7 7800X3D: R$" + produto.getPreco());
            produto.aplicarDesconto(10);
            System.out.println("Preço com 10% de desconto: R$" + produto.getPreco());
        } catch (DescontoInvalidoException e) {
            System.out.println("Erro ao aplicar desconto: " + e.getMessage());
        }
    }
}