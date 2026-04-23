/**
 * Represents a product in the Ecommerce system.
 * Stores product details such as name, price, category, and stock.
 */
public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stockQuantity;
    private String imageUrl;

    /**
     * Default constructor.
     */
    public Product() {}

    /**
     * Creates a new Product with all details.
     *
     * @param id product ID
     * @param name product name
     * @param description product description
     * @param price product price
     * @param category product category
     * @param stockQuantity available stock quantity
     * @param imageUrl image URL of the product
     */
    public Product(Long id, String name, String description, double price,
                   String category, int stockQuantity, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
    }

    /**
     * Gets product ID.
     *
     * @return product ID
     */
    public Long getId() { return id; }

    /**
     * Sets product ID.
     *
     * @param id product ID
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Gets product name.
     *
     * @return product name
     */
    public String getName() { return name; }

    /**
     * Sets product name.
     *
     * @param name product name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets product description.
     *
     * @return product description
     */
    public String getDescription() { return description; }

    /**
     * Sets product description.
     *
     * @param description product description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets product price.
     *
     * @return product price
     */
    public double getPrice() { return price; }

    /**
     * Sets product price.
     *
     * @param price product price
     */
    public void setPrice(double price) { this.price = price; }

    /**
     * Gets product category.
     *
     * @return product category
     */
    public String getCategory() { return category; }

    /**
     * Sets product category.
     *
     * @param category product category
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * Gets stock quantity.
     *
     * @return stock quantity
     */
    public int getStockQuantity() { return stockQuantity; }

    /**
     * Sets stock quantity.
     *
     * @param stockQuantity available stock quantity
     */
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    /**
     * Gets image URL.
     *
     * @return image URL
     */
    public String getImageUrl() { return imageUrl; }

    /**
     * Sets image URL.
     *
     * @param imageUrl image URL
     */
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}