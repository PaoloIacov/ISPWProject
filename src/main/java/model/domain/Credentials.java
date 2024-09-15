package model.domain;

import java.io.Serializable;

public class Credentials implements Serializable {

    private String username;
    private String password;
    private int role; // 1 = Employee, 2 = ProjectManager, 3 = Admin

    public Credentials() {}

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
