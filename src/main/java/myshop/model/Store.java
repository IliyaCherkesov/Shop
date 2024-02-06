package myshop.model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private Cart cart;
    private List<Order> orders;
    private List<Product> products;

    public Store() {
        this.orders = new ArrayList<Order>();
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> listProducts() {
        return this.products;
    }

    public void addProductToCart(Product product) {
        if (this.cart == null) {
            this.cart = new Cart();
        }
        this.cart.addProduct(product);
    }

    public Product getProductById(String id) {
        return this.products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    public void order() {
        if (this.cart != null && !this.cart.isEmpty()) {

        } else {
            this.cart = null;
        }
    }

    public void removeProductFromCart(Product product) {
        this.cart.removeProduct(product);
    }

    public List<Product> listProductsInCart() {
        return this.cart.listProducts();
    }

    public boolean isSingleOrder() {
        return this.orders.size() == 1;
    }

    public void checkout() {
        Order order = new Order(this.cart);
        this.orders.add(order);
        this.cart = new Cart();
    }

    public void outListOrders() {
        for (Order order : this.orders) {
            System.out.println("Order ID: " + order.getId());
            for (Product product : order.getProducts()) {
                System.out.println("Product ID: " + product.getId());
                System.out.println("Product Name: " + product.getName());
                System.out.println("Product Price: " + product.getPrice());
            }
        }
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public Order getOrderById(String id) {
        return this.orders.stream().filter(order -> order.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Store {" +
            "\tProducts: " + products + ",\n" +
            "\tCart: " + cart + ",\n" +
            "\tOrders: " + orders + ",\n" +
        "}";
    }
}
