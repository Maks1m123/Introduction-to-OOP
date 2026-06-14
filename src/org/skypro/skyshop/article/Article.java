package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {

    private final String title;
    private final String text;

    public Article(String titleArticle, String textArticle) {
        this.title = titleArticle;
        this.text = textArticle;
    }

    @Override
    public String getSearchTerm() {
        return title + "\n" + text;
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Название статьи "+this.title+"\nТекст статьи "+ this.text;
    }



}
