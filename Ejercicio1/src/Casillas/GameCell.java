package Casillas;

public abstract class GameCell {

    private boolean isDiscovered;
    protected String content;

    //getter
    public boolean isDiscovered() {
        return isDiscovered;
    }


    //setter
    public void setDiscovered() {
        isDiscovered = true;
    }



    @Override
    public String toString() {
        return  content;
    }
}
