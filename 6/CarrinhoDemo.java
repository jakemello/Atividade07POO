import java.math.BigDecimal;

public class CarrinhoDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Garrafa Termica", new BigDecimal("50.00"));
        Product p2 = new Product("Mouse sem fio Gamer", new BigDecimal("250.00"));

        Carrinho c1 = new Carrinho();
        Carrinho c2 = c1.adicionarItem(new ItemCarrinho(p1, 2));
        Carrinho c3 = c2.adicionarItem(new ItemCarrinho(p2, 1));

        System.out.println("Total antes do cupom: R$" + c3.calcularTotal());

        Carrinho c4 = c3.aplicarCupom(new BigDecimal("15"));
        System.out.println("Total com 15% de cupom: R$" + c4.calcularTotal());

        System.out.println("Total do carrinho original c3 (imutável): R$" + c3.calcularTotal());
    }
}