package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    Player player1;
    Player player2;

    public static void main(String[] args) {
        Main main = new Main();
        main.deck().entrySet().stream()
                .forEach(s -> System.out.println(s.getKey() + " is " + s.getValue().getCardAndSuitString()));
        main.dealCards();
        main.playWar();
    }

    Map<Integer,Acard> deck() {
        Map<Integer, Acard> deck = new HashMap<>();
        int key = 0;
        for(Suit suit : Suit.values()) {
            for (Card card : Card.values()) {
                deck.put(key++, new Acard(suit, card));
            }
        }
        return deck;
    }

    void dealCards() {
        List<Integer> deck52 = IntStream.rangeClosed(0, 51).boxed().collect(Collectors.toList());
        System.out.println("Cards in deck: " + deck52.size());
        player1 = new Player();
        player2 = new Player();
        Random random = new Random();
        int max = 52;
        while(player1.cardsInHandCount() < 26) {
            int rand = random.nextInt(max);
            if (deck52.contains(rand)) {
                player1.addToPlayerHand(rand);
                deck52.remove(Integer.valueOf(rand));
            }

        }
        while(player2.cardsInHandCount() < 26) {
            int rand = random.nextInt(max);
            if (deck52.contains(rand)) {
                player2.addToPlayerHand(rand);
                deck52.remove(Integer.valueOf(rand));
            }

        }
        System.out.println(player1.getHand() + " - " +  player1.cardsInHandCount());
        System.out.println(player2.getHand()+ " - " +  player2.cardsInHandCount());

    }

    void playWar() {
        Map<Integer, Acard> deck = deck();

        Iterator<Integer> iter1 = player1.getHand().iterator();
        Iterator<Integer> iter2 = player2.getHand().iterator();

        while(iter1 !=null && iter1.hasNext() && iter2 !=null && iter2.hasNext()) {
            int next1 = iter1.next();
            int next2 = iter2.next();
            Acard aCard1 = deck.get(next1);
            Acard aCard2 = deck.get(next2);

            if (compareTwoCards(aCard1, aCard2)) {
                System.out.println("Player 1 wins - " + aCard1.getCardAndSuitString() + " beats " + aCard2.getCardAndSuitString());
                player1.addToScore();
            } else {
                System.out.println("Player 2 wins - " + aCard2.getCardAndSuitString() + " beats " + aCard1.getCardAndSuitString());
                player2.addToScore();
            }

        }
        System.out.println("Score: ");
        System.out.println("player1 " + player1.getScore());
        System.out.println("player2 " + player2.getScore());

    }

    // return true if aCard1 beats aCard2
    // if equal, suit is tiebreaker, Spade > Heart > Diamond > Club
    public static boolean compareTwoCards(Acard aCard1, Acard aCard2) {
        boolean result = false;
        if(aCard1.getCard().getRank() > aCard2.getCard().getRank()) {
            result = true;
        } else if(aCard1.getCard().getRank() == aCard2.getCard().getRank()
                && aCard1.getSuit().getSuitRank() > aCard2.getSuit().getSuitRank()) {
            result = true;
        }
        return result;
    }
}
