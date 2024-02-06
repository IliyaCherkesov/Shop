package myshop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> products = new ArrayList<Product>();

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public List<Product> listProducts() {
        return this.products;
    }

    public boolean isEmpty() {
        return this.products.isEmpty();
    }
}
