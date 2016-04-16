package com.webattalia.game;

import java.util.*;

public abstract class Card {
	// The card class has a faction and cost

	public Faction faction;
	
	public abstract CardType type();
	public abstract Cost cost();
	public abstract Card copy();
	
	//Unique Id of card
	private Integer id;
	// Id getter
	public Integer getId(){
		return this.id;
	}
	// Main call for Card
	public Card(Faction faction){
		this.faction = faction;
		//Register this card
		this.id = CardRegistry.getInstance().register(this);
	}
	public Card(){
		this(selectRandomFaction());
	}
	public Card(Card card){
		this(card.faction);
	}
	// Select random faction for card
	public static Faction selectRandomFaction(){
		// Select random faction
		Random rand = new Random();
		int value = rand.nextInt(4)+1;
		switch (value) {
			case 1:
				return Faction.CLOUDBORN;
			case 2:
				return Faction.ISLANDER;
			case 3:
				return Faction.BARFOLK;
			case 4:
				return Faction.EMBERIAN;
		}
		return Faction.NONE;
	}
}
