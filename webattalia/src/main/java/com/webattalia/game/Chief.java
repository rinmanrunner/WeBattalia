package com.webattalia.game;

public class Chief extends Unit{
	// Chief has a faction
	// Chief cost 3 supply
	// Chief has strength 2
	// Chief does not move heroes
	public Chief(Faction faction){
		super(faction, new Cost[]{Cost.SUPPLY, Cost.SUPPLY, Cost.SUPPLY}, 2, 0);
		this.name = "Chief";
	}
	// Select random faction
	public Chief(){
		super(new Cost[]{Cost.SUPPLY, Cost.SUPPLY, Cost.SUPPLY}, 2, 0);
		this.name = "Chief";
	}
}
