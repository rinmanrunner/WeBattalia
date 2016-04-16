package com.webattalia.game;

import java.util.*;

public class ActionLine {
	private List<Unit> units;
	private List<Card> boughtCards;
	public ActionLine(){
		
	}
	
	public List<Unit> getPlayedCards(){
		return units;
	}
	
	public List<Card> getBoughtCards(){
		return boughtCards;
	}
	//An action line is composed of a Card list.
	public void addCard(Unit unit){
		units.add(unit);
	}
	// THIS FUNCTIONALITY NEEDS TO BE ADDED TO DASHBOARD INTERFACE
//		if(units.size()>0){
//			Card lastUnit = units.get(units.size()-1);
//			switch(lastUnit.type()){
//				case AMULET:
//					Artefact.Amulet amulet = (Artefact.Amulet)lastUnit;
//					List<Unit> outUnits = amulet.transform(unit);
//					units.addAll(outUnits);
//					//Lock Scroll so it can't be used again
//					lockedUnits = units.size()-1-outUnits.size();
//					break;
//				case TITLE:
//					Artefact.Title title = (Artefact.Title)lastUnit;
//					Unit newUnit = title.upgrade(unit, market);
//					units.add(newUnit);
//					//Lock cards from removal
//					lockedUnits = units.size()-1;
//					break;
//				default: 
//					
//			}
//		}

	// Need to provide faction if player is adding onto a scroll
//	public void addCardToScroll(Unit unit, Faction f){
//		Unit lastUnit = units.get(units.size()-1);
//		if(lastUnit.type().equals(CardType.SCROLL)){
//			Card newCard = ((Artefact.Scroll) lastUnit).change(unit, f, market);
//			units.add((Unit)newCard);
//			//Lock Changed Unit so it can't be removed from the Action Line
//			lockedUnits = units.size()-1;
//		}
//	}
	// Player can change color of scroll as well
//	public void changeScroll(Faction f){
//		Unit lastUnit = units.get(units.size()-1);
//		if(lastUnit.type().equals(CardType.SCROLL) && units.size()-1>lockedUnits){
//			Card newCard = ((Artefact.Scroll) lastUnit).changeSelf(f,market);
//			//remove old card from action line
//			units.remove(units.size()-1);
//			// Add new card to end of line
//			units.add((Unit)newCard);
//			//Lock Scroll so it can't be used again
//			lockedUnits = units.size()-1;
//		}
//	}
	// Use to remove cards from action line
	public Unit removeLastUnit(){
		if(units.size()>0){
			return units.remove(units.size()-1);
		}
		return null;
	}
	// Used to check if a card can be bought
	public boolean canBuy(Card card){
		if(card.cost().isCovered(units)){
			return true;
		}
		return false;
	}
	// Loop over all decks in the market and 
	// return cards that can be purchased
	public List<Card> canBuy(Market market){
		List<Deck> marketDecks = market.getDecks();
		List<Card> buyableCards = new ArrayList<Card>();
		for(ListIterator<Deck> i=marketDecks.listIterator(); i.hasNext();){
			List<Card> currCards = i.next().getCards();
			if(currCards.size()>0 && currCards.get(0).cost().isCovered(units)){
				buyableCards.add(currCards.get(0));
			}
		}
		return buyableCards;
	}
	// Buy a card type from the market. Checks if purchase is legal
	public List<Card> buyCard(CardType cardType, Market market){
		Deck marketDeck = market.getDeck(cardType);
		List<Card> cards = new ArrayList<Card>(); 
		if(marketDeck.getCards().size()>0){
			Card cardToBuy = marketDeck.getCards().get(0);
			if(canBuy(cardToBuy)){
				// add a supply if unit is friman, chief, priest, or lord and not unbound
				if (!cardToBuy.faction.equals(Faction.UNBOUND)){
					switch(cardType){
					case END_CITY:
					case STRAIGHT_CITY:
					case CURVED_CITY:
					case TEE_CITY:
					case CROSS_CITY:
					case STRAIGHT_ROAD:
					case CURVED_ROAD:
					case TEE_ROAD:
					case CROSS_ROAD:
						//Roads and cities should be returned by this function
						// but not added to bought cards because they need to
						// be played to the board
						cards.add(marketDeck.deal());
						break;
					case FRIMAN:
					case CHIEF:
					case PRIEST:
					case LORD:
						cards.add(market.getDeck(CardType.SUPPLY).deal());
					default:		
						cards.add(marketDeck.deal());
						this.boughtCards = cards;
					}
				}
			}
		}
		return cards;
	}
	// Discard Action Line
	public List<Card> discard(){
		List<Card> outCards = new ArrayList<Card>();
		outCards.addAll(units);
		units.removeAll(units);
		// boughtCards will only work 
		outCards.addAll(boughtCards);
		boughtCards.removeAll(boughtCards);
		return outCards;
	}
}
