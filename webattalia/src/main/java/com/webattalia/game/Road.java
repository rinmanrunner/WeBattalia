package com.webattalia.game;

public abstract class Road extends Card {
	public boolean[] connections;//North, East, South, West

	public abstract Cost cost();
	public abstract CardType type();
	
	public Road(Faction faction, boolean[] connections)
	{
		super(faction);
		this.connections = connections;
	}
	public Road(boolean[] connections){
		super();
		this.connections = connections;
	}

}
