package pl.it.camp.music.store;

import pl.it.camp.music.store.database.Database;
import pl.it.camp.music.store.gui.GUI;
import pl.it.camp.music.store.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Wyswietla pustą listę użytkowników
        System.out.println(database.getUsers());
        boolean flagRegistration = false;
        boolean flagLogin = false;
        boolean flagMenu2 = false;
        boolean flagMenu1 = true;
        String log = "L";
        String reg = "R";
        String temp;
        while (flagMenu1) {

            try {
                System.out.println("Select!! If to log in click L, if registration click R");
                temp = reader.readLine();
                if (temp.equals(reg)) {
                    flagRegistration = true;
                    System.out.println("Registration");
                    break;
                } else if (temp.equals(log)) {
                    if (database.getUsers().isEmpty()) {
                        System.out.println("No users in the database. You need to register!!");
                        continue;
                    } else {
                        System.out.println("Login");
                        flagLogin = true;
                        break;
                    }
                }
                if (!(temp.equals(reg) || temp.equals(log))) {
                    System.out.println("Wrong choice, repeat!!");
                }

            } catch (IOException e) {
                System.out.println("Data download failed!!");
            }

        }

        while (flagRegistration) {

            try {
                System.out.println("Create new user: ");
                System.out.println("Enter your login:");
                //TODO zapętlić jeśli nazwa użytkownika już taka jest
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
                temp = reader.readLine();
                if (temp.equals(log)) {
                    flagRegistration = false;
                    flagLogin = true;
                    break;
                }

                if (temp.equals(reg)) {
                    continue;
                }
                //TODO poprawić sytuację kiedy nie wybieramy L ani R, tylko coś innego lub poproastu ENTER
                if ((!temp.equals(reg)) || (!temp.equals(log))) {
                    System.out.println("Wrong choice, repeat!!");
                /*System.out.println("If registration repeat click R, if registration exit and log in click L");
                temp = reader.readLine();*/
                    //flagRegistration = false;
                    //flagMenu1 = true;
                    continue;
                }
            } catch (IOException e) {
                System.out.println("Data download failed!!");
            }
        }

        int loginCounter = 0;
        while (flagLogin) {
            String login;
            String password;
            try {
                System.out.println("Enter the login:");
                login = reader.readLine();
                System.out.println("Enter the password:");
                password = reader.readLine();
            } catch (IOException e) {
                System.out.println("Data download failed!!");
                continue;
            }
            boolean authResult = database.authenticate(login, password);
            if (authResult) {
                flagMenu2 = true;
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

        while (flagMenu2) {
            try {
                GUI.getInstance().showMainMenu();
                switch (reader.readLine()) {
                    case "1":
                        GUI.getInstance().showAllProducts(database.getList());
                        break;
                    case "2":
                        System.out.println("Enter the code product, and quantity:");
                        GUI.getInstance().showSoldResult(database.soldProduct(reader.readLine(), reader.readLine()));
                        break;
                    case "3":
                        System.out.println("Enter the code product, and quantity:");
                        GUI.getInstance().showReturnResult(database.returnProduct(reader.readLine(), reader.readLine()));
                        break;
                    case "4":
                        flagMenu2 = false;
                        Database.getInstance().writeDataBaseToFile();
                        break;
                    default:
                        System.out.println("Wrong choice!!");
                }
            } catch (IOException e) {
                System.out.println("Data download failed!!");
            }
        }
    }
}

