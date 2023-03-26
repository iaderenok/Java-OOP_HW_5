package Core.DB;

import Core.Models.PhoneBook;

public interface Importer {
    public PhoneBook load();
}
