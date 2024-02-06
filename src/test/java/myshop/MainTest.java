
package myshop;

import myshop.model.*;
import myshop.utils.ConsoleInputMock;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    private Store store;

    Product product1 = new Product("The Lord of the Rings", 10.0f);
    Product product2 = new Product("The Hobbit", 5.0f);
    Product product3 = new Product("The Silmarillion", 7.0f);
    Product product4 = new Product("IBM PC", 1000.0f);
    Product product5 = new Product("Apple Mac", 2000.0f);
    Product product6 = new Product("Dell XPS", 1500.0f);
    Product product7 = new Product("Nike Air", 100.0f);
    Product product8 = new Product("Adidas Superstar", 80.0f);
    Product product9 = new Product("Puma Suede", 90.0f);

    @BeforeEach
    void setUp() {
        store = new Store();
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        store.addProduct(product4);
        store.addProduct(product5);
        store.addProduct(product6);
        store.addProduct(product7);
        store.addProduct(product8);
        store.addProduct(product9);
    }

    @Test
    void checkStoreContentTest() {
        assertEquals(store.listProducts().size(), 9);
    }

    @Test
    void addNewProductTest() {
        store.addProduct(new Product("New Product", 100.0f));
        assertEquals(store.listProducts().size(), 10);
    }

    @Test
    void addProductToCartTest() {
        store.addProductToCart(store.getProductById(product1.getId()));
        store.addProductToCart(store.getProductById(product3.getId()));
        store.addProductToCart(store.getProductById(product7.getId()));
        assertEquals(store.listProductsInCart().size(), 3);
    }

    @Test
    void removeProductFromCartTest() {
        store.addProductToCart(store.getProductById(product1.getId()));
        store.addProductToCart(store.getProductById(product3.getId()));
        store.addProductToCart(store.getProductById(product7.getId()));
        store.removeProductFromCart(store.getProductById(product3.getId()));
        assertEquals(store.listProductsInCart().size(), 2);
    }

    @Test
    void checkoutTest() {
        store.addProductToCart(store.getProductById(product1.getId()));
        store.addProductToCart(store.getProductById(product3.getId()));
        store.addProductToCart(store.getProductById(product7.getId()));
        store.checkout();
        assertEquals(store.listProductsInCart().size(), 0);
        assertEquals(store.isSingleOrder(), true);
    }

    @Test
    void listOrdersTest() {
        store.addProductToCart(store.getProductById(product1.getId()));
        store.addProductToCart(store.getProductById(product3.getId()));
        store.addProductToCart(store.getProductById(product7.getId()));
        store.checkout();
        store.addProductToCart(store.getProductById(product2.getId()));
        store.addProductToCart(store.getProductById(product4.getId()));
        store.addProductToCart(store.getProductById(product8.getId()));
        store.checkout();
        store.outListOrders();
        assertEquals(store.isSingleOrder(), false);
        assertEquals(store.getOrders().size(), 2);
    }

    @Test
    void orderStatusTest() {
        store.addProductToCart(store.getProductById(product1.getId()));
        store.addProductToCart(store.getProductById(product3.getId()));
        store.addProductToCart(store.getProductById(product7.getId()));
        store.checkout();
        Order order = store.getOrders().get(0);
        assertEquals(order.getStatus(), OrderStatus.CREATED);
    }

}
