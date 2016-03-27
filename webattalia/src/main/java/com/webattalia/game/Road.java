package com.webattalia.game;

public class Road extends Card {
	public boolean[] connections;//North, East, South, West
	
	public Road(Faction faction, CardType type, boolean[] connections)
	{
		super(faction, type);
		this.connections = connections;
	}
	public Road(CardType type, boolean[] connections){
		super(type);
		this.connections = connections;
	}
}
