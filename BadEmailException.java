package Core.CustomExceptions;

public class BadEmailException extends Exception{
    public BadEmailException() {
        super("You entered bad email address");
    }
}
