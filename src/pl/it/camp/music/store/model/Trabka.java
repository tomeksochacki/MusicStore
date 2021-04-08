package pl.it.camp.music.store.model;

public class Trabka extends Product{

    private int numberButton;//liczba przyciskow
    private boolean loud;//czy głośna

    public Trabka(String name, int quantity, String codeProduct, String typeProduct, double price, int numberButton, boolean loud) {
        super(name, quantity, codeProduct, typeProduct, price);
        this.numberButton = numberButton;
        this.loud = loud;
    }

    public int getNumberButton() {
        return numberButton;
    }

    public boolean isLoud() {
        return loud;
    }
}
