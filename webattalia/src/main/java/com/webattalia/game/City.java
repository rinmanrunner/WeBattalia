package com.webattalia.game;

import java.util.Arrays;

public abstract class City extends Road {
	// Cities have levels and owners
	protected int level = 0; 
	protected Faction owner = Faction.NONE;
	
	protected boolean[] connections;//North, East, South, West

	public abstract CardType type();
	
	public City(Faction faction)
	{
		super(faction);;
	}
	public City(){
		super();
	}
	public Cost cost(){
		//Use Cost(int level) for actual cost
		return null;
	}
	// City cost depends on the level
	public Cost cost(int level){
		//Cost depends on city level
		// 3 Frimen for level 1, 3 Chiefs for level 2
		// 3 Priests for level 3, 3 Lords for level 4
		switch(level){
		case 1:
			return new Cost(Arrays.asList(
					CardType.FRIMAN, CardType.FRIMAN, CardType.FRIMAN));
		case 2:
			return new Cost(Arrays.asList(
					CardType.CHIEF, CardType.CHIEF, CardType.CHIEF));
		case 3:
			return new Cost(Arrays.asList(
					CardType.PRIEST, CardType.PRIEST, CardType.PRIEST));
	    case 4:
	    	return new Cost(Arrays.asList(
					CardType.LORD, CardType.LORD, CardType.LORD));
	    	default:
	    		return null;
		}	
	}
	public Cost upgradeCost(){
		//Upgrade cost depends on city level
		// 2 Chiefs for level 1 to 2, 2 Priests for level 2 to 3,
		// 2 Lords for level 3 to 4
		switch(level){
		case 1:
			return new Cost(Arrays.asList(
					CardType.CHIEF, CardType.CHIEF));
		case 2:
			return new Cost(Arrays.asList(
					CardType.PRIEST, CardType.PRIEST));
	    case 3:
	    	return new Cost(Arrays.asList(
					CardType.LORD, CardType.LORD));
	    	default:
	    		return null;
		}	
	}
	// Upgrade the city to next level (if less than 4)
	// Returns true if successful
	public boolean upgrade(){
		if(level < 4){
			level++;
			return true;
		}
		return false;
	}
	// Change ownership of city
	public void changeOwner(Faction f){
		owner = f;
	}
	// Find the city owner
	public Faction getOwner(){
		return owner;
	}
	// Find the city level
	public int getLevel(){
		return level;
	}
	//Build city and set the level and owner of the city 
	public void buildCity(int level, Faction owner){
		this.level = level;
		this.owner = owner;
	}
	public static class End extends City {
		public CardType type() {return CardType.END_CITY;}
		public End(Faction faction){
			super(faction);
			connections = new boolean[]{true, false, false, false};
		};
		// Select a random faction
		public End(){
			super();
			connections = new boolean[]{true, false, false, false};
		}
	}
	public static class Straight extends City {
		public CardType type() {return CardType.STRAIGHT_ROAD;}
		public Straight(Faction faction){
			super(faction);
			connections = new boolean[]{true, false, true, false};
		};
		// Select a random faction
		public Straight(){
			super();
			connections = new boolean[]{true, false, true, false};
		}
		// Straight road costs a friman and supply
		public Cost cost(){
			return new Cost(Arrays.asList(
				       CardType.FRIMAN, CardType.SUPPLY));
		}
	}
	public static class Curved extends City {
		public CardType type() {return CardType.CURVED_ROAD;}
		public Curved(Faction faction){
			super(faction);
			connections = new boolean[]{true, true, false, false};
		};
		// Select a random faction
		public Curved(){
			super();
			connections = new boolean[]{true, true, false, false};
		}
		// Curved road costs a friman and supply
		public Cost cost(){
			return new Cost(Arrays.asList(
				       CardType.FRIMAN, CardType.SUPPLY));
		}

	}
	public static class Tee extends City {
		public CardType type() {return CardType.TEE_ROAD;}
		public Tee(Faction faction){
			super(faction);
			connections = new boolean[]{true, true, true, false};
		};
		// Select a random faction
		public Tee(){
			super();
			connections = new boolean[]{true, true, true, false};
		}
		// Tee road costs 2 friman and supply
		public Cost cost(){
			return new Cost(Arrays.asList(
				CardType.FRIMAN, CardType.FRIMAN, CardType.SUPPLY));
		}
	}
	public static class Cross extends City {
		public CardType type() {return CardType.CROSS_ROAD;}
		public Cross(Faction faction){
			super(faction);
			connections = new boolean[]{true, true, true, true};
		};
		// Select a random faction
		public Cross(){
			super();
			connections = new boolean[]{true, true, true, true};
		}
		// Cross road costs 2 friman and supply
		public Cost cost(){
			return new Cost(Arrays.asList(
				CardType.FRIMAN, CardType.FRIMAN, CardType.SUPPLY));
		}
	}
}
