//Exercício 5: Abstração (Sistema de Pagamentos)

import java.math.BigDecimal;

abstract class FormaPagamento {
    public abstract void validarPagamento();
    public abstract void processarPagamento(BigDecimal valor);
}

class CartaoCredito extends FormaPagamento {
    private String numeroCartao;
    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() {
        if (numeroCartao == null || numeroCartao.length() != 16 || !numeroCartao.matches("\\d+")) {
            throw new PagamentoInvalidoException("Número de cartão inválido.");
        }
        System.out.println("Validação do cartão de crédito OK.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Cartão de Crédito...");
    }
}

class Boleto extends FormaPagamento {
    private String codigoBarras;
    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() {
        if (codigoBarras == null || codigoBarras.length() != 47 || !codigoBarras.matches("\\d+")) {
            throw new PagamentoInvalidoException("Formato de boleto inválido.");
        }
        System.out.println("Validação do boleto OK.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Boleto...");
    }
}

class Pix extends FormaPagamento {
    private String chavePix;
    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() {
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
        System.out.println("Validação da chave Pix OK.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Pix...");
    }
}