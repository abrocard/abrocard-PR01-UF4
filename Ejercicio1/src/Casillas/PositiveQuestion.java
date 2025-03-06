package Casillas;

public class PositiveQuestion extends GameCell implements Questionable {
    public PositiveQuestion() {
        this.content = "++";
    }

    @Override
    public String getQuestion() {
        return "Nombra uno de los SGBD mas utilizados en la actualidad:";
    }

    @Override
    public boolean submitAnswer(String answer) {
        if (answer.equalsIgnoreCase("MySQL") || answer.equalsIgnoreCase("PostgreSQL") || answer.equalsIgnoreCase("SQL Server") || answer.equalsIgnoreCase("Oracle")) {
            System.out.println("¡Respuesta correcta, has obtenido 50 puntos!");
            return true;
        }
        System.out.println("¡Respuesta incorrecta! La respuesta correcta era MySQL, PostgreSQL, SQL Server u Oracle.");
        return false;
    }
}
