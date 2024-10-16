package com.example.ishoppinglistdgp.repository;

import com.example.ishoppinglistdgp.models.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    //Creo una lista de productos
    private static List<Product> products = new ArrayList<>();
    //Creo una lista de productos pendientes
    private static List<Product> pendingProducts = new ArrayList<>();

    //Creo una lista de productos no pendientes
    private static List<Product> notPendingProducts = new ArrayList<>();

    //Creo una lista de productos sin lactosa
    private static List<Product> sinLactosaProducts = new ArrayList<>();

    //Creo una lista de productos sin gluten
    private static List<Product> sinGlutenProducts = new ArrayList<>();

    static {
        //Agrego productos a la lista
        products.add(new Product(1, "Leche", "2 litros", false, false, false ));
        products.add(new Product(2, "Pan", "Integral", false, false, false));
        products.add(new Product(3, "Huevos", "Docena", false, false, false));
        products.add(new Product(4, "Azucar", "1 kilo", false, false, false));
        products.add(new Product(5, "Cafe", "1 kilo", false, false, false));
        products.add(new Product(6, "Arroz", "1 kilo", false, false, false));
        products.add(new Product(7, "Fideos", "1 kilo", false, false, false));
        products.add(new Product(8, "Aceite", "1 litro", false, false, false));
        products.add(new Product(9, "Sal", "1 kilo", false, false, true));
        products.add(new Product(10, "Papas", "1 kilo", false, false, true));
        products.add(new Product(11, "Tomates", "1 kilo", false, true, false));
        products.add(new Product(12, "Cebollas", "1 kilo", true, true, false));
        products.add(new Product(13, "Zanahorias", "1 kilo", true, true, true));
        products.add(new Product(14, "Bananas", "1 kilo", true, true, true));
        products.add(new Product(15, "Manzanas", "1 kilo", true, true, true));
        products.add(new Product(16, "Naranjas", "1 kilo", true, true, true));
        products.add(new Product(17, "Mandarinas", "1 kilo", true, true, true));
        products.add(new Product(18, "Limon", "1 kilo", true, true, true));
        products.add(new Product(19, "Lechuga", "1 unidad", true, true, true));
        products.add(new Product(20, "Coca Cola", "2 litros", true, true, true));

    }

    //Metodo para obtener la lista de productos
    public static List<Product> getProducts() {
        return products;
    }

    //Metodo para agregar un producto a la lista
    public static void addProduct(Product product) {
        products.add(product);
    }

    //Metodo para obtener un producto por su id
    public static Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    //Metodo para obtener la lista de los productos pendientes
    public static List<Product> getPendingProductos() {
        return pendingProducts;
    }

    //Metodo para llenar el array de productos pendientes
    public static void fillPendingProducts() {
        pendingProducts.clear();
        for (Product product : products) {
            //Si el status es true
            if (product.isStatus()) {
                pendingProducts.add(product);
            }

        }
    }

    //Metodo para obtener la lista de los productos no pendientes
    public static List<Product> getNotPendingProducts() {
        return notPendingProducts;
    }

    //Metodo para llenar la lista de productos no pendientes
    public static void fillNotPendingProducts() {
        for (Product product : products) {
            //Si el status es false
            if (!product.isStatus()) {
                notPendingProducts.add(product);
            }

        }
    }

    //Metodo para llenar la lista de productos sin lactosa
    public static List<Product> sinLactosaProducts() {
        for (Product product : products) {
            //Si lactosa es false
            if (!product.isLactosa()) {
                sinLactosaProducts.add(product);
            }

        }
        return null;
    }

    //Metodo para llenar la lista de productos sin gluten
    public static List<Product> sinGlutenProducts() {
        for (Product product : products) {
            //Si gluten es false
            if (!product.isGluten()) {
                sinGlutenProducts.add(product);
            }

        }
        return null;
    }


}

