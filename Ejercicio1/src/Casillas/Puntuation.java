package Casillas;

import java.util.Random;

public class Puntuation extends GameCell {
    public Puntuation() {
        this.content = generateRandomPuntuation();
    }

    //Metodo que genera un valor aleatorio de 10, 20 o 30
    private String generateRandomPuntuation() {
        Random random = new Random();
        int[] possibleValues = {10, 20, 30};
        int randomValue = possibleValues[random.nextInt(possibleValues.length)];
        return String.valueOf(randomValue);
    }

    //TODO: Sumar el valor de la casilla a la puntuación total del jugador.
}
