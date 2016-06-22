$( function( ) {
    function dateDifference() {
        var dateDifferenceString = '';
        var future = moment();
        var start = moment('10/28/1995 15:01:00');
        var years = future.diff(start, 'years');
        future = future.subtract(years, 'years');
        var days = future.diff(start, 'days');
        future = future.subtract(days, 'days');
        var hours = future.diff(start, 'hours');
        future = future.subtract(hours, 'hours');
        var minutes = future.diff(start, 'minutes');
        future = future.subtract(minutes, 'minutes');
        var seconds = future.diff(start, 'seconds');
        return years + ' years ' + days + ' days ' + hours + ' hours ' + minutes + ' minutes ' + seconds + ' seconds';
    }
    $("#daysSince").html('<h3>Last championship:  '
        + dateDifference() + '</h3>');
    /*while(true) {
        window.setTimeout(function(){
            $("#daysSince").html('<h3>Last championship:  '
                + dateDifference() + '</h3>');
        }, 5000);
    }*/
    $.ajax( {
		type: "GET",
		url: "/braves/result",
		success: function( data ) {
			console.log(data);

			var gameResults = JSON.parse(data);

			if(gameResults.error != undefined && gameResults.error != "") {
				$("#bravesResult").html('<p class="' + gameResults.cssClass + '">' + gameResults.error + '</p>');
				$("#bravesScore").html('<h3><a href="' + gameResults.link + '">Schedule</a></h3>');
			} else {
				$("#bravesResult").html('<p class="' + gameResults.cssClass + '">' + gameResults.winLossOrOngoing + '</p>');
				$("#bravesScore").html('<h3><a href="' + gameResults.link + '">' + gameResults.score + '</a></h3>');
			}
		},
		error: function( data ) {
			alert("error = " + data);
		},
		failure: function( data ) {
			alert("failure = " + data);
		}
	});

	$.ajax( {
		type: "GET",
		url: "/falcons/result",
		success: function( data ) {
			console.log(data);

			var gameResults = JSON.parse(data);

			if(gameResults.error != undefined && gameResults.error != "") {
				$("#falconsResult").html('<p class="' + gameResults.cssClass + '">' + gameResults.error + '</p>');
				$("#falconsScore").html('<h3><a href="' + gameResults.link + '">Schedule</a></h3>');
			} else {
				$("#falconsResult").html('<p class="' + gameResults.cssClass + '">' + gameResults.winLossOrOngoing + '</p>');
				$("#falconsScore").html('<h3><a href="' + gameResults.link + '">' + gameResults.score + '</a></h3>');
			}
		},
		error: function( data ) {
			alert("error = " + data);
		},
		failure: function( data ) {
			alert("failure = " + data);
		}
	});

	$.ajax( {
		type: "GET",
		url: "/hawks/result",
		success: function( data ) {
			console.log(data);

			var gameResults = JSON.parse(data);

			if(gameResults.error != undefined && gameResults.error != "") {
				$("#hawksResult").html('<p class="' + gameResults.cssClass + '">' + gameResults.error + '</p>');
				$("#hawksScore").html('<h3><a href="' + gameResults.link + '">Schedule</a></h3>');
			} else {
				$("#hawksResult").html('<p class="' + gameResults.cssClass + '">' + gameResults.winLossOrOngoing + '</p>');
				$("#hawksScore").html('<h3><a href="' + gameResults.link + '">' + gameResults.score + '</a></h3>');
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