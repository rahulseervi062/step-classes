public class IsbnValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed;
        }

        String publisherPart = trimmed.substring(0, 3);
        String remainder = trimmed.substring(3);

        return publisherPart.toUpperCase() + remainder;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        boolean publisherOk = true;
        for (int i = 0; i < publisher.length(); i++) {
            if (!Character.isLetter(publisher.charAt(i))) {
                publisherOk = false;
                break;
            }
        }
        if (!publisherOk) {
            return "Invalid: publisher code must be 3 letters";
        }

        String digitsPart = year + catalog;
        boolean digitsOk = true;
        for (int i = 0; i < digitsPart.length(); i++) {
            if (!Character.isDigit(digitsPart.charAt(i))) {
                digitsOk = false;
                break;
            }
        }
        if (!digitsOk) {
            return "Invalid: remaining 10 characters must be digits";
        }

        StringBuilder output = new StringBuilder();
        output.append("[").append(publisher).append("]")
              .append(" YEAR: ").append(year)
              .append(" | CATALOG: ").append(catalog);

        return output.toString();
    }

    public static void main(String[] args) {
        String c1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(c1));
        // [PEN] YEAR: 2026 | CATALOG: 004251

        String c2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(c2));
        // Invalid: publisher code must be 3 letters

        String c3 = normalizeCode("ABC20AB004251");
        System.out.println(validateAndFormat(c3));
        // Invalid: remaining 10 characters must be digits
    }
}