package org.example;

import java.util.LinkedHashSet;
import java.util.Set;

public class Player {

    Set<Integer> playerHand = new LinkedHashSet<>();
    int score = 0;

    public void addToPlayerHand(int cardInt) {
        playerHand.add(cardInt);
    }

    public void removeCardFromHand(int cardInt) {
        playerHand.remove(cardInt);
    }

    public Set<Integer> getHand() {
        return playerHand;
    }

    public int cardsInHandCount() {
        return playerHand.size();
    }

    public void addToScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
