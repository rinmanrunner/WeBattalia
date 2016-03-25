package com.webattalia.game;

public class Road extends Card {
	public boolean[] connections;//North, East, South, West
	
	public Road(Faction faction, Cost[] cost, boolean[] connections)
	{
		super(faction, cost);
		this.connections = connections;
		this.name = "Road";
	}
	public Road(Cost[] cost, boolean[] connections){
		super(cost);
		this.connections = connections;
		this.name = "Road";
	}
}
