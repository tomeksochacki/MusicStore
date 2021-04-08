package pl.it.camp.music.store.model;

public class Gitara extends Product {

    private int numberOfStrings;//liczba strun

    public Gitara(String name,
                  int quantity,
                  String codeProduct,
                  String typeProduct,
                  double price,
                  int numberOfStrings) {
        super(name, quantity, codeProduct, typeProduct, price);
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }
}
