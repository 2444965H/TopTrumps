<html>

	<head>
		<!-- Web page title -->
    	<title>Top Trumps</title>
    	
    	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

		<!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
  
    <link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/TREC_IS/bootstrap.min.css">
  
    <script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
    	<script>vex.defaultOptions.className = 'vex-theme-os';</script>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex.css"/>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex-theme-os.css"/>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
      
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- CSS Part-->
	
	<style>
	h1 {
		 text-align: center;
		 font-size: 40px;
		 font-family: "Comic Sans MS", "Comic Sans", cursive;
		}
			
	p {
	    text-align: center;
	    font-size: 15px;
     	font-family: "Comic Sans MS", "Comic Sans", cursive;
		}
			
	.buttonHolder { 
	     text-align: center; 
		}
			
	img {
		display: block;
		margin-left: auto;
		margin-right: auto;
		width: 40%;
		}
			
	div.StatsPage {
	background: rgba(255, 255, 255, 0.8);
	margin-left: auto;
	margin-right: auto;
	margin-top: 150px;
	margin-bottom: 50px;
	 }
	</style>

	</head>

    <!-- HTML Part -->
    <body onload="initialize()"> <!-- Call the initialize method when the page loads -->
		
		<div class = StatsPage>
			<h1>TopTrumps Game</h1> <img src="https://cdn.shopify.com/s/files/1/0120/0692/products/mockup-4440df99.jpg?v=1560185506" style="width:275px;">     
		  
			<div class="buttonHolder">
			 <button class="btn btn-default" onclick="newGame();">New Game</button>
			 <button class="btn btn-default" onclick="home();">Home</button>
		   </div>
		 </div> 
		    <div class = Stats>
				<p>Number of Games: <p id="numOfGames"></p></p>
				<p>Number of Human Wins: <p id="humanWins"></p></p>
				<p>Number of AI Wins: <p id="AIWins"></p></p>
				<p>Average Draw per game: <p id="avgDraw"></p></p>
				<p>Longest Game: <p id="longestGame"></p></p>
		 </div>

		</div>
		
	<script type="text/javascript">
		
		function initialize() {
			
				numOfGames();
				humanWins();
				AIWins();
				avgDraw();
				longestGame();
		}
			
<#--  Redirect to GameScreen page  -->
		function newGame() {
			window.location = "http://localhost:7777/toptrumps/game";
		}

<#--  Redirect to homepage  -->
		function home() {
			window.location = "http://localhost:7777/toptrumps";
		}

<#--  Sends request to RESTAPI in order to retrieve the total number of games  -->
		function numOfGames() {
			var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/numOfGames"); 
			if (!xhr) {
  				alert("CORS not supported");
		}
				xhr.onload = function(e) {
 					var responseText = xhr.response; 
					$("#numOfGames").text(responseText);
				};
				xhr.send();		
			}

<#--  Sends request to RESTAPI in order to retrieve the number of games won by the user  -->
			function humanWins() {
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/humanWins"); 
				if (!xhr) {
  					alert("CORS not supported");
				}
				xhr.onload = function(e) {
 					var responseText = xhr.response; 
					$("#humanWins").text(responseText);
				};
				xhr.send();		
			}

<#--  Sends request to RESTAPI in order to retrieve the number of games won by the AI -->
			function AIWins() {
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/AIWins"); 
				if (!xhr) {
  					alert("CORS not supported");
				}
				xhr.onload = function(e) {
 					var responseText = xhr.response; 
					$("#AIWins").text(responseText);
				};
				xhr.send();		
			}

<#--  Sends request to RESTAPI in order to retrieve the average number of draws -->
			function avgDraw() {
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/avgDraw"); 
				if (!xhr) {
  					alert("CORS not supported");
				}
				xhr.onload = function(e) {
 					var responseText = xhr.response; 
					$("#avgDraw").text(responseText);
				};
				xhr.send();		
			}

<#--  Sends request to RESTAPI in order to retrieve the longest(most rounds played) game  -->
			function longestGame() {
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/longestGame"); 
				if (!xhr) {
  					alert("CORS not supported");
				}
				xhr.onload = function(e) {
 					var responseText = xhr.response; 
					$("#longestGame").text(responseText);
				};
				xhr.send();		
			}
	</script>

   <script type="text/javascript">
			// This is a reusable method for creating a CORS request. Do not edit this.
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

  				 }
  				 return xhr;
			}
		
	</script>
		
  </body>
</html>