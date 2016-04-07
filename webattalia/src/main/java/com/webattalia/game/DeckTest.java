package com.webattalia.game;

import java.util.*;

public class DeckTest {
	Deck deck;
	public DeckTest(Deck deck){
		this.deck = deck;
	}
	
	public static void main(String[] args){
		List<Card> startCards = new ArrayList<Card>();
		for(int i=0;i<5;i++){startCards.add(new Unit.Supply());}
		for(int i=0;i<3;i++){startCards.add(new Unit.Friman());}
		startCards.add(new Unit.Chief());
		startCards.add(new Unit.Priest());
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
		List<Card> allCards = Arrays.asList(new Unit.Friman(),new Unit.Chief(),
				new Unit.Priest(), new Unit.Lord(), new Artefact.Tool(), 
				new Artefact.Weapon(),new Artefact.Amulet(), new Artefact.Title(),
				new Artefact.Scroll(), new Artefact.Tent(), new Artefact.Horse());
		System.out.println("Player Hand: " + playerHand.getTypes());
		for(ListIterator<Card> i=allCards.listIterator();i.hasNext();){
	    	Card cardToBuy = i.next();
	    	System.out.println(cardToBuy.getId());
	    	boolean isCovered = cardToBuy.cost().isCovered(playerHand.getCards());
			//System.out.println("Cost of " + cardToBuy + ": " + cardCost.getPriceList());
			//System.out.println("Cost Covered?: " + isCovered);
			if(isCovered){
				System.out.println("You can buy " + cardToBuy.type());
			}
			else{
				//System.out.println("You cannot buy " + cardToBuy);	
			}
	    }
//		List<ActionType> allActions = Arrays.asList(ActionType.values());
//		for(ListIterator<ActionType> j=allActions.listIterator();j.hasNext();){
//	    	ActionType action = j.next();
//			Cost actionCost = new Cost(action);
//			boolean isCovered = actionCost.isCovered(playerHand.cards);
//			//System.out.println("Cost of " + cardToBuy + ": " + cardCost.getPriceList());
//			//System.out.println("Cost Covered?: " + isCovered);
//			if(isCovered){
//				System.out.println("You can " + action);
//			}
//			else{
//				//System.out.println("You cannot buy " + cardToBuy);	
//			}
//	    }		
		int startDay = 1;
		System.out.println("Day " + startDay);
		System.out.println("Match: " +  Oracle.getInstance().match() + " Illuminated: " + Oracle.getInstance().illuminated());
		Oracle.getInstance().advance();
		System.out.println("Day " + (startDay+1));		
		System.out.println("Match: " +  Oracle.getInstance().match() + " Illuminated: " + Oracle.getInstance().illuminated());
		
		System.out.println("Road Test");
		Road.Tee roadTest = new Road.Tee(Faction.BARFOLK);
        roadTest.showConnections();
		System.out.println("Rotate CCW: ");
		roadTest.rotateConnections(-1);
		roadTest.showConnections();
	}
}
