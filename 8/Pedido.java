import java.math.BigDecimal;
import java.util.function.BiFunction;

public class Pedido {
    private final String cepDestino;
    private final BigDecimal valorTotal;
    private BiFunction<String, BigDecimal, BigDecimal> estrategiaFrete;

    public Pedido(String cepDestino, BigDecimal valorTotal) {
        this.cepDestino = cepDestino;
        this.valorTotal = valorTotal;
    }

    public void setEstrategiaFrete(BiFunction<String, BigDecimal, BigDecimal> estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal calcularFrete() {
        if (estrategiaFrete == null) {
            throw new IllegalStateException("Estratégia de frete não definida.");
        }
        return this.estrategiaFrete.apply(cepDestino, valorTotal);
    }
}