package Core.MVP;

import Core.DB.ExternalData;
import Core.Models.PhoneBook;

public class Model {
    private PhoneBook phoneBook;
    private ExternalData db;

    public Model(PhoneBook phoneBook, ExternalData db) {
        this.phoneBook = phoneBook;
        this.db = db;
    }

    public Model(ExternalData db) {
        this.db = db;
        this.db.load();
    } 

    public PhoneBook getPhoneBook() {
        return this.phoneBook;
    }

    public ExternalData getDb() {
        return this.db;
    }

    public void load() {
        this.phoneBook = db.load();
    }

    public void save() {
        db.save(this.phoneBook);
    }
}
