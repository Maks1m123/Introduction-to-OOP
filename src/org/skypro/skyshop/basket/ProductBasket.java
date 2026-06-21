package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String,List<Product>> products = new HashMap<>();


    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (List<Product> productList: products.values()) {
            for (Product product: productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCount = 0;

        for (List<Product> productList: products.values()) {
            for (Product product: productList) {
            System.out.println(product);

                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public void clearBasket() {
        products.clear();
    }

    public boolean checkProduct(String name) {

        return products.containsKey(name);
    }

    public List<Product> removeByName(String name) {

        List<Product> removeList = products.remove(name);
        if (removeList == null) {
            return new ArrayList<>();
        }
        return removeList;
    }
}

