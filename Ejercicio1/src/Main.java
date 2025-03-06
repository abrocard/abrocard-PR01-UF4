import Casillas.*;
import java.util.Random;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    //Metodo para generar posiciones aleatorias y que se asegure de que no estan ocupadas ya
    private static int[] getRandomCell(Set<String> occupiedPositions) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(4);
            y = random.nextInt(4);
        } while (occupiedPositions.contains(x + "," + y));
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int newMouseY = 0;
        int newMouseX = 0;
        int totalPoints = 0;

        GameCell[][] matrix = new GameCell[4][4];

        //Coloca el ratón y el queso en posiciones fijas y las guarda
        matrix[0][0] = new Mouse();
        matrix[3][3] = new Cheese();

        Set<String> occupiedPositions = new HashSet<>();

        occupiedPositions.add("0,0");
        occupiedPositions.add("3,3");

        //Coloca las casillas de preguntas y gato en posiciones aleatorias
        int[] posQ = getRandomCell(occupiedPositions);
        matrix[posQ[0]][posQ[1]] = new PositiveQuestion();
        occupiedPositions.add(posQ[0] + "," + posQ[1]);

        int[] negQ = getRandomCell(occupiedPositions);
        matrix[negQ[0]][negQ[1]] = new NegativeQuestion();
        occupiedPositions.add(negQ[0] + "," + negQ[1]);

        int[] cat = getRandomCell(occupiedPositions);
        matrix[cat[0]][cat[1]] = new Cat();
        occupiedPositions.add(cat[0] + "," + cat[1]);

        //LLena el resto de la matrix con casillas de puntos
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = new Puntuation();
                }
            }
        }

        //Inicio de Scanner
        Scanner scanner = new Scanner(System.in);

        //Modo test
        System.out.println("Desea inicar el juego en modo test? (Si/No)");
        String test = scanner.nextLine();
        if (test.equalsIgnoreCase("Si")) {

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
        System.out.println("""
                ¡Bienvenido a Cheese Mouse Game!
                El objetivo del juego es que el raton 'MM' llegue al queso 'CH'
                Para desplazar el raton pulse:
                W - Arriba
                A - Izquierda
                S - Abajo
                D - Derecha
                """);

        boolean inGame = true;
        while (inGame){

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

            System.out.println("Puntuación actual: " + totalPoints);

            //Movimiento del ratón
            String move = scanner.nextLine();
            int oldMouseX= newMouseX;
            int oldMouseY= newMouseY;

            switch (move){
                case "W":
                    newMouseX--;
                    if (newMouseX >= 0 && !(matrix[newMouseX][newMouseY] instanceof VoidCell)){
                        matrix[newMouseX][newMouseY].setDiscovered();
                        matrix[oldMouseX][oldMouseY] = new VoidCell();
                    } else {
                        System.out.println("Movimiento no válido");
                        newMouseX++;
                    }
                    break;

                case "S":
                    newMouseX++;
                    if (newMouseX <= 3 && !(matrix[newMouseX][newMouseY] instanceof VoidCell)){
                        matrix[newMouseX][newMouseY].setDiscovered();
                        matrix[oldMouseX][oldMouseY] = new VoidCell();
                    } else {
                        System.out.println("Movimiento no válido");
                        newMouseX--;
                    }
                    break;

                case "A":
                    newMouseY--;
                    if (newMouseY >= 0 && !(matrix[newMouseX][newMouseY] instanceof VoidCell)){
                        matrix[newMouseX][newMouseY].setDiscovered();
                        matrix[oldMouseX][oldMouseY] = new VoidCell();
                    } else {
                        System.out.println("Movimiento no válido");
                        newMouseY++;
                    }
                    break;

                case "D":
                    newMouseY++;
                    if (newMouseY <= 3 && !(matrix[newMouseX][newMouseY] instanceof VoidCell)){
                        matrix[newMouseX][newMouseY].setDiscovered();
                        matrix[oldMouseX][oldMouseY] = new VoidCell();
                    } else {
                        System.out.println("Movimiento no válido");
                        newMouseY--;
                    }
                    break;

                default:
                    System.out.println("Movimiento no válido");
                    break;
            }

            //Mouse en Cheese
            if (matrix[newMouseX][newMouseY] instanceof Cheese) {
                System.out.println("¡Felicidades! El ratón encontró el queso.");
                System.out.println("Puntuación final: " + totalPoints);
                inGame = false;

                //Mouse en Cat
            } else if  (matrix[newMouseX][newMouseY] instanceof Cat) {
                System.out.println("¡Oh no! El ratón fue atrapado por el gato. Fin del juego.");
                System.out.println("Puntuación final: " + totalPoints);
                inGame = false;

                //Mouse en Positive Question
            } else if (matrix[newMouseX][newMouseY] instanceof PositiveQuestion positiveQ){
                System.out.println(positiveQ.getQuestion());
                String answer = scanner.nextLine();

                if (positiveQ.submitAnswer(answer)){
                    totalPoints += 50;
                }

                //Mouse en Negative Question
            } else if (matrix[newMouseX][newMouseY] instanceof NegativeQuestion negativeQ) {
                System.out.println(negativeQ.getQuestion());
                String answer = scanner.nextLine();

                if (!negativeQ.submitAnswer(answer)) {
                    totalPoints -= 20;
                }

                //Mouse en Puntuation
            } else if (matrix[newMouseX][newMouseY] instanceof Puntuation puntuation) {
                totalPoints += Integer.parseInt(puntuation.toString());
                System.out.println("¡Has obtenido " + puntuation + " puntos!");
            }

            //Nueva posicion del mouse
            matrix[newMouseX][newMouseY] = new Mouse();
        }
    }
}
