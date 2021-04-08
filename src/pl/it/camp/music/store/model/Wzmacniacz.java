package pl.it.camp.music.store.model;

public class Wzmacniacz extends Product {

    private boolean display;
    private boolean radioOperation;
    private boolean bluetooth;
    private int power;

    public Wzmacniacz(String name, int quantity, String codeProduct, String typeProduct, double price, boolean display, boolean radioOperation, boolean bluetooth, int power){
        super(name, quantity, codeProduct, typeProduct, price);
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
}
