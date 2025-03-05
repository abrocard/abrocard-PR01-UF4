import Casillas.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameCell[][] matrix = new GameCell[4][4];

        matrix[0][0] = new Mouse();
        matrix[3][3] = new Cheese();
        matrix[0][1] = new PositiveQ();
        matrix[2][2] = new NegativeQ();
        matrix[1][3] = new Cat();

        //LLenar la matriz con casillas de puntos
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = new Puntuation();
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea inicar el juego en modo test? (Si/No)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Si")) {
            //Imprimir la matriz solucion
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(matrix[i][j].toString() + "\t");
                }
                System.out.println();
            }
            System.out.println(); //Salto de línea
        }
        //Bienvenida + instrucciones

        System.out.println("Bienvenido a Cheese Mouse Game\n" + "El objetivo del juego es que el raton 'MM' llegue al queso 'CH'\n" + "Para desplazar el raton pulse:\n" + "W - arriba\n" + "A - izquierda\n" + "S - abajo\n" + "D - derecha\n");
        boolean victory = false;
        while (!victory){

            //Imprimir la matriz oculta

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (matrix[i][j].isDiscovered()) {
                        System.out.print(matrix[i][j].toString() + "\t");
                    } else {
                        System.out.print("?\t");
                    }
                }
                System.out.println();
            }
        }
    }
}
