package com.webattalia.game;

import java.util.*;

public class Market {
	//The market contains a set of decks
	private List<Deck> decks;
	// Contains the limbo where cards are discarded permanently
	private Deck limbo;
	private static Market instance = null;
	private int numPlayers;
	protected Market(){
		//Used to protect against instantiation
	}
	// Initialize Decks for specified numPlayers
	protected Market(int numPlayers){
		setPlayers(numPlayers);
		//Used to protect against instantiation
	}
	// Create a four player market if none exists
	public static Market getInstance(){
		if(instance == null){
			instance = new Market(4);
		}
		return instance;
	}
	// Create a n-player market if none exists
	public static Market getInstance(int numPlayers){
		if(instance == null){
			instance = new Market(numPlayers);
		}
		return instance;
	}
	public void setPlayers(int numPlayers){
		this.numPlayers = numPlayers;
		initializeDecks();
	}
	public void initializeDecks(){
		//Initialize list of decks
		List<Deck> marketDecks = new ArrayList<Deck>();
		
		// Create list of factions for deck instantiation
		List<Faction> factionList = new ArrayList<Faction>();
		factionList.add(Faction.BARFOLK);
		factionList.add(Faction.CLOUDBORN);
		factionList.add(Faction.EMBERIAN);
		factionList.add(Faction.ISLANDER);
		
		//Find variables based on numPlayers
		int numSupply = 80;

		if(numPlayers<3){
			numSupply = 60;	
			// One faction is removed from the market in a two player game
			Faction factionToRemove = Card.selectRandomFaction(); 
			factionList.remove(factionToRemove);
		}
		//Initialize Supply deck
		marketDecks.add(new Deck(CardType.SUPPLY, Faction.NONE, numSupply));
				
		//Initialize Unit decks
		marketDecks.add(new Deck(CardType.FRIMAN, factionList, 6));
		marketDecks.add(new Deck(CardType.CHIEF, factionList, 6));
		marketDecks.add(new Deck(CardType.PRIEST, factionList, 4));
		marketDecks.add(new Deck(CardType.LORD, factionList, 4));
		
		//Initialize the Artefact decks
		marketDecks.add(new Deck(CardType.TOOL, factionList, 3));
	    marketDecks.add(new Deck(CardType.WEAPON, factionList, 3));
		marketDecks.add(new Deck(CardType.AMULET, factionList, 3));
	    marketDecks.add(new Deck(CardType.TITLE, factionList, 3));
		marketDecks.add(new Deck(CardType.SCROLL, factionList, 3));
	    marketDecks.add(new Deck(CardType.TENT, factionList, 3));
		marketDecks.add(new Deck(CardType.HORSE, factionList, 3));
		
		//Initialize the Roads
	    marketDecks.add(new Deck(CardType.STRAIGHT_ROAD, factionList, 1));
	    marketDecks.add(new Deck(CardType.CURVED_ROAD, factionList, 1));
	    marketDecks.add(new Deck(CardType.TEE_ROAD, factionList, 1));
	    marketDecks.add(new Deck(CardType.CROSS_ROAD, factionList, 1));
	    
	    //Initialize the Cities
	    marketDecks.add(new Deck(CardType.END_CITY,factionList,1));
	    marketDecks.add(new Deck(CardType.STRAIGHT_CITY, factionList, 1));
	    marketDecks.add(new Deck(CardType.CURVED_CITY, factionList, 1));
	    marketDecks.add(new Deck(CardType.TEE_CITY, factionList, 1));
	    marketDecks.add(new Deck(CardType.CROSS_CITY, factionList, 1));
	    
		//Set decks in Market
		this.decks = marketDecks;
		shuffleAll();
	}
	public Deck getDeck(CardType cardType){
		for(ListIterator<Deck> i=decks.listIterator(); i.hasNext();){
			if(i.next().getCards().get(0).type().equals(cardType)){
				return i.previous();
			}
		}
		return null;
	}
	public void shuffleAll(){
		for(ListIterator<Deck> i=decks.listIterator(); i.hasNext();){
			i.next().shuffle();
		}
	}
	public void shuffle(CardType cardType){
		getDeck(cardType).shuffle();
	}
	public Card deal(CardType cardType){
		return getDeck(cardType).deal();
	}
	public Card dealFaction(CardType cardType, Faction faction){
		return getDeck(cardType).dealFaction(faction);
	}
	public void sendToLimbo(Card card){
		limbo.addCard(card);
	}
//	public  removeFromLimbo(Card card){
//		
//	}
}
