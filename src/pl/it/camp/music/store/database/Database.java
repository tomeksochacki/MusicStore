package pl.it.camp.music.store.database;

import pl.it.camp.music.store.model.*;

public class Database {
    private Product[] products = new Product[10];

    public Database() {

        this.products[0] = new Gitara("Gitara basowa", 3,"0000", "instrument smyczkowy - basowy", 350.0, 4);
        this.products[1] = new Gitara("Gitara elektroniczna", 4,"0001", "instrument smyczkowy - elektroniczny", 750.0, 6);
        this.products[2] = new Gitara("Gitara klasyczna", 1,"0002", "instrument smyczkowy - klasyczny", 200.0, 5);

        this.products[3] = new Trabka("Trąbka nowoczesna", 3,"0003", "instrument dęty", 400, 4, true);
        this.products[4] = new Trabka("Trąbka klasyczna", 7,"0004", "instrument dęty", 550, 3, true);

        this.products[5] = new Wzmacniacz("Wzmacniacz Tehnics", 0,"0005", "wzmacniacz", 1000, true, true, false, 300);
        this.products[6] = new Wzmacniacz("Wzmacniacz Sony", 7,"0006", "wzmacniacz", 700, true, true, true, 200);
        this.products[7] = new Wzmacniacz("Wzmacniacz Philips", 2,"0007", "wzmacniacz", 500, false, false, false, 170);

        this.products[8] = new Perkusja("Perkusja Mapex", 1,"0008", "instrument perkusyjny", 1500, true, 8);
        this.products[9] = new Perkusja("Perkusja Millenium",10 ,"0009", "instrument perkusyjny", 800, true, 5);
    }

    public Product[] getProducts() {
        return this.products;
    }

    public boolean soldProduct(String chooseProd, String quantityProd) {
        Product product = findProducts(chooseProd);
        if (product.getQuantity() != 0 && product.getQuantity() >= Integer.parseInt(quantityProd) && !product.isSell()) {
            product.setSell(true);
            product.setQuantity(product.getQuantity() - Integer.parseInt(quantityProd));
            return true;
        }
        return false;
    }

    public boolean returnProduct(String chooseProd2) {
        Product product = findProducts(chooseProd2);
        if (product != null && product.isSell()) {
            product.setSell(false);
            return true;
        }
        return false;
    }

    private Product findProducts(String chooseProd2) {
        for (Product prod : this.products) {
            if (prod.getCodeProduct().equals(chooseProd2)) {
                return prod;
            }
        }
        return null;
    }
}
