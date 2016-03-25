package com.webattalia.game;

public abstract class Unit extends Card {
	public int strength;
	public int move;
	public Unit(Faction faction, Cost[] cost, int strength, int move){
		super(faction, cost);
		this.strength = strength;
		this.move = move;
	}
	public Unit(Cost[] cost, int strength, int move){
		super(cost);
		this.strength = strength;
		this.move     = move;
	}
}
