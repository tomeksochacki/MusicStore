package pl.it.camp.music.store.model;

public class Wzmacniacz extends Product {

    private boolean display;
    private boolean radioOperation;
    private boolean bluetooth;
    private int power;

    public Wzmacniacz(String name, int quantity, String codeProduct, String typeProduct, double price, boolean display, boolean radioOperation, boolean bluetooth, int power, boolean sell){
        super(name, quantity, codeProduct, typeProduct, price, sell);
        this.display = display;
        this.radioOperation = radioOperation;
        this.bluetooth = bluetooth;
        this.power = power;
    }

    public boolean isDisplay() {
        return display;
    }

    public boolean isRadioOperation() {
        return radioOperation;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String convertToDbRecord() {

        StringBuilder sb = new StringBuilder();

        sb.append("Wzmacniacz;")
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
                .append(this.isDisplay())
                .append(";")
                .append(this.isRadioOperation())
                .append(";")
                .append(this.isBluetooth())
                .append(";")
                .append(this.getPower())
                .append(";")
                .append(this.isSell());

        return sb.toString();
    }
}
