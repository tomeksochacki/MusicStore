package pl.it.camp.music.store.model;

public class Product {
    private String name;
    private int quantity;
    private String codeProduct;
    private String typeProduct;
    private double price;
    private boolean sell;//czy sprzedany

    public Product(String name, int quantity, String codeProduct, String typeProduct, double price){
        this.name = name;
        this.quantity = quantity;
        this.codeProduct = codeProduct;
        this.typeProduct = typeProduct;
        this.price = price;
        this.sell = false;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }
}
