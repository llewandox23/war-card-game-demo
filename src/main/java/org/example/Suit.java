package org.example;

public enum Suit {
    SPADE(4),
    HEART(3),
    DIAMOND(2),
    CLUB(1);

    private int suitRank;

    Suit(int suitRank) {
        this.suitRank = suitRank;
    }

    public int getSuitRank() {
        return suitRank;
    }
}
