<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Top Trumps</title>
       <link href="style.css" rel="stylesheet">
  </head>

<!-- CSS part -->
	<style>
		#wholepage{
			/*background-color: #aaf;*/
			width: 80%;
		  height: 700px;
		  /*width: 50%;*/
		  /*background-color: powderblue;*/
			margin-left: auto;
			margin-right:auto;
		}
		.title{

			background-color: #a5c;
			text-align: center;
			padding: 2px;

		}
		.round-state{

			background-color: #ccc;
			text-align: left;
			color: white;
			/*padding: 2px;*/


		}
		.my-container{
			background-color: grey;
			height: 950px;
			/*text-align: center;*/

		}
		.btn-group-vertical{
			width: 80%;
		}
		.card{

			height: 300px;
			max-width: 200px;
			padding: 2px;
		}
		#selection{
			background-color: #999;
			padding: 10px;
			height: 500px;
			width: 20%;
			float: left;
		}
		#user-card{
			background-color: #454;
			padding: 10px;
			height: 500px;
			width: 20%;
			float: right;
		}

		h1 {
		  text-align:left;
			font-size: 20px;
			font-family: "Comic Sans MS", "Comic Sans", cursive;
		}

		table, th, td {
			padding: 10px;
			border: 1px solid black; 
			border-collapse: collapse;
			}

	</style>

	<!-- begining of page -->
	  <div id="wholepage">
		<body onload="initalize()">
		   
		     <!-- main heading of game -->
		        <section class="title">
		          <div>
		            <h3>Top Trumps Game </h3>
		          </div>  
		        </section>

		      <!-- declare current round and winner -->
		        <section class="round-state">
		            <p>Play Round<p id="getRound"></p> Players have selected ...</p>
		            
		        </section>

		    	<div id="selectPlayers">					
							<h1>Please select the number of players you want to play against:</h1>			
							<br>
		            <form action="">
		              <input type="radio" name = "player" id = "one">One Player<br>
		              <input type="radio" name = "player" id = "two">Two Players<br>
		              <input type="radio" name = "player" id = "three">Three Players<br> 
		              <input type="radio" name = "player" id = "four">Four Players<br>
		            </form>
		            <br>
		       
					<button class="btn btn-success" onclick="hidePlayerSelection();" style="padding: 5px;">Begin Game</button><br><br>
				</div>

			    <!-- cards display section: 2 rows, 4 cols-->
			 <div class="container my-container" id = "container"><br>
			    	
			  <div class="row">
				 <div class="col">
				    <div class="row" style= "padding:10px ; max-width: 100%;">
				        <button class="btn btn-success">Next Round</button>
				    </div>
				    <br>
				    <!-- should only appear if the user is the acive player -->
				    
				    </div>


			    <div class="col" id = "userCard">
			    <table class="table" cellpadding="2" cellspacing="0" width="100%" style="border: 10px;" rules="">
			  <thead>
			    <td>
			     <img style="display:block;" width="100%" height="100%" src="http://dummyimage.com/68x50/000/fff" />
			      
			    </td>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			    </tr>
			     <tr>
			      <th scope="row">4</th>
			    </tr>
			     <tr>
			      <th scope="row">5</th>
			    </tr>
			  </tbody>
			</table>
			    </div> 
			    <div class="col" id ="AI1Card">
			    	 <table class="table" cellpadding="2" cellspacing="0" width="100%" style="border: 10px;" rules="none">
			  <thead>
			    <td>
			     <img style="display:block;" width="100%" height="100%" src="http://dummyimage.com/68x50/000/fff" />
			      
			    </td>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			    </tr>
			     <tr>
			      <th scope="row">4</th>
			    </tr>
			     <tr>
			      <th scope="row">5</th>
			    </tr>
			  </tbody>
			</table>

			    </div>
			    <div class="col"id ="AI2Card">
			    	<table class="table" cellpadding="2" cellspacing="0" width="100%" style="border: 10px;" rules="none">
			  <thead>
			    <td>
			     <img style="display:block;" width="100%" height="100%" src="http://dummyimage.com/68x50/000/fff" />
			      
			    </td>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			    </tr>
			     <tr>
			      <th scope="row">4</th>
			    </tr>
			     <tr>
			      <th scope="row">5</th>
			    </tr>
			  </tbody>
			</table>
			    </div>
			  </div>



			    <p></p>
			            
			    <div class="row">
			    <div class="col"></div>


			            <div class="col"></div> 

			            <div class="col"id ="AI4Card">
			  <table class="table" cellpadding="2" cellspacing="0" width="100%" style="border: 10px;" rules="none">
			  <thead>
			    <td>
			     <img style="display:block;" width="100%" height="100%" src="http://dummyimage.com/68x50/000/fff" />
			      
			    </td>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			    </tr>
			     <tr>
			      <th scope="row">4</th>
			    </tr>
			     <tr>
			      <th scope="row">5</th>
			    </tr>
			  </tbody>
			</table>
			    </div>
			            
			           


			 <div class="col"id ="AI4Card">
			  <table class="table" cellpadding="2" cellspacing="0" width="100%" style="border: 10px;" rules="none">
			  <thead>
			    <td>
			     <img style="display:block;" width="100%" height="100%" src="http://dummyimage.com/68x50/000/fff" />
			      
			    </td>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			    </tr>
			     <tr>
			      <th scope="row">4</th>
			    </tr>
			     <tr>
			      <th scope="row">5</th>
			    </tr>
			  </tbody>
			</table>
			    </div>
			              
			        
			        </div>

			         <div class="row" style="background-color: powderblue;">end</div>
			            
			          
			   </div>


      <!-- Jquery Stuff here-->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
      
  
  <script type="text/javascript">
  function initalize() {
    
  }

