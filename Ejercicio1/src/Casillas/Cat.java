package Casillas;

public class Cat extends GameCell {
    private EndGamecellType type;

    //Constructor
    public Cat() {
        this.content = EndGamecellType.Cat.getSymbol();
        this.type = EndGamecellType.Cat;
    }

    //Getter
    public EndGamecellType getType() {
        return type;
    }
}
