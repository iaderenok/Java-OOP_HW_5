package Core.Models;

import java.util.HashMap;
import java.util.Map;

public class PhoneBookMap implements PhoneBook {
    private Map<String,Contact> contacts;

    public PhoneBookMap(Map<String,Contact> contacts) {
        this.contacts = contacts;
    }

    public PhoneBookMap() {
        this.contacts = new HashMap<String, Contact>();
    }

    private Map<String,Contact> getContacts() {
        return this.contacts;
    }

    private boolean setContact(Contact contact) {
        try {
            this.contacts.put(contact.getName(), contact);
        } catch (UnsupportedOperationException | NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;        
    }
    
    @Override
    public boolean create(Contact contact) {
        return this.setContact(contact);
    }

    @Override
    public Contact read(String name) {
        if (this.getContacts().containsKey(name)) {
            return this.getContacts().get(name);
        }
        return null;
    }

    @Override
    public Map<String, Contact> readAll() {
        return this.getContacts();
    }

    @Override
    public boolean modify(Contact contact) {
        return this.setContact(contact);
    }    
    
    @Override
    public boolean delete(String name) {
        try {
            this.contacts.remove(name);
        } catch (UnsupportedOperationException | NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    @Override
    public Contact search(String name) {
        return this.getContacts().get(name);
    }
}