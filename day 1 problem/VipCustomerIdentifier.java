 import java.util.Scanner;

public class VipCustomerIdentifier {

    /**
     * Validates whether a customer ID follows the VIP naming convention ("VIP-").
     * 
     * @param customerId The customer ID string to check
     * @return "VIP Customer" if it starts with "VIP-", otherwise "Regular Customer"
     */
    public static String validateCustomerId(String customerId) {
        // Null check to prevent NullPointerException
        if (customerId == null) {
            return "Regular Customer";
        }

        // Exact rule check: must start with "VIP-"
        if (customerId.startsWith("VIP-")) {
            return "VIP Customer";
        } else {
            return "Regular Customer";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Interactive Input
        System.out.print("Enter Customer ID: ");
        String input = scanner.nextLine();

        // Execution & Direct Print
        String result = validateCustomerId(input);
        System.out.println(result);

        scanner.close();
    }
}