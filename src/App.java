package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        System.out.println("Introduction to OOP");

        ProductBasket basket = new ProductBasket();

        basket.printBasket();

        Product iceCream = new Product("Мороженое", 150);
        Product tomato = new Product("Помидоры", 70);
        Product milk = new Product("Молоко", 50);
        Product bananas = new Product("Бананы", 112);
        Product bred = new Product("Хлеб", 15);
        Product butter = new Product("Масло", 95);

        basket.addProduct(iceCream);
        basket.addProduct(milk);
        basket.addProduct(tomato);
        basket.addProduct(bananas);
        basket.addProduct(bred);
        basket.addProduct(butter);


        basket.printBasket();

        System.out.println("Общая стоимость продуктов: " + basket.getTotalCost());

        System.out.println("Есть ли бананы в корзине ?" + basket.checkProduct("Бананы"));

        System.out.println("Есть хлеб в корзине ?" + basket.checkProduct("Хлеб"));

        basket.clearBasket();

        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());

        System.out.println("Есть ли молоко в пустой корзине ? " + basket.checkProduct("Молоко"));



    }
}