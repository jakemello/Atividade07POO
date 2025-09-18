import java.math.BigDecimal;

public class FreteStrategyDemo {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("RJ20000", new BigDecimal("200.00"));

        // Estratégia 1: Sedex (usando referência de método)
        pedido.setEstrategiaFrete(CalculadoraFrete::calcularFreteSedex);
        System.out.println("Frete Sedex: R$" + pedido.calcularFrete());

        // Estratégia 2: PAC
        pedido.setEstrategiaFrete(CalculadoraFrete::calcularFretePac);
        System.out.println("Frete PAC: R$" + pedido.calcularFrete());

        // Estratégia 3: Frete grátis com lambda (acima de R$ 150)
        pedido.setEstrategiaFrete((cep, valor) -> valor.compareTo(new BigDecimal("150.00")) > 0 ? BigDecimal.ZERO : new BigDecimal("10.00"));
        System.out.println("Frete Promocional (pedido R$200): R$" + pedido.calcularFrete());

        Pedido pedido2 = new Pedido("RJ20000", new BigDecimal("100.00"));
        pedido2.setEstrategiaFrete((cep, valor) -> valor.compareTo(new BigDecimal("150.00")) > 0 ? BigDecimal.ZERO : new BigDecimal("10.00"));
        System.out.println("Frete Promocional (pedido R$100): R$" + pedido2.calcularFrete());
    }
}