package Core.MVP;

import java.util.Collection;
import Core.Models.Contact;

public interface View {

    public void welcome();

    public void bye();

    public void showMainMenu();

    public int getCmd();

    public void invalidCmd();

    public void showChosenCmd(int cmd);

    public String[] addContactMenu();

    public String[] editContactMenu(Collection<Contact> contacts);

    public String removeContactMenu(Collection<Contact> contacts);

    public void showContact(Contact contact);

    public void showAllContacts(Collection<Contact> contacts);

    public void invalidEmail();

    public void invalidPhoneNumber();    
      
    public void noContactFound();

    public void sucessAddContact();

    public void sucessEditContact();

    public void sucessRemovedContact();

    public boolean askAddNewContact();

    public String getSearchString();

    public boolean removeContactAccept(Contact contact);
}