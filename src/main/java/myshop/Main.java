package myshop;

import myshop.model.*;
import java.util.Scanner;

public class Main
{

    public static Store store = new Store();

    private static void initializeStore() {
        store.addProduct(new Product("The Lord of the Rings", 10.0f));
        store.addProduct(new Product("The Hobbit", 5.0f));
        store.addProduct(new Product("The Silmarillion", 7.0f));
        store.addProduct(new Product("IBM PC", 1000.0f));
        store.addProduct(new Product("Apple Mac", 2000.0f));
        store.addProduct(new Product("Dell XPS", 1500.0f));
        store.addProduct(new Product("Nike Air", 100.0f));
        store.addProduct(new Product("Adidas Superstar", 80.0f));
        store.addProduct(new Product("Puma Suede", 90.0f));
    }

    public static void main(String[] args)
    {
        initializeStore();
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            boolean doBreak = false;
            printMenu();
            String str = scanner.nextLine();
            switch(str.trim()) {
                case "1":
                    System.out.println("List of the available products");
                    for (Product product : store.listProducts()) {
                        System.out.println(product);
                    }
                    break;
                case "2":
                    System.out.println("Add product to cart");
                    System.out.println("Please enter product ID:");
                    String productId = scanner.nextLine();
                    Product product = store.getProductById(productId);
                    if (product != null) {
                        store.addProductToCart(product);
                        System.out.println("Product \"" + product.getName() + "\" added to cart");
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                case "3":
                    System.out.println("Remove product from cart");
                    System.out.println("Please enter product ID:");
                    productId = scanner.nextLine();
                    product = store.getProductById(productId);
                    if (product != null) {
                        store.removeProductFromCart(product);
                        System.out.println("Product \"" + product.getName() + "\" removed from cart");
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                case "4":
                    System.out.println("Checkout");
                    store.checkout();
                    System.out.println("Checkout completed");
                    break;
                case "5":
                    System.out.println("List orders");
                    store.outListOrders();
                    break;
                case "6":
                    if (store.isSingleOrder()) {
                        Order order = store.getOrders().get(0);
                        System.out.println("Order ID: " + order.getId());
                        System.out.println("Order status: " + order.getStatus().toString());
                        break;
                    } else {
                        System.out.println("Get Order status");
                        System.out.println("Please enter order ID:");
                        String orderId = scanner.nextLine();
                        Order order = store.getOrderById(orderId);
                        if (order != null) {
                            System.out.println("Order ID: " + order.getId());
                            System.out.println("Order status: " + order.getStatus());
                        } else {
                            System.out.println("Order not found");
                        }
                    }
                    break;
                default:
                    doBreak = true;
                    break;
            }
            if (doBreak) {
                break;
            }
        }
        scanner.close();
    }

    private static void printMenu()
    {
        System.out.println("Welcome to OUR Store");
        System.out.println("Please select an option:");
        System.out.println("1. List of the available products");
        System.out.println("2. Add product to cart");
        System.out.println("3. Remove product from cart");
        System.out.println("4. Checkout");
        System.out.println("5. List orders");
        System.out.println("6. Get Order status");
        System.out.println("7. Exit");
    }

}

