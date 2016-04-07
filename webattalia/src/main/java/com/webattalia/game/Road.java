package com.webattalia.game;

import java.util.Arrays;

public abstract class Road extends Card {
	protected boolean[] connections;//North, East, South, West

	public abstract Cost cost();
	public abstract CardType type();
	public abstract Card copy();
	
	public Road(Faction faction)
	{
		super(faction);;
	}
	public Road(){
		super();
	}
	public boolean[] getConnections(){
		return connections;
	}
	public void rotateConnections(int direction){
		// if integer is 1, rotate clockwise 90.
		// if integer is -1, rotate counterclockwise 90
		// if integer is 2 or -2 rotate 180
		boolean[] newConnections = new boolean[]{true, true, true, true};
		for(int i=0;i<4;i++){
			newConnections[i] = connections[(i-(direction % 4)+4) % 4];
		}
		connections = newConnections;
	}		
	public void showConnections(){
		System.out.println("Road Connections: ");
		System.out.println("[" + getConnections()[0] + " " + getConnections()[1] + " "
				+ getConnections()[2] + " " + getConnections()[3] + "]" );
	}
	public static class Straight extends Road {
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
		public final Card copy(){return new Road.Straight(this.faction);}
	}
	public static class Curved extends Road {
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
		public final Card copy(){return new Road.Curved(this.faction);}
	}
	public static class Tee extends Road {
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
		public final Card copy(){return new Road.Tee(this.faction);}
	}
	public static class Cross extends Road {
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
		public final Card copy(){return new Road.Cross(this.faction);}
	}
}
