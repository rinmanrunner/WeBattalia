package com.webattalia.game;

public class Priest extends Unit{
	// Priest has a faction
	// Priest cost 4 supply
	// Priest has strength 3
	// Priest does not move heroes
	public Priest(Faction faction){
		super(faction, new Cost[]{Cost.SUPPLY, Cost.SUPPLY, Cost.SUPPLY, Cost.SUPPLY}, 3, 0);
		this.name = "Priest";
	}
	// Select random faction
	public Priest(){
		super(new Cost[]{Cost.SUPPLY, Cost.SUPPLY, Cost.SUPPLY, Cost.SUPPLY}, 3, 0);
		this.name = "Priest";
	}
}
