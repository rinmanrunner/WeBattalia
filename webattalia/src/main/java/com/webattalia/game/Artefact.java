package com.webattalia.game;

import java.util.*;

public abstract class Artefact extends Unit {
	public Artefact(){super();}
	public Artefact(Faction faction){super(faction);}
	public boolean isIlluminated(Oracle o)
	{
		if(type().equals(o.illuminated())){
			return true;
		}
		return false;
	}
	// Each class must be able to set its properties based on the oracle
//	public abstract void setProperties(Oracle o);
	public static class Tool extends Artefact {
		private List<CardType> buildValue = Arrays.asList(CardType.FRIMAN, CardType.FRIMAN);
		// The Tool is worth two Friman for building
		public final CardType type(){return CardType.TOOL;}
		public Tool(Faction faction){super(faction);}
		// Select random faction
		public Tool(){super();}
		// Tool costs 3 Friman
		public final Cost cost(){
			return new Cost(Arrays.asList(
					       CardType.FRIMAN,
						   CardType.FRIMAN,
						   CardType.FRIMAN));
		}
		// The Tool has no strength or move
		public final int strength(){return 0;}
		public final int move(){return 0;}	
		public List<CardType> buildValue(){
			return buildValue;
		}
		public final Card copy(){return new Artefact.Tool(this.faction);}
	}
	public static class Weapon extends Artefact {
		// The weapon is used to start battles
		// The weapon also summons heroes
		public final CardType type(){return CardType.WEAPON;}
		public Weapon(Faction faction){super(faction);}
		// Select random faction
		public Weapon(){super();}
		// Weapon costs 1 Chief and 2 Friman
		public final Cost cost(){
			return new Cost(Arrays.asList(
					       CardType.CHIEF,
						   CardType.FRIMAN,
						   CardType.FRIMAN));
		}
		// The Weapon has one strength and no move
		public int strength(){return 1;}
		public final int move(){return 0;}
		public final Card copy(){return new Artefact.Weapon(this.faction);}
	}
	public static class Amulet extends Artefact {
		public int result = 0;
		public final CardType type(){return CardType.AMULET;}
		public Amulet(Faction faction){super(faction);}
		// Select random faction
		public Amulet(){super();}
		// Amulet costs 1 Priest and 2 Friman
		public final Cost cost(){
			return new Cost(Arrays.asList(
					       CardType.PRIEST,
						   CardType.FRIMAN,
						   CardType.FRIMAN));
		}
		// The Amulet has no strength and no move
		public final int strength(){return 0;}
		public final int move(){return 0;}
		public final Card copy(){return new Amulet.Tool(this.faction);}
		// The amulet can transform a card
		public List<Card> transform(Card c){
			List<Card> outCards = new ArrayList<Card>();
			this.result = roll();
			switch (this.result){
				case 3: // Triple the card
					outCards.add(c);
				case 2: // Double the card
					outCards.add(c);				
				case 1: // Card unchanged
					outCards.add(c);
					return outCards;
				case 4:
					//Send card to ambush
					// Needs Assets of player to work
					// TO BE DEVELOPED
					return null;
				case 5:
					//Send card to discard
					// Needs Assets of player to work
					// TO BE DEVELOPED
					return null;
				case 6:
					//Wild Card
					outCards.add(new WildCard(c));
					return outCards;
				default:
					return null;
			}
		}
		// Roll the die randomly
		public int roll(){
			Random rand = new Random();
			this.result = rand.nextInt(6)+1;
			return this.result;
		}
	}
    public static class Title extends Artefact {
    	// The Title is used to upgrade the rank of a unit
		public final CardType type(){return CardType.TITLE;}
		public Title(Faction faction){super(faction);}
		// Select random faction
		public Title(){super();}
		// Title costs 1 Lord and 2 Friman
		public final Cost cost(){
			return new Cost(Arrays.asList(
					       CardType.LORD,
						   CardType.FRIMAN,
						   CardType.FRIMAN));
		}
		// The Title has no strength or move
		public final int strength(){return 0;}
		public final int move(){return 0;}
		public final Card copy(){return new Artefact.Title(this.faction);}
		public Card upgrade(Card c){
			// Returns a card with same faction as c but next level up
			switch (c.type()){
				case FRIMAN:
					return new Unit.Chief(c.faction);
				case CHIEF:
					return new Unit.Priest(c.faction);
				case PRIEST:
					return new Unit.Lord(c.faction);
				default:
					return c;
			}
		}
	}
    public static class Scroll extends Artefact {
    	// The scroll changes the color of a card to the specified faction
		public final CardType type(){return CardType.SCROLL;}
		public Scroll(Faction faction){super(faction);}
		// Select random faction
		public Scroll(){super();}
		// Scroll costs 1 Priest, 1 Chief, and 1 Friman
		public final Cost cost(){
			return new Cost(Arrays.asList(
					       CardType.PRIEST,
						   CardType.CHIEF,
						   CardType.FRIMAN));
		}
		// The Scroll has no strength or move
		public final int strength(){return 0;}
		public final int move(){return 0;}
		public final Card copy(){return new Artefact.Scroll(this.faction);}
		
		public Card change(Card c, Faction f){
			// Returns a card of type c with faction f
			Card newCard = c;
			newCard.faction = f;
			return newCard;
		}
		public Card changeSelf(Faction f){
			// Returns a scroll with faction f
			return new Artefact.Scroll(f);
		}
    }
    public static class Tent extends Artefact {
    	// The tent holds other cards for use in future turns
		public List<Card> contents;
		private int contentsLimit = 1;
		public boolean isErected = false;
    	public final CardType type(){return CardType.TENT;}
		public Tent(Faction faction){super(faction);}
		// Select random faction
		public Tent(){super();}
		// Tent costs 1 Chief, 1 Friman. and 1 Supply
		public final Cost cost(){
			return new Cost(Arrays.asList(
						   CardType.CHIEF,
						   CardType.FRIMAN,
						   CardType.SUPPLY));
		}
		// The Tent has no strength or move
		public final int strength(){return 0;}
		public final int move(){return 0;}
		public final Card copy(){return new Artefact.Tent(this.faction);}
		// The tent can be erected with given contents
		// (Normally costs a supply). Being illuminated allows two cards
		public void erect(List<Card> contents){
			if(!isErected & contents.size()<=contentsLimit){
				this.contents = contents;
				isErected = true;
			}
		}
		public List<Card> disband(){
			if(isErected){
				isErected = false;
				return contents;
			}
			return null;
		}
		public void setContentsLimit(Oracle o){
			contentsLimit = 1;
			if(isIlluminated(o)){
				contentsLimit = 2;
			}
		}
    }  
    public static class Horse extends Artefact {
    	// The horse can move a hero 3 and also retreat heroes
    	public final CardType type(){return CardType.HORSE;}
		public Horse(Faction faction){super(faction);}
		// Select random faction
		public Horse(){super();}
		// Horse costs 1 Chief and 2 Supply
		public final Cost cost(){
			return new Cost(Arrays.asList(
						   CardType.CHIEF,
						   CardType.SUPPLY,
						   CardType.SUPPLY));
		}
		// The Horse has 1 strength and 3 move
		public final int strength(){return 1;}
		public final int move(){return 3;}
		public final Card copy(){return new Artefact.Horse(this.faction);}
    }
}
