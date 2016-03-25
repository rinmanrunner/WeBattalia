package com.webattalia.game;

import java.util.Random;

public enum Faction {
	NONE		("Light Grey",0xE0E0E0), 
	CLOUDBORN 	("Yellow",0xFDD017),
	ISLANDERS  	("Blue", 0x2B60DE),
	BARFOLK     ("Green",0x4AA02C),			
	EMBERIANS   ("Red",0x7D0541),
	RUNEGUARDS  ("Black",0x302217),
	UNBOUND     ("Dark Grey",0x544E4F);
	
	private final String colorStr;
    private final int rgb; 
	private Faction(String colorStr, int rgb){
		this.colorStr = colorStr;
		this.rgb = rgb;
	}
	public String getColor(){return colorStr;}
	public int getRgb() {return rgb;}
}
