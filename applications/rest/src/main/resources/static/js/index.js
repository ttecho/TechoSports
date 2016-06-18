$( function( ) {
	$.ajax( {
		type: "GET",
		url: "/braves/result",
		success: function( data ) {
			console.log(data);

			var gameResults = JSON.parse(data);
			$("#result").html('<p class="' + gameResults.cssClass + '">' + gameResults.winLossOrOngoing + '</p>');
			$("#score").html('<h3><a href="' + gameResults.link + '">' + gameResults.score + '</a></h3>');
		},
		error: function( data ) {
			alert("error = " + data);
		},
		failure: function( data ) {
			alert("failure = " + data);
		}
	});
	
});