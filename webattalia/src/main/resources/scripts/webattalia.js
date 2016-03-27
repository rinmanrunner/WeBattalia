// The current player's action line cards.
var actionLine = [];

// Suppress default drop behavior.
function allowDrop(ev) {
    ev.preventDefault();
}

// Start Drag
function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
	ev.dataTransfer.setData("origin", ev.target.parentElement.id);
}

// End Drag (Drop)
function drop(ev) {
	// Prevent default browser behavior.
    ev.preventDefault();
	
	//Get the target and the target's parent.
    var data = ev.dataTransfer.getData("text");
	var origin = ev.dataTransfer.getData("origin");
	var par = ev.target.parentElement.id;
	
	//Valid drop zones for cards are in the action line and in the hand.
	if(ev.target.id == "actionLine" || ev.target.id == "actionList" || par == "actionList"){
		document.getElementById("actionList").appendChild(document.getElementById(data));
		if(origin == "playerHandList"){
			// The player added a card to the action line.
			cardType = document.getElementById(data).getAttribute("cardtype");
			actionLine.push(cardType);
			
			// Play Audio
			hear(cardPlace);
		}
	}else if(ev.target.id == "playerHand" || ev.target.id == "playerArea" || ev.target.id == "playerHandList" || par == "playerHandList"){
		document.getElementById("playerHandList").appendChild(document.getElementById(data));
		if(origin == "actionList"){
			// The player removed a card from the action line.
			cardType = document.getElementById(data).getAttribute("cardtype");
			for(i = 0; i < actionLine.length; i++){
				if(cardType == actionLine[i]){
					actionLine.splice(i, 1);
					break;
				}
			}
			
			// Play Audio
			hear(cardPull);
		}
	}

	// If the player's hand is empty we add the empty hand placeholder.
	handList = document.getElementById("playerHandList");
	if(handList.childElementCount <= 1){
		document.getElementById("emptyHand").style.display = "inline";
		document.getElementById("playerHand").style.backgroundColor = "darkgray";
	}else{
		document.getElementById("emptyHand").style.display = "none";
		document.getElementById("playerHand").style.backgroundColor = "lightgray";
	}
}