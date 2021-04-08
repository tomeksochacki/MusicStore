package pl.it.camp.music.store.model;

public class Perkusja extends Product {
    private boolean plates;
    private int numberOfDrums;

    public Perkusja(String name, int quantity, String codeProduct, String typeProduct, double price, boolean plates, int numberOfDrums){
        super(name, quantity, codeProduct, typeProduct, price);
        this.plates = plates;
        this.numberOfDrums = numberOfDrums;
    }

    public boolean isPlates() {
        return plates;
    }

    public int getNumberOfDrums() {
        return numberOfDrums;
    }
}
