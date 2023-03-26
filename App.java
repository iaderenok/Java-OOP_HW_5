package UI;

import java.util.Scanner;
import Core.DB.ExternalContactsCSV;
import Core.DB.ExternalData;
import Core.MVP.Model;
import Core.MVP.Presenter;
import Core.MVP.View;
import Core.Models.PhoneBook;
import Core.Models.PhoneBookMap;

public class App {
    public static void Run() {
        Scanner scan = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBookMap();
        ExternalData db = new ExternalContactsCSV(phoneBook, "db.csv");
        Model model = new Model(phoneBook, db);
        View view = new ConsoleUI(scan);
        Presenter presenter = new Presenter(model, view);

        presenter.load();
        presenter.mainMenu();
        presenter.save();

        scan.close();
    }
}