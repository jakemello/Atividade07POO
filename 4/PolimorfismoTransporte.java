//Exercício 4: Polimorfismo com Interface (IMeioTransporte)

import java.util.ArrayList;
import java.util.List;

public class PolimorfismoTransporte {
    public static void main(String[] args) {
        List<IMeioTransporte> meios = new ArrayList<>();
        meios.add(new Carro());
        meios.add(new Bicicleta());

        for (IMeioTransporte meio : meios) {
            System.out.println("\n--- Operando " + meio.getClass().getSimpleName() + " ---");
            meio.acelerar();
            meio.acelerar();
            meio.frear();
        }
    }
}