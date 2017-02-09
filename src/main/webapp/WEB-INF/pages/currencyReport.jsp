<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>currencyReport</title>
    <style type="text/css">
        #container {
   
   display: table
}
#mycanvas, #recFromServer {
   display: table-cell
}
#mycanvas {
   width: 650px;
    height: 500px;
   
}

#width100PercentTest {
   width: 100%;
   height: 10px;
 
}
.span3 {  
    height: 85% !important;
    overflow: scroll;
}
tr {
width: 100%;
display: inline-table;
table-layout: fixed;
}

table{
 height:300px;              // <-- Select the height of the table
 display: -moz-groupbox;    // Firefox Bad Effect
 overflow: scroll;
}
tbody{
  overflow-y: scroll;      
  height: 200px;            //  <-- Select the height of the body
  width: 100%;
  position: absolute;
}

    </style>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.8.1/bootstrap-table.css">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.8.1/bootstrap-table.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/smoothie/1.27.0/smoothie.min.js" type="text/javascript"></script>

    <script>
//alert("before start");
         console.log("starting..");
        var socket = new SockJS("/RESTfulApp/ws");
        //alert("after socket create");
        console.log("after socket create");
        var stompClient = Stomp.over(socket);
        //alert("after socket stomp");
        console.log("after socket stomp");
        ///connect to the server
        stompClient.connect("guest", "guest", function () {

            //$("#recFromServer").append("<br>" + "Successful Connection to Server.!");
            //alert("successfull connection to server");
            console.log("successfull connection to server");
            
            //var time=new Date().getTime();
            var rate = 0.0;
            var smoothie = new SmoothieChart();
            //smoothie.streamTo(document.getElementById("mycanvas"));
            smoothie.streamTo(document.getElementById("mycanvas"), 1000 /*delay*/); 
            // Data
            var line1 = new TimeSeries();
            //var line2 = new TimeSeries();
            
            
            // Add a random value to each line every second
setInterval(function() {
    console.log("*********RATE = "+rate);
  line1.append(new Date().getTime(), rate);
  //line2.append(new Date().getTime(), Math.random());
}, 1000);
// Add to SmoothieChart
smoothie.addTimeSeries(line1,{ strokeStyle: 'rgba(0, 255, 0, 1)', fillStyle: 'rgba(0, 255, 0, 0.2)', lineWidth: 6 });
//smoothie.addTimeSeries(line2);




            //After successful connection，Set the address of the receiving server and the processing method
            stompClient.subscribe('/topic/greetings', function (greeting) {
                
                var content = greeting.body
                console.log(content);
                
                console.log("********************");
                console.log(JSON.parse(greeting.body).rate);
                rate = JSON.parse(greeting.body).rate;
				reload(JSON.parse(greeting.body));
            });
        }, function (error) {
            //Connection error callback function
            //alert(error);
            console.log(error);
        });


        function sendMessage() {
            //Send a message to the server
            //alert("in send message func");
            console.log("in send message func");
            stompClient.send("/app/greeting", {}, JSON.stringify({ 'name': $("#message").val() }));
        }
		
            function reload(data1){
			var table = document.getElementById("table");
    var row = table.insertRow(1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	var cell6 = row.insertCell(5);
    cell1.innerHTML = data1.userId;
    cell2.innerHTML =  data1.currencyFrom;
	cell3.innerHTML =  data1.currencyTo;
	cell4.innerHTML =  data1.amountSell;
	cell5.innerHTML =  data1.amountBuy;
	cell6.innerHTML =  data1.rate;
            }
    </script>
</head>
<body>
<h1>Welcome to currency report</h1>
<div class="row">
  <div class="col-sm-6"><canvas id="mycanvas" width="650" height="500"></canvas></div>
  <div class="col-sm-6"><div  class="span3"><table class="table" id="table">
            <thead>
                <tr>
                    <th >UserId</th>
                    <th >Currency From</th>
                    <th >Currency To</th>
					<th >Amount Sell</th>
					<th >Amount Buy</th>
					<th >Rate</th>
                </tr>
            </thead>
        </table></div></div>
</div>
<div id="container">
    


</div>
</body>
</html>
