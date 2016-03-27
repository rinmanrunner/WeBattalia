package com.webattalia.game;

import java.util.Random;

public abstract class Card {
	// The card class has a faction and cost
	public CardType type;
	public Faction faction;
	private Cost cost;
	
	public Card(CardType type){
		this.faction = selectRandomFaction();
		this.type    = type;
		this.cost    = new Cost(type);
	}
	public Card(Faction faction, CardType type){
		this.type    = type;
		this.cost    = new Cost(type);
		this.faction = faction;
	}
	public Faction selectRandomFaction(){
		// Select random faction
		Random rand = new Random();
		int value = rand.nextInt(4)+1;
		switch (value) {
			case 1:
				return Faction.CLOUDBORN;
			case 2:
				return Faction.ISLANDERS;
			case 3:
				return Faction.BARFOLK;
			case 4:
				return Faction.EMBERIANS;
		}
		return Faction.NONE;
	}
	public Cost getCost(){
		setCost();
		return cost;
	}
	private void setCost(){
		this.cost =  new Cost(this.type);
	}
}
