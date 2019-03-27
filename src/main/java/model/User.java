package model;

public class User {
    private String emailAdress;
    private String firstName;
    private String lastName;

    public User(String emailAdress, String firstName, String lastName) {
        this.emailAdress = emailAdress;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User (String emailAdress){
        this.emailAdress = emailAdress;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
