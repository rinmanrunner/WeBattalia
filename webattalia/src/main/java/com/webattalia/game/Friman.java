package com.webattalia.game;

public class Friman extends Unit{
	// Frimen have a faction
	// Frimen cost 2 supply
	// Frimen have strength 1
	// Frimen do not move heroes
	public Friman(Faction faction){
		super(faction, new Cost[]{Cost.SUPPLY, Cost.SUPPLY}, 1, 0);
		this.name = "Friman";
	}
	// Select random faction
	public Friman(){
		super(new Cost[]{Cost.SUPPLY, Cost.SUPPLY}, 1, 0);
		this.name = "Friman";
	}
}
