package pl.it.camp.music.store.model;

public class Perkusja extends Product {
    private boolean plates;
    private int numberOfDrums;

    public Perkusja(String name, int quantity, String codeProduct, String typeProduct, double price, boolean plates, int numberOfDrums, boolean sell){
        super(name, quantity, codeProduct, typeProduct, price, sell);
        this.plates = plates;
        this.numberOfDrums = numberOfDrums;
    }

    public boolean isPlates() {
        return plates;
    }

    public int getNumberOfDrums() {
        return numberOfDrums;
    }

    public String convertToDbRecord() {
        StringBuilder sb = new StringBuilder();

        sb.append("Perkusja;")
                .append(this.getName())
                .append(";")
                .append(this.getQuantity())
                .append(";")
                .append(this.getCodeProduct())
                .append(";")
                .append(this.getTypeProduct())
                .append(";")
                .append(this.getPrice())
                .append(";")
                .append(this.isPlates())
                .append(";")
                .append(this.getNumberOfDrums())
                .append(";")
                .append(this.isSell());

        return sb.toString();
    }
}
