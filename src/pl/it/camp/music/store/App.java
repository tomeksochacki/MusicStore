package pl.it.camp.music.store;

import pl.it.camp.music.store.database.Database;
import pl.it.camp.music.store.gui.GUI;
import pl.it.camp.music.store.model.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        Database database = new Database();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Wyswietla pustą listę użytkowników
        System.out.println(database.getUsers());

        while (true) {
            System.out.println("Select!! If to log in click L, if registration click R");
            String log = "L";
            String reg = "R";
            boolean flagRegistration = false;
            String temp = reader.readLine();

            if (temp.equals(reg)) {
                flagRegistration = true;
                System.out.println("Registration");
                break;
            } else if (temp.equals(log)) {
                if (database.getUsers().equals(null)) {
                    System.out.println("No users in the database. You need to register!!");
                } else {
                    System.out.println("Login");
                }
                break;
            }

            if ((!temp.equals(reg)) || (!temp.equals(log))) {
                System.out.println("Wrong choice, repeat!!");
            }
            continue;
        }

        //Rejestracja zapis do pliku txt
        /*System.out.println("This is registration!! ");
        System.out.println("Enter your login:");
        PrintWriter printWriter = new PrintWriter(database.getFile());
        printWriter.println(reader.readLine());
        System.out.println("Enter your password:");
        printWriter.println(reader.readLine());
        printWriter.close();*/

        boolean flggg = true;
        while (flggg) {
            //Rejestracja wpisanie danych przez użytkownika i odczytanie ich przez program
            System.out.println("Create new user: ");
            System.out.println("Enter your login:");
            String loginTyped = database.registrationLogin(reader.readLine());
            System.out.println("Enter your password:");
            String passwordTyped = database.registrationPassword(reader.readLine());
            System.out.println("Enter your name:");
            String nameTyped = database.registrationName(reader.readLine());
            System.out.println("Enter your surname:");
            String sureNameTyped = database.registrationSureName(reader.readLine());
            System.out.println("Enter your age:");
            String ageTyped = database.registrationAge(reader.readLine());
            System.out.println("Enter your phone number:");
            String phoneNumberTyped = database.registrationPhoneNumber(reader.readLine());

            //Utworzenie nowego użytkownika na podstawie wpisanych danych
            User user1 = database.createUser(loginTyped, passwordTyped, nameTyped, sureNameTyped, ageTyped, phoneNumberTyped);

            //Dodanie użytkownika do bazy danych - czyli listy
            database.addUserToList(user1);

            //Pomocnicze wyświelenie listy użytkowników w celu sprawdzenia, czy został utworzony i dodany
            database.listUsers();

            System.out.println("If registration repeat click R, if registration exit and log in click L");
            if (reader.readLine().equals("L")) {
                flggg = false;
            }
        }

        int loginCounter = 0;
        while (true) {
            System.out.println("Enter the login:");
            String login = reader.readLine();
            System.out.println("Enter the password:");
            String password = reader.readLine();

            boolean authResult = database.authenticate(login, password);
            if (authResult) {
                break;
            } else {
                System.out.println("Incorrect data!!");
                loginCounter++;
            }

            if (loginCounter >= 3) {
                System.out.println("Login failed!!");
                System.exit(0);
            }
        }
        /*if (flagLogin == true) {
            flag = true;
        }*/
        boolean flag = true;
        while (flag) {
            GUI.showMainMenu();
            switch (reader.readLine()) {
                case "1":
                    GUI.showAllProducts(database.getList());
                    break;
                case "2":
                    System.out.println("Enter the code product, and quantity:");
                    GUI.showSoldResult(database.soldProduct(reader.readLine(), reader.readLine()));
                    break;
                case "3":
                    System.out.println("Enter the code product, and quantity:");
                    GUI.showReturnResult(database.returnProduct(reader.readLine(), reader.readLine()));
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong choice!!");
            }
        }
    }
}

