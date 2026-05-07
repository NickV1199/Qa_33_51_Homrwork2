package models;

public class User {
    private String email;
    private String password;
    private String name;
    private String lastName;



    public User setEmail(String email) {
        this.email = email;
        return this;

    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }


    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
