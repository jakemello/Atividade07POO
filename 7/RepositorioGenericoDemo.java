import java.util.List;
import java.util.Optional;

public class RepositorioGenericoDemo {
    public static void main(String[] args) {
        IRepository<ProdutoIdentificavel, String> repositorioProdutos = new InMemoryRepository<>();

        ProdutoIdentificavel p1 = new ProdutoIdentificavel("P1", "Headset RGB");
        ProdutoIdentificavel p2 = new ProdutoIdentificavel("P2", "Teclado Gamer");

        repositorioProdutos.salvar(p1);
        repositorioProdutos.salvar(p2);

        System.out.println("Lista de produtos: " + repositorioProdutos.listarTodos());

        repositorioProdutos.buscarPorId("P1").ifPresent(p -> System.out.println("Encontrado: " + p));

        repositorioProdutos.remover("P2");
        System.out.println("Lista após remoção: " + repositorioProdutos.listarTodos());

        try {
            repositorioProdutos.remover("P99");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }
    }
}