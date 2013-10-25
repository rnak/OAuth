
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta charset="utf-8">
   <meta name="viewport" content="width=device-width,initial-scale=1.0">
   <title>ronk</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <!-- Bootstrap -->
   <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="/js/bootstrap.min.js"></script>
		
  </head>
  <body>
	<div class="container">
		<header class="row">
			<div class="span12">
				<nav class="navbar">
					<div class="navbar-inner">
					<a href="#" class="brand"><%= session.getAttribute( "email" ) %></a>
					<a href="#" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon=bar"></span>
						<span class="icon=bar"></span>
						<span class="icon=bar"></span>
					
					</a>
					<div class="nav-collapse collapse">
					
						<ul class="nav">
								<li class="divider-vertical"></li>
							<li><a href="#">home</a></li>
							    <li class="divider-vertical"></li>
							<li><a href="#">blog</a></li>
								<li class="divider-vertical"></li>
							<li><a href="#">contact</a></li>
								<li class="divider-vertical"></li>
							<li><a href="#">about</a></li>
								<li class="divider-vertical"></li>
								
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">connect
								<b class="caret"></b>
								</a>
						<ul class="dropdown-menu">
							<li><a href="#">Facebook</a></li>
							<li><a href="#">twitter</a></li>
							<li><a href="#">adaptiveyou</a></li>
							<li class="divider"></li>
							<li><a href="#">codeacadamy</a></li>
						</ul>
							</li>
						</ul>
						</div>
					</div>
				</nav>
			</div>
		</header>
		
		
		<div class="row" id="main-content">
			<div class="span4" id="sidebar">
			
				<div class="well">
					<form>
						<fieldset>
							<legend>Welcome!! <%= session.getAttribute( "name" ) %></legend>
							
							<img src="<%= session.getAttribute( "image" ) %>"/><br>
							<h2>Gender:<%= session.getAttribute( "gender" ) %></h2>
							
							
							<!-- <input type="text" class="input-block-level" placeholder="username">
							<input type="text" class="input-block-level" placeholder="password"> -->
							<!-- <label class="checkbox">
							<input type="checkbox">Remember me
							</label> -->
							
						</fieldset>
					</form>
			<form action="/authocontact" method="GET">
    
    <button class="btn btn-danger" data-dismiss="model" aria-hidden="true">Import Google Contacts</button>
    </form>
			</div>
		
		<div class="accordian" id="questions">
			<div class="accordion-group">
				<div class="accordion-heading">
				<a class="accordion-toggle btn" data-toggle="collapse" data-parent="#questions"
				href="#who">who?</a>
				</div>
				<div id="who" class="accordion-body collapse">
					<div class="accordian-inner">
						<p>I am Ronak Jain</p>
					</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
				<a class="accordion-toggle btn" data-toggle="collapse" data-parent="#questions"
				href="#how">how?</a>
				</div>
				<div id="how" class="accordion-body collapse">
					<div class="accordian-inner">
						<p>I will gonna complete this soon</p>
					</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
				<a class="accordion-toggle btn" data-toggle="collapse" data-parent="#questions"
				href="#why">why?</a>
				</div>
				<div id="why" class="accordion-body collapse">
					<div class="accordian-inner">
						<p>I find it interesting</p>
					</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
				<a class="accordion-toggle btn" data-toggle="collapse" data-parent="#questions"
				href="#where">where?</a>
				</div>
				<div id="where" class="accordion-body collapse">
					<div class="accordian-inner">
						<p>on notepad++</p>
					</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
				<a class="accordion-toggle btn" data-toggle="collapse" data-parent="#questions"
				href="#wao">wao?</a>
				</div>
				<div id="wao" class="accordion-body collapse">
					<div class="accordian-inner">
						<p>oooho! enough</p>
					</div>
				</div>
			</div>
		</div>
		
		
		
		</div>
		<div class="span8">
			<div id="slider" class="carousel slide">
				<div class="carousel-inner">
					<div class="item">
						<img src="http://www.placehold.it/850x500">
						<div class="carousel-caption">
							<h4>HeadLine for image 1</h4>
							<p>Description of image 1</p>
						</div>
					</div>
					<div class="item active">
						<img src="http://www.placehold.it/850x500">
						<div class="carousel-caption">
							<h4>HeadLine for image 2</h4>
							<p>Description of image 2</p>
						</div>
					</div>
					<div class="item">
						<img src="http://www.placehold.it/850x500">
						<div class="carousel-caption">
							<h4>HeadLine for image 3</h4>
							<p>Description of image 3</p>
						</div>
					</div>
				</div>	
				<a class="left carousel-control" href="#slider" data-slide="prev">&lsaquo;</a>
				<a class="right carousel-control" href="#slider" data-slide="next">&rsaquo;</a>
			</div>
		</div>
		
		
		<div>
			<footer class="row"></footer>
		</div><!-- end of container-->

		

    <!-- Button to trigger modal -->
<!--<a href="#register" role="button" class="btn" data-toggle="modal"></a>-->
 
<!-- Modal -->
<div id="register" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="model" aria-hidden="true"><i class="icon-remove"></i></button>
    <h3 id="myModalLabel">Register</h3>
  </div>
  <div class="modal-body">
    
				<form>
					<div class="controls controls-row">
						<input type="text" class="span2"placeholder="First name">
						<input type="text" class="span2"placeholder="Last name">
						
					</div>
					<div>
					<input type="text" class="span5"placeholder="E_mail">
					</div>
				</form>
  </div>
  <div class="modal-footer">
    				<button class="btn btn-danger" data-dismiss="model" aria-hidden="true">cancel</button>
				<button class="btn btn-success" >register</button>
  </div>
</div>
<form action="/gcookiedel" method="GET">
    
    <button class="btn btn-danger" data-dismiss="model" aria-hidden="true">login as diff google user</button>
    </form>
    <form action="/fcookiedel" method="GET">
    
    <button class="btn btn-danger" data-dismiss="model" aria-hidden="true">login as diff facebook user</button>
    </form>
    <form action="/logout" method="GET">
    
    <button class="btn btn-danger" data-dismiss="model" aria-hidden="true">LOGOUT</button>
    </form>
  </body>
</html>
<%
//session.invalidate();
%>
</body>
</html>