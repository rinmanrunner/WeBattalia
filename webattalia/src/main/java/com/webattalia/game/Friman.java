package com.webattalia.game;

public class Friman extends Unit{
	// Frimen have a faction
	// Frimen cost 2 supply
	// Frimen have strength 1
	// Frimen do not move heroes
	
	// Select random faction
	public Friman(){
		super(CardType.FRIMAN, 1, 0);
	}
	public Friman(Faction faction){
		super(faction, CardType.FRIMAN, 1, 0);
	}

}
