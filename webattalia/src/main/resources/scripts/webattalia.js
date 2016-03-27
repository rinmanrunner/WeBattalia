function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
	if(ev.target.id == "actionLine" || ev.target.id == "actionList"){
		document.getElementById("actionList").appendChild(document.getElementById(data));
	}else if(ev.target.id == "playerHand" || ev.target.id == "playerArea" || ev.target.id == "playerHandList"){
		document.getElementById("playerHandList").appendChild(document.getElementById(data));
	}
}