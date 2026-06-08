package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public class SearchEngine {
    private Searchable[] searchables;
    private int count = 0;


    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable element) {

        if (count < searchables.length) {
            searchables[count] = element;
            count++;
        }

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
    public static class BestResultNotFound extends Exception{
        public BestResultNotFound(String search) {
            super("Не нашлось подходящего резульатат "+ search);
        }
    }

    public Searchable findBest(String search) throws BestResultNotFound  {

        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Ничего не найдено "+ search);
        }
        Searchable bestMatch = null;
        int maxCount = 0;

        for (int i = 0; i < count; i++) {
            String term = searchables[i].getSearchTerm();

            int currentCount = 0;
            int index = 0;
            int indexSubstring = term.indexOf(search, index);

            while (indexSubstring != -1) {
                currentCount++;
                index = indexSubstring + search.length();
                indexSubstring = term.indexOf(search, index);
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestMatch = searchables[i];
            }
            if (bestMatch == null) {
                throw new BestResultNotFound("Не нашлось подходящего резульатат " + search);
            }
        }
        return bestMatch;
    }
}