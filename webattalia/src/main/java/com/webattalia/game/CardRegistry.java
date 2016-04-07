package com.webattalia.game;

import java.util.*;
// Centralized Factory and Registry for cards and tracking them by id
public class CardRegistry {
	private Map<Integer, Card> map = new HashMap<Integer, Card>();
	private static CardRegistry instance = null;
	protected CardRegistry(){
		// Exists only to defeat instantiation
	}
	public static CardRegistry getInstance(){
		if(instance == null){
			instance = new CardRegistry();
		}
		return instance;
	}
	// Return card from Registry based on id
	public Card getCard(Integer id){
		return map.get(id);
	}
	
	public Integer register(Card card){
		//Add this card to the map with id based on map size
		Integer nextId = map.size();
		map.put(nextId, card);
		return nextId;
	}
	public Card makeCard(CardType cardType, Faction faction){
		Card card = null;
		switch (cardType){
		case SUPPLY:
			card = new Unit.Supply();
			break;
		case FRIMAN:
			card = new Unit.Friman(faction);
			break;
		case CHIEF:
			card = new Unit.Chief(faction);
			break;
		case PRIEST:
			card = new Unit.Priest(faction);
			break;
		case LORD:
			card = new Unit.Lord(faction);
			break;
		case TOOL:
			card = new Artefact.Tool(faction);
			break;
		case WEAPON:
			card = new Artefact.Weapon(faction);
			break;
		case AMULET:
			card = new Artefact.Amulet(faction);
			break;
		case TITLE:
			card = new Artefact.Title(faction);
			break;
		case SCROLL:
			card = new Artefact.Scroll(faction);
			break;
		case TENT:
			card = new Artefact.Tent(faction);
			break;		
		case HORSE:
			card = new Artefact.Horse(faction);
			break;	
		case STRAIGHT_ROAD:
			card = new Road.Straight(faction);
			break;	
		case CURVED_ROAD:
			card = new Road.Curved(faction);
			break;	
		case TEE_ROAD:
			card = new Road.Tee(faction);
			break;		
		case CROSS_ROAD:
			card = new Road.Cross(faction);
			break;
		case END_CITY:
			card = new City.End(faction);
			break;			
		case STRAIGHT_CITY:
			card = new City.Straight(faction);
			break;	
		case CURVED_CITY:
			card = new City.Curved(faction);
			break;	
		case TEE_CITY:
			card = new City.Tee(faction);
			break;		
		case CROSS_CITY:
			card = new City.Cross(faction);
			break;
		case NONE:
			return null;
		}
		return card;
	}
	public Card makeCard(CardType cardType){
		return makeCard(cardType,Card.selectRandomFaction());
	}
}
