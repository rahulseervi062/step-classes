public class InventoryParser {

    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String record = String.format("Product: %s | SKU: %s | Qty: %s",
                fields[0], fields[1], fields[2]);
        System.out.println(record);
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        // Product: Wireless Mouse | SKU: WM-2201 | Qty: 150
        parseInventoryRecord("Wireless Mouse,150");
        // Invalid Record
        parseInventoryRecord("USB Cable,UC-9,200,Extra");
        // Invalid Record
    }
}