package com.webattalia.web;

import static spark.Spark.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.webattalia.game.Card;
import com.webattalia.game.Deck;
import com.webattalia.game.Unit;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {
	
	private static String version = new String("0.1a"); // The version number string.
	private static String codename = new String("White Owl"); // The version code name.
	
    public static void main(String[] args) {
    	
    	/*
    	 * Freemarker Configuration
    	 */
    	
    	Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
    	
    	try{
	    	cfg.setDirectoryForTemplateLoading(new File("./templates/"));
	    	cfg.setDefaultEncoding("UTF-8");
	    	cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
    	} catch (Exception e){
    		e.printStackTrace();
    		System.exit(-1);
    	}
    	
    	/*
    	 * Get requests on "/"
    	 */
        get("/", (req, res) -> {
        	
        	/*
        	 * Starting Hand Demonstration
        	 */

        	// Create a starting deck.
    		List<Card> startCards = new ArrayList<Card>();
    		List<Card> hand = new ArrayList<Card>();
    		
    		for(int i=0;i<5;i++){startCards.add(new Unit.Supply());}
    		for(int i=0;i<3;i++){startCards.add(new Unit.Friman());}
    		
    		startCards.add(new Unit.Chief());
    		startCards.add(new Unit.Priest());
    		
    		Deck startingDeck = new Deck(startCards);
    		startingDeck.shuffle();
    		
    		// Draw six cards.
    		Iterator<Card> cardIterator = startCards.iterator();
    		while(hand.size()<6){
    			hand.add(cardIterator.next());
    		}
    		
    		// Create a data map for the card information.
        	Map<String, Object> map = new HashMap<>();
        	map.put("card1faction", hand.get(0).faction.name().toLowerCase());
        	map.put("card1type", hand.get(0).type().name().toLowerCase());
        	map.put("card1title", hand.get(0).faction.name() + " " + hand.get(0).type().name().toLowerCase());
        	map.put("card2faction", hand.get(1).faction.name().toLowerCase());
        	map.put("card2type", hand.get(1).type().name().toLowerCase());
        	map.put("card2title", hand.get(1).faction.name() + " " + hand.get(1).type().name().toLowerCase());
        	map.put("card3faction", hand.get(2).faction.name().toLowerCase());
        	map.put("card3type", hand.get(2).type().name().toLowerCase());
        	map.put("card3title", hand.get(2).faction.name() + " " + hand.get(2).type().name().toLowerCase());
        	map.put("card4faction", hand.get(3).faction.name().toLowerCase());
        	map.put("card4type", hand.get(3).type().name().toLowerCase());
        	map.put("card4title", hand.get(3).faction.name() + " " + hand.get(3).type().name().toLowerCase());
        	map.put("card5faction", hand.get(4).faction.name().toLowerCase());
        	map.put("card5type", hand.get(4).type().name().toLowerCase());
        	map.put("card5title", hand.get(4).faction.name() + " " + hand.get(4).type().name().toLowerCase());
        	map.put("card6faction", hand.get(5).faction.name().toLowerCase());
        	map.put("card6type", hand.get(5).type().name().toLowerCase());
        	map.put("card6title", hand.get(5).faction.name() + " " + hand.get(5).type().name().toLowerCase());
        	
        	// Add the version information to the data map.
        	map.put("version", version);
        	map.put("codename", codename);
        	
        	return new ModelAndView(map, "gameInterface.ftl");
        }, new FreeMarkerEngine(cfg));
    }
}