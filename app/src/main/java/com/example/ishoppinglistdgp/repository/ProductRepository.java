package com.example.ishoppinglistdgp.repository;

import com.example.ishoppinglistdgp.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static List<Product> products = new ArrayList<>();
    private static List<Product> pendingProducts = new ArrayList<>();

    static {
        // Datos precargados de ejemplo
        products.add(new Product(1, "Leche", "2 litros", false));
        products.add(new Product(2, "Pan", "Integral", false));
        products.add(new Product(3, "Huevos", "Docena", false));
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static void updateProducto(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return;
            }
        }
    }

    public static Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static List<Product> getPendingProductos() {
        return pendingProducts;
    }

    public static void addPendingProducto(Product product) {
        if (!pendingProducts.contains(product)) {
            pendingProducts.add(product);
        }
    }

}