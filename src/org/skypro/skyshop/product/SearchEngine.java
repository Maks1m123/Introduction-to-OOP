package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public class SearchEngine {
    private Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable element) {

        searchables[count] = element;
        count++;
    }

    public Searchable[] search(String query) {


        Searchable[] result = new Searchable[5];
        int resultsCount = 0;

        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null) {
                String term = searchables[i].getSearchTerm();
                if (term.contains(query)) {
                    result[resultsCount] = searchables[i];
                    resultsCount++;
                }
                if (resultsCount == 5) {
                    break;
                }
            }
        }
        return result;
    }
}