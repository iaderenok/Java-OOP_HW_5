package Core.Models;

public class PhoneNumber {
    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        if (isValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    private static boolean isValid(String phoneNumber) throws NumberFormatException{
        if (phoneNumber.charAt(0) == '+') {
            Integer.parseInt(phoneNumber.substring(1));
            return true;
        } else if (phoneNumber.charAt(0) == '-') {
            throw new NumberFormatException();
        }
        Integer.parseInt(phoneNumber);
        return true;
    }

    @Override
    public String toString() {
        return this.getPhoneNumber();
    }
}