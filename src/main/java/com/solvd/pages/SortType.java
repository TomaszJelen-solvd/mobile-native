package com.solvd.pages;

public enum SortType {
    PRICE_HIGH_TO_LOW(false),
    PRICE_LOW_TO_HIGH(true);
    boolean ascending;

    SortType(boolean ascending) {
        this.ascending = ascending;
    }

    public boolean isAscending() {
        return ascending;
    }
}
