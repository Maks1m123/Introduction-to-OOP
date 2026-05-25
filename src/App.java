package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        System.out.println("Introduction to OOP");

        ProductBasket basket = new ProductBasket();

        basket.printBasket();

        Product iceCream = new SimpleProduct("Мороженое", 150);
        Product tomato = new SimpleProduct("Помидоры", 70);

        Product milk = new DiscountedProduct("Молоко", 50,10);
        Product bananas = new DiscountedProduct("Бананы", 112,25);
        Product bred = new DiscountedProduct("Хлеб", 100,30);

        Product butter = new FixPriceProduct("Журнал");
        Product book = new FixPriceProduct("Книга");

        basket.addProduct(iceCream);
        basket.addProduct(milk);
        basket.addProduct(tomato);
        basket.addProduct(bananas);
        basket.addProduct(bred);
        basket.addProduct(butter);
        basket.addProduct(book);


        basket.printBasket();

        System.out.println("Общая стоимость продуктов: " + basket.getTotalCost());

        System.out.println("Есть ли бананы в корзине ?" + basket.checkProduct("Бананы"));

        System.out.println("Есть хлеб в корзине ?" + basket.checkProduct("Хлеб"));

        basket.clearBasket();

        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());

        System.out.println("Есть ли молоко в пустой корзине ? " + basket.checkProduct("Молоко"));




    }
}