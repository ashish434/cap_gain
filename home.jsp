

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="home.css" />
<title>Welcome Home</title>
</head>

<body>

<div id="container">
<img src="<%= session.getAttribute("imgurl") %>" height="130" width="130">

		<div id="header">
        	<h1>Welcome &nbsp;<span class="off"> <%= session.getAttribute( "firstname" ) %></span></h1>
            <h2>LogOut</h2>
        </div>   
        
        <div id="menu">
        	<ul>
            	<li class="menuitem"><a href="#">Home</a></li>
                <li class="menuitem"><a href="#">About</a></li>
                <li class="menuitem"><a href="#">Products</a></li>
                <li class="menuitem"><a href="#">Services</a></li>
                <li class="menuitem"><a href="#">Design</a></li>
              <li class="menuitem"><a href="#">Contact</a></li>
            </ul>
        </div>
        
        <div id="leftmenu">

        <div id="leftmenu_top"></div>

				<div id="leftmenu_main">    
                
                        
                <ul>
                    <ti><a href="#">view Profile</a></ti>
                    <li><a href="edit.jsp">update Profile</a></li>
                    <li><a href="home_photo.jsp">Photo</a></li>
                    <li><a href="home_video.jsp">Video</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">Design</a></li>
                    <li><a href="#">Submit articles</a></li>
                    <li><a href="#">Deactivate account</a></li>
                </ul>
</div>
                
                
              <div id="leftmenu_bottom"></div>
        </div>
        
        
        
        
		<div id="content">
        
        
        <div id="content_top"></div>
        <div id="content_main">
        	

       	  <h3>First Name:</h3> <%= session.getAttribute( "firstname" ) %>
          <p>&nbsp;</p>
          <h3>Middle Name:</h3> <%= session.getAttribute( "middlename" ) %>
          <p>&nbsp;</p>
          <h3>Last Number:</h3> <%= session.getAttribute( "lastname" ) %>
          <p>&nbsp;</p>
          <h3>Email ID:</h3> <%= session.getAttribute( "emailid" ) %>
          <p>&nbsp;</p>
          <h3>CRD Number:</h3> <%= session.getAttribute( "crdnumber" ) %>
          <p>&nbsp;</p>
          <h3>Street:</h3> <%= session.getAttribute( "street" ) %>
          <p>&nbsp;</p>
          <h3>City:</h3> <%= session.getAttribute( "city" ) %>
          <p>&nbsp;</p>
          <h3>State:</h3> <%= session.getAttribute( "state" ) %>
          <p>&nbsp;</p>
          <h3>Zip:</h3> <%= session.getAttribute( "zip" ) %>
          <p>&nbsp;</p>
          <h3>Phone:</h3> <%= session.getAttribute( "phone" ) %>
          <p>&nbsp;</p>
          <h3>Web URL:</h3> <%= session.getAttribute( "weburl" ) %>

       
         <p>&nbsp;</p>

        </div>
        <div id="content_bottom"></div>
            
            <div id="footer"><h3><a href="http://http://www.capitalgainadvisor.com/">Capital Gain Advisor</a></h3></div>
      </div>
   </div>
</body>
</html>
