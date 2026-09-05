 public class PinValidator {

    static void checkPinLength(String pin) {
        int len = pin.length();
        String message = (len == 4) ? "PIN length OK." 
                                     : "Invalid PIN — must be exactly 4 digits.";
        System.out.println(message);
    }

    public static void main(String[] args) {
        checkPinLength("482");    // Invalid PIN — must be exactly 4 digits.
        checkPinLength("4820");   // PIN length OK.
        checkPinLength("58231");  // Invalid PIN — must be exactly 4 digits.
    }
}