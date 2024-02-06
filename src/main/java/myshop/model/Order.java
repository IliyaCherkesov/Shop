package myshop.model;

import java.util.ArrayList;
import java.util.List;

import myshop.utils.UniqueId;

public class Order {
    private String id = UniqueId.generateUniqueId();
    private List<Product> products = new ArrayList<Product>();
    private OrderStatus status = OrderStatus.CREATED;

    public Order(Cart cart) {
        cart.listProducts().forEach(product -> products.add(product));
    }

    public String getId() {
        return id;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
