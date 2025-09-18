//Exercício 5: Abstração (Sistema de Pagamentos)

import java.math.BigDecimal;

public class SistemaPagamentos {
    public static void main(String[] args) {
        BigDecimal valorCompra = new BigDecimal("500.00");
        try {
            FormaPagamento cartao = new CartaoCredito("1234567890123456");
            cartao.validarPagamento();
            cartao.processarPagamento(valorCompra);

            System.out.println("---");

            FormaPagamento boleto = new Boleto("987654321098765432109876543210987654321098765");
            boleto.validarPagamento();
            boleto.processarPagamento(valorCompra);

            System.out.println("---");

            FormaPagamento pix = new Pix("minha.chave@exemplo");
            pix.validarPagamento();
            pix.processarPagamento(valorCompra);

        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        }
    }
}