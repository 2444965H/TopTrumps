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

	background-color: #ccc;
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
	height: 650px;
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
              <input type="radio" name = "player">One Player<br>
              <input type="radio" name = "player">Two Players<br>
              <input type="radio" name = "player">Three Players<br> 
              <input type="radio" name = "player">Four Players
            </form>
         <br>
					<br><button class="btn btn-default" onclick="hidePlayerSelection();" style="padding: 5px;">Begin Game</button><br><br>
				</div>

    <!-- cards display section: 2 rows, 4 cols-->
    <div class="container my-container" id = "container">
      <div class="row">
        <div class="col">
        <div class="row" style= "padding:2px ; max-width: 100%;">
        <button class="btn btn-success">Next Round</button>
    </div>

    <!-- should only appear if the user is the acive player -->
    <div class="btn-group-vertical">
     <button type="button" class="btn btn-primary">size</button>
     <button type="button" class="btn btn-primary">speed</button>
     <button type="button" class="btn btn-primary">cargo</button>
     <button type="button" class="btn btn-primary">range</button>
     <button type="button" class="btn btn-primary">firepower</button>
    </div>  
    </div>


    <div class="col" id = "userCard"><img class="card" src="ship.jpg" alt="USER"></div> 
    <div class="col" id ="AI1Card"><img class="card" src="ship.jpg" alt="AI 1"></div>
    <div class="col"id ="AI2Card"><img class="card" src="ship.jpg" alt="AI 2"></div>
    </div>
    <p></p>
            
    <div class="row">
    <div class="col"></div>

            <div class="col"></div> 

           <div class="col"id ="AI3Card"> 
              <img class="card" src="ship.jpg" alt="AI 3">
            </div>
            
            <div class="col"id ="AI4Card">
              <img class="card" src="ship.jpg" alt="AI 4">
            </div> 
        </div>

          <div class="row" style="background-color: powderblue;">
            
          </div>
        </div>


      <!-- Jquery Stuff here-->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
      
  
  <script type="text/javascript">
  function initalize() {
    getRound();
    showPlayerSelection();
  }

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

  function choosePlayers() {
    var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/choosePlayers"); 
		if (!xhr) {
  		alert("CORS not supported");
		}
		xhr.onload = function(e) {
 			var responseText = xhr.response; 
			$("#choosePlayers").text(responseText);
		};
		xhr.send();		
  }

function showPlayerSelection(){
    $('#container').hide();
  }

function hidePlayerSelection() {
  $('#selectPlayers').hide();
  $('#container').show(); 
  $('#AI1Card').hide();
  $('#AI2Card').hide();
  $('#AI3Card').hide();
  $('#AI4Card').hide();
}




function startGame(){

}

function numberOfPlayers() {

}

function getNumberOfCardsInCommunalPile() {

}

function namesOfPlayers() {

}

function activePlayer() {

}

function cardCategoryNames() {

}

function getFirstCardDescription() {

}

function getFirstCardValue() {

}

function roundWinner() {

}

function endGameWithoutHumanPlayer(){

}

function getGameWinner() {

}

function playerNames() {

}

function numberOfCards() {

}

function userChosenCategory() {

}

function AIchosenCategory() {

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