/**
 * Represents a piece of clothing with attributes such as name, size, color, price, and brand.
 */
class Clothing {
    String name;  // Name of the clothing item
    String size;  // Size of the clothing item
    String color; // Color of the clothing item
    double price; // Price of the clothing item
    String brand; // Brand of the clothing item

    /**
     * Constructs a new Clothing object with the specified attributes.
     *
     * @param name  The name of the clothing item.
     * @param size  The size of the clothing item.
     * @param color The color of the clothing item.
     * @param price The price of the clothing item.
     * @param brand The brand of the clothing item.
     */
    public Clothing(String name, String size, String color, double price, String brand) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    /**
     * Determines whether this Clothing object is equal to another object.
     *
     * @param other The object to compare with.
     * @return True if the objects are equal; false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Clothing clothing = (Clothing) other;
        return name.equals(clothing.name) && size.equals(clothing.size)
                && color.equals(clothing.color) && price == clothing.price
                && brand.equals(clothing.brand);
    }

    /**
     * Outputs a string representation of the Clothing object.
     *
     * @return A string containing the attributes of the Clothing object.
     */
    public String output() {
        return name + " " + size + " " + color + " " + price + " " + brand;
    }
}