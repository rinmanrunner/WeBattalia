function compareArrays(a, b){
	if(a.length == b.length){
		for(x = 0; x < a.length; x++){
			if(a[x] != b[x]){
				return false;
			}
		}
		return true;
	}else{
		return false;
	}
}

function arrayContains(a, b){
	for(x = 0; x < a.length; x++){
		if(a[x] == b){
			return true;
		}
	}
	return false;
}