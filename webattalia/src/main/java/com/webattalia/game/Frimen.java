package com.webattalia.game;

public class Frimen extends Unit{
	// Frimen have a faction
	// Frimen cost 2 supply
	// Frimen have strength 1
	// Frimen do not move heroes
	public Frimen(Faction faction){
		super(faction, new Cost[]{Cost.SUPPLY, Cost.SUPPLY}, 1, 0);
		this.name = "Frimen";
	}
	// Select random faction
	public Frimen(){
		super(new Cost[]{Cost.SUPPLY, Cost.SUPPLY}, 1, 0);
		this.name = "Frimen";
	}
}
