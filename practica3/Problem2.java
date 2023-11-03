package practica3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Problem2
 */
class Problem2 {
    static class Product {
    private String name;
    private String barcode;
    private double price;
    private String typeOfProduct;
    private boolean perishable;
    private LocalDate expirationDate;

    public Product(String name, String barcode, double price, String typeOfProduct, boolean perishable, LocalDate expirationDate) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.typeOfProduct = typeOfProduct;
        this.perishable = perishable;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

    public String getTypeOfProduct(){
        return typeOfProduct; 
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}

static class Store {
    private List<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName());
            System.out.println("Barcode: " + product.getBarcode());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Type: " + product.getTypeOfProduct());
            System.out.println("Perishable: " + (product.isPerishable() ? "Yes" : "No"));
            System.out.println("Expiration Date: " + product.getExpirationDate());
            System.out.println("------------------------");
        }
    }

    public void updateInventory() {
        LocalDate currentDate = LocalDate.now();
        for (Product product : products) {
            if (product.isPerishable() && product.getExpirationDate().isBefore(currentDate)) {
                System.out.println("Product '" + product.getName() + "' has expired. Please update the inventory.");
            } else if (product.isPerishable()) {
                long daysLeft = currentDate.until(product.getExpirationDate()).getDays();
                if (daysLeft == 1) {
                    double newPrice = product.getPrice() * 0.25;
                    product.setPrice(newPrice);
                    System.out.println("Product '" + product.getName() + "' will expire in 1 day. Price reduced to: $" + newPrice);
                } else if (daysLeft == 2) {
                    double newPrice = product.getPrice() * 0.33;
                    product.setPrice(newPrice);
                    System.out.println("Product '" + product.getName() + "' will expire in 2 days. Price reduced to: $" + newPrice);
                } else if (daysLeft == 3) {
                    double newPrice = product.getPrice() * 0.5;
                    product.setPrice(newPrice);
                    System.out.println("Product '" + product.getName() + "' will expire in 3 days. Price reduced to: $" + newPrice);
                }
            }
        }
    }
}

public class Main {    
}
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        // Adding initial products
        store.addProduct(new Product("Apple", "1234567890", 1.99, "Fruit", true, LocalDate.of(2022, 12, 31)));
        store.addProduct(new Product("Milk", "0987654321", 2.99, "Beverage", true, LocalDate.of(2022, 10, 15)));
        store.addProduct(new Product("Bread", "5678901234", 0.99, "Bakery", true, LocalDate.of(2022, 11, 30)));
        store.addProduct(new Product("Cheese", "4321098765", 3.99, "Dairy", true, LocalDate.of(2022, 11, 20)));
        store.addProduct(new Product("Cereal", "9876543210", 4.99, "Breakfast", false, null));

    
        // Adding initial products
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter details for Product " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Barcode: ");
            String barcode = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Type of Product: ");
            String typeOfProduct = scanner.nextLine();
            System.out.print("Perishable (true/false): ");
            boolean perishable = scanner.nextBoolean();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Expiration Date (yyyy-mm-dd): ");
            LocalDate expirationDate = LocalDate.parse(scanner.nextLine());
    
            store.addProduct(new Product(name, barcode, price, typeOfProduct, perishable, expirationDate));
        }
    
        // Displaying products
        store.showProducts();
    
        // Updating inventory
        store.updateInventory();
    
        scanner.close();
    }
}