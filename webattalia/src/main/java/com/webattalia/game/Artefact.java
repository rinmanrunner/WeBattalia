package com.webattalia.game;

public abstract class Artefact extends Unit {
	boolean isDouble;
	public Artefact(Faction faction, CardType type, int strength, int move){
		super(faction, type, strength, move);
	}
}
