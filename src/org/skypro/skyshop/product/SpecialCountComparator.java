package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Comparator;

public class SpecialCountComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable firstElement, Searchable secondElement) {
        int firstLength = firstElement.getName().length();
        int secondLength = secondElement.getName().length();
        int comparisonLength = Integer.compare(secondLength, firstLength);
        if (comparisonLength != 0) {
            return comparisonLength;
        }
        return firstElement.getName().compareTo(secondElement.getName());
    }
}

