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

 <!-- CSS part, dealing with how things are set on the webpage -->
<style>
h1 {
  text-align: center;
  font-size: 40px;
  font-family: "Comic Sans MS", "Comic Sans", cursive;
}

h2 {
  text-align: center;
  font-size: 20px;
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
div.WebPage {
    background: rgba(255, 255, 255, 0.8);
    margin-left: auto;
    margin-right: auto;
    margin-top: 200px;
    margin-bottom: 50px;
  }
    
</style>

</head>

<!--"actual HTML", putting the elements on the webpage-->
<body>
  <!-- Call the initalize method when the page loads -->
    <body onload="initalize()"> 
    
      <div class = WebPage>
        <h1>TopTrumps Game</h1>
        <img
             src="https://cdn.shopify.com/s/files/1/0120/0692/products/mockup-4440df99.jpg?v=1560185506" style="width:275px;">
             
        <h2>Welcome to the game!</h2>
        <p>Choose whether you want to play a new game or see previous game statistics:</p>
     
        <div class="buttonHolder">
         <button class="btn btn-default" onclick="newGame();" >New Game</button>
         <button class="btn btn-default" onclick="viewStats();">View Previous Game Statistics</button>
        </div>
      </div>  
      
  <!-- JavaScript part, handles the functionality, changing the window to either a new game or the game stats -->		          
<script type="text/javascript">
		
	function newGame(){
  window.location='http://localhost:7777/toptrumps/game';
  }
    		    		
  function viewStats(){
  window.location='http://localhost:7777/toptrumps/stats';
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

</html>