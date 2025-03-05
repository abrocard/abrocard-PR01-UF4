package Casillas;

public enum EndGamecellType {
    Cat("CC"),Cheese("CH");
    private final String symbol;

    //Constructor
    EndGamecellType(String symbol) {
        this.symbol = symbol;
    }

    //Getter
    public String getSymbol() {
        return symbol;
    }

}
