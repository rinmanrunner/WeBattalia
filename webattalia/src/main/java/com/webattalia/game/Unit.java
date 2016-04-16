package com.webattalia.game;

import java.util.*;

public abstract class Unit extends Card {
	// Units have strength and move in addition to card properties
	public abstract int strength();
	public abstract int move();
	public abstract Unit copy();
	
	// Flag to track whether a unit is virtual or real. Virtual cards only exist when
	// created by amulets or illumination. They disappear when discarded
	public boolean isVirtual = false;
	
	public Unit(){super();}
	public Unit(Faction faction){super(faction);}
	public static class Supply extends Unit {
		public final CardType type(){return CardType.SUPPLY;}
		// Supply have no faction
		public Supply(){super(Faction.NONE);}
		// They can only be purchased with units
		public final Cost cost(){
			return new Cost(Arrays.asList(CardType.NONE));
		}
		// Supply have strength 0, and can move heroes 1
		public final int strength(){return 0;}
		public final int move(){return 1;}
		public final Unit copy(){return new Unit.Supply();};
	}
	public static class Friman extends Unit{
		public final CardType type(){return CardType.FRIMAN;}
		public Friman(Faction faction){super(faction);}
		// Select random faction
		public Friman(){super();}
		// Friman costs 2 supply
		public final Cost cost(){
			return new Cost(Arrays.asList(
					       CardType.SUPPLY,
						   CardType.SUPPLY));
		}
		// Frimen have strength 1 and move 0
		public final int strength(){return 1;}
		public final int move(){return 0;}
		public final Unit copy(){return new Unit.Friman(this.faction);}
	}
	public static class Chief extends Unit{
		public final CardType type(){return CardType.CHIEF;}
		// Select random faction
		public Chief(){super();}
		public Chief(Faction faction){super(faction);}
		// Chief cost 3 supply
		public final Cost cost(){
			return new Cost(Arrays.asList(
					       CardType.SUPPLY,
						   CardType.SUPPLY,
						   CardType.SUPPLY));
		}
		// Chief has strength 2 and move 0
		public final int strength(){return 2;}
		public final int move(){return 0;}
		public final Unit copy(){return new Unit.Chief(this.faction);}
	}
	public static class Priest extends Unit{
		public final CardType type(){return CardType.PRIEST;}
		public Priest(Faction faction){super(faction);}
		// Select random faction
		public Priest(){super();}
		// Priest costs 4 supply
		public final Cost cost(){
			return new Cost(Arrays.asList(
					       CardType.SUPPLY,
						   CardType.SUPPLY,
						   CardType.SUPPLY,
						   CardType.SUPPLY));
		}
		// Priest has strength 3 and move 0
		public final int strength(){return 3;}
		public final int move(){return 0;}
		public final Unit copy(){return new Unit.Priest(this.faction);}
	}
	public static class Lord extends Unit{
		public final CardType type(){return CardType.LORD;}
		public Lord(Faction faction){super(faction);}
		// Select random faction
		public Lord(){super();}
		// Lord costs 5 supply
		public final Cost cost(){
			return new Cost(Arrays.asList(
					       CardType.SUPPLY,
						   CardType.SUPPLY,
						   CardType.SUPPLY,
						   CardType.SUPPLY,
						   CardType.SUPPLY));
		}
		// Lord has strength 4 and move 0
		public final int strength(){return 4;}
		public final int move(){return 0;}
		public final Unit copy(){return new Unit.Lord(this.faction);}
	}
	public class WildCard extends Unit{
		private Unit tempUnit;
		public Unit actualUnit;
		// Create a temporary WildCard from a given unit
		public WildCard(Unit unit){
			super(unit.faction);
			this.actualUnit = unit;
			this.tempUnit = unit;
		}
		// Wild card can be temporarily transformed to selected unit
		public void transformTo(Unit unit){
			this.tempUnit = unit;
		}
		public CardType type() {
			return tempUnit.type();
		}
		public CardType actualType() {
			return actualUnit.type();
		}
		public Cost cost() {
			return actualUnit.cost();
		}
		public int strength() {
			return tempUnit.strength();
		}
		public int move() {
			return tempUnit.move();
		}
		// Return the actual card from which this temporary wild card was created
		// Used for discarding wild card to shelter
		public Unit revert(){
			return actualUnit;
		}
		public Unit copy(){
			WildCard unit = new WildCard(this.actualUnit);
			unit.tempUnit = this.tempUnit;
			return unit;
		}
	}
}
