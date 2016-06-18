$( function( ) {
	$.ajax( {
		type: "GET",
		url: "/falcons/result",
		success: function( data ) {
			console.log(data);

			var gameResults = JSON.parse(data);

			if(gameResults.error != undefined && gameResults.error != "") {
				$("#result").html('<p class="' + gameResults.cssClass + '">' + gameResults.error + '</p>');
				$("#score").html('<h3><a href="' + gameResults.link + '">Schedule</a></h3>');
			} else {
				$("#result").html('<p class="' + gameResults.cssClass + '">' + gameResults.winLossOrOngoing + '</p>');
				$("#score").html('<h3><a href="' + gameResults.link + '">' + gameResults.score + '</a></h3>');
			}
		},
		error: function( data ) {
			alert("error = " + data);
		},
		failure: function( data ) {
			alert("failure = " + data);
		}
	});
	
});