package Core.Models;

public class Contact implements Comparable<Contact> {
    private String name;
    private Email email;
    private PhoneNumber phoneNumber;

    public Contact(String name, Email email, PhoneNumber phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public Email getEmail() {
        return this.email;
    }

    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s; Email: %s; Phone: %s\n", this.getName(), this.getEmail(),
                this.getPhoneNumber());
    }

    @Override
    public int compareTo(Contact anotherContact) {
        return this.getName().compareTo(anotherContact.getName());
        
    }
}