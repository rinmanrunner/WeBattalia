package com.webattalia.game;

public class Supply extends Unit {
	// Supply have no faction
	// They can only be purchased with units
	// Supply have strength 0, and can move heroes 1
	public Supply(){
		super(Faction.NONE, CardType.SUPPLY, 0, 1);
	}
}
