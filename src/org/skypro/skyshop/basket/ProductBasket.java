package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String,List<Product>> products = new HashMap<>();


    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        return products.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
    }
    private long getSpecialCount(){
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        products.values()
                .stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + getSpecialCount());
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

