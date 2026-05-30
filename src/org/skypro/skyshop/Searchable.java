package org.skypro.skyshop;

public interface Searchable {

    String getSearchTerm();
    String getType();
    String getName();

default String getStingRepresentation(){
    return getName() + " -" + getType();
}

}
