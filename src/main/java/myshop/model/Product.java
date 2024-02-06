package myshop.model;

import myshop.utils.UniqueId;

public class Product {
    private String id;
    private String name;
    private float price;

    public Product(String name, float price) {
        this.id = UniqueId.generateUniqueId();
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() { return name; }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product {" +
            "\tId: " + id + ",\n" +
            "\tname: " + name + ",\n" +
            "\tprice: " + price + ",\n" +
        "}";
    }
}
