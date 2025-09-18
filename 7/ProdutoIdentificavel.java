class ProdutoIdentificavel implements Identificavel<String> {
    private final String id;
    private String nome;

    public ProdutoIdentificavel(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ProdutoIdentificavel{" + "id=\'" + id + '\'' + ", nome=\'" + nome + '\'' + '}';
    }
}