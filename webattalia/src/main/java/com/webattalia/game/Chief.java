package com.webattalia.game;

public class Chief extends Unit{
	// Chief has a faction
	// Chief cost 3 supply
	// Chief has strength 2
	// Chief does not move heroes
	// Select random faction
	public Chief(){
		super(CardType.CHIEF, 2, 0);
	}
	public Chief(Faction faction){
		super(faction, CardType.CHIEF, 2, 0);
	}

}
