import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal cupomDesconto;

    public Carrinho() {
        this.itens = Collections.emptyList();
        this.cupomDesconto = BigDecimal.ZERO;
    }

    private Carrinho(List<ItemCarrinho> itens, BigDecimal cupomDesconto) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.cupomDesconto = cupomDesconto;
    }

    public Carrinho adicionarItem(ItemCarrinho novoItem) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.add(novoItem);
        return new Carrinho(novaLista, this.cupomDesconto);
    }

    public Carrinho aplicarCupom(BigDecimal porcentagem) {
        if (porcentagem.compareTo(BigDecimal.ZERO) < 0 || porcentagem.compareTo(new BigDecimal("30")) > 0) {
            throw new IllegalArgumentException("Cupom limitado a 20%.");
        }
        return new Carrinho(this.itens, porcentagem);
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCarrinho item : itens) {
            total = total.add(item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())));
        }
        BigDecimal valorDesconto = total.multiply(this.cupomDesconto.divide(new BigDecimal("100")));
        return total.subtract(valorDesconto).setScale(2, RoundingMode.HALF_UP);
    }
}