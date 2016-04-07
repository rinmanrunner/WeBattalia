package com.webattalia.game;

import java.util.*;

public class Deck{
	// A deck is composed of an array of cards
	private List<Card> cards;

	public List<Card> getCards(){
		return cards;
	}
	public Deck(List<Card> cards){
		this.cards = cards;
	}
	//Initialize a deck with a specified number[i] of each CardType[i] and Faction[i] 
	public Deck(List<CardType> cardTypes, List<Faction> factions, int[] number){
		List<Card> deckCards = new ArrayList<Card>();
		for(ListIterator<CardType> i=cardTypes.listIterator(); i.hasNext();)
		{
			for(int j=0;j<number[i.nextIndex()];j++){
				deckCards.add(CardRegistry.getInstance().
						makeCard(cardTypes.get(i.nextIndex()),
								factions.get(i.nextIndex())));
			}
			i.next();
		}
		this.cards = deckCards;
	}
	//Initialize a deck with a specified number of each Faction[i] for CardType[ 
	public Deck(CardType cardType, List<Faction> factions, int number){
		List<Card> deckCards = new ArrayList<Card>();
		for(ListIterator<Faction> i=factions.listIterator(); i.hasNext();)
		{
			for(int j=0;j<number;j++){
				deckCards.add(CardRegistry.getInstance().
						makeCard(cardType,
								factions.get(i.nextIndex())));
			}
			i.next();
		}
		this.cards = deckCards;
	}
	//Initialize a deck with a number of cardType and faction
	public Deck(CardType cardType, Faction faction, int number){
		List<Card> deckCards = new ArrayList<Card>();
		for(int i=0;i<number;i++){
			deckCards.add(CardRegistry.getInstance().makeCard(cardType,faction));
		}
		this.cards = deckCards;
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
	
	// Add a card to the bottom of the deck
	public void addCard(Card card){
		cards.add(card);
	}
	
	// Add a card to the top of the deck
	public void addCardToTop(Card card){
		cards.add(0,card);
	}
	
	// Add multiple cards to the bottom of the deck
	public void addCards(List<Card> cards){
		cards.addAll(cards);
	}
	
	// Add multiple cards to the top of the deck
	public void addCardsToTop(List<Card> cards){
		cards.addAll(0,cards);
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
