package Core.DB;

import Core.Models.PhoneBook;

public interface Exporter {

    public void save(PhoneBook pb);
}