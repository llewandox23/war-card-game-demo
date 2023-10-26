package org.example;

public class Acard {

    private Suit suit;
    private Card card;


    public Acard() {
    }

    public Acard(Suit suit, Card card) {
        this.suit = suit;
        this.card = card;
    }

    public Suit getSuit() {
        return suit;
    }

    public Card getCard() {
        return card;
    }

    public String getCardAndSuitString() {
        return card.name() + " of " + suit.name() + "S";
    }

}
