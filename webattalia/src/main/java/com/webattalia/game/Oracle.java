package com.webattalia.game;

import java.util.*;

// The Oracle points at a different artefact each day
// One artefact each day has its power doubled
// One artefact each day is allowed to have its color selected
public class Oracle {
	public int day = 1;//Start at day one
	private final List<CardType> matchArray = 
			Arrays.asList(CardType.TOOL, CardType.SCROLL, CardType.WEAPON,
					CardType.TENT, CardType.AMULET, CardType.HORSE, CardType.TITLE);
	private final List<CardType> illuminateArray =
			Arrays.asList(CardType.TOOL, CardType.WEAPON, CardType.AMULET,
					CardType.TITLE, CardType.SCROLL, CardType.TENT, CardType.HORSE);
	// start Oracle on default day 1
	public Oracle(){
		
	}
	// start Oracle on specified day
	public Oracle(int day){
		this.day = day;
	}
	// Advance Oracle one day
	public void advance(){
		this.day++;
	}
	// Retreat Oracle one day
	public void retreat(){
		this.day--;
	}
	// Get the artefact type that is currently matching on the oracle
	public CardType match(){
		return matchArray.get((day-1) % 7);
	}
	// Get the artefact type that is currently illuminated on the oracle
	public CardType illuminated(){
		return illuminateArray.get((day-1) % 7);
	}
}
