package Casillas;

public class PositiveQ extends GameCell implements Questionable {
    public PositiveQ() {
        this.content = "++";
    }

    @Override
    public String getQuestion() {
        return "Nombra uno de los SGBD mas utilizados en la actualidad:";
    }

    @Override
    public boolean submitAnswer(String answer) {
        if (answer.equalsIgnoreCase("MySQL") || answer.equalsIgnoreCase("PostgreSQL") || answer.equalsIgnoreCase("SQL Server") || answer.equalsIgnoreCase("Oracle")) {
            System.out.println("¡Respuesta correcta!");
            //TODO: SUMAR 50 PUNTOS AL JUGADOR
            return true;
        }
        System.out.println("¡Respuesta incorrecta! La respuesta correcta era MySQL, PostgreSQL, SQL Server u Oracle.");
        return false;
    }
}
