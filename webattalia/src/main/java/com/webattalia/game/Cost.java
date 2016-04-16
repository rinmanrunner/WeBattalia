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
	//priceList is determined by the Cost object's cardType or ActionType
	public List<CardType> getPriceList(){
		return priceList;
	}
	// Returns true if the specified list of cards contains the priceList
	public boolean isCovered(List<? extends Card> cards){
		//Build list of card types
		List<CardType> types = new ArrayList<CardType>();
		for(ListIterator<? extends Card> i=cards.listIterator(); i.hasNext();)
		{
			CardType newType = i.next().type();
			// if it is a tool, then add buildValue to list, otherwise add type
			if(newType.equals(CardType.TOOL)){
				Artefact.Tool tool = (Artefact.Tool)cards.get(i.previousIndex());
				types.addAll(tool.buildValue());
			}
			else{
				types.add(newType);				
			}

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
}
