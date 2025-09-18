//Exercício 4: Polimorfismo com Interface (IMeioTransporte)

interface IMeioTransporte {
    void acelerar();
    void frear();
}

class Carro implements IMeioTransporte {
    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 180;

    @Override
    public void acelerar() {
        if (velocidadeAtual < VELOCIDADE_MAXIMA) {
            velocidadeAtual += 10;
            System.out.println("Carro acelerando... velocidade: " + velocidadeAtual + " km/h");
        } else {
            System.out.println("Carro já está na velocidade máxima.");
        }
    }

    @Override
    public void frear() {
        if (velocidadeAtual > 0) {
            velocidadeAtual -= 10;
            System.out.println("Carro freando... velocidade: " + velocidadeAtual + " km/h");
        } else {
            System.out.println("Carro já está parado.");
        }
    }
}

class Bicicleta implements IMeioTransporte {
    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 40;

    @Override
    public void acelerar() {
        if (velocidadeAtual < VELOCIDADE_MAXIMA) {
            velocidadeAtual += 2;
            System.out.println("Bicicleta acelerando... velocidade: " + velocidadeAtual + " km/h");
        } else {
            System.out.println("Bicicleta já está na velocidade máxima.");
        }
    }

    @Override
    public void frear() {
        if (velocidadeAtual > 0) {
            velocidadeAtual -= 2;
            System.out.println("Bicicleta freando... velocidade: " + velocidadeAtual + " km/h");
        } else {
            System.out.println("Bicicleta já está parada.");
        }
    }
}