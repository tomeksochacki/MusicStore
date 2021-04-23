package pl.it.camp.music.store.database;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.codec.digest.DigestUtils;
import pl.it.camp.music.store.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private static Database instance = new Database();
    private List<Product> list = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private final String pathToDbFile = "Db.txt";

    private Database() {
        this.loadDataFromFile();
        //TODO usunąć z konstruktora całą tą listę, bo będzie zapisana w pliku

        /*this.list.add(new Gitara("Gitara basowa", 3, "0000", "instrument smyczkowy - basowy", 350.0, 4, false));
        this.list.add(new Gitara("Gitara elektroniczna", 4, "0001", "instrument smyczkowy - elektroniczny", 750.0, 6, false));
        this.list.add(new Gitara("Gitara klasyczna", 1, "0002", "instrument smyczkowy - klasyczny", 200.0, 5, false));
        this.list.add(new Trabka("Trąbka nowoczesna", 3, "0003", "instrument dęty", 400, 4, true, false));
        this.list.add(new Trabka("Trąbka klasyczna", 7, "0004", "instrument dęty", 550, 3, true, false));
        this.list.add(new Wzmacniacz("Wzmacniacz Tehnics", 0, "0005", "wzmacniacz", 1000, true, true, false, 300, false));
        this.list.add(new Wzmacniacz("Wzmacniacz Sony", 7, "0006", "wzmacniacz", 700, true, true, true, 200, false));
        this.list.add(new Wzmacniacz("Wzmacniacz Philips", 2, "0007", "wzmacniacz", 500, false, false, false, 170, false));
        this.list.add(new Perkusja("Perkusja Mapex", 1, "0008", "instrument perkusyjny", 1500, true, 8, false));
        this.list.add(new Perkusja("Perkusja Millenium", 10, "0009", "instrument perkusyjny", 800, true, 5, false));*/
    }

    public static Database getInstance() {
        if (Database.instance == null) {
            Database.instance = new Database();
        }
        return Database.instance;
    }

    public List<User> getUsers() {
        return this.users;
    }

