package com.webattalia.game;

import java.util.*;

public class Cost {
	//User sets the cardType
	public CardType cardType;
	private List<CardType> priceList;
	
	public Cost(CardType c){
		this.cardType = c;
	}
	public List<CardType> getPriceList(){
		setPriceList();
		return priceList;
	} 
	private void setPriceList(){
		this.priceList = new ArrayList<CardType>();
		switch (cardType){
			case SUPPLY:
				this.priceList.add(CardType.NONE);
				break;
			case FRIMAN:
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				break;
			case CHIEF:
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				break;
			case PRIEST:
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				break;
			case LORD:
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				break;
			case TOOL:
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.FRIMAN);
				break;
			case WEAPON:
				this.priceList.add(CardType.CHIEF);
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.FRIMAN);
				break;
			case AMULET:
				this.priceList.add(CardType.PRIEST);
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.FRIMAN);
				break;
			case TITLE:
				this.priceList.add(CardType.LORD);
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.FRIMAN);
				break;
			case SCROLL:
				this.priceList.add(CardType.PRIEST);
				this.priceList.add(CardType.CHIEF);
				this.priceList.add(CardType.FRIMAN);
				break;
			case TENT:
				this.priceList.add(CardType.CHIEF);
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.SUPPLY);
				break;
			case HORSE:
				this.priceList.add(CardType.CHIEF);
				this.priceList.add(CardType.SUPPLY);
				this.priceList.add(CardType.SUPPLY);
				break;
			case SIMPLE_ROAD:
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.SUPPLY);
				break;
			case COMPLEX_ROAD:
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.SUPPLY);
				break;
			case CITY_ONE:
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.FRIMAN);
				this.priceList.add(CardType.FRIMAN);
				break;
			case CITY_TWO:
				this.priceList.add(CardType.CHIEF);
				this.priceList.add(CardType.CHIEF);
				this.priceList.add(CardType.CHIEF);
				break;
			case CITY_THREE:
				this.priceList.add(CardType.PRIEST);
				this.priceList.add(CardType.PRIEST);
				this.priceList.add(CardType.PRIEST);
				break;
			case CITY_FOUR:
				this.priceList.add(CardType.LORD);
				this.priceList.add(CardType.LORD);
				this.priceList.add(CardType.LORD);
				break;
		default:
			this.priceList.add(CardType.NONE);
			break;
		
		}
	}
	// Returns true if the specified list of cards contains the priceList
	public boolean isCovered(List<Card> cards){
		//Build list of card types
		List<CardType> types = new ArrayList<CardType>();
		for(ListIterator<Card> i=cards.listIterator(); i.hasNext();)
		{
			types.add(i.next().type);
		}
		// Loop over priceList and compare to types, removing matches along the way
		for(ListIterator<CardType> i=getPriceList().listIterator(); i.hasNext();)
		{
			if(types.contains(i.next())){
				types.remove(getPriceList().get(i.previousIndex()));
			}
			else{
				return false;
			}		
		}
		return true;
	}
}
