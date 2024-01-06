public class Product {
    private final int id;
    private final String name;
    private final double price;

    public Product(int id, String name, double price) {
        if (id <= 0) {
            throw new IllegalArgumentException("Product ID should be positive");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Product price should not be negative");
        }

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Product product, int id) {
        this(id, product.name, product.price);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Product name cannot be null");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Product price should not be negative");
        }
        this.price = price;
    }
}
