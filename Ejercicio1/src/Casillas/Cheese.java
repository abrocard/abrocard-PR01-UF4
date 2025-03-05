package Casillas;

public class Cheese extends GameCell {
    private EndGamecellType type;

    //Constructor
    public Cheese() {
        this.content = EndGamecellType.Cheese.getSymbol();
        this.type = EndGamecellType.Cheese;
        setDiscovered();
    }

    //Getter
    public EndGamecellType getType() {
        return type;
    }
}
