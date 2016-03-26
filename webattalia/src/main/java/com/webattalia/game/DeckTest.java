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
		for(int i=0;i<3;i++){startCards.add(new Frimen());}
		startCards.add(new Chief());
		startCards.add(new Priest());
		Deck startingDeck = new Deck(startCards);
		System.out.println("The deck before shuffling");
		startingDeck.printCards();
		startingDeck.shuffle();
		System.out.println("The deck after shuffling");
		startingDeck.printCards();
	}
}
