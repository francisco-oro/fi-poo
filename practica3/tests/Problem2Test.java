package practica3.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class Problem2Test {
    @Test
    public void testUpdateInventory_ExpiredProduct() {
        Store store = new Store();
        Product expiredProduct = new Product("Expired Product", "1234567890", 1.99, "Food", true, LocalDate.now().minusDays(1));
        store.addProduct(expiredProduct);
        store.updateInventory();
        Assertions.assertTrue(store.getProducts().contains(expiredProduct));
    }

    @Test
    public void testUpdateInventory_OneDayLeft() {
        Store store = new Store();
        Product product = new Product("Product", "1234567890", 1.99, "Food", true, LocalDate.now().plusDays(1));
        store.addProduct(product);
        store.updateInventory();
        Assertions.assertEquals(0.25 * 1.99, product.getPrice());
    }

    @Test
    public void testUpdateInventory_TwoDaysLeft() {
        Store store = new Store();
        Product product = new Product("Product", "1234567890", 1.99, "Food", true, LocalDate.now().plusDays(2));
        store.addProduct(product);
        store.updateInventory();
        Assertions.assertEquals(0.33 * 1.99, product.getPrice());
    }

    @Test
    public void testUpdateInventory_ThreeDaysLeft() {
        Store store = new Store();
        Product product = new Product("Product", "1234567890", 1.99, "Food", true, LocalDate.now().plusDays(3));
        store.addProduct(product);
        store.updateInventory();
        Assertions.assertEquals(0.5 * 1.99, product.getPrice());
    }

    @Test
    public void testUpdateInventory_NotPerishableProduct() {
        Store store = new Store();
        Product product = new Product("Product", "1234567890", 1.99, "Food", false, LocalDate.now().minusDays(1));
        store.addProduct(product);
        store.updateInventory();
        Assertions.assertFalse(store.getProducts().contains(product));
    }
}

