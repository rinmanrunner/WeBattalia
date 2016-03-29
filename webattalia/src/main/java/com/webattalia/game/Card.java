package com.webattalia.game;

import java.util.*;

public abstract class Card {
	// The card class has a faction and cost

	public Faction faction;

	public abstract CardType type();
	public abstract Cost cost();
	
	public Card(){
		this.faction = selectRandomFaction();
	}
	public Card(Faction faction){
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

	public class WildCard extends Card{
		public Unit tempCard;
		public Unit actualCard;
		// Create a temporary WildCard from a given unit
		public WildCard(Card card){
			super(card.faction);
			this.actualCard = (Unit)card;
		}
		// Wild card can be temporarily transformed to selected unit
		public void transformTo(Unit unit){
			this.tempCard = unit;
		}
		public CardType type() {
			return actualCard.type();
		}
		public Cost cost() {
			return actualCard.cost();
		}
		// Return the actual card from which this temporary wild card was created
		// Used for discarding wild card to shelter
		public Unit revert(){
			return actualCard;
		}
	}
}
