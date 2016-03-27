package com.webattalia.game;

public class Lord extends Unit{
	// Lord has a faction
	// Lord cost 5 supply
	// Lord has strength 4
	// Lord does not move heroes

	// Select random faction
	public Lord(){
		super(CardType.LORD, 4, 0);
	}
	public Lord(Faction faction){
		super(faction, CardType.LORD, 4, 0);
	}
}