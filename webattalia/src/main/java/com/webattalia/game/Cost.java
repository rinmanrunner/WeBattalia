package com.webattalia.game;

import java.util.*;

public class Cost {
	//User sets the cardType or ActionType
//	private CardType cardType;
//	private ActionType action;
	private List<CardType> priceList;
	
	public Cost(List<CardType> priceList){
		this.priceList = priceList;
	}
//	public Cost(CardType c){
//		this.cardType = c;
//		this.action = null;
//	}
//	public Cost(ActionType a){
//		this.action = a;
//		this.cardType = null;
//	}
//
//	public void setCardType(CardType c){
//		this.cardType = c;
//		this.action = null;
//	}
//	public void setAction(ActionType a){
//		this.cardType = null;
//		this.action = a;
//	}
	//priceList is determined by the Cost object's cardType or ActionType
	public List<CardType> getPriceList(){
		return priceList;
	}
//		List<CardType> priceList = new ArrayList<CardType>();
//		if(cardType != null)
//		{
//			switch (cardType){
//				case SUPPLY:
//					priceList.add(CardType.NONE);
//					break;
//				case FRIMAN:
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case CHIEF:
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case PRIEST:
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case LORD:
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case TOOL:
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.FRIMAN);
//					break;
//				case WEAPON:
//					priceList.add(CardType.CHIEF);
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.FRIMAN);
//					break;
//				case AMULET:
//					priceList.add(CardType.PRIEST);
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.FRIMAN);
//					break;
//				case TITLE:
//					priceList.add(CardType.LORD);
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.FRIMAN);
//					break;
//				case SCROLL:
//					priceList.add(CardType.PRIEST);
//					priceList.add(CardType.CHIEF);
//					priceList.add(CardType.FRIMAN);
//					break;
//				case TENT:
//					priceList.add(CardType.CHIEF);
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case HORSE:
//					priceList.add(CardType.CHIEF);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case SIMPLE_ROAD:
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case COMPLEX_ROAD:
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case CITY_ONE:
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.FRIMAN);
//					priceList.add(CardType.FRIMAN);
//					break;
//				case CITY_TWO:
//					priceList.add(CardType.CHIEF);
//					priceList.add(CardType.CHIEF);
//					priceList.add(CardType.CHIEF);
//					break;
//				case CITY_THREE:
//					priceList.add(CardType.PRIEST);
//					priceList.add(CardType.PRIEST);
//					priceList.add(CardType.PRIEST);
//					break;
//				case CITY_FOUR:
//					priceList.add(CardType.LORD);
//					priceList.add(CardType.LORD);
//					priceList.add(CardType.LORD);
//					break;
//			default:
//				priceList.add(CardType.NONE);
//				break;
//			
//			}
//		}
//		else{
//			switch (action){
//				case SUMMON_HERO:
//					priceList.add(CardType.WEAPON);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case UPGRADE_TO_CITY_TWO:
//					priceList.add(CardType.CHIEF);
//					priceList.add(CardType.CHIEF);
//					break;
//				case UPGRADE_TO_CITY_THREE:
//					priceList.add(CardType.PRIEST);
//					priceList.add(CardType.PRIEST);
//					break;
//				case UPGRADE_TO_CITY_FOUR:
//					priceList.add(CardType.LORD);
//					priceList.add(CardType.LORD);
//					break;
//				case MOVE_HERO_ONE:
//					priceList.add(CardType.SUPPLY);
//					break;
//				case MOVE_HERO_THREE:
//					priceList.add(CardType.HORSE);
//					break;
//				case START_BATTLE:
//					priceList.add(CardType.WEAPON);
//					break;
//				case ERECT_TENT:
//					priceList.add(CardType.TENT);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case RETREAT_WITH_SUPPLY:
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case RETREAT_WITH_HORSE:
//					priceList.add(CardType.HORSE);
//					break;
//				case ACTIVATE_HERO_ABILITY_TWO:
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case ACTIVATE_HERO_ABILITY_THREE:
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;			
//				case BRIBE_UNBOUND_BUFF:
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				case HIRE_UNBOUND_BUFF:
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					priceList.add(CardType.SUPPLY);
//					break;
//				default:
//					priceList.add(CardType.NONE);
//					break;
//			}
//		}
//		return priceList;
//	}
	// Returns true if the specified list of cards contains the priceList
	public boolean isCovered(List<Card> cards){
		//Build list of card types
		List<CardType> types = new ArrayList<CardType>();
		for(ListIterator<Card> i=cards.listIterator(); i.hasNext();)
		{
			types.add(i.next().type());
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
