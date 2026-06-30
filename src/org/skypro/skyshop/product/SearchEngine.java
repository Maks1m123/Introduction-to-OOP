package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();


    public SearchEngine() {
    }

    public void add(Searchable element) {
        searchables.add(element);
    }

    public Set<Searchable> search(String query) {

        Set<Searchable> result = new TreeSet<>((o1, o2) -> {

            String name1 = o1.getName();
            String name2 = o2.getName();
            int lengthCompare = Integer.compare(name2.length(), name1.length());

            if (lengthCompare != 0) {
            return lengthCompare;
            }
            return name1.compareTo(name2);});

        for (Searchable item : searchables) {
            String searchTerm = item.getSearchTerm();

            if (searchTerm.contains(query)) {
                result.add(item);
            }
        }
        return result;
    }

    public static class BestResultNotFound extends Exception {
        public BestResultNotFound(String search) {
            super("Не нашлось подходящего резульатат " + search);
        }
    }

    public Searchable findBest(String search) throws BestResultNotFound {

        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Ничего не найдено " + search);
        }
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchables) {
            String term = item.getSearchTerm();

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
                bestMatch = item;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Не нашлось подходящего резульатат " + search);
        }
        return bestMatch;
    }

}