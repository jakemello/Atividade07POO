import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String nome;
    private final BigDecimal preco;

    public Product(String nome, BigDecimal preco) {
        this.nome = Objects.requireNonNull(nome);
        this.preco = Objects.requireNonNull(preco);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}