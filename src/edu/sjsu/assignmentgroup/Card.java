package edu.sjsu.assignmentgroup;

public class Card {
    private String suitRank;
    private String description;
    private static final String UNKNOWN = "Unknown";

    public Card(String suitRank) {
        //Assume input is always valid
        if (suitRank.length() > 3 || suitRank.length() < 2) {
            this.suitRank = UNKNOWN;
        } else {
            this.suitRank = suitRank;
        }
        setDescription();
    }

    private void setDescription() {
        if(suitRank.equals(UNKNOWN)) {
            description = suitRank;
            return;
        }
        //Get suit
        String suit = getSuit();
        if(suit.equals(UNKNOWN)) {
            description = suit;
            return;
        }
        //Get rank
        String rank = getRank();
        if(rank.equals(UNKNOWN)) {
            description = rank;
            return;
        }

        //Return results
        description = rank + " of " + suit;
    }

    public String getDescription() {
        return description;
    }

    private String getSuit() {
        //Last digit is always suit, so compare here and return in words
        String suit = suitRank.substring(suitRank.length()-1);
        return switch (suit) {
            case "D" -> "Diamonds";
            case "H" -> "Hearts";
            case "S" -> "Spades";
            case "C" -> "Clubs";
            default -> UNKNOWN;
        };
    }

    private String getRank() {
        //First digit or two is rank, so check validity and return in words
        String rank = suitRank.substring(0,suitRank.length()-1);
        return switch (rank) {
            case "A" -> "Ace";
            case "1" -> "One";
            case "2" -> "Two";
            case "3" -> "Three";
            case "4" -> "Four";
            case "5" -> "Five";
            case "6" -> "Six";
            case "7" -> "Seven";
            case "8" -> "Eight";
            case "9" -> "Nine";
            case "10" -> "Ten";
            case "J" -> "Jack";
            case "Q" -> "Queen";
            case "K" -> "King";
            default -> UNKNOWN;
        };
    }
}
