package com.webattalia.game;

public class Lord extends Unit{
	// Lord has a faction
	// Lord cost 5 supply
	// Lord has strength 4
	// Lord does not move heroes
	public Lord(Faction faction){
		super(faction, new Cost[]{Cost.SUPPLY, Cost.SUPPLY, Cost.SUPPLY}, 4, 0);
		this.name = "Lord";
	}
	// Select random faction
	public Lord(){
		super(new Cost[]{Cost.SUPPLY, Cost.SUPPLY, Cost.SUPPLY}, 4, 0);
		this.name = "Lord";
	}
}