import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalculadoraFrete {
    private static final Map<String, BigDecimal> custosFretePorRegiao = new HashMap<>();

    static {
        custosFretePorRegiao.put("SP", new BigDecimal("15.00"));
        custosFretePorRegiao.put("RJ", new BigDecimal("20.00"));
        custosFretePorRegiao.put("MG", new BigDecimal("25.00"));
    }

    public static BigDecimal calcularFreteSedex(String cep, BigDecimal valor) {
        String regiao = cep.substring(0, 2);
        if (!custosFretePorRegiao.containsKey(regiao)) {
            throw new CEPInvalidoException("CEP inválido para Sedex.");
        }
        return custosFretePorRegiao.get(regiao);
    }

    public static BigDecimal calcularFretePac(String cep, BigDecimal valor) {
        String regiao = cep.substring(0, 2);
        if (!custosFretePorRegiao.containsKey(regiao)) {
            throw new CEPInvalidoException("CEP inválido para PAC.");
        }
        return custosFretePorRegiao.get(regiao).subtract(new BigDecimal("5.00"));
    }

    public static BigDecimal calcularFreteRetiradaNaLoja(String cep, BigDecimal valor) {
        return BigDecimal.ZERO;
    }
}