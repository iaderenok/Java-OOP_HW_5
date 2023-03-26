package Core.DB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Core.CustomExceptions.BadCsvContentException;
import Core.CustomExceptions.BadEmailException;
import Core.Models.Contact;
import Core.Models.Email;
import Core.Models.PhoneBook;
import Core.Models.PhoneNumber;

public class ExternalContactsCSV implements ExternalData {
    private static final String CSV_HEADER = "name;emails;phones\n";
    private static final String CSV_DELIMITER = ";";
    private static final String CANNOT_READ_FILE_MSG = "Cannot read DB file, empty phone will be used";
    private static final String EMPTY_FILE_MSG = "Empty phone book found";
    private static final String BAD_FILE_MSG = "DB file is corrupted, some contacts can be lost";
    private static final String CANNOT_WRITE_FILE_MSG = "Cannot save DB file...";

    private String dbPath;
    private PhoneBook phoneBook;

    public ExternalContactsCSV(PhoneBook phoneBook, String dbPath) {
        this.dbPath = dbPath;
        this.phoneBook = phoneBook;
    }

    @Override
    public PhoneBook load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.dbPath));
            String line = reader.readLine();
            if (hasValidHeader(line)) {
                processLines(reader);
                reader.close();
                return phoneBook;
            }
            reader.close();
            throw new BadCsvContentException();
        } catch (IOException e) {
            System.out.println(CANNOT_READ_FILE_MSG);
        } catch (NullPointerException e) {
            System.out.println(EMPTY_FILE_MSG);
        } catch (BadCsvContentException e) {
            System.out.println(BAD_FILE_MSG);
        }
        return this.phoneBook;
    }

    private boolean hasValidHeader(String line) {
        return line.equals(CSV_HEADER.trim());
    }

    private void processLines(BufferedReader reader) throws IOException, BadCsvContentException {
        String line = reader.readLine();
        boolean errors = false;
        while (line != null) {
            String[] data = line.split(CSV_DELIMITER);
            String name = data[0];
            try {
                Email email = new Email(data[1]);
                PhoneNumber phoneNumber = new PhoneNumber(data[2]);
                Contact contact = new Contact(name, email, phoneNumber);
                this.phoneBook.create(contact);
            } catch (BadEmailException | NumberFormatException e) {
                errors = true;
            }            
            line = reader.readLine();
        }
        if (errors) {
            throw new BadCsvContentException();
        }
    }

    @Override
    public void save(PhoneBook pb) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.dbPath));
            writeHeader(writer);
            writeBody(writer, pb);
            writer.close();
        } catch (IOException e) {
            System.out.println(CANNOT_WRITE_FILE_MSG);
        }
    }

    private void writeHeader(BufferedWriter writer) throws IOException {
        writer.write(CSV_HEADER);
    }

    private void writeBody(BufferedWriter writer, PhoneBook pb) throws IOException {
        for (Contact contact : pb.readAll().values()) {
            writer.write(String.format("%s;%s;%s\n", contact.getName(), contact.getEmail(), contact.getPhoneNumber()));
        }
    }
}