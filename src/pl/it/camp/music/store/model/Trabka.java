package pl.it.camp.music.store.model;

public class Trabka extends Product{

    private int numberButton;//liczba przyciskow
    private boolean loud;//czy głośna

    public Trabka(String name, int quantity, String codeProduct, String typeProduct, double price, int numberButton, boolean loud, boolean sell) {
        super(name, quantity, codeProduct, typeProduct, price, sell);
        this.numberButton = numberButton;
        this.loud = loud;
    }

    public int getNumberButton() {
        return numberButton;
    }

    public boolean isLoud() {
        return loud;
    }


    @Override
    public String convertToDbRecord() {

        StringBuilder sb = new StringBuilder();

        sb.append("Trąbka;")
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
                .append(this.getNumberButton())
                .append(";")
                .append(this.isLoud())
                .append(";")
                .append(this.isSell());

        return sb.toString();
    }
}
