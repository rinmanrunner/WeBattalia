package com.webattalia.game;

import java.util.Random;

public abstract class Card {
	// The card class has a faction and cost
	public String name;
	public Faction faction;
	public Cost[] cost;
	public Card(Faction faction, Cost[] cost){
		this.faction = faction;
		this.cost    = cost;
	}
	public Card(Cost[] cost){
		this.faction = selectRandomFaction();
		this.cost    = cost;
	}
	public Faction selectRandomFaction(){
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
