package com.webattalia.game;

public abstract class Unit extends Card {
	public int strength;
	public int move;
	public Unit(CardType type, int strength, int move){
		super(type);
		this.strength = strength;
		this.move     = move;
	}
	public Unit(Faction faction, CardType type, int strength, int move){
		super(faction,type);
		this.strength = strength;
		this.move = move;
	}

}
