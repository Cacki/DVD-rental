package client;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    Date birthDate;

    public Client() {};

    public Client(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "{" + firstName +
                ", lastName='" + lastName +
                ", birthDate=" + birthDate +
                '}';
    }

    public List<String> toStringList() {
        List<String> list = Arrays.asList(firstName, lastName, birthDate.toString());
        return list;
    }
}