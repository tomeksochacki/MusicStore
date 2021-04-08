package pl.it.camp.music.store;

import pl.it.camp.music.store.database.Database;
import pl.it.camp.music.store.gui.GUI;
import pl.it.camp.music.store.model.Login;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the username and password:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Login login = new Login();
        if (login.logIn(reader.readLine(), reader.readLine())) {
            System.out.println("Good job !!");
            Database database = new Database();
            GUI gui = new GUI();
            boolean flag = true;
            while (flag) {
                gui.showMainMenu();
                switch (reader.readLine()) {
                    case "1":
                        gui.showAllProducts(database.getProducts());
                        break;
                    case "2":
                        System.out.println("Enter the code product, and quantity:");
                        gui.showSoldResult(database.soldProduct(reader.readLine(), reader.readLine()));
                        break;
                    case "3":
                        System.out.println("Enter the code product:");
                        gui.showReturnResult(database.returnProduct(reader.readLine()));
                        break;
                    case "4":
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong choice!!");
                }
            }
        } else System.out.println("Wrong password or username!!");
    }
}

