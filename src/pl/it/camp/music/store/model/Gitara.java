package pl.it.camp.music.store.model;

public class Gitara extends Product {

    private int numberOfStrings;//liczba strun

    public Gitara(String name, int quantity, String codeProduct, String typeProduct, double price, int numberOfStrings, boolean sell) {
        super(name, quantity, codeProduct, typeProduct, price, sell);
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    @Override
    public String convertToDbRecord() {
        StringBuilder sb = new StringBuilder();

        sb.append("Gitara;")
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
                .append(this.getNumberOfStrings())
                .append(";")
                .append(this.isSell());

        return sb.toString();
    }
}
