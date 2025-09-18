//Exercício 5: Abstração (Sistema de Pagamentos)

class PagamentoInvalidoException extends RuntimeException {
    public PagamentoInvalidoException(String message) {
        super(message);
    }
}