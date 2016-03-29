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
			i.next();
		}
	}
	// Shuffle the deck of cards using the Collections class
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	// Deal the top card from the deck
	public Card deal(){
		if(cards.size()>0){
			return cards.remove(0);
		}
		return null;					
	}
	// Deal the top n cards from the deck
	public List<Card> deal(int n){
		List<Card> outCards = new ArrayList<Card>();
		for(int i=0;i<n & cards.size()>0;i++){
			outCards.add(cards.remove(0));
		}
		return outCards;
	}
	
	//Get cardType of every card in the deck
	public List<CardType> getTypes(){
		//Set the cardType of every card in the deck
		List<CardType> types = new ArrayList<CardType>();
		for(ListIterator<Card> i=cards.listIterator(); i.hasNext();)
		{
			types.add(i.next().type());
		}
		return types;
	}
	// Remove first card with specified faction. If faction doesn't exist, deal top card.
	public Card dealFaction(Faction f){
		for(ListIterator<Card> i=cards.listIterator(); i.hasNext();)
		{
			if(i.next().faction == f)
			{
				return cards.remove(i.previousIndex());
			}
		}
		//System.out.println(f + " not in deck. Dealing top card");
		return deal();
	}
	
	//Prints out the cards in the deck to the screen
	public void printCards(){
		for(ListIterator<Card> j=cards.listIterator(); j.hasNext();)
		{
			System.out.print(cards.get(j.nextIndex()).faction.getColor() + " " + j.next().type() + ", ");
		}
		System.out.println("");
	}

}
