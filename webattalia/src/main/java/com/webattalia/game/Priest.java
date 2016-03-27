package com.webattalia.game;

public class Priest extends Unit{
	// Priest has a faction
	// Priest cost 4 supply
	// Priest has strength 3
	// Priest does not move heroes
	// Select random faction
	public Priest(){
		super(CardType.PRIEST, 3, 0);
	}
	public Priest(Faction faction){
		super(faction, CardType.PRIEST, 3, 0);
	}

}
