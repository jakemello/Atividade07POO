public final class ItemCarrinho {
    private final Product produto;
    private final int quantidade;

    public ItemCarrinho(Product produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade do item deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Product getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}