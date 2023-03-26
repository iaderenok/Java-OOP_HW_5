package Core.CustomExceptions;

public class BadCsvContentException extends Exception{
    public BadCsvContentException() {
        super("Invalid CSV file specified, cannot load Phonebook");
    }
}