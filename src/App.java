package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

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

        Article article1 = new Article("Название","Текст");
        Article article2 = new Article("Название2","Текст2");

        SearchEngine searchEngine = new SearchEngine(7);

        searchEngine.add(iceCream);
        searchEngine.add(milk);
        searchEngine.add(bananas);
        searchEngine.add(book);
        searchEngine.add(butter);
        searchEngine.add(article2);
        searchEngine.add(article1);

        Searchable[] results1 = searchEngine.search("Молоко");
        Searchable[] results2 = searchEngine.search("Название");

        System.out.println("Результат поиска 'Молоко' ");
        for (Searchable item : results1){
            if (item != null){
                System.out.println(item.getStringRepresentation());
            }
        }
        System.out.println("Результат поиска 'Название' ");
        for (Searchable item : results2){
            if (item != null){
                System.out.println(item.getStringRepresentation());
            }
        }












    }
}