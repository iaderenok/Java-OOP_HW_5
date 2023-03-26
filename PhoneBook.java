package Core.Models;

import java.util.Map;

public interface PhoneBook {
    public boolean create(Contact contact);

    public Contact read(String name);

    public Map<String,Contact> readAll();

    public boolean modify(Contact contact);

    public boolean delete(String name);

    public Contact search(String name);
}
