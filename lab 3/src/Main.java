import java.util.Arrays;

/**
 * Demonstrates sorting and searching an array of Clothing objects.
 */
public class Main {

    /**
     * Main method that serves as the entry point of the program.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Initialize an array of Clothing objects
        Clothing[] clothes = {
                new Clothing("shirt", "M", "blue", 25.99, "Nike"),
                new Clothing("pants", "L", "black", 45.50, "Puma"),
                new Clothing("Jacket", "XL", "green", 89.99, "Adidas"),
                new Clothing("hat", "S", "red", 45.50, "Louis Vuitton"),
                new Clothing("shoes", "M", "white", 75.00, "Zara")
        };

        // Define the primary and secondary sorting fields
        String primarySortField = "price"; // First field for sorting
        String secondarySortField = "brand"; // Second field for sorting

        // Sort the array based on the specified fields
        Arrays.sort(clothes, (c1, c2) -> {
            int primaryComparison = compareFields(c1, c2, primarySortField);
            if (primaryComparison != 0) {
                return primaryComparison;
            }
            int secondaryComparison = compareFields(c1, c2, secondarySortField);
            return -secondaryComparison; // Reverse order for secondary comparison
        });

        // Output the sorted array
        for (Clothing c : clothes) {
            System.out.println(c.output());
        }

        // Define the target Clothing object to search for
        Clothing target = new Clothing("shirt", "M", "blue", 25.99, "Nike");

        // Search for the target object in the array
        boolean f = false;
        int index = 0;
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i].equals(target)) {
                f = true;
                index = i;
            }
        }

        // Output the search result
        if (f) {
            System.out.println("Знайдено об'єкт: " + clothes[index].output());
        } else {
            System.out.println("Об'єкт не знайдено.");
        }
    }

    /**
     * Compares two Clothing objects based on the specified field.
     *
     * @param c1    The first Clothing object.
     * @param c2    The second Clothing object.
     * @param field The field used for comparison. Supported fields are:
     *              "price", "brand", "name", "size", "color".
     * @return An integer representing the comparison result:
     *         a negative value if c1 < c2, zero if c1 == c2, and a positive value if c1 > c2.
     * @throws IllegalArgumentException If the specified field is not recognized.
     */
    public static int compareFields(Clothing c1, Clothing c2, String field) {
        switch (field) {
            case "price":
                return Double.compare(c1.price, c2.price);
            case "brand":
                return c1.brand.compareTo(c2.brand);
            case "name":
                return c1.name.compareTo(c2.name);
            case "size":
                return c1.size.compareTo(c2.size);
            case "color":
                return c1.color.compareTo(c2.color);
            default:
                throw new IllegalArgumentException("Невідоме поле для сортування: " + field);
        }
    }
}