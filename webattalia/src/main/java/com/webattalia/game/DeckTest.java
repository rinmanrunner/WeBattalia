package com.webattalia.game;

import java.util.*;

public class DeckTest {
	Deck deck;
	public DeckTest(Deck deck){
		this.deck = deck;
	}
	
	public static void main(String[] args){
		List<Card> startCards = new ArrayList<Card>();
		for(int i=0;i<5;i++){startCards.add(new Supply());}
		for(int i=0;i<3;i++){startCards.add(new Friman());}
		startCards.add(new Chief());
		startCards.add(new Priest());
		Deck startingDeck = new Deck(startCards);
		System.out.println("The deck before shuffling");
		startingDeck.printCards();
		startingDeck.shuffle();
		System.out.println("The deck after shuffling");
		startingDeck.printCards();
		Deck playerHand = new Deck(startingDeck.deal(6));
		System.out.println("The player's starting hand");
		playerHand.printCards();
		System.out.println("The deck after dealing");
		startingDeck.printCards();
		List<CardType> allCards = Arrays.asList(CardType.values());
		System.out.println("Player Hand: " + playerHand.getTypes());
		for(ListIterator<CardType> i=allCards.listIterator();i.hasNext();){
	    	CardType cardToBuy = i.next();
			Cost cardCost = new Cost(cardToBuy);
			boolean isCovered = cardCost.isCovered(playerHand.cards);
			//System.out.println("Cost of " + cardToBuy + ": " + cardCost.getPriceList());
			//System.out.println("Cost Covered?: " + isCovered);
			if(isCovered){
				System.out.println("You can buy " + cardToBuy);
			}
			else{
				//System.out.println("You cannot buy " + cardToBuy);	
			}
	    }


	}
}