<#--  General file logic  -->
  <#--  Still need create players buttons and logic  -->

  <#--  on click: new Game  
  as next round but also call resetGameState, setPlayers() (order important!)-->

  <#--  On click: Category btn 
  call activeUserInput handler, display all cards, if user: display options,->

  <#--  On click: show Winner btn
  call findRoundWinner, drawChecker,endGame + display round winner -->

  <#--  On click: next round btn  
  call nextRound, display "players have drawn cards", "user card", activeplayer -->

  <#--  on endgame: display game is over, stats, last 2 player cards  -->


<#--  Beginning of Game  / new Game btn  -->

<#--  Sends request to RESTAPI to reset game variables at the start of a new game  -->
function resetGameState() {
	var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/resetGameState"); 
	if (!xhr) {
	alert("CORS not supported");
	}
	<#--  xhr.onload = function(e) {
	};  -->
	xhr.send();		
	}

<#--  Sends request to RESTAPI to create number of AI players equal to the passed parameter at the start of a new game  -->
function setPlayers(num) {
    var xhr = createCORSRequest('PUT', "http://localhost:7777/toptrumps/setPlayers?num="+num); 
		if (!xhr) {
  		alert("CORS not supported");
		}
		xhr.onload = function(e) { 
			<#--  set playerNum to response / Frontend stuff -->
		};
		xhr.send();		
  	}

<#--  Sends request to RESTAPI to start a new round (needs work!)  -->
  function nextRound() {
    var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/nextRound"); 
		if (!xhr) {
  		alert("CORS not supported");
		}
		xhr.send();
  }

<#--  Category btn or category selection --> 

<#--  Sends request to RESTAPI to handle gameplay based on the chosen category. -->
<#--  Passed parameter indicates whether the user is the active player and adjusts method accordingly  -->  
  function activeUserInputHandler(int playerChoice) {
    var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/activeUserInputHandler?playerChoice="+playerChoice); 
		if (!xhr) {
  		alert("CORS not supported");
		}
		xhr.send();
  }

<#-- show Winner btn  -->

<#--  Sends request to RESTAPI to find the round winner -->
  function findRoundWinner() {
		var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/findRoundWinner"); 
		if (!xhr) {
  		alert("CORS not supported");
		}
		xhr.send();		
	}

<#--  Sends request to RESTAPI to check if game is over, and if so handles endgame condition (needs work)  -->
  function endGame() {
		var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/endGame"); 
		if (!xhr) {
  		alert("CORS not supported");
		}
		xhr.onload = function(e) {
 			var responseText = xhr.response; 
			if (responseText.equals("yes")) {
				<#--  Handle endGame, call endGameArray(?)  -->

				gameEndHandler()
				<#--  Call endGame display, playerscores etc  -->
			}
		};
		xhr.send();		
	}

	<#--  Sends request to RESTAPI to handle the end of the game-->
  function gameEndHandler() {
		var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/gameEndHandler"); 
		if (!xhr) {
  		alert("CORS not supported");
		}
		xhr.send();		
	}

  <#--  Front-end/Display methods  -->

<#--  Retrieves the game round from the RESTAPI and displays it where appropriate  -->
    function getRound() {
		var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getRound"); 
		if (!xhr) {
  		alert("CORS not supported");
		}
		xhr.onload = function(e) {
 			var responseText = xhr.response; 
			$("#getRound").text(responseText);
		};
		xhr.send();		
	 }

<#--Show player selection buttons  -->
function showPlayerSelection(){
    $('#container').hide();
  }

<#--  Hide player selection button  -->
function hidePlayerSelection() {
  $('#selectPlayers').hide();
  $('#container').show(); 
  $('#AI1Card').hide();
  $('#AI2Card').hide();
  $('#AI3Card').hide();
  $('#AI4Card').hide();
}

</script>

<!--This is a reusable method for creating a CORS request. Do not edit this. -->
<script type="text/javascript">
	function createCORSRequest(method, url) {
	  var xhr = new XMLHttpRequest();
		  if ("withCredentials" in xhr) {
	
						// Check if the XMLHttpRequest object has a "withCredentials" property.
						// "withCredentials" only exists on XMLHTTPRequest2 objects.
			xhr.open(method, url, true);
	
		  } else if (typeof XDomainRequest != "undefined") {
	
						// Otherwise, check if XDomainRequest.
						// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
		  xhr = new XDomainRequest();
			xhr.open(method, url);
	
			 } else {
	
				// Otherwise, CORS is not supported by the browser.
			xhr = null;
	
		  }return xhr;
		  }
		</script>	
    </body>
  </div>
</html>