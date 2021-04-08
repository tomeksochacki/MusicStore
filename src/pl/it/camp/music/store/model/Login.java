package pl.it.camp.music.store.model;

public class Login {
    private final String userName = "user";
    private final String password = "user";

    public Login() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean logIn(String userName, String password) {
        if (this.userName.equals(userName) && this.password.equals(password)) {
            return true;
        }
        return false;
    }
}
