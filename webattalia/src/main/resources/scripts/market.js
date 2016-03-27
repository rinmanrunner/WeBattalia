// Unit Cost Constants
const lordCost = ["supply", "supply", "supply", "supply", "supply"];
const priestCost = ["supply", "supply", "supply", "supply"];
const chiefCost = ["supply", "supply", "supply"];
const frimanCost = ["supply", "supply"];

// Artefact Costs
const toolCost = ["friman", "friman", "friman"];
const weaponCost = ["chief", "friman", "friman"];
const amuletCost = ["friman", "friman", "priest"];
const titleCost = ["friman", "friman", "lord"];
const scrollCost = ["chief", "friman", "priest"];
const tentCost = ["chief", "friman", "supply"];
const horseCost = ["chief", "supply", "supply"];

function getMarketOptions(items){
	// Sort the item list.
	items.sort();
	var options = [];
	switch(items.length){
		case 5:
			// 5 Cost
			// Purchase Lord
			if (compareArrays(items, lordCost)){
				options.push("lord");
				break
			}
			break;
		case 4:
			// 4 Cost
			// Purchase Priest
			if (compareArrays(items, priestCost)){
				options.push("priest");
				break
			}
			break;
		case 3:
			// 3 Cost
			// Purchase Chief, Purchase Artefact
			if (compareArrays(items, chiefCost)){
				options.push("chief");
				break;
			}
			if(compareArrays(items, toolCost)){
				options.push("tool");
				break;
			}
			if(compareArrays(items, weaponCost)){
				options.push("weapon");
				break;
			}
			if(compareArrays(items, amuletCost)){
				options.push("amulet");
				break;
			}
			if(compareArrays(items, titleCost)){
				options.push("title");
				break;
			}
			if(compareArrays(items, scrollCost)){
				options.push("scroll");
				break;
			}
			if(compareArrays(items, tentCost)){
				options.push("tent");
				break;
			}
			if(compareArrays(items, horseCost)){
				options.push("horse");
				break;
			}
			break;
		case 2:
			// 2 Cost
			// Purchase Friman
			if (compareArrays(items, frimanCost)){
				options.push("friman");
				break;
			}
			break;
	}
	
	// Every tool counts as two friman but can be used as one if necessary.
	if(arrayContains(items, "tool")){
		// For a tool used as two frimen.
		temp = items;
		for(i = 0; i < temp.length; i++){
			if(temp[i] == "tool"){
				temp.splice(i, 1, "friman", "friman");
			}
		}
		options.concat(getMarketOptions(temp));
		
		// For a tool used as one friman.
		temp = items;
		for(i = 0; i < temp.length; i++){
			if(temp[i] == "tool"){
				temp.splice(i, 1, "friman");
			}
		}
		options.concat(getMarketOptions(temp));
	}
	
	return options;
}