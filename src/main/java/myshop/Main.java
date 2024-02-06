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

