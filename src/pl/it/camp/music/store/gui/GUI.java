package pl.it.camp.music.store.gui;

import pl.it.camp.music.store.model.*;

import java.util.List;

public class GUI {
    public static void showMainMenu() {
        System.out.println("1.List products");
        System.out.println("2.Buy product");
        System.out.println("3.Return the product");
        System.out.println("4.Exit");
        System.out.println("---------------------");
        System.out.println("Enter the number:");
    }

    public static void showAllProducts(List<Product> list) {
        for (Product product : list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(product.getName() + ",")
                    .append(" ilość sztuk:")
                    .append(product.getQuantity() + ",")
                    .append(" typ produktu:")
                    .append(product.getTypeProduct() + ",")
                    .append(" kod produktu:")
                    .append(product.getCodeProduct() + ",")
                    .append(" cena:")
                    .append(product.getPrice() + ",");

            if (product instanceof Gitara) {
                stringBuilder.append(" liczba strun:")
                        .append(((Gitara) product).getNumberOfStrings() + ",");
            }

            if (product instanceof Trabka) {
                stringBuilder.append(" liczba przycisków:")
                        .append(((Trabka) product).getNumberButton() + ",")
                        .append(" głośna:")
                        .append(((Trabka) product).isLoud() + ",");
            }

            if (product instanceof Wzmacniacz) {
                stringBuilder.append(" wyświetlacz:")
                        .append(((Wzmacniacz) product).isDisplay() ? " Tak" + "," : " Nie" + ",")
                        .append(" obsługa radia:")
                        .append(((Wzmacniacz) product).isRadioOperation() ? " Tak" + "," : " Nie" + ",")
                        .append(" bluetooth:")
                        .append(((Wzmacniacz) product).isBluetooth() ? " Tak" + "," : " Nie" + ",")
                        .append(" moc:")
                        .append(((Wzmacniacz) product).getPower() + ",");
            }

            if (product instanceof Perkusja) {
                stringBuilder.append(" talerze:")
                        .append(((Perkusja) product).isPlates() ? " Tak" + "," : " Nie" + ",")
                        .append(" liczba bębnów:")
                        .append(((Perkusja) product).getNumberOfDrums() + ",");
            }

            stringBuilder.append(" sprzedany:")
                    .append(product.isSell() ? " Tak" : " Nie");
            System.out.println(stringBuilder.toString());
        }
        System.out.println("---------------------");
    }

    public static void showSoldResult(boolean soldResult) {
        if (soldResult) {
            System.out.println("Bought!!");
        } else {
            System.out.println("No product - sold!!");
        }
    }

    public static void showReturnResult(boolean returnResult) {
        if (returnResult)
            System.out.println("The product was returned.");
        else {
            System.out.println("The product is not found or the product is not sold.");
        }
    }
}