/*public File getFile() {
        return file;
    }*/

    public List<Product> getList() {
        return this.list;
    }

    public boolean soldProduct(String chooseProd, String quantityProd) {
        Product product = findProducts(chooseProd);
        if (product.getQuantity() != 0 && product.getQuantity() >= Integer.parseInt(quantityProd) && !product.isSell()) {
            product.setSell(false);
            product.setQuantity(product.getQuantity() - Integer.parseInt(quantityProd));
            if (product.getQuantity() == 0) {
                product.setSell(true);
            }
            return true;
        }
        return false;
    }

    public boolean returnProduct(String chooseProd2, String quantityProd) {
        Product product = findProducts(chooseProd2);
        if (product.isSell()) {
            product.setQuantity(product.getQuantity() + Integer.parseInt(quantityProd));
            if (product.getQuantity() > 0) {
                product.setSell(false);
            }
            return true;
        }
        return false;
    }

    private Product findProducts(String chooseProd2) {
        for (Product prod : this.list) {
            if (prod.getCodeProduct().equals(chooseProd2)) {
                return prod;
            }
        }
        return null;
    }

    public String registrationLogin(String login) {
        return login;
    }

    public String registrationPassword(String password) {
        return password;
    }

    public String registrationName(String name) {
        return name;
    }

    public String registrationSureName(String sureName) {
        return sureName;
    }

    public String registrationAge(String age) {
        return age;
    }

    public String registrationPhoneNumber(String phoneNumber) {
        return phoneNumber;
    }

    public User createUser(String yourLogin, String yourPassword, String yourName, String yourSureName, String yourAge, String yourPhoneNumber) {
        User user = new User(yourLogin,
                yourPassword,
                yourName,
                yourSureName,
                yourAge,
                yourPhoneNumber);
        return user;
    }

    public List<User> addUserToList(User user) {
        users.add(user);
        return users;
    }

    public void listUsers() {
        for (User user : this.users) {
            System.out.println(user.getLogin() + ", " + user.getPassword() + ", " + user.getName() + ", " + user.getSureName() + ", " + user.getAge() + ", " + user.getPhoneNumber());
        }
    }

    /*public void getLoginUser(){
        for ()
    }*/

    //tu muszę wrzucić stworzoną przez siebie metodę pobierająca listy login konkretnego użytkownika i porównać go z loginem wpisanym
    //czyli prawdopodobnie zmodyfikować metodę tą powyżej listUsers, wykorzystać jej kod i dodać do niego coś jeszcze żeby dostać się do
    //konkretnego loginu konkretnego użytkownika
    public boolean logIn2(String login, String password) {
        for (User user : this.users) {
            //while (true) {
            //System.out.println("Enter the login and password:");
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Good job!!");
                break;
            } else if (user.getLogin().equals(login) && !(user.getPassword().equals(password))) {
                System.out.println("Wrong password!! Please repeat!!");
                Scanner scanner = new Scanner(System.in);
                login = scanner.nextLine();
                password = scanner.nextLine();
            } else if (!(user.getLogin().equals(login)) && user.getPassword().equals(password)) {
                System.out.println("Wrong login!! Please repeat!!");
                Scanner scanner = new Scanner(System.in);
                login = scanner.nextLine();
                password = scanner.nextLine();
            } else if (!(user.getLogin().equals(login) && !(user.getPassword().equals(password)))) {
                System.out.println("Wrong login and password. Please repeat!!");
                Scanner scanner = new Scanner(System.in);
                login = scanner.nextLine();
                password = scanner.nextLine();
            }
        }
        return true;
    }

    public boolean authenticate(String login, String password) {
        for (User currentUser : users) {
            if (currentUser.getLogin().equals(login) && currentUser.getPassword().equals(DigestUtils.md5Hex(password))) {
                return true;
            }
        }
        return false;
    }

    public boolean orCorrectLogin(String login) {
        for (User user1 : users) {
            if (user1.getLogin().equals(login)) ;
        }
        return false;
    }

    public void writeDataBaseToFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.pathToDbFile));

            for (Product product : this.list) {
                bufferedWriter.append(product.convertToDbRecord());
                bufferedWriter.newLine();
            }

            for (User user : this.users) {
                bufferedWriter.append(user.convertToDbRecord());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromFile(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.pathToDbFile));

            String record;
            while ((record = bufferedReader.readLine()) != null){
                String[] recordArray = record.split(";");
                switch (recordArray[0]){
                    case "Gitara":
                        this.list.add(new Gitara(
                                recordArray[1], Integer.parseInt(recordArray[2]),
                                recordArray[3], recordArray[4], Double.parseDouble(recordArray[5]),
                                Integer.parseInt(recordArray[6]), Boolean.parseBoolean(recordArray[7]))
                        );
                        break;
                    case "Perkusja":
                        this.list.add(new Perkusja(
                                recordArray[1], Integer.parseInt(recordArray[2]),
                                recordArray[3], recordArray[4], Double.parseDouble(recordArray[5]),
                                Boolean.parseBoolean(recordArray[6]), Integer.parseInt(recordArray[7]), Boolean.parseBoolean(recordArray[8]))
                        );
                        break;
                    case "Trąbka":
                        this.list.add(new Trabka(
                                recordArray[1], Integer.parseInt(recordArray[2]),
                                recordArray[3], recordArray[4], Double.parseDouble(recordArray[5]),
                                Integer.parseInt(recordArray[6]), Boolean.parseBoolean(recordArray[7]), Boolean.parseBoolean(recordArray[8]))
                        );
                        break;
                    case "Wzmacniacz":
                        this.list.add(new Wzmacniacz(
                                recordArray[1], Integer.parseInt(recordArray[2]),
                                recordArray[3], recordArray[4], Double.parseDouble(recordArray[5]),
                                Boolean.parseBoolean(recordArray[6]), Boolean.parseBoolean(recordArray[7]),
                                Boolean.parseBoolean(recordArray[8]), Integer.parseInt(recordArray[9]), Boolean.parseBoolean(recordArray[10]))
                        );
                        break;
                    case "User":
                        this.users.add(new User(
                                recordArray[1], recordArray[2],
                                recordArray[3], recordArray[4],
                                recordArray[5], recordArray[6])
                        );
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Database loading failed!!");
            System.exit(0);
        }
    }
}

