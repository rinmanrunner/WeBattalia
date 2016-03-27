//Define Audio Source
const source = "http://nickmacholl.com/webattalia/audio/";

// Define Sound Arrays
const cardPlace = ["cardPlace1.mp3", "cardPlace2.mp3"];
const cardPull = ["cardPull1.mp3", "cardPull2.mp3"];

// Play a given sound name.
function hear(soundName){
	if(soundName.length > 1){
		var i = Math.floor((Math.random() * cardPull.length));
	}else{
		i = 0;
	}
	var audio = new Audio(source.concat(soundName[i]));
	audio.play();
}