package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> elements;


    public SearchEngine() { this.elements = new HashSet<>(); }


    public void add(Searchable element) {
        if(element == null){
            return;
        }
        elements.add(element);
    }

    public Set<Searchable> search(String message) {
        return elements.stream()
                .filter(element -> element != null &&
                        element.getSearchTerm() != null &&
                        element.getSearchTerm().contains(message))
        .collect(Collectors.toCollection(() -> new TreeSet<>(new SpecialCountComparator())));
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

        for (Searchable item : elements) {
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