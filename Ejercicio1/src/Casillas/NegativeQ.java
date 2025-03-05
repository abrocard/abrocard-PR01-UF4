package Casillas;

import java.util.Random;

public class NegativeQ extends GameCell implements Questionable {
    public NegativeQ() {
        this.content = "--";
    }

    @Override
    public String getQuestion() {
        return "Inserte un número entre 1 y 3, si falla perderá 50 puntos:";

    }

    @Override
    public boolean submitAnswer(String answer) {
        try {
            int userAnswer = Integer.parseInt(answer);
            if (userAnswer < 1 || userAnswer > 3) {
                System.out.println("Número fuera de rango. Debe ser entre 1 y 3.");
                return false;
            }

            Random random = new Random();
            int correctAnswer = random.nextInt(3) + 1;

            if (userAnswer == correctAnswer) {
                System.out.println("¡Respuesta correcta!");
                return true;
            } else {
                System.out.println("¡Respuesta incorrecta! El número correcto era " + correctAnswer + ".");
                //TODO: RESTAR 50 PUNTOS AL JUGADOR
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Debe ser un número entre 1 y 3.");
            return false;
        }
    }
}
