$(document).ready(function(){
	var stomClient = null;
	
	console.log('trying');
	
	var socket = new SockJS('/poe-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame){
		console.log('Connect :' + frame);
		stompClient.subscribe('/topic/newRide',function(ride){
			var jsonObject = JSON.parse(ride.body);
			updateRide(jsonObject);
		});
	});
	
	function sendName(){
		//stomClient.send("/app/newRide", JSON.stringify({'Lieu depart : ' $("#ema").val()}));
	}
	
	  function updateRide(message) {
	        console.log(message);
	        var tableRides = $("#rides");
	        var htmlRideLine;

	        $.ajax({
	            url: "/ride/" + message.id,
	            datatype: "html",
	            type: 'GET',
	            success: function (html, status) {
	                tableRides.append("<tr>" + html + "</tr>");
	            }
	        });
	    }
});
