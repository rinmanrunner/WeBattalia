package com.webattalia.game;

import java.util.*;

public class Deck{
	// A deck is composed of an array of cards
	public List<Card> cards;
	
	public Deck(List<Card> cards){
		this.cards = cards;
	}
	//Initialize a deck with a specified number[i] of each Card[i] 
	public Deck(List<Card> cardTypes, int[] numCardType){
		List<Card> cards = new ArrayList<Card>();
		for(ListIterator<Card> i=cardTypes.listIterator(); i.hasNext();)
		{
			for(int j=0;j<numCardType[i.nextIndex()];j++){
				cards.add(cardTypes.get(i.nextIndex()));
			}
		}
	}
	//Prints out the cards in the deck to the screen
	public void printCards(){
		for(ListIterator<Card> j=cards.listIterator(); j.hasNext();)
		{
			System.out.print(cards.get(j.nextIndex()).faction.getColor() + " " + j.next().name + ", ");
		}
		System.out.println("");
	}
	
}
